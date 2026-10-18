package dev.fenix.ui.core.form

import android.util.Patterns
import java.math.BigDecimal

/**
 * Ready-made validators for String controls.
 * Each one reports its matching [FormError].
 *
 * Numeric validators read the text as a [BigDecimal] (safe for money) and skip blank values,
 * so combine them with [required] when the field is mandatory.
 */
object FormValidators {
    fun required(): Validator<String, FormError> =
        { value -> if (value.isBlank()) FormError.Empty else null }

    fun email(): Validator<String, FormError> =
        { value -> if (!Patterns.EMAIL_ADDRESS.matcher(value).matches()) FormError.InvalidEmail else null }

    fun minLength(min: Int): Validator<String, FormError> =
        { value -> if (value.length < min) FormError.MinLength(min) else null }

    fun numeric(): Validator<String, FormError> =
        { value -> if (value.isNotBlank() && value.toBigDecimalOrNull() == null) FormError.NotANumber else null }

    fun min(limit: Double): Validator<String, FormError> {
        val bound = BigDecimal.valueOf(limit)
        return { value ->
            val number = value.toBigDecimalOrNull()
            if (number != null && number < bound) FormError.MinValue(bound) else null
        }
    }

    fun max(limit: Double): Validator<String, FormError> {
        val bound = BigDecimal.valueOf(limit)
        return { value ->
            val number = value.toBigDecimalOrNull()
            if (number != null && number > bound) FormError.MaxValue(bound) else null
        }
    }
}
