package ru.nvgsoft.testeffectivemobile.data

import android.app.Application
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.stateIn
import ru.nvgsoft.testeffectivemobile.data.database.AppDatabase
import ru.nvgsoft.testeffectivemobile.data.network.ApiFactory
import ru.nvgsoft.testeffectivemobile.domain.entity.OfferModel
import ru.nvgsoft.testeffectivemobile.domain.entity.VacancyModel
import ru.nvgsoft.testeffectivemobile.utils.mergeWith


class RepositoryImpl(
    application: Application
) {

    private val mapper = Mapper()
    private val apiService = ApiFactory.apiService
    private val dao = AppDatabase.getInstance(application).appDao()

    private val coroutineScope = CoroutineScope(Dispatchers.Default)
    private val refreshedListFlow = MutableSharedFlow<List<VacancyModel>>()
    private val loadVacancies = flow {
        val vacanciesDb = dao.getVacancyList()
        val vacancies = mapper.mapListDbModelVacancyToEntityList(vacanciesDb)
        _vacancy.addAll(vacancies)
        emit(vacancy)
    }

    private val loadOffers = flow {
        val offersDb = dao.getOfferList()
        val offers = mapper.mapListDbModelOfferToEntityList(offersDb)
        _offer.addAll(offers)
        emit(offer)
    }

    private val _vacancy = mutableListOf<VacancyModel>()
    private val vacancy: List<VacancyModel>
        get() = _vacancy.toList()

    private val _offer = mutableListOf<OfferModel>()
    private val offer: List<OfferModel>
        get() = _offer.toList()



    private val vacancies: StateFlow<List<VacancyModel>> = loadVacancies
        .mergeWith(refreshedListFlow)
        .stateIn(
        scope = coroutineScope,
        started = SharingStarted.Lazily,
        initialValue = vacancy
    )

    private val offers = loadOffers
        .stateIn(
            scope = coroutineScope,
            started = SharingStarted.Lazily,
            initialValue = offer
        )

   fun getOfferList(): StateFlow<List<OfferModel>> = offers

    fun getVacancyList(): StateFlow<List<VacancyModel>> = vacancies


    suspend fun loadDataToDatabase() {
        try {
            val response = apiService.getData()
            dao.addVacancyList(mapper.mapListDtoModelVacancyToDBList(response.vacancies))
            dao.addOffer(mapper.mapListDtoModelOfferToDBList(response.offers))
        } catch (e: Exception){

        }

    }

    suspend fun changeFavourite(vac: VacancyModel){
        val oldVacancy = vac
        val index =_vacancy.indexOf(vac)
        val newVacancy = vac.copy(isFavorite = !oldVacancy.isFavorite)
        dao.addVacancy(mapper.mapEntityVacancyToDbModel(newVacancy))
        _vacancy[index] = newVacancy
        refreshedListFlow.emit(vacancy)

    }
}


