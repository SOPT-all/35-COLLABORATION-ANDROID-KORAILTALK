package com.sopt.korailtalk.data.remote.service

import com.sopt.korailtalk.data.remote.model.base.ApiResponse
import com.sopt.korailtalk.data.remote.model.request.SeatSelectingRequestDto
import com.sopt.korailtalk.data.remote.model.response.SeatsResponseDto
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.PATCH
import retrofit2.http.Path

interface SeatsService {
    @GET("/coaches/{timetableId}")
    suspend fun getSeats(
        @Body userId: Long,
        @Path("timetableId") timetableId: Long
    ): ApiResponse<SeatsResponseDto>

    @PATCH("/seats")
    suspend fun selectSeat(
        @Body seatSelectingRequestDto: SeatSelectingRequestDto
    ): ApiResponse<Unit>
}