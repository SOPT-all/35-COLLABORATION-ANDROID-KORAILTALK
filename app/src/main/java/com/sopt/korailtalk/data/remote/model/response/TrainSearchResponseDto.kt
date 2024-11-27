package com.sopt.korailtalk.data.remote.model.response


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class TrainSearchResponseDto(
    @SerialName("timetableId")
    val timetableId: Long?,
    @SerialName("trainName")
    val trainName: String,
    @SerialName("departureTime")
    val departureTime: String,
    @SerialName("arrivalTime")
    val arrivalTime: String,
    @SerialName("standardPrice")
    val standardPrice: Int,
    @SerialName("premiumPrice")
    val premiumPrice: Int,
    @SerialName("isStandardSold")
    val isStandardSold: Boolean,
    @SerialName("isPremiumSold")
    val isPremiumSold: Boolean,
    @SerialName("travelTime")
    val travelTime: Int,
)