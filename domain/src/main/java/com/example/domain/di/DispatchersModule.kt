package com.example.domain.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.CoroutineDispatcher

@InstallIn(SingletonComponent::class)
@Module
interface DispatchersModule {

    companion object {
        @Provides
        @Dispatcher(DispatcherType.IO)
        fun provideIODispatcher(): CoroutineDispatcher = Dispatchers.IO

        @Provides
        @Dispatcher(DispatcherType.DEFAULT)
        fun provideDefaultDispatcher(): CoroutineDispatcher = Dispatchers.Default

        @Provides
        @Dispatcher(DispatcherType.MAIN)
        fun provideMainDispatcher(): CoroutineDispatcher = Dispatchers.Main.immediate
    }
}
