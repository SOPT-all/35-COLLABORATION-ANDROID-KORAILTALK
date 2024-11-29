package com.sopt.korailtalk.data.remote.datasourceimpl

import com.sopt.korailtalk.data.remote.datasource.PaymentRemoteDataSource
import com.sopt.korailtalk.data.remote.model.request.TicketBuyingRequestDto
import com.sopt.korailtalk.data.remote.service.PaymentService
import javax.inject.Inject

class PaymentRemoteDataSourceImpl @Inject constructor(
    private val paymentService: PaymentService
) : PaymentRemoteDataSource {
    override suspend fun getLpoint(userId: Long, pointPassword: Int) =
        paymentService.getLpoint(userId, pointPassword)

    override suspend fun buyTicket(ticketBuyingRequestDto: TicketBuyingRequestDto) =
        paymentService.buyTicket(ticketBuyingRequestDto)
}