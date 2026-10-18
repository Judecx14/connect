package dev.fenix.customer.feature.hub.component

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import dev.fenix.ui.component.app_bar.navigation_bar.FenixNavigationBar
import dev.fenix.ui.component.icon.type.FenixIcons
import dev.fenix.ui.theme.FenixTheme

@Composable
fun BottomBar() {
    FenixNavigationBar(tonalElevation = FenixTheme.dimensions.elevation.xs) {
        item(
            label = "Home",
            icon = FenixIcons.House,
            selected = true,
            showLabel = true,
            onClick = {}
        )

        item(
            label = "Requests",
            icon = FenixIcons.ListRestart,
            selected = false,
            showLabel = false,
            onClick = {}
        )

        item(
            label = "Settings",
            icon = FenixIcons.Bolt,
            selected = false,
            showLabel = false,
            onClick = {}
        )
    }
}

@Preview
@Composable
private fun BottomBarPreview() {
    FenixTheme {
        BottomBar()
    }
}