package com.sopt.korailtalk.domain.repository

import com.sopt.korailtalk.domain.model.ExampleModel

interface ExampleRepository {
    suspend fun getExampleData(): Result<ExampleModel>
    suspend fun postExampleData(exampleModel: ExampleModel): Result<Unit>
}