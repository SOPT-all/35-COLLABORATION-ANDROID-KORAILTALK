package com.sopt.korailtalk.presentation.ui.trainsearch

import com.sopt.korailtalk.domain.model.TimeTables

sealed class TimeTableState {
    data object Idle: TimeTableState()
    data object Loading: TimeTableState()
    data class Success(val data: TimeTables): TimeTableState()
    data class Failure(val message: String): TimeTableState()
}