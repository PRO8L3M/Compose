package com.example.common.di

import com.example.common.base.DefaultEventsDispatcher
import com.example.common.base.EventsDispatcher
import com.example.domain.di.Dispatcher
import com.example.domain.di.DispatcherType.MAIN
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob

@Module
@InstallIn(ViewModelComponent::class)
interface CommonModule {

    @Binds
    @ViewModelScoped
    fun bindEventsDispatcher(dispatcher: DefaultEventsDispatcher): EventsDispatcher

    companion object {

        @Provides
        @ViewModelScoped
        fun provideViewModelScope(
            @Dispatcher(MAIN) dispatcher: CoroutineDispatcher
        ) = CoroutineScope(dispatcher + SupervisorJob())
    }
}
