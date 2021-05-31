package andrey.murzin.com.personcapital.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.Colors
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable


private val lightColorPallet = lightColors(
    primary = Neutral0,
    onPrimary = Neutral9,
    primaryVariant = Neutral1,
    secondary = Slate6,
    secondaryVariant = Slate8,
    onSecondary = Neutral2
)

private val darkColorPallet = darkColors()

@Composable
fun PersonCapitalTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val currencyColor = if (darkTheme) darkColorPallet else lightColorPallet

    MaterialTheme(
        colors = currencyColor,
        content = content
    )
}




