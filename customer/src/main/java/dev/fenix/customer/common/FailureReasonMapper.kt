package dev.fenix.customer.common

import android.content.Context
import com.fenix.domain.model.auth.AuthFailure
import dev.fenix.core.resource.FailureReason
import dev.fenix.customer.R
import dev.fenix.ui.core.error.asString as asCoreString

fun FailureReason.asString(context: Context): String {
    return when (this) {
        is AuthFailure.InvalidCredentials -> context.getString(R.string.error_invalid_credentials)
        is AuthFailure.UserNotFound -> context.getString(R.string.error_user_not_found)
        is AuthFailure.EmailAlreadyInUse -> context.getString(R.string.error_email_already_in_use)
        else -> asCoreString(context)
    }
}
