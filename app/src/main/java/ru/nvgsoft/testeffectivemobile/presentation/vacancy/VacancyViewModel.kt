package ru.nvgsoft.testeffectivemobile.presentation.vacancy

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch
import ru.nvgsoft.testeffectivemobile.domain.usecase.ChangeFavoriteUseCase
import ru.nvgsoft.testeffectivemobile.domain.usecase.GetOfferListUseCase
import ru.nvgsoft.testeffectivemobile.domain.usecase.GetVacancyListUseCase
import ru.nvgsoft.testeffectivemobile.domain.usecase.LoadDataToDatabaseUseCase
import javax.inject.Inject

class VacancyViewModel @Inject constructor(
    private val getVacancyListUseCase: GetVacancyListUseCase,
    private val getOfferListUseCase: GetOfferListUseCase,
    private val loadDataToDatabaseUseCase: LoadDataToDatabaseUseCase,
    private val changeFavoriteUseCase: ChangeFavoriteUseCase
) : ViewModel() {


    val vacancyScreenState: Flow<VacancyScreenState> = getVacancyListUseCase()
        .onStart { VacancyScreenState.Loading }
        .map { VacancyScreenState.VacancyList(it) }
    val offerScreenState: Flow<OfferScreenState> = getOfferListUseCase()
        .onStart { OfferScreenState.Loading }
        .map { OfferScreenState.OfferList(it) }


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