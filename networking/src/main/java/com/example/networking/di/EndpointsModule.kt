package com.example.networking.di

import com.example.networking.endpoints.JokeEndpoints
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit

@InstallIn(SingletonComponent::class)
@Module
object EndpointsModule {

    @Provides
    fun provideJokeEndpoints(retrofit: Retrofit): JokeEndpoints = retrofit.create(JokeEndpoints::class.java)
}