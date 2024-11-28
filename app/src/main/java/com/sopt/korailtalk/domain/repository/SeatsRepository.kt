package com.sopt.korailtalk.domain.repository

import com.sopt.korailtalk.domain.model.LeftSeats
import com.sopt.korailtalk.domain.model.SeatSelecting
import com.sopt.korailtalk.domain.model.SeatTicket

interface SeatsRepository {
    suspend fun getLeftSeats(userId: Long, timetableId: Long): Result<LeftSeats>
    suspend fun selectSeat(userId: Long, seatSelecting: SeatSelecting): Result<SeatTicket>
}