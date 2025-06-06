package ru.nvgsoft.testeffectivemobile.data.network.dto

import androidx.compose.runtime.Immutable
import kotlinx.parcelize.Parcelize


data class VacancyDto(
    val id: String,
    val lookingNumber: Int,
    val title: String,
    val address: AddressDto,
    val company: String,
    val experience: ExperienceDto,
    val publishedDate: String,
    val isFavorite: Boolean,
    val salary: SalaryDto,
    val schedules: List<String>,
    val appliedNumber: Int = 147,
    val description: String,
    val responsibilities: String,
    val questions: List<String>
)

