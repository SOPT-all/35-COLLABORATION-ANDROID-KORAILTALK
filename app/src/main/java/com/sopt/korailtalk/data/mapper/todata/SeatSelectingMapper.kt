package com.sopt.korailtalk.data.mapper.todata

import com.sopt.korailtalk.data.remote.model.request.SeatSelectingRequestDto
import com.sopt.korailtalk.domain.model.SeatSelecting

fun SeatSelecting.toData(): SeatSelectingRequestDto = SeatSelectingRequestDto(
    isAuto = this.isAuto,
    timetableId = this.timetableId,
    coachId = this.coachId,
    seatId = this.seatId,
    price = this.price
)