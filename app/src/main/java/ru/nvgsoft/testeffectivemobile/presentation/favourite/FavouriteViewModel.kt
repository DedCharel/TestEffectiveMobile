package ru.nvgsoft.testeffectivemobile.presentation.favourite

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.flatMap
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import ru.nvgsoft.testeffectivemobile.data.RepositoryImpl
import ru.nvgsoft.testeffectivemobile.domain.entity.VacancyModel
import ru.nvgsoft.testeffectivemobile.domain.usecase.GetVacancyListUseCase
import ru.nvgsoft.testeffectivemobile.presentation.vacancy.VacancyScreenState

class FavouriteViewModel(application: Application) : AndroidViewModel(application) {

    val repository = RepositoryImpl(application)
    val vacancy = GetVacancyListUseCase(repository).invoke()
        .map {
            it.filter { item -> item.isFavorite }
        }


    fun changeFavouriteStatus(vac: VacancyModel) {
        viewModelScope.launch {
            repository.changeFavourite(vac)
        }


    }
}