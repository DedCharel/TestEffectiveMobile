package ru.nvgsoft.testeffectivemobile.presentation

import android.app.Application
import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import ru.nvgsoft.testeffectivemobile.di.ApplicationComponent
import ru.nvgsoft.testeffectivemobile.di.DaggerApplicationComponent

class JobApplication: Application() {

    val component: ApplicationComponent by lazy {
        DaggerApplicationComponent.factory().create(this)
    }
}

@Composable
fun getApplicationComponent(): ApplicationComponent {
    return (LocalContext.current.applicationContext as JobApplication).component
}

