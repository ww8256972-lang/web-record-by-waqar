package com.waqar.webrecord.utils

import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale
import java.util.concurrent.atomic.AtomicInteger

object IdGenerator {
    private val counter = AtomicInteger(0)
    private val dateFormat = SimpleDateFormat("yyyyMMdd", Locale.US)

    fun nextCustomerCode(): String {
        val date = dateFormat.format(Date())
        val seq = counter.incrementAndGet() % 10000
        val random = (1000..9999).random()
        return "WR-$date-${String.format("%04d", seq)}-$random"
    }
}
