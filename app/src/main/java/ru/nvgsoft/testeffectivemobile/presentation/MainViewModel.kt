package ru.nvgsoft.testeffectivemobile.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import ru.nvgsoft.testeffectivemobile.domain.ButtonText
import ru.nvgsoft.testeffectivemobile.domain.Offer
import ru.nvgsoft.testeffectivemobile.domain.Vacancy

class MainViewModel: ViewModel() {

    private val _vacancy = MutableLiveData<List<Vacancy>>(listOf(Vacancy(), Vacancy( id = "111"), Vacancy( id = "222"), Vacancy(id = "333")))
    val vacancy: LiveData<List<Vacancy>> = _vacancy

    val initOffers = listOf(
        Offer(),
        Offer(
            id = "level_up_resume",
            title = "Поднять резюме в поиске",
            button = ButtonText("Поднять"),
            link = "https://hh.ru/mentors?from=footer_new&hhtmFromLabel=footer_new&hhtmFrom=main&purposeId=1"
        ),
        Offer(
            id = "temporary_job",
            title = "Временная работа или подработка",
            link = "https://hh.ru/"
        )

    )

    private val _offers= MutableLiveData<List<Offer>>(initOffers)
    val offers: LiveData<List<Offer>> = _offers

    fun changeFavourite(vac: Vacancy){
        //TODO

    }
}