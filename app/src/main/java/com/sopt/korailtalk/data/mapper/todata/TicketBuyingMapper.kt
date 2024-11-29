package com.sopt.korailtalk.data.mapper.todata

import com.sopt.korailtalk.data.remote.model.request.TicketBuyingRequestDto
import com.sopt.korailtalk.domain.model.TicketBuying

fun TicketBuying.toData(): TicketBuyingRequestDto = TicketBuyingRequestDto(
    ticketId = this.ticketId,
    totalPrice = this.totalPrice,
    usedPoint = this.usedPoint
)