package ru.nvgsoft.testeffectivemobile.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
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



