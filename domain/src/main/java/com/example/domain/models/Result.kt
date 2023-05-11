package com.example.domain.models

import com.example.domain.errors.ErrorEntity

sealed class Result<out T> {
    object Loading : Result<Nothing>()
    data class Success<out T>(val data: T) : Result<T>()
    data class Error(val error: ErrorEntity) : Result<Nothing>()

    inline fun onSuccess(block: (T) -> Unit): Result<T> {
        if (this is Success) block(data)
        return this
    }

    inline fun onError(block: (ErrorEntity) -> Unit): Result<T> {
        if (this is Error) block(error)
        return this
    }

}
