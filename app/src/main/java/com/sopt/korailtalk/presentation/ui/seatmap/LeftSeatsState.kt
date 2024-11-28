package com.sopt.korailtalk.presentation.ui.seatmap

import com.sopt.korailtalk.domain.model.LeftSeats

sealed class LeftSeatsState {
    data object Idle: LeftSeatsState()
    data object Loading: LeftSeatsState()
    data class Success(val data: LeftSeats): LeftSeatsState()
    data class Failure(val message: String): LeftSeatsState()
}