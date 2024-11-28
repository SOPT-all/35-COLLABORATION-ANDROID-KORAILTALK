package com.sopt.korailtalk.data.remote.datasource

import com.sopt.korailtalk.data.remote.model.base.ApiResponse
import com.sopt.korailtalk.data.remote.model.request.SeatSelectingRequestDto
import com.sopt.korailtalk.data.remote.model.response.LeftSeatsResponseDto
import com.sopt.korailtalk.data.remote.model.response.SeatTicketResponse


interface SeatsRemoteDataSource {
    suspend fun getLeftSeats(userId: Long, timetableId: Long): ApiResponse<LeftSeatsResponseDto>
    suspend fun selectSeat(userId: Long, seatSelectingRequestDto: SeatSelectingRequestDto): ApiResponse<SeatTicketResponse>
}