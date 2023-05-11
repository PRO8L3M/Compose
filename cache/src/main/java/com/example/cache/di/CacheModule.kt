package com.example.cache.di

import com.example.cache.DefaultJokeCacheService
import com.example.data.cacheservices.JokeCacheService
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@InstallIn(ViewModelComponent::class)
@Module
interface CacheModule {

    @Binds
    @ViewModelScoped
    fun bindJokeCacheService(service: DefaultJokeCacheService): JokeCacheService
}
