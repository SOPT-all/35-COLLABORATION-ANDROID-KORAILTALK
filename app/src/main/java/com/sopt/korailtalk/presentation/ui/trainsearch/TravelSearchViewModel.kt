package com.sopt.korailtalk.presentation.ui.trainsearch

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sopt.korailtalk.domain.model.TimeTable
import com.sopt.korailtalk.domain.repository.TrainSearchRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import java.text.DecimalFormat
import javax.inject.Inject

@HiltViewModel
class TravelSearchViewModel @Inject constructor(
    private val trainSearchRepository: TrainSearchRepository
) : ViewModel() {
    private val _timeTableState = MutableStateFlow<TimeTableState>(TimeTableState.Idle)
    val timeTableState: StateFlow<TimeTableState> = _timeTableState

    private val _timeTableList = MutableStateFlow<ArrayList<TimeTable>>(arrayListOf())
    val timeTableList: StateFlow<ArrayList<TimeTable>> get() = _timeTableList

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
                onSuccess = {
                    _timeTableList.value = it.timetables
                    TimeTableState.Success(it)
                },
                onFailure = { error ->
                    TimeTableState.Failure(error.message.orEmpty())
                }
            )
        }
    }

    private val _selectDate = MutableStateFlow("11.16 (토)")
    val selectDate: StateFlow<String> = _selectDate

    private val _nextDate = MutableStateFlow(17)
    val nextDate: StateFlow<Int> = _nextDate

    fun setDate(date: String) {
        _selectDate.value = date
    }

    fun setNextDate() {
        _nextDate.value++
    }

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
    val trainDummy = TimeTable(
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

    fun formatPrice(amount: Int): String {
        val formatter = DecimalFormat("#,###")
        return formatter.format(amount)
    }
}