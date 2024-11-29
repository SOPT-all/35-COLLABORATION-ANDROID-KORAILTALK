package com.sopt.korailtalk.data.remote.model.base

import kotlinx.serialization.Serializable

@Serializable
data class ApiResponse<T>(
    val status: Int = 200,
    val message: String = "Success",
    val data: T? = null
)