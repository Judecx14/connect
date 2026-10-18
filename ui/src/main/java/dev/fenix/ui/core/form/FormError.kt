package dev.fenix.ui.core.form

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import dev.fenix.ui.R
import java.math.BigDecimal

/**
 * Common errors shared by most forms.
 */
sealed interface FormError {
    data object Empty : FormError
    data object InvalidEmail : FormError
    data class MinLength(val min: Int) : FormError
    data object NotANumber : FormError
    data class MinValue(val limit: BigDecimal) : FormError
    data class MaxValue(val limit: BigDecimal) : FormError
}

@Composable
fun FormError.asString(): String {
    return when (this) {
        FormError.Empty -> stringResource(R.string.form_error_empty)
        FormError.InvalidEmail -> stringResource(R.string.form_error_invalid_email)
        is FormError.MinLength -> stringResource(R.string.form_error_min_length, min)
        FormError.NotANumber -> stringResource(R.string.form_error_not_a_number)
        is FormError.MinValue -> stringResource(R.string.form_error_min_value, limit.toPlainString())
        is FormError.MaxValue -> stringResource(R.string.form_error_max_value, limit.toPlainString())
    }
}
