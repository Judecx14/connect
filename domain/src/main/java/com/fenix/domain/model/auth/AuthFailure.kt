package com.fenix.domain.model.auth

import dev.fenix.core.resource.FailureReason

sealed interface AuthFailure : FailureReason {
    data object InvalidCredentials : AuthFailure
    data object UserNotFound : AuthFailure
    data object EmailAlreadyInUse : AuthFailure
}
