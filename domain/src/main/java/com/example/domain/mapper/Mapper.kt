package com.example.domain.mapper

interface Mapper<T, R> {

    fun map(source: T): R
    fun mapAll(source: Collection<T>): Collection<R> = source.map(::map)
}
