package ru.nvgsoft.testeffectivemobile.presentation

import ru.nvgsoft.testeffectivemobile.domain.OfferModel
import ru.nvgsoft.testeffectivemobile.domain.VacancyModel

sealed class MainScreenState {

    data class VacancyList(
        val vacancyList: List<VacancyModel>,
        val offersList: List<OfferModel>
    ): MainScreenState()

    data class VacancyDetail(val vacancy: VacancyModel): MainScreenState()
}