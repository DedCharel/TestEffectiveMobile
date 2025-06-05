package ru.nvgsoft.testeffectivemobile.domain

data class Offer(
    val id: String = "near_vacancies",
    val title: String = "Вакансии рядом с вами",
    val link: String = "https://hh.ru/",
    val button: ButtonText? = null
)

data class ButtonText(
    val text: String =""
)
