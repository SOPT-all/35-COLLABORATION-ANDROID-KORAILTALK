package com.sopt.korailtalk.presentation.ui.trainsearch

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sopt.korailtalk.domain.model.SeatSelecting
import com.sopt.korailtalk.domain.model.TimeTables
import com.sopt.korailtalk.domain.repository.SeatsRepository
import com.sopt.korailtalk.domain.repository.TrainSearchRepository
import com.sopt.korailtalk.presentation.ui.seatmap.SeatSelectingState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import java.text.DecimalFormat
import javax.inject.Inject

@HiltViewModel
class TravelSearchViewModel @Inject constructor(
    private val trainSearchRepository: TrainSearchRepository,
    private val seatsRepository: SeatsRepository
) : ViewModel() {
    private val _timeTableState = MutableStateFlow<TimeTableState>(TimeTableState.Idle)
    val timeTableState: StateFlow<TimeTableState> = _timeTableState

    private val _timeTables = MutableStateFlow(TimeTables(emptyList()))
    val timeTables: StateFlow<TimeTables> = _timeTables

    private val _seatSelectingState = MutableStateFlow<SeatSelectingState>(SeatSelectingState.Idle)
    val seatSelectingState: StateFlow<SeatSelectingState> = _seatSelectingState

    private val _ticketId = MutableStateFlow<Long>(1)
    val ticketId: StateFlow<Long> = _ticketId

    private val _selectDate = MutableStateFlow("11.16 (토)")
    val selectDate: StateFlow<String> = _selectDate

    private val _nextDate = MutableStateFlow(17)
    val nextDate: StateFlow<Int> = _nextDate

    val chipList = listOf(
        "11.16 (토)",
        "11.17 (일)",
        "11.18 (월)",
        "11.19 (화)",
        "11.20 (수)",
        "11.21 (목)",
        "11.22 (금)",
        "11.23 (토)",
        "11.24 (일)",
        "11.25 (월)",
        "11.26 (화)",
        "11.27 (수)",
        "11.28 (목)",
        "11.29 (금)"
    )
    val trainDummy = TimeTables.TimeTable(
        timetableId = 1,
        trainName = "KTX 001",
        departureTime = "05:13",
        arrivalTime = "07:49",
        standardPrice = 12300,
        premiumPrice = 15000,
        isStandardSold = true,
        isPremiumSold = false,
        travelTime = 2,
    )
    val trainDummyList =
        listOf(trainDummy, trainDummy, trainDummy, trainDummy)

    fun getTimeTableData(
        userId: Long,
        date: String,
        departurePlace: String,
        arrivalPlace: String
    ) {
        _timeTableState.value = TimeTableState.Loading
        viewModelScope.launch {
            val result = trainSearchRepository.getTimeTableData(
                userId = userId,
                date = date,
                departurePlace = departurePlace,
                arrivalPlace = arrivalPlace
            )
            _timeTableState.value = result.fold(
                onSuccess = { timeTables ->
                    _timeTables.value = timeTables
                    TimeTableState.Success(timeTables)
                },
                onFailure = { error ->
                    TimeTableState.Failure(error.message.orEmpty())
                }
            )
        }
    }

    fun selectSeat() {
        _seatSelectingState.value = SeatSelectingState.Loading
        viewModelScope.launch {
            val result = seatsRepository.selectSeat(
                userId = 1,
                seatSelecting = SeatSelecting(
                    isAuto = false,
                    timetableId = 1,
                    coachId = 1,
                    seatId = null,
                    price = 1000
                )
            )
            _seatSelectingState.value = result.fold(
                onSuccess = { seatSelectingResult ->
                    _ticketId.value = seatSelectingResult.ticketId
                    SeatSelectingState.Success(seatSelectingResult.ticketId)
                },
                onFailure = { error ->
                    SeatSelectingState.Failure(error.message.orEmpty())
                }
            )
        }
    }

    fun setDate(date: String) {
        _selectDate.value = date
    }

    fun setNextDate() {
        _nextDate.value++
    }

    fun formatPrice(amount: Int): String {
        val formatter = DecimalFormat("#,###")
        return formatter.format(amount)
    }
}