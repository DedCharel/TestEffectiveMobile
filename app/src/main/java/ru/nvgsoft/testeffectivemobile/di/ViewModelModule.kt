package ru.nvgsoft.testeffectivemobile.di

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import ru.nvgsoft.testeffectivemobile.presentation.favourite.FavouriteViewModel
import ru.nvgsoft.testeffectivemobile.presentation.vacancy.VacancyViewModel
import ru.nvgsoft.testeffectivemobile.presentation.vacansy_detail.VacancyDetailViewModel

@Module
interface ViewModelModule {

    @IntoMap
    @ViewModelKey(VacancyViewModel::class)
    @Binds
    fun bindsVacancyViewModel(viewModel: VacancyViewModel): ViewModel

    @IntoMap
    @ViewModelKey(FavouriteViewModel::class)
    @Binds
    fun bindsFavouriteViewModel(viewModel: FavouriteViewModel): ViewModel

    @IntoMap
    @ViewModelKey(VacancyDetailViewModel::class)
    @Binds
    fun bindsVacancyDetailViewModel(viewModel: VacancyDetailViewModel): ViewModel

}