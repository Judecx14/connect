package dev.fenix.ui.component.app_bar

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import dev.fenix.ui.component.button.FenixIconButton
import dev.fenix.ui.component.button.type.Variant
import dev.fenix.ui.component.text.FenixText
import dev.fenix.ui.component.text.type.FenixTextStyle
import dev.fenix.ui.theme.FenixTheme

@Composable
fun FenixTopBar(
    modifier: Modifier = Modifier,
    title: String = "",
    leading: @Composable (() -> Unit)? = null,
    trailing: @Composable (() -> Unit)? = null,
) {
    Box(
        modifier = modifier
            .statusBarsPadding()
            .padding(FenixTheme.dimensions.padding.normal)
            .fillMaxWidth()
            .height(FenixTheme.dimensions.height.normal),
        contentAlignment = Alignment.Center
    ) {
        leading?.let { component ->
            Box(modifier = Modifier.align(Alignment.CenterStart)) {
                component()
            }
        }

        FenixText(
            text = title,
            style = FenixTextStyle.Title,
            align = TextAlign.Center
        )

        trailing?.let { component ->
            Box(modifier = Modifier.align(Alignment.CenterEnd)) {
                component()
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun FenixTopBarPreview() {
    FenixTheme {
        Column {
            // All
            FenixTopBar(
                title = "Top Bar Title",
                leading = {
                    FenixIconButton(
                        onClick = {},
                        variant = Variant.Outlined
                    ) { color ->
                        FenixText(text = "<", color = color)
                    }
                },
                trailing = {
                    FenixIconButton(
                        onClick = {},
                        variant = Variant.Ghost
                    ) { color ->
                        FenixText(text = ":", color = color)
                    }
                }
            )
            // Only Title
            FenixTopBar(
                title = "Top Bar Title",
            )
            // Without leading and title
            FenixTopBar(
                title = "Top Bar Title",
                leading = {
                    FenixIconButton(
                        onClick = {},
                        variant = Variant.Outlined
                    ) { color ->
                        FenixText(text = "<", color = color)
                    }
                },
            )
            // Without trailing and title
            FenixTopBar(
                title = "Top Bar Title",
                trailing = {
                    FenixIconButton(
                        onClick = {},
                        variant = Variant.Ghost
                    ) { color ->
                        FenixText(text = ":", color = color)
                    }
                },
            )
            // Without title
            FenixTopBar(
                leading = {
                    FenixIconButton(
                        onClick = {},
                        variant = Variant.Outlined
                    ) { color ->
                        FenixText(text = "<", color = color)
                    }
                },
                trailing = {
                    FenixIconButton(
                        onClick = {},
                        variant = Variant.Ghost
                    ) { color ->
                        FenixText(text = ":", color = color)
                    }
                }
            )
            // Only leading
            FenixTopBar(
                leading = {
                    FenixIconButton(
                        onClick = {},
                        variant = Variant.Outlined
                    ) { color ->
                        FenixText(text = "<", color = color)
                    }
                },
            )
            // Only trailing
            FenixTopBar(
                trailing = {
                    FenixIconButton(
                        onClick = {},
                        variant = Variant.Ghost
                    ) { color ->
                        FenixText(text = ":", color = color)
                    }
                }
            )
        }
    }
}

