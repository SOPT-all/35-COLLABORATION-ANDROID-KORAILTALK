package com.sopt.korailtalk.data.repositoryimpl

import com.sopt.korailtalk.data.mapper.todata.toData
import com.sopt.korailtalk.data.mapper.todomain.toDomain
import com.sopt.korailtalk.data.remote.datasource.TrainSearchRemoteDataSource
import com.sopt.korailtalk.data.remote.util.handleApiResponse
import com.sopt.korailtalk.domain.model.SeatSelecting
import com.sopt.korailtalk.domain.model.SeatTicket
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
    override suspend fun selectSeat(userId: Long, seatSelecting: SeatSelecting): Result<SeatTicket> {
        return runCatching {
            // post에 대한 response를 확인
            val response = trainSearchRemoteDataSource.selectSeat(userId, seatSelecting.toData())
            // 받은 response를 domain의 데이터로 저장
            val ticketId = response.data?.ticketId ?: throw IllegalStateException("ticketId가 비어있음")
            // ticketId Int형으로 저장
            SeatTicket(ticketId = ticketId)
        }
    }
}