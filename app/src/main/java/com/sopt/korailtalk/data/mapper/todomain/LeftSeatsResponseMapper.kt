package com.sopt.korailtalk.data.mapper.todomain

import com.sopt.korailtalk.data.remote.model.response.LeftSeatsResponseDto
import com.sopt.korailtalk.domain.model.LeftSeats

fun LeftSeatsResponseDto.toDomain(): LeftSeats {
    return LeftSeats(
        coaches = this.coaches.map { coach ->
            LeftSeats.SeatMapData(
                coachId = coach.coachId,
                leftSeats = coach.leftSeats,
                seats = coach.seats.map { seat ->
                    LeftSeats.SeatMapData.SeatData(
                        seatId = seat.seatId,
                        seatName = seat.seatName,
                        direction = seat.direction,
                        isSold = seat.isSold
                    )
                }
            )
        }
    )
}