package com.example.data.repositories

import android.util.Log
import com.example.data.cacheservices.JokeCacheService
import com.example.data.networkingservices.JokeNetworkingService
import com.example.domain.errors.ErrorHandler
import com.example.domain.models.Joke
import com.example.domain.models.Result
import com.example.domain.models.Value
import com.example.domain.repository.JokeRepository
import com.example.domain.utils.runCatchingSafe
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

class DefaultJokeRepository @Inject constructor(
    private val errorHandler: ErrorHandler,
    private val cacheService: JokeCacheService,
    private val networkingService: JokeNetworkingService,
) : JokeRepository {

    override val jokeList: StateFlow<Value<List<Joke>>> = cacheService.homeFeed

    override suspend fun getTenJokes(): Result<Unit> = runCatchingSafe(errorHandler) {
        Log.i("jokes", "before fetching")
        val feed: List<Joke> = networkingService.getTenJokes()
        Log.i("jokes", feed.toString())
        cacheService.setHomeFeed(feed)
    }
}

