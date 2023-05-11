package com.example.common.base

import javax.inject.Inject

class DefaultEventsDispatcher @Inject constructor(
    private val eventHandlerMap: Map<Class<out Event>, @JvmSuppressWildcards EventHandler>,
) : EventsDispatcher {

    override fun dispatch(event: Event) {
        eventHandlerMap[event::class.java]?.handle(event)
    }
}
