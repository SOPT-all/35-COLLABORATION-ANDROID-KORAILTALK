package com.sopt.korailtalk.data.remote.model.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class LPointResponseDto(
    @SerialName("isValid") val isValid: Boolean,
    @SerialName("point") val point: Int
)