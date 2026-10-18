package com.fenix.domain.repository.user

import dev.fenix.core.resource.FailureReason
import dev.fenix.core.resource.Resource
import com.fenix.domain.model.user.CreateUserInput
import com.fenix.domain.model.user.User

interface UserRepository {
    suspend fun create(input: CreateUserInput) : Resource<User, FailureReason>
}