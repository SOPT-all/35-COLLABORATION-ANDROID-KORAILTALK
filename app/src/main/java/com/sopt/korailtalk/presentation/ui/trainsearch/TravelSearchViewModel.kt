package com.sopt.korailtalk.presentation.ui.trainsearch

import androidx.lifecycle.ViewModel
import com.sopt.korailtalk.domain.model.TrainInformation
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import java.text.DecimalFormat
import javax.inject.Inject

@HiltViewModel
class TravelSearchViewModel @Inject constructor(
) : ViewModel() {
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
    val trainDummy = TrainInformation(
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