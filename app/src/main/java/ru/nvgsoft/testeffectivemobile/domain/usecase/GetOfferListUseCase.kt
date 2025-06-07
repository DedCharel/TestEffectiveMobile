package ru.nvgsoft.testeffectivemobile.domain.usecase

import kotlinx.coroutines.flow.StateFlow
import ru.nvgsoft.testeffectivemobile.data.RepositoryImpl
import ru.nvgsoft.testeffectivemobile.domain.entity.OfferModel

class GetOfferListUseCase(private val repository: RepositoryImpl) {

    operator fun invoke(): StateFlow<List<OfferModel>>{
        return repository.getOfferList()
    }
}