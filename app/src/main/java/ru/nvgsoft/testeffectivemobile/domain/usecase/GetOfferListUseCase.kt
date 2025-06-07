package ru.nvgsoft.testeffectivemobile.domain.usecase

import kotlinx.coroutines.flow.StateFlow
import ru.nvgsoft.testeffectivemobile.domain.Repository
import ru.nvgsoft.testeffectivemobile.domain.entity.OfferEntity
import javax.inject.Inject

class GetOfferListUseCase @Inject constructor(private val repository: Repository) {

    operator fun invoke(): StateFlow<List<OfferEntity>> {
        return repository.getOfferList()
    }
}