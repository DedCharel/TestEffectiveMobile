package ru.nvgsoft.testeffectivemobile

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import ru.nvgsoft.testeffectivemobile.ui.theme.TestEffectiveMobileTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            TestEffectiveMobileTheme {
                MainScreen()
            }
        }
    }
}



