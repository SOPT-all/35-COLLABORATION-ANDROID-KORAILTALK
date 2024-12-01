package com.sopt.korailtalk.data.remote.model.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class SeatTicketResponseDto(
    @SerialName("ticketId") val ticketId: Long
)