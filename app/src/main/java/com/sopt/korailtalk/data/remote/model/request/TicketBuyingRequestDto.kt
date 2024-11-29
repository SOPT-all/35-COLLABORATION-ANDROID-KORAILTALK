package com.sopt.korailtalk.data.remote.model.request

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class TicketBuyingRequestDto(
    @SerialName("ticketId") val ticketId: Long,
    @SerialName("totalPrice") val totalPrice: Int,
    @SerialName("usedPoint") val usedPoint: Int
)