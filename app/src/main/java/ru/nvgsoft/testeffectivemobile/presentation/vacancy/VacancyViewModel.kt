package ru.nvgsoft.testeffectivemobile.presentation.vacancy

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import ru.nvgsoft.testeffectivemobile.data.Mapper
import ru.nvgsoft.testeffectivemobile.data.RepositoryImpl
import ru.nvgsoft.testeffectivemobile.data.network.ApiFactory
import ru.nvgsoft.testeffectivemobile.data.network.ApiService
import ru.nvgsoft.testeffectivemobile.domain.entity.OfferModel
import ru.nvgsoft.testeffectivemobile.domain.entity.VacancyModel

class VacancyViewModel(application: Application) : AndroidViewModel(application) {

    private val sourceList = listOf(
        VacancyModel(),
        VacancyModel(id = "111"),
        VacancyModel(id = "222"),
        VacancyModel(id = "333")
    )


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

    val maper = Mapper()


    private val vacancyState:VacancyScreenState = VacancyScreenState.Initial

    private val _screenState = MutableLiveData<VacancyScreenState>(vacancyState)
    val screenState: LiveData<VacancyScreenState> = _screenState

    init {
        loadData()
    }

    private fun loadData() {
        viewModelScope.launch {
            val response = ApiFactory.apiService.getData()
            val vacancies = maper.mapListDtoModelVacancyToListEntity(response.vacancies)
            val offers = maper.mapListDtoModelOffersToListEntity(response.offers)

            _screenState.value = VacancyScreenState.VacancyList(vacancies, offers)
        }

    }


    fun changeFavourite(vac: VacancyModel) {
        //TODO

    }
}