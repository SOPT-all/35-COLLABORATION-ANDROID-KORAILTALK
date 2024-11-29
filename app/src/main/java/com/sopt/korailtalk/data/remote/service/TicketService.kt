package com.sopt.korailtalk.data.remote.service

import com.sopt.korailtalk.data.remote.model.base.ApiResponse
import com.sopt.korailtalk.data.remote.model.response.TicketResponseDto
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Path

interface TicketService {
    @GET("tickets/{ticketId}")
    suspend fun getTicketInformation(
        @Header("userId") userId: Long,
        @Path("ticketId") ticketId: Long
    ): ApiResponse<TicketResponseDto>
}