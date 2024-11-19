package com.sopt.korailtalk.data.remote.model.base

import kotlinx.serialization.Serializable

@Serializable
data class ApiResponse<T>(
    val status: Int,
    val message: String,
    val data: T? = null
)