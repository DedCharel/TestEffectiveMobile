package ru.nvgsoft.testeffectivemobile.domain.usecase

import ru.nvgsoft.testeffectivemobile.domain.Repository

class ChangeFavoriteUseCase(
    private val repository: Repository
) {

    suspend operator fun invoke(vacancyId: String) {
        repository.changeFavourite(vacancyId)
    }
}