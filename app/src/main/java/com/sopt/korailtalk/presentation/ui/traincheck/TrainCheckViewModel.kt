package com.sopt.korailtalk.presentation.ui.traincheck

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.sopt.korailtalk.data.remote.model.response.TicketData
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

@HiltViewModel
class TrainCheckViewModel @Inject constructor(
)  : ViewModel() {
    var showDialog = mutableStateOf(false)

    val ticketDummy = TicketData(
        departurePlace = "서울",
        arrivalPlace = "부산",
        date = "2024년 10월 30일 (수)",
        trainName = "KTX 001",
        departureTime = "09:30",
        arrivalTime = "12:45",
        seatName = "16A",
        ticketPrice = 50000,
        limitPaymentTime = formatDate(),
        coachesNumber = 4
    )

    fun formatDate(): String{
        val limitPaymentTime = "2024-11-30T18:00:00"
        val formatter = DateTimeFormatter.ofPattern("HH시 mm분")
        return LocalDateTime.parse(limitPaymentTime).format(formatter)
    }

    fun toggleDialog(show: Boolean) {
        showDialog.value = show
    }
}