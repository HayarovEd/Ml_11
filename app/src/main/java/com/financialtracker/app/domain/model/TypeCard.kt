package com.financialtracker.app.domain.model

sealed interface TypeCard{
    object CardCredit: TypeCard
    object CardDebit: TypeCard
    object CardInstallment: TypeCard
}