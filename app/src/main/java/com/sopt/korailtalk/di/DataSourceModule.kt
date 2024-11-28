package com.sopt.korailtalk.di

import com.sopt.korailtalk.data.local.datasource.ExampleLocalDataSource
import com.sopt.korailtalk.data.local.datasourceimpl.ExampleLocalDataSourceImpl
import com.sopt.korailtalk.data.remote.datasource.ExampleRemoteDataSource
import com.sopt.korailtalk.data.remote.datasource.SeatsRemoteDataSource
import com.sopt.korailtalk.data.remote.datasourceimpl.ExampleRemoteDataSourceImpl
import com.sopt.korailtalk.data.remote.datasourceimpl.SeatsRemoteDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class DataSourceModule {
    @Binds
    @Singleton
    abstract fun bindExampleLocalDataSource(
        exampleLocalDataSourceImpl: ExampleLocalDataSourceImpl
    ): ExampleLocalDataSource

    @Binds
    @Singleton
    abstract fun bindExampleRemoteDataSource(
        exampleRemoteDataSourceImpl: ExampleRemoteDataSourceImpl
    ): ExampleRemoteDataSource

    @Binds
    @Singleton
    abstract fun bindSeatsRemoteDataSource(
        seatsRemoteDataSourceImpl: SeatsRemoteDataSourceImpl
    ): SeatsRemoteDataSource
}