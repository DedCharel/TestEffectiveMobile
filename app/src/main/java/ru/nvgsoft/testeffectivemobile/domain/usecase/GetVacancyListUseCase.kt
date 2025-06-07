package ru.nvgsoft.testeffectivemobile.domain.usecase

import kotlinx.coroutines.flow.StateFlow
import ru.nvgsoft.testeffectivemobile.data.RepositoryImpl
import ru.nvgsoft.testeffectivemobile.domain.entity.VacancyModel

class GetVacancyListUseCase(private val repositoryImpl: RepositoryImpl) {

    operator fun invoke(): StateFlow<List<VacancyModel>>{
        return repositoryImpl.getVacancyList()
    }
}