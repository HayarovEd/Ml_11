package com.financialtracker.app.domain.model

import com.financialtracker.app.domain.model.basedto.BaseState

sealed class StatusApplication {
    object Loading: StatusApplication()
    object Mock : StatusApplication()
    object Splash: StatusApplication()
    class Connect (val baseState: BaseState): StatusApplication()

    class Offer (
        val currentBaseState: BaseState,
        val elementOffer: ElementOffer
        ): StatusApplication()

    class Info (
        val currentBaseState: BaseState,
        val content: String
        ): StatusApplication()

    class Web (
        val url: String,
        val offerName: String
    ): StatusApplication()

    object NoConnect: StatusApplication()
}
