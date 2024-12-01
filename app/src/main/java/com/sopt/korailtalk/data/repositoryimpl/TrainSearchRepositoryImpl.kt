package com.sopt.korailtalk.data.repositoryimpl

import com.sopt.korailtalk.data.mapper.todomain.toDomain
import com.sopt.korailtalk.data.remote.datasource.TrainSearchRemoteDataSource
import com.sopt.korailtalk.data.remote.util.handleApiResponse
import com.sopt.korailtalk.domain.model.TimeTables
import com.sopt.korailtalk.domain.repository.TrainSearchRepository
import javax.inject.Inject

class TrainSearchRepositoryImpl @Inject constructor(
    private val trainSearchRemoteDataSource: TrainSearchRemoteDataSource
) : TrainSearchRepository {
    override suspend fun getTimeTableData(
        userId: Long,
        date: String,
        departurePlace: String,
        arrivalPlace: String
    ): Result<TimeTables> {
        return runCatching {
            trainSearchRemoteDataSource.getTimeTableData(
                userId = userId,
                date = date,
                departurePlace = departurePlace,
                arrivalPlace = arrivalPlace
            ).handleApiResponse().getOrThrow()
                .toDomain()
        }
    }
}