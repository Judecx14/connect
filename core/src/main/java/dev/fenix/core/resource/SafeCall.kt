package dev.fenix.core.resource

import java.io.IOException

fun mapToDefaultFailureReason(throwable: Throwable): FailureReason {
    return when (throwable) {
        is IOException -> FailureReason.Hardware.NoInternet
        else -> FailureReason.Unknown
    }
}

inline fun <R, T> safeCall(
    call: () -> R,
    onSuccess: (R) -> T,
    onFailure: (Throwable) -> FailureReason = { throwable -> mapToDefaultFailureReason(throwable) }
): Resource<T, FailureReason> {
    val result = runCatching { call() }

    return result.fold(
        onSuccess = { response -> Resource.Success(onSuccess(response)) },
        onFailure = { throwable -> Resource.Failure(onFailure(throwable)) }
    )
}

inline fun safeCall(
    call: () -> Unit,
    onFailure: (Throwable) -> FailureReason = { throwable -> mapToDefaultFailureReason(throwable) }
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
