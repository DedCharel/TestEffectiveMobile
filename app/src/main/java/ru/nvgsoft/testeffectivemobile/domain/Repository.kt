package ru.nvgsoft.testeffectivemobile.domain

import kotlinx.coroutines.flow.StateFlow
import ru.nvgsoft.testeffectivemobile.domain.entity.OfferEntity
import ru.nvgsoft.testeffectivemobile.domain.entity.VacancyEntity

interface Repository {

    fun getVacancyList(): StateFlow<List<VacancyEntity>>

    fun getOfferList(): StateFlow<List<OfferEntity>>

    suspend fun changeFavourite(vacancyEntity: VacancyEntity)

    suspend fun loadDataToDatabase()
}