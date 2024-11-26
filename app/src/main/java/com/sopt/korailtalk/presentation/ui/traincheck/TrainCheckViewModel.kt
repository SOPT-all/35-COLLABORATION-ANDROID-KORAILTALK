package com.sopt.korailtalk.presentation.ui.traincheck

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class TrainCheckViewModel @Inject constructor(
)  : ViewModel() {
    var showDialog = mutableStateOf(false)

    fun toggleDialog(show: Boolean) {
        showDialog.value = show
    }
}