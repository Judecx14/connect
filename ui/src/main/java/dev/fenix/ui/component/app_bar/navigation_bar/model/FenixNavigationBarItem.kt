package dev.fenix.ui.component.app_bar.navigation_bar.model

import dev.fenix.ui.component.icon.type.FenixIcons

data class FenixNavigationBarItem(
    val label: String,
    val icon: FenixIcons,
    val selected: Boolean,
    val showLabel: Boolean,
    val onClick: () -> Unit
)

class Scope {
    private val MAX_ITEMS_LENGTH = 4

    private val _items = mutableListOf<FenixNavigationBarItem>()
    val items: List<FenixNavigationBarItem> = _items

    fun item(
        label: String,
        icon: FenixIcons,
        selected: Boolean,
        showLabel: Boolean,
        onClick: () -> Unit
    ) {
        if (_items.size == MAX_ITEMS_LENGTH) return

        _items.add(
            FenixNavigationBarItem(
                label = label,
                icon = icon,
                selected = selected,
                showLabel = showLabel,
                onClick = onClick
            )
        )
    }
}