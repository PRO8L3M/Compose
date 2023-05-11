package com.example.networking.di

import com.example.networking.services.DefaultJokeNetworkingService
import com.example.data.networkingservices.JokeNetworkingService
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
interface NetworkingServicesModule {

    @Binds
    fun bindJokeNetworkingService(service: DefaultJokeNetworkingService): com.example.data.networkingservices.JokeNetworkingService
}
