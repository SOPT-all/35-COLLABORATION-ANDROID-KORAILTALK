package com.sopt.korailtalk.presentation.ui.seatmap

sealed class SeatSelectingState {
    data object Idle: SeatSelectingState()
    data object Loading: SeatSelectingState()
    data class Success(val data: Int): SeatSelectingState()
    data class Failure(val message: String): SeatSelectingState()
}