package com.sopt.korailtalk.di

import com.sopt.korailtalk.data.local.datasource.ExampleLocalDataSource
import com.sopt.korailtalk.data.local.datasourceimpl.ExampleLocalDataSourceImpl
import com.sopt.korailtalk.data.remote.datasource.ExampleRemoteDataSource
import com.sopt.korailtalk.data.remote.datasource.PaymentRemoteDataSource
import com.sopt.korailtalk.data.remote.datasource.TrainSearchRemoteDataSource
import com.sopt.korailtalk.data.remote.datasourceimpl.ExampleRemoteDataSourceImpl
import com.sopt.korailtalk.data.remote.datasourceimpl.PaymentRemoteDataSourceImpl
import com.sopt.korailtalk.data.remote.datasourceimpl.TrainSearchRemoteDataSourceImpl
import com.sopt.korailtalk.data.remote.datasource.SeatsRemoteDataSource
import com.sopt.korailtalk.data.remote.datasource.TicketRemoteDataSource
import com.sopt.korailtalk.data.remote.datasourceimpl.SeatsRemoteDataSourceImpl
import com.sopt.korailtalk.data.remote.datasourceimpl.TicketRemoteDataSourceImpl
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
    abstract fun bindPaymentRemoteDataSource(
        paymentRemoteDataSourceImpl: PaymentRemoteDataSourceImpl
    ): PaymentRemoteDataSource

    @Binds
    @Singleton
    abstract fun bindTrainSearchRemoteDataSource(
        trainSearchRemoteDataSourceImpl: TrainSearchRemoteDataSourceImpl
    ): TrainSearchRemoteDataSource

    @Binds
    @Singleton
    abstract fun bindSeatsRemoteDataSource(
        seatsRemoteDataSourceImpl: SeatsRemoteDataSourceImpl
    ): SeatsRemoteDataSource

    @Binds
    @Singleton
    abstract fun bindsTicketRemoteDataSource(
        ticketRemoteDataSourceImpl: TicketRemoteDataSourceImpl
    ): TicketRemoteDataSource
}