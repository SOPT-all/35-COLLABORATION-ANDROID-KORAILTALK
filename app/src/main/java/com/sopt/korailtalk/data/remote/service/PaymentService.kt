package com.sopt.korailtalk.data.remote.service

import com.sopt.korailtalk.data.remote.model.base.ApiResponse
import com.sopt.korailtalk.data.remote.model.request.TicketBuyingRequestDto
import com.sopt.korailtalk.data.remote.model.response.LPointResponseDto
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.PATCH
import retrofit2.http.Query

interface PaymentService {
    @GET("users/points")
    suspend fun getLpoint(
        @Header("userId") userId: Long,
        @Query("pointPassword") pointPassword: Int
    ): ApiResponse<LPointResponseDto>

    @PATCH("tickets")
    suspend fun buyTicket(
        @Body ticketBuyingRequestDto: TicketBuyingRequestDto
    ): ApiResponse<Unit>
}