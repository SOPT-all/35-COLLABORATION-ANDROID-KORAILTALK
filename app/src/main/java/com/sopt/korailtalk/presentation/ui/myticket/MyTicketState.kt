package com.sopt.korailtalk.presentation.ui.myticket

import com.sopt.korailtalk.data.remote.model.response.TicketData

sealed class MyTicketState {
    data object Idle: MyTicketState()
    data object Loading: MyTicketState()
    data class Success(val data: TicketData): MyTicketState()
    data class Failure(val message: String): MyTicketState()
}