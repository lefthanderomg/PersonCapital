package andrey.murzin.com.personcapital.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable


private val lightColorPallet = lightColors()

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




