package com.sopt.korailtalk.data.repositoryimpl

import com.sopt.korailtalk.data.mapper.todata.toData
import com.sopt.korailtalk.data.mapper.todomain.toDomain
import com.sopt.korailtalk.data.remote.datasource.ExampleRemoteDataSource
import com.sopt.korailtalk.data.remote.util.handleApiResponse
import com.sopt.korailtalk.domain.model.ExampleModel
import com.sopt.korailtalk.domain.repository.ExampleRepository
import javax.inject.Inject

class ExampleRepositoryImpl @Inject constructor(
   private val exampleRemoteDataSource: ExampleRemoteDataSource
) : ExampleRepository {
    override suspend fun getExampleData(): Result<ExampleModel> {
        return runCatching {
            exampleRemoteDataSource.getExampleData().handleApiResponse().getOrThrow().toDomain()
        }
    }

    override suspend fun postExampleData(exampleModel: ExampleModel): Result<Unit> {
        return runCatching {
            exampleRemoteDataSource.postExampleData(exampleModel.toData()).handleApiResponse().getOrThrow()
        }
    }
}