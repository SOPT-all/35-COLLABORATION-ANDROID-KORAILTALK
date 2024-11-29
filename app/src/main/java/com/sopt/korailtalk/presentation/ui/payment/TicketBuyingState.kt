package com.sopt.korailtalk.presentation.ui.payment

sealed class TicketBuyingState {
    data object Idle: TicketBuyingState()
    data object Loading: TicketBuyingState()
    data object Success: TicketBuyingState()
    data class Failure(val message: String): TicketBuyingState()
}