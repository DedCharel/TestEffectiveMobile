package ru.nvgsoft.testeffectivemobile.presentation

import android.app.Application
import ru.nvgsoft.testeffectivemobile.di.ApplicationComponent

class JobApplication: Application() {

    val component: ApplicationComponent by lazy {
        TODO()
    }
}
//    @Composable
//    fun getApplicationComponent(): ApplicationComponent {
//        return(LocalContext.current.applicationContext as JobApplication).component
//    }
