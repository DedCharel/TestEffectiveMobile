package ru.nvgsoft.testeffectivemobile.di

import android.app.Application
import android.content.Context
import dagger.BindsInstance
import dagger.Component
import ru.nvgsoft.testeffectivemobile.presentation.MainActivity
import ru.nvgsoft.testeffectivemobile.presentation.ViewModelFactory

@ApplicationScope
@Component(
    modules = [
        DataModule::class,
        ViewModelModule::class
    ]
)
interface ApplicationComponent {

    fun getViewModelFactory(): ViewModelFactory

    @Component.Factory
    interface Factory{

        fun create(
            @BindsInstance application: Application
        ):ApplicationComponent
    }
}