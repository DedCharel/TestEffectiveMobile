package ru.nvgsoft.testeffectivemobile.presentation.vacansy_detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import ru.nvgsoft.testeffectivemobile.domain.entity.VacancyEntity
import ru.nvgsoft.testeffectivemobile.domain.usecase.ChangeFavoriteUseCase
import javax.inject.Inject

class VacancyDetailViewModel @Inject constructor(
    val changeFavoriteUseCase: ChangeFavoriteUseCase
): ViewModel() {


    // Необходимо изменить получении детальный записей через flow, чтобы обновлялисяь данные о isFavourite bp БД

    fun changeFavouriteStatus(vacancy: VacancyEntity) {
        viewModelScope.launch {
            changeFavoriteUseCase(vacancy)
        }

    }


}