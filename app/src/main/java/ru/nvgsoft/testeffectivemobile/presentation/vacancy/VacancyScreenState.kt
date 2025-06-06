package ru.nvgsoft.testeffectivemobile.presentation.vacancy

import ru.nvgsoft.testeffectivemobile.domain.OfferModel
import ru.nvgsoft.testeffectivemobile.domain.VacancyModel

sealed class VacancyScreenState {

    object Initial: VacancyScreenState()

    data class VacancyList(
        val vacancyList: List<VacancyModel>,
        val offersList: List<OfferModel>
    ): VacancyScreenState()
}