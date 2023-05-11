package com.example.networking.di

import com.example.domain.mapper.Mapper
import com.example.domain.models.Joke
import com.example.networking.mappers.JokeNetworkingToDomainMapper
import com.example.networking.models.JokeNetworking
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
interface MappersModule {

    @Binds
    fun bindJokeNetworkingToDomainMapper(mapper: JokeNetworkingToDomainMapper): Mapper<JokeNetworking, Joke>
}
