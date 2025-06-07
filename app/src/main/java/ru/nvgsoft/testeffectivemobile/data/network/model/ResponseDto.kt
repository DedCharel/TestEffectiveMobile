package ru.nvgsoft.testeffectivemobile.data.network.model

data class ResponseDto(
    val offers: List<OfferDto>,
    val vacancies: List<VacancyDto>
)
