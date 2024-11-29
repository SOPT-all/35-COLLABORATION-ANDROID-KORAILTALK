package com.sopt.korailtalk.data.remote.model.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class LeftSeatsResponseDto(
    @SerialName("coaches") val coaches: ArrayList<SeatMapData>
)

@Serializable
data class SeatMapData (
    @SerialName("coachId") val coachId: Long,
    @SerialName("leftSeats") val leftSeats: Int,
    @SerialName("seats") val seats: ArrayList<SeatData>
)

@Serializable
data class SeatData(
    @SerialName("seatId") val seatId : Long,
    @SerialName("seatName") val seatName: String,
    @SerialName("direction") val direction : Boolean,
    @SerialName("isSold") val isSold: Boolean
)