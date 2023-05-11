package com.example.domain.di

import javax.inject.Qualifier

@Retention
@Qualifier
annotation class Dispatcher(val type: DispatcherType)

enum class DispatcherType {
    IO,
    DEFAULT,
    MAIN;
}
