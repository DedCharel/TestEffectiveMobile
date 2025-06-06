package ru.nvgsoft.testeffectivemobile.data.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query

@Dao
interface AppDao {

    @Query("SELECT * FROM vacancy")
    fun getVacancyList(): LiveData<List<VacancyDbModel>>


    @Query("SELECT * FROM vacancy WHERE id=:vacancyId LIMIT 1")
    suspend fun getWVacancy(vacancyId: String): VacancyDbModel


    @Query("SELECT * FROM offer")
    fun getOfferList(): LiveData<List<OfferDbModel>>

}