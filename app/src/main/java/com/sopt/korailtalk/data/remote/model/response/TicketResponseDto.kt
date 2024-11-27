package com.sopt.korailtalk.data.remote.model.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


@Serializable
data class TicketResponseDto(
    @SerialName("data")
    val data: TicketData
)

@Serializable
data class TicketData(
    @SerialName("departurePlace")
    val departurePlace: String,
    @SerialName("arrivalPlace")
    val arrivalPlace: String,
    @SerialName("date")
    val date: String,
    @SerialName("trainName")
    val trainName: String,
    @SerialName("departureTime")
    val departureTime: String,
    @SerialName("arrivalTime")
    val arrivalTime: String,
    @SerialName("seatName")
    val seatName: String,
    @SerialName("ticketPrice")
    val ticketPrice: Int,
    @SerialName("limitPaymentTime")
    val limitPaymentTime: String,
    @SerialName("coachesNumber")
    val coachesNumber: Int
)