package ru.nvgsoft.testeffectivemobile.domain

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import ru.nvgsoft.testeffectivemobile.domain.entity.OfferModel
import ru.nvgsoft.testeffectivemobile.domain.entity.VacancyModel

interface Repository {

    suspend fun getOffers(context: Context): LiveData<List<OfferModel>>

    suspend fun getVacancies(context: Context) : LiveData<List<VacancyModel>>


   suspend fun getVacancy(vacancyId: String, context: Context): LiveData<VacancyModel>

    fun changeFavourite(vacancyId: String)
}