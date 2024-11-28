package com.sopt.korailtalk.di

import com.sopt.korailtalk.data.remote.service.ExampleService
import com.sopt.korailtalk.data.remote.service.PaymentService
import com.sopt.korailtalk.data.remote.service.TrainSearchService
import com.sopt.korailtalk.di.qualifier.KorailTalk
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ServiceModule {
    @Provides
    @Singleton
    fun provideExampleService(@KorailTalk retrofit: Retrofit): ExampleService =
        retrofit.create(ExampleService::class.java)

    @Provides
    @Singleton
    fun providePaymentService(@KorailTalk retrofit: Retrofit): PaymentService =
        retrofit.create(PaymentService::class.java)

    @Provides
    @Singleton
    fun provideTrainSearchService(@KorailTalk retrofit: Retrofit): TrainSearchService =
        retrofit.create(TrainSearchService::class.java)
}