package com.example.data.cacheservices

import com.example.domain.models.Joke
import com.example.domain.models.Value
import kotlinx.coroutines.flow.StateFlow

interface JokeCacheService {

    val homeFeed: StateFlow<Value<List<Joke>>>

    fun setHomeFeed(feed: List<Joke>)
}
