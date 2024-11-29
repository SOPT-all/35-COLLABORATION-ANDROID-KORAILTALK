package com.sopt.korailtalk.data.mapper.todomain

import com.sopt.korailtalk.data.remote.model.response.LPointResponseDto
import com.sopt.korailtalk.domain.model.LPoint

fun LPointResponseDto.toDomain(): LPoint = LPoint(
    isValid = this.isValid,
    point = this.point
)