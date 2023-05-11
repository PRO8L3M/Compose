package com.example.domain.repository

import com.example.domain.models.Joke
import com.example.domain.models.Result
import com.example.domain.models.Value
import kotlinx.coroutines.flow.StateFlow

interface JokeRepository {

    val jokeList: StateFlow<Value<List<Joke>>>
    suspend fun getTenJokes(): Result<Unit>
}
