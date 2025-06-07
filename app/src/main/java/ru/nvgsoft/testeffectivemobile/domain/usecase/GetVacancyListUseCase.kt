package ru.nvgsoft.testeffectivemobile.domain.usecase

import kotlinx.coroutines.flow.StateFlow
import ru.nvgsoft.testeffectivemobile.domain.Repository
import ru.nvgsoft.testeffectivemobile.domain.entity.VacancyEntity
import javax.inject.Inject

class GetVacancyListUseCase @Inject constructor(private val repository: Repository) {

    operator fun invoke(): StateFlow<List<VacancyEntity>> {
        return repository.getVacancyList()
    }
}