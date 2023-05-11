package com.example.networking.services

import com.example.data.networkingservices.JokeNetworkingService
import com.example.domain.di.Dispatcher
import com.example.domain.di.DispatcherType.IO
import com.example.domain.mapper.Mapper
import com.example.domain.models.Joke
import com.example.networking.endpoints.JokeEndpoints
import com.example.networking.models.JokeNetworking
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import javax.inject.Inject

class DefaultJokeNetworkingService @Inject constructor(
    private val endpoints: JokeEndpoints,
    @Dispatcher(IO) private val dispatcher: CoroutineDispatcher,
    private val jokeMapper: Mapper<JokeNetworking, Joke>,
) : JokeNetworkingService {

    override suspend fun getTenJokes(): List<Joke> = withContext(dispatcher) {
        endpoints.getTenJokes()
            .body()
            ?.run(jokeMapper::mapAll)
            ?.toList() ?: throw NullPointerException()
    }
}
