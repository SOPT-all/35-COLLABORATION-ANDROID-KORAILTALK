package com.sopt.korailtalk.data.repositoryimpl

import com.sopt.korailtalk.data.mapper.todata.toData
import com.sopt.korailtalk.data.mapper.todomain.toDomain
import com.sopt.korailtalk.data.remote.datasource.SeatsRemoteDataSource
import com.sopt.korailtalk.data.remote.util.handleApiResponse
import com.sopt.korailtalk.domain.model.LeftSeats
import com.sopt.korailtalk.domain.model.SeatSelecting
import com.sopt.korailtalk.domain.repository.SeatsRepository
import javax.inject.Inject

class SeatsRepositoryImpl @Inject constructor(
    private val seatsRemoteDataSource: SeatsRemoteDataSource
) : SeatsRepository {
    override suspend fun getLeftSeats(userId: Long, timetableId: Long): Result<LeftSeats> {
        return runCatching {
            seatsRemoteDataSource.getLeftSeats(userId = userId, timetableId = timetableId)
                .handleApiResponse().getOrThrow().toDomain()
        }
    }

    override suspend fun selectSeat(seatSelecting: SeatSelecting): Result<Unit> {
        return runCatching {
            seatsRemoteDataSource.selectSeat(seatSelectingRequestDto = seatSelecting.toData())
        }
    }
}

