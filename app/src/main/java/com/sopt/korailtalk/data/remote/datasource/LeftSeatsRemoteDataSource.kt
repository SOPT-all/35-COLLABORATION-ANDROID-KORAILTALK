package com.sopt.korailtalk.data.remote.datasource

import com.sopt.korailtalk.data.remote.model.base.ApiResponse
import com.sopt.korailtalk.data.remote.model.request.SeatSelectingRequestDto
import com.sopt.korailtalk.data.remote.model.response.LeftSeatsResponseDto


interface LeftSeatsRemoteDataSource {
    suspend fun getLeftSeats(userId: Long, timetableId: Long): ApiResponse<LeftSeatsResponseDto>
    suspend fun selectSeat(seatSelectingRequestDto: SeatSelectingRequestDto): ApiResponse<Unit>
}