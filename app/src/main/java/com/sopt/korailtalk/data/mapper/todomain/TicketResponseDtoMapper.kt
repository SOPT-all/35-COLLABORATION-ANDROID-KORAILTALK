package com.sopt.korailtalk.data.mapper.todomain

import com.sopt.korailtalk.data.remote.model.response.TicketResponseDto
import com.sopt.korailtalk.domain.model.TicketData

fun TicketResponseDto.toDomain(): TicketData = TicketData(
    departurePlace = this.departurePlace,
    arrivalPlace = this.arrivalPlace,
    date = this.date,
    trainName = this.trainName,
    departureTime = this.departureTime,
    arrivalTime = this.arrivalTime,
    seatName = this.seatName,
    ticketPrice = this.ticketPrice,
    limitPaymentTime = this.limitPaymentTime,
    coachesNumber = this.coachesNumber
)