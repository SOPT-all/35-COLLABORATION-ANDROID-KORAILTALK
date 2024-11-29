package com.sopt.korailtalk.domain.model

data class TicketData(
    val departurePlace: String,
    val arrivalPlace: String,
    val date: String,
    val trainName: String,
    val departureTime: String,
    val arrivalTime: String,
    val seatName: String,
    val ticketPrice: Int,
    val limitPaymentTime: String,
    val coachesNumber: Int
)