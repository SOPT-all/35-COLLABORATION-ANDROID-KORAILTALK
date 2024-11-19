package com.sopt.korailtalk.data.mapper.todata

import com.sopt.korailtalk.data.remote.model.request.ExampleRequestDto
import com.sopt.korailtalk.domain.model.ExampleModel

fun ExampleModel.toData(): ExampleRequestDto = ExampleRequestDto(
    id = this.id,
    name = this.name
)