package com.sopt.korailtalk.data.remote.datasourceimpl

import com.sopt.korailtalk.data.remote.datasource.ExampleRemoteDataSource
import com.sopt.korailtalk.data.remote.model.base.ApiResponse
import com.sopt.korailtalk.data.remote.model.request.ExampleRequestDto
import com.sopt.korailtalk.data.remote.model.response.ExampleResponseDto
import com.sopt.korailtalk.data.remote.service.ExampleService
import javax.inject.Inject

class ExampleRemoteDataSourceImpl @Inject constructor(
    private val exampleService: ExampleService
) : ExampleRemoteDataSource {
    override suspend fun getExampleData(): ApiResponse<ExampleResponseDto> =
        exampleService.getExampleData()


    override suspend fun postExampleData(exampleRequestDto: ExampleRequestDto): ApiResponse<Unit> =
        exampleService.postExampleData(exampleRequestDto = exampleRequestDto)
}