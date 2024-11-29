package com.sopt.korailtalk.presentation.ui.traincheck

import com.sopt.korailtalk.domain.model.TicketData

sealed class TicketState {
    data object Idle: TicketState()
    data object Loading: TicketState()
    data class Success(val data: TicketData): TicketState()
    data class Failure(val message: String): TicketState()
}