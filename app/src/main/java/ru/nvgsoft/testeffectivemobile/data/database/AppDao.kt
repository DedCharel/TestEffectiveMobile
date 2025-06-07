package ru.nvgsoft.testeffectivemobile.data.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface AppDao {

    @Query("SELECT * FROM vacancy")
    fun getVacancyList(): List<VacancyDbModel>


    @Query("SELECT * FROM vacancy WHERE id=:vacancyId LIMIT 1")
    suspend fun getVacancy(vacancyId: String): VacancyDbModel


    @Query("SELECT * FROM offer")
    fun getOfferList(): List<OfferDbModel>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addVacancyList(list: List<VacancyDbModel>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addVacancy(vacancy: VacancyDbModel)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addOffer(list: List<OfferDbModel>)

}