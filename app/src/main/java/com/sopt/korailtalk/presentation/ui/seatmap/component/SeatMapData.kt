package com.sopt.korailtalk.presentation.ui.seatmap.component

data class SeatMapData (
    val coachId: Long,
    val leftSeats: Int,
    val seats: ArrayList<SeatData>
)

data class SeatData(
    val seatId : Long,
    val seatName: String,
    val direction : Boolean,
    val isSold: Boolean
)