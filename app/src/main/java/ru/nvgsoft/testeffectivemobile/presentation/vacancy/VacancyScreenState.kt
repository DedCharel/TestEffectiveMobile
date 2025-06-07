package ru.nvgsoft.testeffectivemobile.presentation.vacancy

import ru.nvgsoft.testeffectivemobile.domain.entity.VacancyEntity

sealed class VacancyScreenState {

    object Initial: VacancyScreenState()

    object Loading: VacancyScreenState()

    data class VacancyList(val vacancyList: List<VacancyEntity>): VacancyScreenState()
}