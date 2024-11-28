package com.sopt.korailtalk.domain.repository

import com.sopt.korailtalk.domain.model.LeftSeats
import com.sopt.korailtalk.domain.model.SeatSelecting

interface SeatsRepository {
    suspend fun getLeftSeats(userId: Long, timetableId: Long): Result<LeftSeats>
    suspend fun selectSeat(seatSelecting: SeatSelecting): Result<Unit>
}