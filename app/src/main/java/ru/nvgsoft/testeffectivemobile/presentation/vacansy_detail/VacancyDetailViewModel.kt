package ru.nvgsoft.testeffectivemobile.presentation.vacansy_detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import ru.nvgsoft.testeffectivemobile.domain.ButtonText
import ru.nvgsoft.testeffectivemobile.domain.OfferModel
import ru.nvgsoft.testeffectivemobile.domain.VacancyModel

class VacancyDetailViewModel: ViewModel() {

    val _screenState = MutableLiveData<VacancyDetailScreenState>(VacancyDetailScreenState.Initial)
    val screenState: LiveData<VacancyDetailScreenState> = _screenState



    init {
        _screenState.value = VacancyDetailScreenState.VacancyDetail(VacancyModel())
    }
}