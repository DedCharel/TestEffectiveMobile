package ru.nvgsoft.testeffectivemobile.domain.usecase

import ru.nvgsoft.testeffectivemobile.domain.Repository
import ru.nvgsoft.testeffectivemobile.domain.entity.VacancyEntity
import javax.inject.Inject

class ChangeFavoriteUseCase @Inject constructor(
    private val repository: Repository
) {

    suspend operator fun invoke(vacancy: VacancyEntity) {
        repository.changeFavourite(vacancy)
    }
}