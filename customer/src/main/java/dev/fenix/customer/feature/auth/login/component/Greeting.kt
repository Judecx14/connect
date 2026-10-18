package dev.fenix.customer.feature.auth.login.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import dev.fenix.customer.R
import dev.fenix.ui.component.tag.FenixTag
import dev.fenix.ui.component.text.FenixText
import dev.fenix.ui.component.text.type.FenixTextStyle
import dev.fenix.ui.theme.FenixTheme

@Composable
fun Greeting(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier.padding(
            start = FenixTheme.dimensions.padding.medium,
            end = FenixTheme.dimensions.padding.medium,
            bottom = FenixTheme.dimensions.padding.normal
        ),
        verticalArrangement = Arrangement.Bottom,
    ) {
        Row(
            modifier = Modifier.padding(bottom = FenixTheme.dimensions.padding.normal),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(
                FenixTheme.dimensions.spacing.small
            )
        ) {
            FenixText(text = stringResource(R.string.login_screen_greeting_for))
            FenixTag(
                text = stringResource(R.string.login_screen_greeting_tag)
            )
        }
        FenixText(
            text = stringResource(R.string.login_screen_greeting_title),
            style = FenixTextStyle.Display
        )
        FenixText(text = stringResource(R.string.login_screen_greeting_description))
    }
}

@Preview(showBackground = true)
@Composable
private fun AuthByPreview(){
    FenixTheme {
        Greeting()
    }
}