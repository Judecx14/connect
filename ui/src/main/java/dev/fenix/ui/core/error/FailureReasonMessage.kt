package dev.fenix.ui.core.error

import android.content.Context
import dev.fenix.core.resource.FailureReason
import dev.fenix.ui.R

fun FailureReason.asString(context: Context): String {
    return when (this) {
        is FailureReason.Hardware.NoInternet -> context.getString(R.string.error_no_internet)
        is FailureReason.Hardware.GpsDisabled -> context.getString(R.string.error_gps_disabled)
        is FailureReason.Api.BadRequest -> context.getString(R.string.error_bad_request)
        is FailureReason.Api.InternalServerError -> context.getString(R.string.error_server)
        else -> context.getString(R.string.error_unknown)
    }
}
