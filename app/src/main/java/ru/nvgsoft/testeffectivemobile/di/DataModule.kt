package ru.nvgsoft.testeffectivemobile.di

import android.app.Application
import dagger.Binds
import dagger.Module
import dagger.Provides
import ru.nvgsoft.testeffectivemobile.data.RepositoryImpl
import ru.nvgsoft.testeffectivemobile.data.database.AppDao
import ru.nvgsoft.testeffectivemobile.data.database.AppDatabase
import ru.nvgsoft.testeffectivemobile.data.network.ApiFactory
import ru.nvgsoft.testeffectivemobile.data.network.ApiService
import ru.nvgsoft.testeffectivemobile.domain.Repository

@Module
interface DataModule {

    @ApplicationScope
    @Binds
    fun bindRepository(impl: RepositoryImpl): Repository

    companion object{
        @ApplicationScope
        @Provides
        fun provideApiService(): ApiService {
            return ApiFactory.apiService
        }

        @ApplicationScope
        @Provides
        fun provideAppDao(
            application: Application
        ): AppDao{
            return AppDatabase.getInstance(application).appDao()
        }
    }
}