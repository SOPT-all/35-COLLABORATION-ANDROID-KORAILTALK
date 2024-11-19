package com.sopt.korailtalk.data.remote.service

import com.sopt.korailtalk.data.remote.model.base.ApiResponse
import com.sopt.korailtalk.data.remote.model.request.ExampleRequestDto
import com.sopt.korailtalk.data.remote.model.response.ExampleResponseDto
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface ExampleService {
    @GET("api/v1/data")
    suspend fun getExampleData(): ApiResponse<ExampleResponseDto>

    @POST("api/v1/data")
    suspend fun postExampleData(
        @Body exampleRequestDto: ExampleRequestDto
    ): ApiResponse<Unit>
}