package com.fenix.data.datasource.error

import dev.fenix.core.resource.FailureReason
import okio.IOException
import retrofit2.HttpException

internal fun mapToBaseFailureReason(throwable: Throwable): FailureReason {
    return when (throwable) {
        is IOException -> FailureReason.Hardware.NoInternet

        is HttpException -> when (throwable.code()) {
            FailureReason.Api.BadRequest.code -> FailureReason.Api.BadRequest
            else -> FailureReason.Api.InternalServerError
        }

        else -> FailureReason.Unknown
    }
}