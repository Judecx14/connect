package dev.fenix.customer.feature.auth.signup.form

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import dev.fenix.customer.R
import dev.fenix.ui.component.button.FenixButton
import dev.fenix.ui.component.field.FenixField
import dev.fenix.ui.core.form.asString
import dev.fenix.ui.theme.FenixTheme
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.foundation.layout.size

@Composable
fun SignUpFormSection(
    modifier: Modifier = Modifier,
    form: SignUpFormGroup,
    isLoading: Boolean = false,
    onSubmit: () -> Unit,
) {
    Column(
        modifier = modifier.padding(FenixTheme.dimensions.padding.medium),
        verticalArrangement = Arrangement.spacedBy(FenixTheme.dimensions.spacing.medium)
    ) {
        FenixField(
            label = stringResource(R.string.signup_screen_form_field_label_email),
            placeholder = stringResource(R.string.signup_screen_form_field_placeholder_email),
            enabled = !isLoading,
            value = form.email.value,
            onChange = { form.email.onChange(it) },
            hasError = form.email.error != null,
            errorMessage = form.email.error?.asString()
        )

        FenixField(
            label = stringResource(R.string.signup_screen_form_field_label_password),
            placeholder = stringResource(R.string.signup_screen_form_field_placeholder_password),
            enabled = !isLoading,
            value = form.password.value,
            onChange = { form.password.onChange(it) },
            visualTransformation = PasswordVisualTransformation(),
            hasError = form.password.error != null,
            errorMessage = form.password.error?.asString()
        )

        FenixButton(
            label = stringResource(R.string.signup_screen_form_button_signup),
            enabled = !isLoading,
            onClick = onSubmit,
            leading = if (isLoading) {
                { color ->
                    CircularProgressIndicator(
                        modifier = Modifier.size(FenixTheme.dimensions.icon.small),
                        color = color,
                        strokeWidth = FenixTheme.dimensions.border.small
                    )
                }
            } else null
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun HeaderPreview() {
    FenixTheme {
        SignUpFormSection(
            form = SignUpFormGroup(),
            isLoading = true,
            onSubmit = {}
        )
    }
}