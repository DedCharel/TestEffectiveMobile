package ru.nvgsoft.testeffectivemobile.presentation.favourite

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import ru.nvgsoft.testeffectivemobile.domain.VacancyModel

class FavouriteViewModel: ViewModel() {
    private val _vacancy = MutableLiveData<List<VacancyModel>>(listOf(VacancyModel(), VacancyModel( id = "111"), VacancyModel( id = "222"), VacancyModel(id = "333")))
    val vacancy: LiveData<List<VacancyModel>> = _vacancy
}