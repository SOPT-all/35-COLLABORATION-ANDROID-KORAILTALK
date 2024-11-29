package com.sopt.korailtalk.domain.model

data class SeatSelecting(
    val isAuto: Boolean,
    val timetableId: Long,
    val coachId: Long,
    val seatId: Long?,
    val price: Int
)