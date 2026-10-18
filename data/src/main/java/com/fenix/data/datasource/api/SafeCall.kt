package com.fenix.data.datasource.api

import com.fenix.data.datasource.error.mapToBaseFailureReason
import com.fenix.domain.model.resource.FailureReason
import com.fenix.domain.model.resource.Resource

internal inline fun <R, T> safeCall(
    call: () -> R,
    onSuccess: (R) -> T,
    onFailure: (Throwable) -> FailureReason = { throwable -> mapToBaseFailureReason(throwable) }
): Resource<T, FailureReason> {
    val result = runCatching { call() }

    return result.fold(
        onSuccess = { response -> Resource.Success(onSuccess(response)) },
        onFailure = { throwable -> Resource.Failure(onFailure(throwable)) }
    )
}

internal inline fun safeCall(
    call: () -> Unit,
    onFailure: (Throwable) -> FailureReason = { throwable -> mapToBaseFailureReason(throwable) }
): Resource<Unit, FailureReason> {
    val result = runCatching { call() }

    return result.fold(
        onSuccess = { Resource.Success(Unit) },
        onFailure = { throwable ->
            val failureReason = onFailure(throwable)
            Resource.Failure(failureReason)
        }
    )
}


