package andrey.murzin.com.personcapital.presentation

import andrey.murzin.com.personcapital.PersonNavGraph
import andrey.murzin.com.personcapital.core.theme.PersonCapitalTheme
import andrey.murzin.com.personcapital.home.HomeSections
import andrey.murzin.com.personcapital.home.PersonCapitalBottomBar
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.google.accompanist.insets.ProvideWindowInsets
import com.google.accompanist.insets.statusBarsPadding

@Composable
fun PersonCapitalApp() {
    ProvideWindowInsets {
        PersonCapitalTheme {
            val tabs = remember { HomeSections.values().toList() }
            val navController = rememberNavController()

            Scaffold(
                bottomBar = {
                    PersonCapitalBottomBar(tabs = tabs, navController = navController)
                }
            ) { paddingValue ->
                PersonNavGraph(
                    navController = navController,
                    startDestination = tabs.first().route,
                    modifier = Modifier
                        .padding(paddingValue)
                        .statusBarsPadding(),
                )
            }
        }
    }
}
