package com.example.data.di

import com.example.data.repositories.DefaultJokeRepository
import com.example.domain.repository.JokeRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@InstallIn(ViewModelComponent::class)
@Module
interface RepositoriesModule {

    @Binds
    @ViewModelScoped
    fun bindJokeRepository(repository: DefaultJokeRepository): JokeRepository
}
