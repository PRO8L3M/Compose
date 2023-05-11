package com.example.data.errors

import android.content.res.Resources
import com.example.domain.errors.ErrorEntity
import com.example.domain.errors.ErrorHandler
import java.io.IOException
import javax.inject.Inject

class DefaultErrorHandler @Inject constructor(
    private val resources: Resources
) : ErrorHandler {

    override fun getError(error: Throwable): ErrorEntity = when(error) {
        is IOException -> ErrorEntity.Network
        else -> ErrorEntity.Unknown
    }
}
