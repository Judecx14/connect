package dev.fenix.core.resource

interface FailureReason {
    sealed class Hardware : FailureReason {
       data object NoInternet : Hardware()
       data object GpsDisabled: Hardware()
    }

    sealed class Api(val code: Int) : FailureReason {
       data object BadRequest : Api(400)
       data object InternalServerError : Api(500)
    }

    data object Unknown : FailureReason
}
