package ru.nvgsoft.testeffectivemobile.presentation.vacansy_detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import ru.nvgsoft.testeffectivemobile.domain.usecase.ChangeFavoriteUseCase
import javax.inject.Inject

class VacancyDetailViewModel @Inject constructor(
    val changeFavoriteUseCase: ChangeFavoriteUseCase
): ViewModel() {



    fun changeFavouriteStatus(vacancyId: String) {
        viewModelScope.launch {
            changeFavoriteUseCase(vacancyId)
        }


    }


}