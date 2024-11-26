package com.sopt.korailtalk.presentation.ui.trainsearch

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.sopt.korailtalk.data.remote.model.response.Timetable
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class TravelSearchViewModel @Inject constructor(
) : ViewModel() {
    private val _selectDate = MutableLiveData("11.16 (토)")
    val selectDate: LiveData<String> get() = _selectDate

    fun setDate(date: String) {
        _selectDate.value = date
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
    val trainDummy = Timetable(
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
    val trainDummyList = mutableListOf<Timetable>()

}