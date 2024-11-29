package com.sopt.korailtalk.data.remote.service

import com.sopt.korailtalk.data.remote.model.base.ApiResponse
import com.sopt.korailtalk.data.remote.model.request.SeatSelectingRequestDto
import com.sopt.korailtalk.data.remote.model.response.SeatTicketResponse
import com.sopt.korailtalk.data.remote.model.response.TrainSearchResponseDto
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST
import retrofit2.http.Query

interface TrainSearchService {
    @GET("timetables")
    suspend fun getTimeTableData(
        @Header("userId") userId: Long,
        @Query("date") date: String,
        @Query("departurePlace") departurePlace: String,
        @Query("arrivalPlace") arrivalPlace: String,
        ): ApiResponse<TrainSearchResponseDto>
    @POST("seats")
    suspend fun selectSeat(
        @Header("userId") userId: Long,
        @Body seatSelectingRequestDto: SeatSelectingRequestDto
    ): ApiResponse<SeatTicketResponse>
}