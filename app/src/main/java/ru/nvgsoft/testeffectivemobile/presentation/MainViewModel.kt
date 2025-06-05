package ru.nvgsoft.testeffectivemobile.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import ru.nvgsoft.testeffectivemobile.domain.ButtonText
import ru.nvgsoft.testeffectivemobile.domain.OfferModel
import ru.nvgsoft.testeffectivemobile.domain.VacancyModel

class MainViewModel: ViewModel() {

    private val _vacancy = MutableLiveData<List<VacancyModel>>(listOf(VacancyModel(), VacancyModel( id = "111"), VacancyModel( id = "222"), VacancyModel(id = "333")))
    val vacancy: LiveData<List<VacancyModel>> = _vacancy

    val initOffers = listOf(
        OfferModel(),
        OfferModel(
            id = "level_up_resume",
            title = "Поднять резюме в поиске",
            button = ButtonText("Поднять"),
            link = "https://hh.ru/mentors?from=footer_new&hhtmFromLabel=footer_new&hhtmFrom=main&purposeId=1"
        ),
        OfferModel(
            id = "temporary_job",
            title = "Временная работа или подработка",
            link = "https://hh.ru/"
        )

    )

    private val _offers= MutableLiveData<List<OfferModel>>(initOffers)
    val offers: LiveData<List<OfferModel>> = _offers

    fun changeFavourite(vac: VacancyModel){
        //TODO

    }
}