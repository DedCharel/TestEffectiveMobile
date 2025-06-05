package ru.nvgsoft.testeffectivemobile.presentation

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import ru.nvgsoft.testeffectivemobile.ui.theme.TestEffectiveMobileTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val viewModel by viewModels<MainViewModel> ()

        fun onClickOffer(url:String) = {
            Intent(Intent.ACTION_VIEW, Uri.parse(url))

        }

        setContent {
            TestEffectiveMobileTheme {
                MainScreen(viewModel)

            }
        }
    }
}



