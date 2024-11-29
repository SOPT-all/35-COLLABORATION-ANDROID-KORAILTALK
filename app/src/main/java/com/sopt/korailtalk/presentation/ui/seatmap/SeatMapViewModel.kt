package com.sopt.korailtalk.presentation.ui.seatmap

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sopt.korailtalk.domain.model.SeatMapData
import com.sopt.korailtalk.domain.model.SeatSelecting
import com.sopt.korailtalk.domain.model.SeatTicket
import com.sopt.korailtalk.domain.repository.SeatsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SeatMapViewModel @Inject constructor(
    private val seatsRepository: SeatsRepository
)  : ViewModel() {

    var selectedCoachId = mutableStateOf<Long>(1)
    var selectedSeatId = mutableStateOf<Long?>(1)
    var showDialog = mutableStateOf(false)

    private var _leftSeatsState = MutableStateFlow<LeftSeatsState>(LeftSeatsState.Idle)
    val leftSeatsState: StateFlow<LeftSeatsState> = _leftSeatsState

    private var _seatSelectingState = MutableStateFlow<SeatSelectingState>(SeatSelectingState.Idle)
    val seatSelectingState: StateFlow<SeatSelectingState> = _seatSelectingState

    private val _seatsMapData = MutableStateFlow<ArrayList<SeatMapData>>(arrayListOf())
    val seatsMapData: StateFlow<ArrayList<SeatMapData>> get() = _seatsMapData

    private val _ticketId = MutableStateFlow<Long>(1)
    val ticketId: StateFlow<Long> = _ticketId

    private fun loadInitCoachId() {
        viewModelScope.launch {
            if (seatsMapData.value.isNotEmpty()) {
                selectedCoachId.value = seatsMapData.value.first().coachId
            }
        }
    }

    fun getLeftSeats(userId: Long, timetableId: Long) {
        _leftSeatsState.value = LeftSeatsState.Loading
        viewModelScope.launch {
            val result = seatsRepository.getLeftSeats(userId = userId, timetableId = timetableId)
            result.fold(
                onSuccess = { leftSeats ->
                    _seatsMapData.value = leftSeats.coaches
                    _leftSeatsState.value = LeftSeatsState.Success(leftSeats)
                    loadInitCoachId()
                    Log.d("SeatMapViewModel", "${_seatsMapData.value}")
                },
                onFailure = { throwable ->
                    _leftSeatsState.value = LeftSeatsState.Failure(throwable.message ?: "알 수 없는 오류")
                    Log.e("SeatMapViewModel", "로드 실패: ${_leftSeatsState.value}")
                }
            )
        }
    }

    fun selectSeat(userId: Long, timetableId: Long = 1){
        _seatSelectingState.value = SeatSelectingState.Loading
        viewModelScope.launch{
            val result = seatsRepository.selectSeat(userId,
                SeatSelecting(
                    isAuto = false,
                    timetableId = timetableId,
                    coachId = 1,
                    seatId = selectedSeatId.value,
                    price = 1000
                )
            )
            _seatSelectingState.value = result.fold(
                onSuccess = { SeatSelectingState.Success(it.ticketId) },
                onFailure = { SeatSelectingState.Failure(it.message ?: "") }
            )
        }
    }

    fun selectCoach(id: Long) {
        selectedCoachId.value = id
    }

    fun selectSeat(id: Long?) {
        selectedSeatId.value = id
    }

    fun toggleDialog(show: Boolean) {
        showDialog.value = show
    }
}