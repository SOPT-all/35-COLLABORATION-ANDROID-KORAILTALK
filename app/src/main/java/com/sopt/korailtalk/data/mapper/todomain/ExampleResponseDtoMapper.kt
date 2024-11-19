package com.sopt.korailtalk.data.mapper.todomain

import com.sopt.korailtalk.data.remote.model.response.ExampleResponseDto
import com.sopt.korailtalk.domain.model.ExampleModel

fun ExampleResponseDto.toDomain(): ExampleModel = ExampleModel(
    id = this.id,
    name = this.name
)