package com.sopt.korailtalk.data.remote.datasourceimpl

import com.sopt.korailtalk.data.remote.datasource.LeftSeatsRemoteDataSource
import com.sopt.korailtalk.data.remote.model.base.ApiResponse
import com.sopt.korailtalk.data.remote.model.request.SeatSelectingRequestDto
import com.sopt.korailtalk.data.remote.model.response.LeftSeatsResponseDto
import com.sopt.korailtalk.data.remote.service.SeatsService
import javax.inject.Inject

class LeftSeatsRemoteDataSourceImpl @Inject constructor(
    private val seatsService: SeatsService
) : LeftSeatsRemoteDataSource {
    override suspend fun getLeftSeats(userId: Long, timetableId: Long) =
        seatsService.getSeats(userId, timetableId)

    override suspend fun selectSeat(seatSelectingRequestDto: SeatSelectingRequestDto) =
        seatsService.selectSeat(seatSelectingRequestDto)
}