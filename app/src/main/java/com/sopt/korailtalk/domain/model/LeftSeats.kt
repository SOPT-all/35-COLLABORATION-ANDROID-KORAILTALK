package com.sopt.korailtalk.domain.model

data class LeftSeats(
    val coaches: List<SeatMapData>
) {
    data class SeatMapData (
        val coachId: Long,
        val leftSeats: Int,
        val seats: List<SeatData>
    ) {
        data class SeatData(
            val seatId : Long,
            val seatName: String,
            val direction : Boolean,
            val isSold: Boolean
        )
    }
}