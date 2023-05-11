package com.example.home.events.handlers

import android.util.Log
import com.example.common.base.Event
import com.example.common.base.EventHandler
import com.example.domain.repository.JokeRepository
import com.example.home.events.SyncJokes
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import javax.inject.Inject

class SyncJokesEventHandler @Inject constructor(
    private val repository: JokeRepository,
    private val viewModelScope: CoroutineScope,
) : EventHandler {

    override fun handle(event: Event) {
        if (event !is SyncJokes) return
        viewModelScope.launch {
            repository.getTenJokes()
                .onSuccess { Log.i("jokes", "success") }
                .onError { Log.i("jokes", "error") }
        }
    }
}
