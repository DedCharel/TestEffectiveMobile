package ru.nvgsoft.testeffectivemobile.presentation.favourite

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import ru.nvgsoft.testeffectivemobile.data.RepositoryImpl
import ru.nvgsoft.testeffectivemobile.domain.entity.VacancyEntity
import ru.nvgsoft.testeffectivemobile.domain.usecase.ChangeFavoriteUseCase
import ru.nvgsoft.testeffectivemobile.domain.usecase.GetVacancyListUseCase

class FavouriteViewModel(application: Application) : AndroidViewModel(application) {

    private val repository = RepositoryImpl(application)

    private val changeFavoriteUseCase = ChangeFavoriteUseCase(repository)


    val vacancy = GetVacancyListUseCase(repository).invoke()
        .map {
            it.filter { item -> item.isFavorite }
        }


    fun changeFavouriteStatus(vacancyId: String) {
        viewModelScope.launch {
            changeFavoriteUseCase(vacancyId)
        }


    }
}