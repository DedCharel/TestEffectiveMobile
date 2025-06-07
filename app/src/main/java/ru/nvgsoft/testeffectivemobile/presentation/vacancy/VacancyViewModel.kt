package ru.nvgsoft.testeffectivemobile.presentation.vacancy

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.zip
import kotlinx.coroutines.launch
import ru.nvgsoft.testeffectivemobile.data.RepositoryImpl
import ru.nvgsoft.testeffectivemobile.domain.entity.OfferModel
import ru.nvgsoft.testeffectivemobile.domain.entity.VacancyModel

class VacancyViewModel(application: Application) : AndroidViewModel(application) {



    private val coroutineScope = CoroutineScope(Dispatchers.Default)
    private val initOffers = listOf(
        OfferModel(),
        OfferModel(
            id = "level_up_resume",
            title = "Поднять резюме в поиске",
            buttonText = "Поднять",
            link = "https://hh.ru/mentors?from=footer_new&hhtmFromLabel=footer_new&hhtmFrom=main&purposeId=1"
        ),
        OfferModel(
            id = "temporary_job",
            title = "Временная работа или подработка",
            link = "https://hh.ru/"
        )
    )
    val repository = RepositoryImpl(getApplication())
    val vacancyFlow = repository.getVacancyList()
    val screenState= repository.getOfferList()
        .combine(vacancyFlow){
            offerModels, vacancyModels -> VacancyScreenState.VacancyList(vacancyModels, offerModels) as VacancyScreenState
    }   .onStart { emit(VacancyScreenState.Loading) }






    private fun loadData() {
        viewModelScope.launch {
            repository.loadDataToDatabase()
        }

    }

    init {
        loadData()
    }



    fun changeFavouriteStatus(vac: VacancyModel) {
        viewModelScope.launch {
            repository.changeFavourite(vac)
        }


    }
}