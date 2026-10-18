package dev.fenix.customer.feature.hub.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import dev.fenix.ui.component.app_bar.FenixTopBar
import dev.fenix.ui.component.button.FenixIconButton
import dev.fenix.ui.component.button.type.Variant
import dev.fenix.ui.component.icon.FenixIcon
import dev.fenix.ui.component.icon.type.FenixIcons
import dev.fenix.ui.component.text.FenixText
import dev.fenix.ui.component.text.type.FenixTextStyle
import dev.fenix.ui.theme.FenixTheme
import dev.fenix.ui.theme.token.color_scheme.Colors

@Composable
fun TopBar(
    currentLocation: String,
    logout: () -> Unit,
) {
    val contentColor = Colors.Dark.onSurface

    FenixTopBar(
        leading = {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(
                    FenixTheme.dimensions.spacing.small
                )
            ) {
                FenixIconButton(
                    onClick = { },
                ) {
                    FenixIcon(icon = FenixIcons.UserRounded, tint = contentColor)
                }

                Column(
                    verticalArrangement = Arrangement.spacedBy(
                        FenixTheme.dimensions.spacing.xs
                    ),
                ) {
                    FenixText(
                        text = "User name",
                        style = FenixTextStyle.Label,
                        color = contentColor
                    )

                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(FenixTheme.dimensions.spacing.xs)
                    ) {
                        FenixIcon(
                            icon = FenixIcons.Locate,
                            modifier = Modifier.size(FenixTheme.dimensions.icon.medium),
                            tint = contentColor
                        )

                        FenixText(
                            modifier = Modifier.width(225.dp),
                            text = currentLocation,
                            color = contentColor
                        )
                    }
                }
            }
        },
        trailing = {
            FenixIconButton(
                variant = Variant.Ghost,
                onClick = logout
            ) {
                FenixIcon(
                    icon = FenixIcons.Logout,
                    tint = contentColor
                )
            }
        }
    )
}


@Preview
@Composable
private fun TopBarPreview() {
    FenixTheme {
        TopBar(currentLocation = "Street #123 Boulevard Example between", logout = { })
    }
}