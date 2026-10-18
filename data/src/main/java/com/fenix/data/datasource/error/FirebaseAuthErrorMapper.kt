package com.fenix.data.datasource.error

import com.fenix.domain.model.auth.AuthFailure
import dev.fenix.core.resource.FailureReason
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException
import com.google.firebase.auth.FirebaseAuthInvalidUserException
import com.google.firebase.auth.FirebaseAuthUserCollisionException

internal fun mapFirebaseAuthException(throwable: Throwable): FailureReason {
    return when (throwable) {
        is FirebaseAuthInvalidCredentialsException -> AuthFailure.InvalidCredentials
        is FirebaseAuthInvalidUserException -> AuthFailure.UserNotFound
        is FirebaseAuthUserCollisionException -> AuthFailure.EmailAlreadyInUse
        else -> mapToBaseFailureReason(throwable)
    }
}