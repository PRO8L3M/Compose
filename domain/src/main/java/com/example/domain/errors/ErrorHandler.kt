package com.example.domain.errors

interface ErrorHandler {

    fun getError(error: Throwable): ErrorEntity
}
