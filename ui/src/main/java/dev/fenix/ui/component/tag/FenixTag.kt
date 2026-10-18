package dev.fenix.ui.component.tag

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import dev.fenix.ui.theme.FenixTheme
import dev.fenix.ui.component.text.FenixText

@Composable
fun FenixTag(
    modifier: Modifier = Modifier,
    text: String,
    containerColor: Color = FenixTheme.colors.primary,
    contentColor: Color = FenixTheme.colors.onPrimary
) {
    Box(
        modifier = modifier
            .background(
                color = containerColor,
                shape = FenixTheme.shapes.extraSmall
            )
            .padding(
                horizontal = FenixTheme.dimensions.padding.small,
                vertical = FenixTheme.dimensions.padding.xs
            )
    ) {
        FenixText(
            text = text,
            color = contentColor,
        )
    }
}


@Preview(showBackground = true)
@Composable
private fun FenixTagPreview() {
    FenixTheme {
        FenixTag(text = "Example")
    }
}