package com.sopt.korailtalk.data.mapper.todomain

import com.sopt.korailtalk.data.remote.model.response.SeatTicketResponseDto
import com.sopt.korailtalk.domain.model.SeatTicket

fun SeatTicketResponseDto.toDomain(): SeatTicket = SeatTicket(
    ticketId = this.ticketId
)