package com.sopt.korailtalk.domain.repository

import com.sopt.korailtalk.domain.model.LPoint
import com.sopt.korailtalk.domain.model.TicketBuying

interface PaymentRepository {
    suspend fun getLpoint(userId: Long, pointPassword: Int): Result<LPoint>
    suspend fun buyTicket(ticketBuying: TicketBuying): Result<Unit>
}