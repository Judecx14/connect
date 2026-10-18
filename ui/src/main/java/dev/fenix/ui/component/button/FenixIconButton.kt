package dev.fenix.ui.component.button

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.FilledIconButton
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedIconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import dev.fenix.ui.theme.FenixTheme
import dev.fenix.ui.component.button.colors.buildIconButtonColors
import dev.fenix.ui.core.type.Emphasis
import dev.fenix.ui.component.button.type.Variant

@Composable
fun FenixIconButton(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    enabled: Boolean = true,
    emphasis: Emphasis = Emphasis.Primary,
    variant: Variant = Variant.Filled,
    content: @Composable (color: Color) -> Unit,
) {
    val buttonColors = buildIconButtonColors(variant = variant, emphasis = emphasis)
    val shape = FenixTheme.shapes.large

    val setupModifier = modifier
        .width(FenixTheme.dimensions.button.medium)
        .height(FenixTheme.dimensions.button.medium)

    when (variant) {
        Variant.Filled -> {
            FilledIconButton(
                modifier = setupModifier,
                onClick = onClick,
                enabled = enabled,
                shape = shape,
                colors = buttonColors
            ) {
                content(buttonColors.contentColor)
            }
        }

        Variant.Outlined -> {
            OutlinedIconButton(
                modifier = setupModifier,
                onClick = onClick,
                enabled = enabled,
                shape = shape,
                colors = buttonColors,
                border = BorderStroke(
                    width = FenixTheme.dimensions.border.xs,
                    color = buttonColors.contentColor
                )
            ) {
                content(buttonColors.contentColor)
            }
        }

        Variant.Ghost -> {
            IconButton(
                modifier = setupModifier,
                onClick = onClick,
                enabled = enabled,
                shape = shape,
                colors = buttonColors,
            ) {
                content(buttonColors.contentColor)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun PrimaryPreview() {
    FenixTheme {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(FenixTheme.dimensions.padding.normal),
            verticalArrangement = Arrangement.SpaceEvenly
        ) {
            FenixIconButton(
                onClick = {},
            ) {
                Text("I")
            }

            FenixIconButton(
                onClick = {},
                variant = Variant.Outlined
            ) {
                Text("I")
            }


            FenixIconButton(
                onClick = {},
                variant = Variant.Ghost
            ) {
                Text("I")
            }

            // Secondary

            FenixIconButton(
                onClick = {},
                emphasis = Emphasis.Secondary
            ) {
                Text("I")
            }

            FenixIconButton(
                onClick = {},
                variant = Variant.Outlined,
                emphasis = Emphasis.Secondary
            ) {
                Text("I")
            }


            FenixIconButton(
                onClick = {},
                variant = Variant.Ghost,
                emphasis = Emphasis.Secondary
            ) {
                Text("I")
            }


        }
    }
}