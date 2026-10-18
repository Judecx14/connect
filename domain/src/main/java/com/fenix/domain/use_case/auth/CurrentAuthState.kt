package com.fenix.domain.use_case.auth

import com.fenix.domain.model.auth.AuthState
import dev.fenix.core.resource.FailureReason
import dev.fenix.core.resource.Resource
import com.fenix.domain.repository.auth.AuthRepository
import javax.inject.Inject

class CurrentAuthState @Inject constructor(
    private val authRepository: AuthRepository
) {
    operator fun invoke() : Resource<AuthState, FailureReason> {
        return authRepository.getAuthState()
    }
}