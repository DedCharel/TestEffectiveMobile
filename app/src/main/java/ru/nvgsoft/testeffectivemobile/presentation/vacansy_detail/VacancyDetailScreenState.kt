package ru.nvgsoft.testeffectivemobile.presentation.vacansy_detail

import ru.nvgsoft.testeffectivemobile.domain.entity.VacancyModel

sealed class VacancyDetailScreenState {

    object Initial: VacancyDetailScreenState()

    data class VacancyDetail(val vacancy: VacancyModel): VacancyDetailScreenState()
}