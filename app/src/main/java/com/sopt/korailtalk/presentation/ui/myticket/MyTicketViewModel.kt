package com.sopt.korailtalk.presentation.ui.myticket

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sopt.korailtalk.domain.model.TicketData
import com.sopt.korailtalk.domain.type.MyTicketTabType
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import javax.inject.Inject

@HiltViewModel
class MyTicketViewModel @Inject constructor(
   private val ticketRepository: TicketRepository
) : ViewModel()  {
    val myTicketTabText = MyTicketTabType.entries.toTypedArray()

    private var _myTicketState = MutableStateFlow<MyTicketState>(MyTicketState.Idle)
    val myTicketState: StateFlow<MyTicketState> = _myTicketState

    private val _ticketData = MutableStateFlow<TicketData>(
        TicketData(
            departurePlace = "",
            arrivalPlace = "",
            date = "",
            trainName = "",
            departureTime = "",
            arrivalTime = "",
            seatName = "",
            ticketPrice = 0,
            limitPaymentTime = "",
            coachesNumber = 0
        )
    )
    val ticketData: StateFlow<TicketData> get() = _ticketData

    fun getTicketInformation(userId: Long, ticketId: Long) {
        _myTicketState.value = MyTicketState.Loading
        viewModelScope.launch {
            val result = ticketRepository.getTicketInformation(userId = userId, ticketId = ticketId)
            Log.d("result",result.toString())
            result.fold(
                onSuccess = { ticket ->
                    val formattedTicket = ticket.copy(
                        limitPaymentTime = formatDate(ticket.limitPaymentTime)
                    )
                    _ticketData.value = formattedTicket
                    _myTicketState.value = MyTicketState.Success(ticket)
                    Log.d("MyTicketViewModel", "${_myTicketState.value}")
                },
                onFailure = { throwable ->
                    _myTicketState.value = MyTicketState.Failure(throwable.message ?: "알 수 없는 오류")
                    Log.e("MyTicketViewModel", "로드 실패: ${_myTicketState.value}")
                }
            )
        }
    }

    private fun formatDate(time: String): String{
        val inputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")
        val outputFormatter = DateTimeFormatter.ofPattern("HH시 mm분")
        val parsedDate = LocalDateTime.parse(time, inputFormatter)
        return parsedDate.format(outputFormatter)
    }
}