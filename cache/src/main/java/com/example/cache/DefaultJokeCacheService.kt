package com.example.cache

import com.example.data.cacheservices.JokeCacheService
import com.example.domain.models.Joke
import com.example.domain.models.Value
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

class DefaultJokeCacheService @Inject constructor() : JokeCacheService {

    private val _homeFeed = MutableStateFlow<Value<List<Joke>>>(Value.NoData())
    override val homeFeed: StateFlow<Value<List<Joke>>> = _homeFeed.asStateFlow()

    override fun setHomeFeed(feed: List<Joke>) {
        _homeFeed.update { Value.Data(feed) }
    }
}