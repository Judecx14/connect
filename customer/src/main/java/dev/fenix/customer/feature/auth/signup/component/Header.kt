package dev.fenix.customer.feature.auth.signup.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import dev.fenix.customer.R
import dev.fenix.ui.component.text.FenixText
import dev.fenix.ui.component.text.type.FenixTextStyle
import dev.fenix.ui.theme.FenixTheme

@Composable
fun Header(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier.padding(FenixTheme.dimensions.padding.medium),
        verticalArrangement = Arrangement.spacedBy(FenixTheme.dimensions.spacing.normal)
    ) {
        FenixText(
            text = stringResource(R.string.signup_screen_header_title),
            style = FenixTextStyle.Headline
        )
        FenixText(text = stringResource(R.string.signup_screen_header_description))
    }
}

@Preview
@Composable
private fun HeaderPreview() {
    FenixTheme {
        Header()
    }
}