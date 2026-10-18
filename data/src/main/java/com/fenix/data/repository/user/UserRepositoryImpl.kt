package com.fenix.data.repository.user

import dev.fenix.core.resource.safeCall
import com.fenix.data.datasource.api.user.UserApi
import com.fenix.data.datasource.error.mapToBaseFailureReason
import com.fenix.data.model.user.request.toRequest
import com.fenix.data.model.user.response.toUser
import dev.fenix.core.resource.FailureReason
import dev.fenix.core.resource.Resource
import com.fenix.domain.model.user.CreateUserInput
import com.fenix.domain.model.user.User
import com.fenix.domain.repository.user.UserRepository
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(
    private val userApi: UserApi
) : UserRepository {

    override suspend fun create(input: CreateUserInput): Resource<User, FailureReason> {
        val payloadRequest = input.toRequest()

        return safeCall(
            call = { userApi.create(payloadRequest) },
            onSuccess = { response -> response.toUser() },
            onFailure = { throwable -> mapToBaseFailureReason(throwable) }
        )
    }
}