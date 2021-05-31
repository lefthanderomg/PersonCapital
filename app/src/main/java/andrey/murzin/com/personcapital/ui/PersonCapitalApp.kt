package andrey.murzin.com.personcapital.ui

import andrey.murzin.com.personcapital.ui.theme.PersonCapitalTheme
import androidx.compose.runtime.Composable
import com.google.accompanist.insets.ProvideWindowInsets

@Composable
fun PersonCapitalApp() {
    ProvideWindowInsets {
        PersonCapitalTheme {

        }
    }
}
