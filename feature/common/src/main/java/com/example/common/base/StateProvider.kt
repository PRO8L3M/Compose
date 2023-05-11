package com.example.common.base

import kotlinx.coroutines.flow.StateFlow

interface StateProvider<T : UiState> {
    val screenState: StateFlow<T>
}
