package com.example.common.base

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.cancel
import kotlinx.coroutines.flow.StateFlow

abstract class BaseViewModel<T : UiState> : ViewModel()  {

    abstract val viewModelScope: CoroutineScope
    abstract val viewState: StateFlow<T>

    protected abstract fun onEvent(event: Event)

    fun setEvent(event: Event) = onEvent(event)

    override fun onCleared() {
        super.onCleared()
        viewModelScope.cancel()
    }
}
