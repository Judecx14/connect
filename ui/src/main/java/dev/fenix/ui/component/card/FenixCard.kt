package dev.fenix.ui.component.card

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import dev.fenix.ui.component.button.FenixIconButton
import dev.fenix.ui.component.icon.FenixIcon
import dev.fenix.ui.component.icon.type.FenixIcons
import dev.fenix.ui.component.text.FenixText
import dev.fenix.ui.component.text.type.FenixTextStyle
import dev.fenix.ui.theme.FenixTheme
import dev.fenix.ui.theme.token.color_scheme.Colors

@Composable
fun FenixCard(
    modifier: Modifier = Modifier,
    icon: FenixIcons,
    title: String,
    description: String
) {
    val contentColor = Colors.Light.onSecondary

    Box(
        modifier = modifier
            .height(FenixTheme.dimensions.height.large)
            .clip(shape = FenixTheme.shapes.large)
            .background(FenixTheme.colors.secondaryContainer)
            .padding(
                horizontal = FenixTheme.dimensions.padding.normal,
                vertical = FenixTheme.dimensions.padding.small
            )
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.Start
        ) {
            FenixIconButton(
                enabled = false,
                onClick = { },
            ) {
                FenixIcon(icon = icon, tint = contentColor)
            }
            FenixText(
                text = title,
                color = contentColor,
                style = FenixTextStyle.Label
            )
            FenixText(
                text = description, 
                color = contentColor.copy(alpha = 0.5f)
            )
        }
    }
}


@Preview
@Composable
private fun FenixCardPreview() {
    FenixTheme {
        FenixCard(
            icon = FenixIcons.Bolt,
            title = "Title",
            description = "Description"
        )
    }
}