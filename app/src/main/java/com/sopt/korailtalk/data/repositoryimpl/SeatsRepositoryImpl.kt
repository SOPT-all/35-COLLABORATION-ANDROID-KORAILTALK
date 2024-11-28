package com.sopt.korailtalk.data.repositoryimpl

import com.sopt.korailtalk.data.remote.datasource.LeftSeatsRemoteDataSource
import javax.inject.Inject

class SeatsRepositoryImpl @Inject constructor(
    private val seatsRemoteDataSource: LeftSeatsRemoteDataSource
) : PaymentRepository {
    override suspend fun getLpoint(userId: Long, pointPassword: Int): Result<LPoint> {
        return runCatching {
            paymentRemoteDataSource.getLpoint(userId = userId, pointPassword = pointPassword)
                .handleApiResponse().getOrThrow().toDomain()
        }
    }

    override suspend fun buyTicket(ticketBuying: TicketBuying): Result<Unit> {
        return runCatching {
            paymentRemoteDataSource.buyTicket(ticketBuyingRequestDto = ticketBuying.toData())
        }
    }
}