package dev.fenix.ui.component.text

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import dev.fenix.ui.theme.FenixTheme
import dev.fenix.ui.component.text.type.FenixTextStyle

@Composable
fun FenixText(
    modifier: Modifier = Modifier,
    text: String,
    style: FenixTextStyle = FenixTextStyle.Body,
    color: Color = FenixTheme.colors.onSurface,
    align: TextAlign = TextAlign.Start,
    overflow: TextOverflow = TextOverflow.Ellipsis,
    maxLines: Int = Int.MAX_VALUE,
) {
    val typography = when (style) {
        FenixTextStyle.Display -> FenixTheme.typography.displayLarge
        FenixTextStyle.Headline -> FenixTheme.typography.headlineLarge
        FenixTextStyle.Title -> FenixTheme.typography.titleLarge
        FenixTextStyle.Label -> FenixTheme.typography.labelLarge
        FenixTextStyle.Body -> FenixTheme.typography.bodyLarge
    }

    Text(
        modifier = modifier,
        text = text,
        style = typography,
        color = color,
        overflow = overflow,
        maxLines = maxLines,
        textAlign = align,
    )
}


@Preview(showBackground = true)
@Composable
private fun FenixTextPreview() {
    FenixTheme {
        Column(verticalArrangement = Arrangement.spacedBy(FenixTheme.dimensions.spacing.large)) {
            FenixText(text = "Display example", style = FenixTextStyle.Display)

            FenixText(text = "Headline example", style = FenixTextStyle.Headline)

            FenixText(text = "Title example", style = FenixTextStyle.Title)

            FenixText(text = "Label example", style = FenixTextStyle.Label)

            FenixText(text = "Body example", style = FenixTextStyle.Body)

            FenixText(
                text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Vivamus eget venenatis nunc, at hendrerit purus. Fusce magna erat, suscipit ac mattis id, scelerisque vel velit. Maecenas posuere turpis ac mollis semper. Suspendisse sagittis rhoncus libero, nec vulputate quam pulvinar dictum. Nunc imperdiet gravida risus, non ornare dolor vulputate auctor. Praesent ultricies feugiat odio. In efficitur non velit non mattis. Vivamus id congue lacus. Cras est lectus, fringilla sit amet luctus vel, faucibus quis risus.",
                style = FenixTextStyle.Body,
                maxLines = 1
            )
        }

    }
}