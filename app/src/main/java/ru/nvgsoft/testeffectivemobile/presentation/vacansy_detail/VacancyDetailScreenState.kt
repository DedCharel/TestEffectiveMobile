package ru.nvgsoft.testeffectivemobile.presentation.vacansy_detail

import ru.nvgsoft.testeffectivemobile.domain.entity.VacancyEntity

sealed class VacancyDetailScreenState {

    object Initial: VacancyDetailScreenState()

    data class VacancyDetail(val vacancy: VacancyEntity): VacancyDetailScreenState()
}