package com.example.home.di

import com.example.common.base.EventHandler
import com.example.common.di.EventHandlerKey
import com.example.home.events.SyncJokes
import com.example.home.events.handlers.SyncJokesEventHandler
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped
import dagger.multibindings.IntoMap

@InstallIn(ViewModelComponent::class)
@Module
interface HomeModule {

    @Binds
    @EventHandlerKey(SyncJokes::class)
    @IntoMap
    @ViewModelScoped
    fun bindSyncJokeEventHandler(handler: SyncJokesEventHandler): EventHandler
}
