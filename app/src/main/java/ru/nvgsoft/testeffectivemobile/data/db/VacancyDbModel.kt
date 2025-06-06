package ru.nvgsoft.testeffectivemobile.data.db

import android.os.Bundle
import android.os.Parcelable
import androidx.compose.runtime.Immutable
import androidx.navigation.NavType
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverter
import androidx.room.TypeConverters
import com.google.gson.Gson
import kotlinx.parcelize.Parcelize

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
    val description: String,
    val responsibilities: String ,

    val questions: List<String>,
)



