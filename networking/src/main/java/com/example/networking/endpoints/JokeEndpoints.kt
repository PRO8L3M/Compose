package com.example.networking.endpoints

import com.example.networking.models.JokeNetworking
import retrofit2.Response
import retrofit2.http.GET

interface JokeEndpoints {

    @GET("jokes/ten")
    suspend fun getTenJokes(): Response<List<JokeNetworking>>
}