package ru.nvgsoft.testeffectivemobile.presentation.vacancy

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import ru.nvgsoft.testeffectivemobile.domain.ButtonText
import ru.nvgsoft.testeffectivemobile.domain.OfferModel
import ru.nvgsoft.testeffectivemobile.domain.VacancyModel

class VacancyViewModel: ViewModel() {

    private val sourceList = listOf(VacancyModel(), VacancyModel( id = "111"), VacancyModel( id = "222"), VacancyModel(id = "333"))

    private val initOffers = listOf(
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

    private val vacancyState = VacancyScreenState.VacancyList(sourceList, initOffers)

    private val _screenState = MutableLiveData<VacancyScreenState>(vacancyState)
    val screenState: LiveData<VacancyScreenState> = _screenState






    private var savedState: VacancyScreenState? = vacancyState



    fun changeFavourite(vac: VacancyModel){
        //TODO

    }
}