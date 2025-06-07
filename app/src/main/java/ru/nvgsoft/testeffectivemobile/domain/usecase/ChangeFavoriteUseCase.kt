package ru.nvgsoft.testeffectivemobile.domain.usecase

import ru.nvgsoft.testeffectivemobile.domain.Repository
import javax.inject.Inject

class ChangeFavoriteUseCase @Inject constructor(
    private val repository: Repository
) {

    suspend operator fun invoke(vacancyId: String) {
        repository.changeFavourite(vacancyId)
    }
}