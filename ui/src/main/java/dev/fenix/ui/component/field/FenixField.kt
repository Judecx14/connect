package dev.fenix.ui.component.field

import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import dev.fenix.ui.theme.FenixTheme
import dev.fenix.ui.component.text.FenixText
import androidx.compose.ui.graphics.SolidColor

@Composable
fun FenixField(
    modifier: Modifier = Modifier,
    value: String,
    label: String? = null,
    placeholder: String? = null,
    enabled: Boolean = true,
    leading: @Composable ((color: Color) -> Unit)? = null,
    trailing: @Composable ((color: Color) -> Unit)? = null,
    hasError: Boolean = false,
    errorMessage: String? = null,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    onChange: (String) -> Unit,
) {
    val interactionSource = remember { MutableInteractionSource() }

    val colors = TextFieldDefaults.colors(
        focusedIndicatorColor = Color.Transparent,
        unfocusedIndicatorColor = Color.Transparent,
        disabledIndicatorColor = Color.Transparent,
        errorIndicatorColor = Color.Transparent,
    )

    Column(
        modifier = modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(FenixTheme.dimensions.spacing.normal)
    ) {
        label?.let { text ->
            FenixText(text = text)
        }

        BasicTextField(
            modifier = Modifier.fillMaxWidth(),
            interactionSource = interactionSource,
            visualTransformation = visualTransformation,
            textStyle = FenixTheme.typography.bodyLarge.copy(color = FenixTheme.colors.onSurface),
            cursorBrush = SolidColor(FenixTheme.colors.primary),

            value = value,
            onValueChange = { change -> onChange(change) },

            decorationBox = @Composable { innerTextField ->
                TextFieldDefaults.DecorationBox(
                    value = value,
                    innerTextField = innerTextField,
                    enabled = true,
                    singleLine = true,
                    visualTransformation = visualTransformation,
                    interactionSource = interactionSource,
                    isError = hasError,

                    placeholder = placeholder?.let { text ->
                        { FenixText(text = text) }
                    },

                    leadingIcon = leading?.let { component ->
                        {
                            component(FenixTheme.colors.primary)
                        }
                    },
                    trailingIcon = trailing?.let { component ->
                        {
                            component(FenixTheme.colors.primary)
                        }
                    },

                    shape = FenixTheme.shapes.medium,
                    colors = colors
                )
            },

            enabled = enabled,
        )

        if (hasError && errorMessage != null) {
            Row(
                modifier = modifier.padding(horizontal = FenixTheme.dimensions.padding.normal)
            ) {
                FenixText(
                    text = errorMessage,
                    color = FenixTheme.colors.error,
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun FenixFieldPreview() {
    FenixTheme {
        Column(verticalArrangement = Arrangement.spacedBy(FenixTheme.dimensions.spacing.normal)) {
            FenixField(
                value = "", placeholder = "Write your email"
            ) {}

            FenixField(
                label = "Password",
                value = "password",
                visualTransformation = PasswordVisualTransformation()
            ) {}

            FenixField(
                value = "", placeholder = "Error",
                hasError = true,
                errorMessage = "This is a error!"
            ) {}
        }
    }
}