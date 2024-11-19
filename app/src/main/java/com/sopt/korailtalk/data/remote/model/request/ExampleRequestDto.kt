package com.sopt.korailtalk.data.remote.model.request

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ExampleRequestDto(
    @SerialName("id") val id: String,
    @SerialName("name") val name: String
)