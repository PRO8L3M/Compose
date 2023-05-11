package com.example.domain.errors

sealed class ErrorEntity(val message: String = "") {
    object Network : ErrorEntity()
    object Unknown : ErrorEntity()
}
