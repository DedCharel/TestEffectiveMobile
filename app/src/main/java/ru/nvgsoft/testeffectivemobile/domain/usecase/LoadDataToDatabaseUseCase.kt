package ru.nvgsoft.testeffectivemobile.domain.usecase

import ru.nvgsoft.testeffectivemobile.domain.Repository

class LoadDataToDatabaseUseCase(private val repository: Repository) {

    suspend operator fun invoke() {
        repository.loadDataToDatabase()
    }
}