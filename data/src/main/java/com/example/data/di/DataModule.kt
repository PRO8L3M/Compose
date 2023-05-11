package com.example.data.di

import android.content.Context
import com.example.data.errors.DefaultErrorHandler
import com.example.domain.errors.ErrorHandler
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
interface DataModule {

    @Binds
    fun bindErrorHandler(handler: DefaultErrorHandler): ErrorHandler

    companion object {

        @Provides
        fun provideResources(@ApplicationContext context: Context) = context.resources
    }
}
