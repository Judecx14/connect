package com.fenix.data.datasource.error

import com.fenix.domain.model.resource.FailureReason
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException
import com.google.firebase.auth.FirebaseAuthInvalidUserException
import com.google.firebase.auth.FirebaseAuthUserCollisionException

internal fun mapFirebaseAuthException(throwable: Throwable): FailureReason {
    return when (throwable) {
        is FirebaseAuthInvalidCredentialsException -> FailureReason.Auth.InvalidCredentials
        is FirebaseAuthInvalidUserException -> FailureReason.Auth.UserNotFound
        is FirebaseAuthUserCollisionException -> FailureReason.Auth.EmailAlreadyInUse
        else -> mapToBaseFailureReason(throwable)
    }
}