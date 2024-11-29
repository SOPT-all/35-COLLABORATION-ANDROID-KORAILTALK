package com.sopt.korailtalk.data.remote.datasource

import com.sopt.korailtalk.data.remote.model.base.ApiResponse
import com.sopt.korailtalk.data.remote.model.response.TicketResponseDto

interface TicketRemoteDataSource {
    suspend fun getTicketInformation(userId: Long, ticketId: Long): ApiResponse<TicketResponseDto>
}