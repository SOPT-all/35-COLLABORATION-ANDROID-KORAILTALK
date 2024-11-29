package com.sopt.korailtalk.domain.repository

import com.sopt.korailtalk.domain.model.SeatSelecting
import com.sopt.korailtalk.domain.model.SeatTicket
import com.sopt.korailtalk.domain.model.TimeTables

interface TrainSearchRepository {
    suspend fun getTimeTableData(
        userId: Long,
        date: String,
        departurePlace: String,
        arrivalPlace: String
    ): Result<TimeTables>
    suspend fun selectSeat(userId: Long, seatSelecting: SeatSelecting): Result<SeatTicket>
}