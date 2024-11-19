package com.sopt.korailtalk.data.remote.datasource

import com.sopt.korailtalk.data.remote.model.base.ApiResponse
import com.sopt.korailtalk.data.remote.model.request.ExampleRequestDto
import com.sopt.korailtalk.data.remote.model.response.ExampleResponseDto

interface ExampleRemoteDataSource {
    suspend fun getExampleData(): ApiResponse<ExampleResponseDto>
    suspend fun postExampleData(exampleRequestDto: ExampleRequestDto): ApiResponse<Unit>
}