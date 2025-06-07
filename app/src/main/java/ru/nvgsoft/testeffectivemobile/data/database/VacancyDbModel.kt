package ru.nvgsoft.testeffectivemobile.data.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "vacancy")
data class VacancyDbModel(
    @PrimaryKey val id: String ,
    val lookingNumber: Int,
    val title: String,
    val addressTown: String,
    val addressStreet: String,
    val addressHouse: String,
    val company: String,
    val experiencePreviewText: String,
    val experienceText: String,
    val publishedDate: String,
    val isFavorite: Boolean,
    val salaryFull: String,
    val schedules: List<String>,
    val appliedNumber: Int,
    val description: String?,
    val responsibilities: String ,

    val questions: List<String>,
)



