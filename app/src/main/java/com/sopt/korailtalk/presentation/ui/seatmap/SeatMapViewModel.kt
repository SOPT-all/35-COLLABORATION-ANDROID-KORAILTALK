package com.sopt.korailtalk.presentation.ui.seatmap

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sopt.korailtalk.domain.model.SeatData
import com.sopt.korailtalk.domain.model.SeatMapData
import com.sopt.korailtalk.domain.repository.SeatsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlin.random.Random

@HiltViewModel
class SeatMapViewModel @Inject constructor(
    private val seatsRepository: SeatsRepository
)  : ViewModel() {

    var selectedCoachId = mutableStateOf<Long?>(null)
    var selectedSeatId = mutableStateOf<Long?>(null)
    var showDialog = mutableStateOf(false)

    private var _leftSeatsState = MutableStateFlow<LeftSeatsState>(LeftSeatsState.Idle)
    val leftSeatsState: StateFlow<LeftSeatsState> = _leftSeatsState

    private val _seatsMapData = MutableStateFlow<ArrayList<SeatMapData>>(arrayListOf())
    val seatsMapData: StateFlow<ArrayList<SeatMapData>>
        get() = _seatsMapData

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
                    Log.e("SeatMapViewModel", "로드 실패: ${throwable.message}")
                }
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