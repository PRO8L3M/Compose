package com.example.common.di

import com.example.common.base.StateProvider
import com.example.common.state.DefaultHomeStateProvider
import com.example.home.state.HomeState
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@InstallIn(ViewModelComponent::class)
@Module
interface HomeModule {

    @Binds
    @ViewModelScoped
    fun bindHomeStateProvider(provider: DefaultHomeStateProvider): StateProvider<HomeState>
}