package com.example.data.networkingservices

import com.example.domain.models.Joke

interface JokeNetworkingService {

    suspend fun getTenJokes(): List<Joke>
}