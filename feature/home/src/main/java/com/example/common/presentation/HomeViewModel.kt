package com.example.common.presentation

import com.example.common.base.BaseViewModel
import com.example.common.base.Event
import com.example.common.base.EventsDispatcher
import com.example.common.base.StateProvider
import com.example.home.state.HomeState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    override val viewModelScope: CoroutineScope,
    private val eventsDispatcher: EventsDispatcher,
    stateProvider: StateProvider<HomeState>,
) : BaseViewModel<HomeState>() {

    override val viewState: StateFlow<HomeState> = stateProvider.screenState

    override fun onEvent(event: Event) = eventsDispatcher.dispatch(event)
}
