package com.sopt.korailtalk.data.mapper.todomain

import com.sopt.korailtalk.data.remote.model.response.LeftSeatsResponseDto
import com.sopt.korailtalk.domain.model.LeftSeats

fun LeftSeatsResponseDto.toDomain(): LeftSeats = LeftSeats(
    coaches = this.coaches
)