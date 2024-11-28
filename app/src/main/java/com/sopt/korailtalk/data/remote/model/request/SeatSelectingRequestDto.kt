package com.sopt.korailtalk.data.remote.model.request

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class SeatSelectingRequestDto(
    @SerialName("isAuto") val isAuto: Boolean,
    @SerialName("timetableId") val timetableId: Long,
    @SerialName("coachId") val coachId: Long,
    @SerialName("seatId") val seatId: Long?,
    @SerialName("price") val price: Int
)