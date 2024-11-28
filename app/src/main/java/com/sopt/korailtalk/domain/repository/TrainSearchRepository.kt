package com.sopt.korailtalk.domain.repository

import com.sopt.korailtalk.domain.model.TimeTable

interface TrainSearchRepository {
    suspend fun getTimeTableData(
        userId: Long,
        date: String,
        departurePlace: String,
        arrivalPlace: String
    ): Result<List<TimeTable>>
}