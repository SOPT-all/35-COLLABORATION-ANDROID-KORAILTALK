package com.sopt.korailtalk.data.remote.datasource

import com.sopt.korailtalk.data.remote.model.base.ApiResponse
import com.sopt.korailtalk.data.remote.model.request.TicketBuyingRequestDto
import com.sopt.korailtalk.data.remote.model.response.LPointResponseDto

interface PaymentRemoteDataSource {
    suspend fun getLpoint(userId: Long, pointPassword: Int): ApiResponse<LPointResponseDto>
    suspend fun buyTicket(ticketBuyingRequestDto: TicketBuyingRequestDto): ApiResponse<Unit>
}