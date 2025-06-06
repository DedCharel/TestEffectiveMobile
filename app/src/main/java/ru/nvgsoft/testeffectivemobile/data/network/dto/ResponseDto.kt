package ru.nvgsoft.testeffectivemobile.data.network.dto

data class ResponseDto(
    val offers: List<OfferDto>,
    val vacancies: List<VacancyDto>
)
