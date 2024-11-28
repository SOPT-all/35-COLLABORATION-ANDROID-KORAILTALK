package com.sopt.korailtalk.data.remote.service

import com.sopt.korailtalk.data.remote.model.base.ApiResponse
import com.sopt.korailtalk.data.remote.model.request.SeatSelectingRequestDto
import com.sopt.korailtalk.data.remote.model.response.LeftSeatsResponseDto
import com.sopt.korailtalk.data.remote.model.response.SeatTicketResponse
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST
import retrofit2.http.Path

interface SeatsService {
    @GET("coaches/{timetableId}")
    suspend fun getSeats(
        @Header("userId") userId: Long,
        @Path("timetableId") timetableId: Long
    ): ApiResponse<LeftSeatsResponseDto>

    @POST("seats")
    suspend fun selectSeat(
        @Header("userId") userId: Long,
        @Body seatSelectingRequestDto: SeatSelectingRequestDto
    ): ApiResponse<SeatTicketResponse>
}