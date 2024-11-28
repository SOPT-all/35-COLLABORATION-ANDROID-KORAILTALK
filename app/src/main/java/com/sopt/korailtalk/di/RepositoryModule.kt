package com.sopt.korailtalk.di

import com.sopt.korailtalk.data.repositoryimpl.ExampleRepositoryImpl
import com.sopt.korailtalk.data.repositoryimpl.PaymentRepositoryImpl
import com.sopt.korailtalk.data.repositoryimpl.TrainSearchRepositoryImpl
import com.sopt.korailtalk.domain.repository.ExampleRepository
import com.sopt.korailtalk.domain.repository.PaymentRepository
import com.sopt.korailtalk.domain.repository.TrainSearchRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Binds
    @Singleton
    abstract fun bindExampleRepository(
        exampleRepositoryImpl: ExampleRepositoryImpl
    ): ExampleRepository

    @Binds
    @Singleton
    abstract fun bindPaymentRepository(
        paymentRepositoryImpl: PaymentRepositoryImpl
    ): PaymentRepository

    @Binds
    @Singleton
    abstract fun bindTrainSearchRepository(
        trainSearchRepositoryImpl: TrainSearchRepositoryImpl
    ): TrainSearchRepository
}