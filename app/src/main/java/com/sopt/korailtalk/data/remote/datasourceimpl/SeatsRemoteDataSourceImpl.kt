package com.sopt.korailtalk.data.remote.datasourceimpl

import com.sopt.korailtalk.data.remote.datasource.SeatsRemoteDataSource
import com.sopt.korailtalk.data.remote.model.request.SeatSelectingRequestDto
import com.sopt.korailtalk.data.remote.service.SeatsService
import javax.inject.Inject

class SeatsRemoteDataSourceImpl @Inject constructor(
    private val seatsService: SeatsService
) : SeatsRemoteDataSource {
    override suspend fun getLeftSeats(userId: Long, timetableId: Long) =
        seatsService.getSeats(userId, timetableId)

    override suspend fun selectSeat(seatSelectingRequestDto: SeatSelectingRequestDto) =
        seatsService.selectSeat(seatSelectingRequestDto)
}