package ru.nvgsoft.testeffectivemobile.presentation.favourite

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import ru.nvgsoft.testeffectivemobile.domain.entity.VacancyEntity
import ru.nvgsoft.testeffectivemobile.domain.usecase.ChangeFavoriteUseCase
import ru.nvgsoft.testeffectivemobile.domain.usecase.GetVacancyListUseCase
import javax.inject.Inject

class FavouriteViewModel @Inject constructor(
    private val changeFavoriteUseCase: ChangeFavoriteUseCase,
    private val getVacancyListUseCase: GetVacancyListUseCase
    ) : ViewModel() {


    val vacancy = getVacancyListUseCase.invoke()
        .map {
            it.filter { item -> item.isFavorite }
        }


    fun changeFavouriteStatus(vacancy: VacancyEntity) {
        viewModelScope.launch {
            changeFavoriteUseCase(vacancy)
        }


    }
}