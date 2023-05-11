package com.example.home.state

import com.example.common.base.UiState
import com.example.domain.models.Joke
import com.example.domain.models.Value
import kotlinx.collections.immutable.ImmutableList

sealed interface HomeState : UiState {
    object NotApplicable : HomeState
    data class Success(
        val uiState: HomeScreenScreenUiState,
        val jokes: Value<ImmutableList<Joke>>,
    ) : HomeState
}

data class HomeScreenScreenUiState(
    val title: String,
)
