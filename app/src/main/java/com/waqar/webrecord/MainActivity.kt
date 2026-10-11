package com.waqar.webrecord

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.waqar.webrecord.domain.model.ThemeMode
import com.waqar.webrecord.ui.navigation.AppNavGraph
import com.waqar.webrecord.ui.theme.WebRecordTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        val prefs = WebRecordApp.instance.securePrefs
        val auth = WebRecordApp.instance.authRepository

        setContent {
            var themeMode by remember {
                mutableStateOf(
                    try {
                        ThemeMode.valueOf(prefs.themeMode)
                    } catch (_: Exception) {
                        ThemeMode.SYSTEM
                    }
                )
            }
            var loggedIn by remember { mutableStateOf(auth.isLoggedIn()) }

            WebRecordTheme(themeMode = themeMode) {
                AppNavGraph(
                    isLoggedIn = loggedIn,
                    themeMode = themeMode,
                    onThemeChange = { mode ->
                        themeMode = mode
                        prefs.themeMode = mode.name
                    },
                    onLogout = {
                        auth.logout()
                        loggedIn = false
                    }
                )
            }
        }
    }
}
