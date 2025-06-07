package ru.nvgsoft.testeffectivemobile.presentation.vacancy

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch
import ru.nvgsoft.testeffectivemobile.data.RepositoryImpl
import ru.nvgsoft.testeffectivemobile.domain.entity.VacancyEntity
import ru.nvgsoft.testeffectivemobile.domain.usecase.ChangeFavoriteUseCase
import ru.nvgsoft.testeffectivemobile.domain.usecase.GetOfferListUseCase
import ru.nvgsoft.testeffectivemobile.domain.usecase.GetVacancyListUseCase
import ru.nvgsoft.testeffectivemobile.domain.usecase.LoadDataToDatabaseUseCase

class VacancyViewModel(application: Application) : AndroidViewModel(application) {

    private val repository = RepositoryImpl(getApplication())
    private val getVacancyListUseCase = GetVacancyListUseCase(repository)
    private val getOfferListUseCase = GetOfferListUseCase(repository)
    private val loadDataToDatabaseUseCase = LoadDataToDatabaseUseCase(repository)
    private val changeFavoriteUseCase = ChangeFavoriteUseCase(repository)

    val vacancyScreenState: Flow<VacancyScreenState> = getVacancyListUseCase()
        .onStart { VacancyScreenState.Loading }
        .map { VacancyScreenState.VacancyList(it)  }
    val offerScreenState: Flow<OfferScreenState> = getOfferListUseCase()
        .onStart { OfferScreenState.Loading }
        .map {OfferScreenState.OfferList(it) }


    private fun loadData() {
        viewModelScope.launch {
            loadDataToDatabaseUseCase()
        }
    }

    init {
        vacancyScreenState
        loadData()
    }

    fun changeFavouriteStatus(vacancyId: String) {
        viewModelScope.launch {
            changeFavoriteUseCase(vacancyId)
        }


    }
}