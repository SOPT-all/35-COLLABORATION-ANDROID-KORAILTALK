package com.sopt.korailtalk.presentation.ui.traincheck

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sopt.korailtalk.domain.model.TicketData
import com.sopt.korailtalk.domain.repository.TicketRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import javax.inject.Inject

@HiltViewModel
class TrainCheckViewModel @Inject constructor(
    private val ticketRepository: TicketRepository
) : ViewModel() {

    private var _ticketState = MutableStateFlow<TicketState>(TicketState.Idle)
    val ticketState: StateFlow<TicketState> = _ticketState

    private val _ticketData = MutableStateFlow(
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
    val ticketData: StateFlow<TicketData> = _ticketData

    var showDialog = mutableStateOf(false)

    fun getTicketInformation(userId: Long, ticketId: Long) {
        _ticketState.value = TicketState.Loading
        viewModelScope.launch {
            val result = ticketRepository.getTicketInformation(userId = userId, ticketId = ticketId)
            Log.d("result", result.toString())
            result.fold(
                onSuccess = { ticket ->
                    val formattedTicket = ticket.copy(
                        limitPaymentTime = formatDate(ticket.limitPaymentTime)
                    )
                    _ticketData.value = formattedTicket
                    _ticketState.value = TicketState.Success(ticket)
                    Log.d("TrainCheckViewModel", "${_ticketState.value}")
                },
                onFailure = { throwable ->
                    _ticketState.value = TicketState.Failure(throwable.message ?: "알 수 없는 오류")
                    Log.e("TrainCheckViewModel", "로드 실패: ${_ticketState.value}")
                }
            )
        }
    }

    fun formatDate(time: String): String {
        // 서버의 포맷 타입을 적용!
        val inputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")
        // 출력 문자열의 형식
        val outputFormatter = DateTimeFormatter.ofPattern("HH시 mm분")
        // 문자열 파싱 및 재포맷
        val parsedDate = LocalDateTime.parse(time, inputFormatter)
        return parsedDate.format(outputFormatter)
    }

    fun toggleDialog(show: Boolean) {
        showDialog.value = show
    }
}