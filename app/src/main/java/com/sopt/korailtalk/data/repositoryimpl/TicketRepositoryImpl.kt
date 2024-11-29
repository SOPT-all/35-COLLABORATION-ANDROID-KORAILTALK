package com.sopt.korailtalk.data.repositoryimpl

import com.sopt.korailtalk.data.mapper.todomain.toDomain
import com.sopt.korailtalk.data.remote.datasource.TicketRemoteDataSource
import com.sopt.korailtalk.data.remote.util.handleApiResponse
import com.sopt.korailtalk.domain.model.TicketData
import com.sopt.korailtalk.domain.repository.TicketRepository
import javax.inject.Inject

class TicketRepositoryImpl @Inject constructor(
    private val ticketRemoteDataSource: TicketRemoteDataSource
) : TicketRepository {
    override suspend fun getTicketInformation(userId: Long, ticketId: Long): Result<TicketData> {
        return runCatching {
            ticketRemoteDataSource.getTicketInformation(userId = userId, ticketId = ticketId)
                .handleApiResponse().getOrThrow().toDomain()
        }
    }
}