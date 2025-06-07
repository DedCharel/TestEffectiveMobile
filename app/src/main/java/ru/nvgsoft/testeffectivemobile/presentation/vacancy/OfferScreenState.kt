package ru.nvgsoft.testeffectivemobile.presentation.vacancy

import ru.nvgsoft.testeffectivemobile.domain.entity.OfferEntity

sealed class OfferScreenState {

    object Initial: OfferScreenState()

    object Loading: OfferScreenState()

    data class OfferList(val offers: List<OfferEntity>):OfferScreenState()
}