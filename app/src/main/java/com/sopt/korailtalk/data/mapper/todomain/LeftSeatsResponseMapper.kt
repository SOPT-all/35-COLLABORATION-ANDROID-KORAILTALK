package com.sopt.korailtalk.data.mapper.todomain

import com.sopt.korailtalk.data.remote.model.response.LeftSeatsResponseDto
import com.sopt.korailtalk.domain.model.LeftSeats
import com.sopt.korailtalk.domain.model.SeatData
import com.sopt.korailtalk.domain.model.SeatMapData

fun LeftSeatsResponseDto.toDomain(): LeftSeats {
    // LeftSeats domain 과 각 하위 데이터 클래스를 매핑
    return LeftSeats(
        coaches = this.coaches.map {
            SeatMapData(
                coachId = it.coachId,
                leftSeats = it.leftSeats,
                seats = it.seats.map {
                    SeatData(
                        seatId = it.seatId,
                        seatName = it.seatName,
                        direction = it.direction,
                        isSold = it.isSold
                    )
                }.toCollection(ArrayList())
            )
        }.toCollection(ArrayList())
    )
}