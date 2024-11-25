package com.sopt.korailtalk.presentation.ui.seatmap

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class SeatMapViewModel : ViewModel() {

    private var _seatsMapData = mutableStateOf<List<SeatMapData>>(emptyList())
    val seatsMapData: List<SeatMapData>
        get() = _seatsMapData.value

    init {
        loadSeatsMapData()
    }

    private fun loadSeatsMapData() {
        _seatsMapData.value = listOf(
            SeatMapData(1L, 40, arrayListOf(
                SeatData(1, "1A", true, false),
                SeatData(2, "1B", true, false),
                SeatData(3, "1C", true, false),
                SeatData(4, "1D", true, false)
            )),
            SeatMapData(2L, 40, arrayListOf(
                SeatData(5, "2A", true, false),
                SeatData(6, "2B", true, false),
                SeatData(7, "2C", true, false),
                SeatData(8, "2D", true, false)
            )),
            SeatMapData(3L, 40, arrayListOf(
                SeatData(9, "3A", true, false),
                SeatData(10, "3B", true, false),
                SeatData(11, "3C", true, false),
                SeatData(12, "3D", true, false)
            )),
            SeatMapData(4L, 40, arrayListOf(
                SeatData(13, "4A", true, false),
                SeatData(14, "4B", true, false),
                SeatData(15, "4C", true, false),
                SeatData(16, "4D", true, false)
            )),
            SeatMapData(5L, 40, arrayListOf(
                SeatData(17, "5A", true, false),
                SeatData(18, "5B", true, false),
                SeatData(19, "5C", true, false),
                SeatData(20, "5D", true, false)
            )),
            SeatMapData(6L, 40, arrayListOf(
                SeatData(21, "5A", true, false),
                SeatData(22, "5B", true, false),
                SeatData(23, "5C", true, false),
                SeatData(24, "5D", true, false)
            ))
        )
    }

    // 선택된 Coach ID를 저장
    var selectedCoachId = mutableStateOf<Long?>(null)

    // 선택 로직
    fun selectCoach(id: Long) {
        selectedCoachId.value = id
    }
}