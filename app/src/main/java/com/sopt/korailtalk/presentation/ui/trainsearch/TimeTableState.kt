package com.sopt.korailtalk.presentation.ui.trainsearch

import com.sopt.korailtalk.domain.model.TimeTable

sealed class TimeTableState {
    data object Idle: TimeTableState()
    data object Loading: TimeTableState()
    data class Success(val data: List<TimeTable>): TimeTableState()
    data class Failure(val message: String): TimeTableState()
}