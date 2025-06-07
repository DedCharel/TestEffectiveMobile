package ru.nvgsoft.testeffectivemobile.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import ru.nvgsoft.testeffectivemobile.ui.theme.TestEffectiveMobileTheme
import javax.inject.Inject


class MainActivity : ComponentActivity() {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    private val component by lazy {
        (application as JobApplication).component
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        component.inject(this)
        super.onCreate(savedInstanceState)



        setContent {
            TestEffectiveMobileTheme {
                MainScreen(viewModelFactory)

            }
        }
    }
}



