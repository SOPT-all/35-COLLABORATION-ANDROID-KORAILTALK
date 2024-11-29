package com.sopt.korailtalk.data.remote.datasource

import com.sopt.korailtalk.data.remote.model.base.ApiResponse
import com.sopt.korailtalk.data.remote.model.response.TrainSearchResponseDto

interface TrainSearchRemoteDataSource {
    suspend fun getTimeTableData(
        userId: Long,
        date: String,
        departurePlace: String,
        arrivalPlace: String
    ): ApiResponse<TrainSearchResponseDto>
}