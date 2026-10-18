package dev.fenix.customer.common

import android.content.Context
import com.fenix.domain.model.resource.FailureReason
import dev.fenix.customer.R

fun FailureReason.asString(context: Context): String {
    return when (this) {
        is FailureReason.Hardware.NoInternet -> context.getString(R.string.error_no_internet)
        is FailureReason.Hardware.GpsDisabled -> context.getString(R.string.error_gps_disabled)
        is FailureReason.Api.BadRequest -> context.getString(R.string.error_bad_request)
        is FailureReason.Api.InternalServerError -> context.getString(R.string.error_server)
        is FailureReason.Auth.InvalidCredentials -> context.getString(R.string.error_invalid_credentials)
        is FailureReason.Auth.UserNotFound -> context.getString(R.string.error_user_not_found)
        is FailureReason.Auth.EmailAlreadyInUse -> context.getString(R.string.error_email_already_in_use)
        is FailureReason.Unknown -> context.getString(R.string.error_unknown)
    }
}