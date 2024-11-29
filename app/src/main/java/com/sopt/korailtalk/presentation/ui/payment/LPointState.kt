package com.sopt.korailtalk.presentation.ui.payment

import com.sopt.korailtalk.domain.model.LPoint

sealed class LPointState {
    data object Idle: LPointState()
    data object Loading: LPointState()
    data class Success(val data: LPoint): LPointState()
    data class Failure(val message: String): LPointState()
}