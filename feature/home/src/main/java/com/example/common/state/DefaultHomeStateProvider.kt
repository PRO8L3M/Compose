package com.example.common.state

import com.example.common.base.StateProvider
import com.example.domain.models.Joke
import com.example.domain.models.Value
import com.example.domain.repository.JokeRepository
import com.example.home.state.HomeScreenScreenUiState
import com.example.home.state.HomeState
import kotlinx.collections.immutable.toImmutableList
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

class DefaultHomeStateProvider @Inject constructor(
    viewModelScope: CoroutineScope,
    repository: JokeRepository,
) : StateProvider<HomeState> {

    override val screenState: StateFlow<HomeState> = combine(
        flowOf(HomeScreenScreenUiState("")),
        repository.jokeList,
    ) { uiState, jokes ->
        mapHomeState(
            uiState = uiState,
            jokes = jokes,
        )
    }.stateIn(viewModelScope, SharingStarted.WhileSubscribed(5_000), HomeState.NotApplicable)

    private fun mapHomeState(
        uiState: HomeScreenScreenUiState,
        jokes: Value<List<Joke>>
    ): HomeState = HomeState.Success(
        uiState = uiState,
        jokes = jokes.map { it.toImmutableList() },
    )
}
