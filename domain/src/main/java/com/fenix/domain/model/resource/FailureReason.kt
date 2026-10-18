package com.fenix.domain.model.resource

sealed interface FailureReason {
    sealed class Hardware : FailureReason {
       data object NoInternet : Hardware()
       data object GpsDisabled: Hardware()
    }

    sealed class Api(val code: Int) : FailureReason {
       data object BadRequest : Api(400)
       data object InternalServerError : Api(505)
    }

    sealed interface Auth : FailureReason {
        data object InvalidCredentials : Auth
        data object UserNotFound : Auth
        data object EmailAlreadyInUse : Auth
    }

    data object Unknown : FailureReason
}