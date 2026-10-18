package dev.fenix.customer.feature.hub.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import dev.fenix.ui.component.card.FenixCard
import dev.fenix.ui.component.icon.type.FenixIcons
import dev.fenix.ui.component.text.FenixText
import dev.fenix.ui.component.text.type.FenixTextStyle
import dev.fenix.ui.theme.FenixTheme
import dev.fenix.ui.theme.token.color_scheme.Colors


@Composable
fun Categories(
    modifier: Modifier = Modifier
) {
    val contentColor = Colors.Dark.onSurface

    Column(modifier = modifier) {
        FenixText(
            modifier = Modifier.padding(
                horizontal = FenixTheme.dimensions.padding.medium,
                vertical = FenixTheme.dimensions.padding.large
            ),
            text = "Categorias",
            color = contentColor,
            style = FenixTextStyle.Headline,
        )

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = FenixTheme.dimensions.padding.normal),
            horizontalArrangement = Arrangement.spacedBy(
                FenixTheme.dimensions.padding.normal
            )
        ) {
            FenixCard(
                modifier = Modifier.weight(1f),
                icon = FenixIcons.Zap,
                title = "Pedido rapido",
                description = "Menos de 30 minutos"
            )
            FenixCard(
                modifier = Modifier.weight(1f),
                icon = FenixIcons.Store,
                title = "Mandado",
                description = "Solicita un pedido mas complejo"
            )
        }
    }
}

@Preview
@Composable
private fun CategoriesPreview() {
    FenixTheme {
        Categories()
    }
}