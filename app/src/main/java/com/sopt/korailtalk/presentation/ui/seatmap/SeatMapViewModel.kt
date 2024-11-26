package com.sopt.korailtalk.presentation.ui.seatmap

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import kotlin.random.Random

class SeatMapViewModel : ViewModel() {

    private var _seatsMapData = mutableStateOf<List<SeatMapData>>(emptyList())
    val seatsMapData: List<SeatMapData>
        get() = _seatsMapData.value

    init {
        loadSeatsMapData()
    }

    private fun loadSeatsMapData() {
        val seats = arrayListOf<SeatData>()
        for (i in 1..60) {
            val seatId = i.toLong()
            val seatName = "${(i - 1) / 4 + 1}${charArrayOf('A', 'B', 'C', 'D')[(i - 1) % 4]}"
            val direction = i <= 30
            val isSold = Random.nextBoolean()  // 무작위로 판매 상태 결정

            seats.add(SeatData(seatId, seatName, direction, isSold))
        }
        _seatsMapData.value = listOf(
            SeatMapData(1L, 40, seats),
            SeatMapData(2L, 40, arrayListOf()),
            SeatMapData(3L, 40, arrayListOf()),
            SeatMapData(4L, 40, arrayListOf()),
            SeatMapData(5L, 40, arrayListOf())
        )
    }

    // 선택된 Coach ID를 저장
    var selectedCoachId = mutableStateOf<Long?>(null)

    // 선택 로직
    fun selectCoach(id: Long) {
        selectedCoachId.value = id
    }

    var selectedSeatId = mutableStateOf<Long?>(null)

    fun selectSeat(id: Long?) {
        selectedSeatId.value = id
    }
}