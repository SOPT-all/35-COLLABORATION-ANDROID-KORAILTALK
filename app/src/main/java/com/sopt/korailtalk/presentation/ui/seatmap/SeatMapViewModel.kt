package com.sopt.korailtalk.presentation.ui.seatmap

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import javax.inject.Inject
import kotlin.random.Random

class SeatMapViewModel @Inject constructor(
)  : ViewModel() {

    private var _seatsMapData = mutableStateOf<List<SeatMapData>>(emptyList())
    val seatsMapData: List<SeatMapData>
        get() = _seatsMapData.value
    var selectedCoachId = mutableStateOf<Long?>(null)
    var selectedSeatId = mutableStateOf<Long?>(null)
    var showDialog = mutableStateOf(false)

    init {
        loadSeatsMapData()
        loadInitCoachId()
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

    private fun loadInitCoachId() {
        if (seatsMapData.isNotEmpty()) {
            selectedCoachId.value = seatsMapData.first().coachId
        }
    }

    fun selectCoach(id: Long) {
        selectedCoachId.value = id
    }

    fun selectSeat(id: Long?) {
        selectedSeatId.value = id
    }

    fun toggleDialog(show: Boolean) {
        showDialog.value = show
    }
}