package com.fenix.domain.repository.location

import dev.fenix.core.resource.FailureReason
import dev.fenix.core.resource.Resource
import kotlinx.coroutines.flow.Flow

interface LocationRepository {
   fun currentLocation() : Flow<Resource<String, FailureReason>>
}