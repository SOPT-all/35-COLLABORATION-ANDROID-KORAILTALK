package com.sopt.korailtalk.presentation.ui.myticket

import androidx.lifecycle.ViewModel
import com.sopt.korailtalk.domain.model.TicketData
import com.sopt.korailtalk.domain.type.MyTicketTabType
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MyTicketViewModel @Inject constructor(
) : ViewModel()  {
    val myTicketTabText = MyTicketTabType.entries.toTypedArray()

    val ticketDummy = TicketData(
        departurePlace = "서울",
        arrivalPlace = "부산",
        date = "2024년 10월 30일 (수)",
        trainName = "KTX 001",
        departureTime = "09:30",
        arrivalTime = "12:45",
        seatName = "16A",
        ticketPrice = 50000,
        limitPaymentTime = "2024-11-30T18:00:00",
        coachesNumber = 4
    )
}