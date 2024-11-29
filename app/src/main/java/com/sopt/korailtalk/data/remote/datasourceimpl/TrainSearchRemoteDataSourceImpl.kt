package com.sopt.korailtalk.data.remote.datasourceimpl

import com.sopt.korailtalk.data.remote.datasource.TrainSearchRemoteDataSource
import com.sopt.korailtalk.data.remote.service.TrainSearchService
import javax.inject.Inject

class TrainSearchRemoteDataSourceImpl @Inject constructor(
    private val trainSearchService: TrainSearchService
) : TrainSearchRemoteDataSource {
    override suspend fun getTimeTableData(
        userId: Long,
        date: String,
        departurePlace: String,
        arrivalPlace: String
    ) = trainSearchService.getTimeTableData(
            userId = userId,
            date = date,
            departurePlace = departurePlace,
            arrivalPlace = arrivalPlace
        )
}