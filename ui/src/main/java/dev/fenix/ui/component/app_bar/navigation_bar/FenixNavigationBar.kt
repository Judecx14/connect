package dev.fenix.ui.component.app_bar.navigation_bar

import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import dev.fenix.ui.component.app_bar.navigation_bar.model.Scope
import dev.fenix.ui.component.icon.FenixIcon
import dev.fenix.ui.component.icon.type.FenixIcons
import dev.fenix.ui.component.text.FenixText
import dev.fenix.ui.theme.FenixTheme

@Composable
fun FenixNavigationBar(
    modifier: Modifier = Modifier,
    background: Color = FenixTheme.colors.surface,
    tonalElevation: Dp = 0.dp,
    configure: Scope.() -> Unit
) {
    val scope = Scope().apply(configure)

    NavigationBar(
        modifier = modifier
            .navigationBarsPadding()
            .padding(
                horizontal = FenixTheme.dimensions.padding.normal,
            )
            .clip(FenixTheme.shapes.extraLarge),
        containerColor = background,
        tonalElevation = tonalElevation
    ) {
        scope.items.forEach { item ->
            NavigationBarItem(
                label = { FenixText(text = item.label, color = FenixTheme.colors.primary) },
                icon = { FenixIcon(icon = item.icon) },
                alwaysShowLabel = item.selected,
                selected = item.selected,
                onClick = item.onClick,
                colors = NavigationBarItemColors(
                    selectedIconColor = FenixTheme.colors.primary,
                    selectedTextColor = FenixTheme.colors.primary,
                    selectedIndicatorColor = Color.Transparent,
                    unselectedIconColor = FenixTheme.colors.onSurface,
                    unselectedTextColor = FenixTheme.colors.onSurface,
                    disabledIconColor = FenixTheme.colors.onSurfaceVariant,
                    disabledTextColor = FenixTheme.colors.onSurfaceVariant,
                )
            )
        }
    }
}

@Preview
@Composable
private fun FenixNavigationBarPreview() {
    FenixTheme {
        FenixNavigationBar {
            item(
                label = "House",
                icon = FenixIcons.House,
                selected = true,
                showLabel = true,
                onClick = {}
            )

            item(
                label = "Settings",
                icon = FenixIcons.Bolt,
                selected = false,
                showLabel = false,
                onClick = {}
            )

            item(
                label = "List",
                icon = FenixIcons.ListRestart,
                selected = false,
                showLabel = false,
                onClick = {}
            )

            item(
                label = "Exit",
                icon = FenixIcons.Logout,
                selected = false,
                showLabel = false,
                onClick = {}
            )
        }
    }
}