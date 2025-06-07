package ru.nvgsoft.testeffectivemobile.data

import android.app.Application
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.stateIn
import ru.nvgsoft.testeffectivemobile.data.database.AppDao
import ru.nvgsoft.testeffectivemobile.data.network.ApiService
import ru.nvgsoft.testeffectivemobile.domain.Repository
import ru.nvgsoft.testeffectivemobile.domain.entity.OfferEntity
import ru.nvgsoft.testeffectivemobile.domain.entity.VacancyEntity
import ru.nvgsoft.testeffectivemobile.utils.mergeWith
import javax.inject.Inject


class RepositoryImpl @Inject constructor(
    private val mapper: Mapper,
    private val apiService: ApiService,
    private val dao: AppDao
) : Repository {

//    private val mapper = Mapper()
//    private val apiService = ApiFactory.apiService
//    private val dao = AppDatabase.getInstance(application).appDao()

    private val coroutineScope = CoroutineScope(Dispatchers.Default)
    private val refreshedListFlow = MutableSharedFlow<List<VacancyEntity>>()
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

    private val _vacancy = mutableListOf<VacancyEntity>()
    private val vacancy: List<VacancyEntity>
        get() = _vacancy.toList()

    private val _offer = mutableListOf<OfferEntity>()
    private val offer: List<OfferEntity>
        get() = _offer.toList()


    private val vacancies: StateFlow<List<VacancyEntity>> = loadVacancies
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

    override fun getOfferList(): StateFlow<List<OfferEntity>> = offers

    override fun getVacancyList(): StateFlow<List<VacancyEntity>> = vacancies


    override suspend fun loadDataToDatabase() {
        try {
            val response = apiService.getData()
            dao.addVacancyList(mapper.mapListDtoModelVacancyToDBList(response.vacancies))
            dao.addOffer(mapper.mapListDtoModelOfferToDBList(response.offers))
        } catch (e: Exception) {

        }

    }

    override suspend fun changeFavourite(vacancyId: String) {
        val currentVacancy = mapper.mapDbModelVacancyToEntity(dao.getVacancy(vacancyId))
        val oldVacancy = currentVacancy
        val index = _vacancy.indexOf(currentVacancy)
        val newVacancy = currentVacancy.copy(isFavorite = !oldVacancy.isFavorite)
        dao.addVacancy(mapper.mapEntityVacancyToDbModel(newVacancy))
        _vacancy[index] = newVacancy
        refreshedListFlow.emit(vacancy)

    }
}


