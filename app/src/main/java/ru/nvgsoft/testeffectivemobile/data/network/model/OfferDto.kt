package ru.nvgsoft.testeffectivemobile.data.network.model

data class OfferDto(
    val id: String = "near_vacancies",
    val title: String = "Вакансии рядом с вами",
    val link: String = "https://hh.ru/",
    val button: ButtonTextDto? = null
)


