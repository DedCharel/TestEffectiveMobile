package ru.nvgsoft.testeffectivemobile.presentation.vacancy

import ru.nvgsoft.testeffectivemobile.domain.entity.OfferModel

sealed class OfferScreenState {

    object Initial: OfferScreenState()

    object Loading: OfferScreenState()

    data class OfferList(val offers: List<OfferModel>):OfferScreenState()
}