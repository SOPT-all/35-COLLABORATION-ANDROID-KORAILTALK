package com.sopt.korailtalk.data.repositoryimpl

import com.sopt.korailtalk.data.mapper.todata.toData
import com.sopt.korailtalk.data.mapper.todomain.toDomain
import com.sopt.korailtalk.data.remote.datasource.PaymentRemoteDataSource
import com.sopt.korailtalk.data.remote.util.handleApiResponse
import com.sopt.korailtalk.domain.model.LPoint
import com.sopt.korailtalk.domain.model.TicketBuying
import com.sopt.korailtalk.domain.repository.PaymentRepository
import javax.inject.Inject

class PaymentRepositoryImpl @Inject constructor(
    private val paymentRemoteDataSource: PaymentRemoteDataSource
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