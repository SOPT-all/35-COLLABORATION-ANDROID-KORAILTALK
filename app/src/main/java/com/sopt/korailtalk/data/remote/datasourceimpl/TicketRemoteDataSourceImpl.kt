package com.sopt.korailtalk.data.remote.datasourceimpl

import com.sopt.korailtalk.data.remote.datasource.TicketRemoteDataSource
import com.sopt.korailtalk.data.remote.service.TicketService
import javax.inject.Inject

class TicketRemoteDataSourceImpl @Inject constructor(
    private val ticketService: TicketService
) : TicketRemoteDataSource {
    override suspend fun getTicketInformation(userId: Long, ticketId: Long) =
        ticketService.getTicketInformation(userId, ticketId)
}