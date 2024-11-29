package com.sopt.korailtalk.domain.repository

import com.sopt.korailtalk.domain.model.TicketData

interface TicketRepository {
    suspend fun getTicketInformation(userId: Long, ticketId: Long): Result<TicketData>
}