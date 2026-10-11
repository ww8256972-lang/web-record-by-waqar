package com.waqar.webrecord

import android.app.Application
import android.app.NotificationChannel
import android.app.NotificationManager
import android.os.Build
import androidx.work.Configuration
import androidx.work.ExistingPeriodicWorkPolicy
import androidx.work.PeriodicWorkRequestBuilder
import androidx.work.WorkManager
import com.waqar.webrecord.database.AppDatabase
import com.waqar.webrecord.data.repository.AuthRepository
import com.waqar.webrecord.data.repository.CustomerRepository
import com.waqar.webrecord.utils.SecurePrefs
import com.waqar.webrecord.workers.FollowUpWorker
import java.util.concurrent.TimeUnit

class WebRecordApp : Application(), Configuration.Provider {

    lateinit var database: AppDatabase
        private set
    lateinit var securePrefs: SecurePrefs
        private set
    lateinit var authRepository: AuthRepository
        private set
    lateinit var customerRepository: CustomerRepository
        private set

    override fun onCreate() {
        super.onCreate()
        instance = this
        database = AppDatabase.getInstance(this)
        securePrefs = SecurePrefs(this)
        authRepository = AuthRepository(database.userDao(), securePrefs)
        customerRepository = CustomerRepository(
            database.customerDao(),
            database.activityLogDao(),
            database.callLogDao(),
            database.whatsAppLogDao(),
            database.syncQueueDao()
        )
        createNotificationChannels()
        scheduleFollowUpWorker()
    }

    private fun createNotificationChannels() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val manager = getSystemService(NotificationManager::class.java)
            val channels = listOf(
                NotificationChannel(CHANNEL_FOLLOWUPS, "Follow-ups", NotificationManager.IMPORTANCE_HIGH),
                NotificationChannel(CHANNEL_OVERDUE, "Overdue", NotificationManager.IMPORTANCE_HIGH),
                NotificationChannel(CHANNEL_PAYMENTS, "Payments", NotificationManager.IMPORTANCE_DEFAULT)
            )
            manager.createNotificationChannels(channels)
        }
    }

    private fun scheduleFollowUpWorker() {
        val request = PeriodicWorkRequestBuilder<FollowUpWorker>(6, TimeUnit.HOURS).build()
        WorkManager.getInstance(this).enqueueUniquePeriodicWork(
            "follow_up_check",
            ExistingPeriodicWorkPolicy.KEEP,
            request
        )
    }

    override val workManagerConfiguration: Configuration
        get() = Configuration.Builder()
            .setMinimumLoggingLevel(android.util.Log.INFO)
            .build()

    companion object {
        lateinit var instance: WebRecordApp
            private set

        const val CHANNEL_FOLLOWUPS = "followups"
        const val CHANNEL_OVERDUE = "overdue"
        const val CHANNEL_PAYMENTS = "payments"
    }
}
