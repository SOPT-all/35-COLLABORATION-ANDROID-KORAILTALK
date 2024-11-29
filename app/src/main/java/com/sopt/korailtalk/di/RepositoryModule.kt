package com.sopt.korailtalk.di

import com.sopt.korailtalk.data.repositoryimpl.ExampleRepositoryImpl
import com.sopt.korailtalk.data.repositoryimpl.SeatsRepositoryImpl
import com.sopt.korailtalk.data.repositoryimpl.TicketRepositoryImpl
import com.sopt.korailtalk.domain.repository.ExampleRepository
import com.sopt.korailtalk.domain.repository.SeatsRepository
import com.sopt.korailtalk.domain.repository.TicketRepository
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
    abstract fun bindSeatsRepository(
        seatsRepositoryImpl: SeatsRepositoryImpl
    ): SeatsRepository

    @Binds
    @Singleton
    abstract fun bindTicketRepository(
        ticketRepositoryImpl: TicketRepositoryImpl
    ): TicketRepository
}