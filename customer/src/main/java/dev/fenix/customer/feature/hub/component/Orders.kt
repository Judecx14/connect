package dev.fenix.customer.feature.hub.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import dev.fenix.ui.component.icon.FenixIcon
import dev.fenix.ui.component.icon.type.FenixIcons
import dev.fenix.ui.component.text.FenixText
import dev.fenix.ui.component.text.type.FenixTextStyle
import dev.fenix.ui.theme.FenixTheme

@Composable
fun EmptyOrdes(
    modifier: Modifier = Modifier
) {
    val contentColor = FenixTheme.colors.onSurface.copy(alpha = 0.5f)

    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Center
    ) {
        FenixText(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    horizontal = FenixTheme.dimensions.padding.medium,
                ),
            text = "Sin pedidos activos",
            align = TextAlign.Center,
            style = FenixTextStyle.Label,
            color = contentColor
        )

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .padding(
                    vertical = FenixTheme.dimensions.padding.normal
                ),
            contentAlignment = Alignment.Center
        ) {
            FenixIcon(
                modifier = Modifier
                    .width(FenixTheme.dimensions.icon.xxl)
                    .height(FenixTheme.dimensions.icon.xxl),
                icon = FenixIcons.StickyNotePlus,
                tint = contentColor
            )
        }

        FenixText(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    horizontal = FenixTheme.dimensions.padding.medium,
                ),
            align = TextAlign.Center,
            text =
                "No cuentas con pedidos en curso en este momento. Para visualizar información, es necesario que generes un pedido",
            style = FenixTextStyle.Body,
            color = contentColor
        )
    }
}

@Composable
fun Orders(
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier) {
        FenixText(
            modifier = Modifier.padding(
                horizontal = FenixTheme.dimensions.padding.medium,
                vertical = FenixTheme.dimensions.padding.large
            ),
            text = "Pedidos activos",
            style = FenixTextStyle.Headline,
        )

        EmptyOrdes(
            modifier = Modifier.weight(1f)
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun OrdersPreview() {
    FenixTheme {
        Orders()
    }
}