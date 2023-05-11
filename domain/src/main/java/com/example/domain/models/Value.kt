package com.example.domain.models

sealed interface Value<T> {
    class NoData<T> : Value<T>
    data class Data<T>(val data: T) : Value<T>

    fun <R> map(mapper: (T) -> R): Value<R> = when(this) {
        is Data -> Data(mapper(data))
        else -> NoData()
    }
}
