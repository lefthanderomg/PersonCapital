package andrey.murzin.com.personcapital.ui

import andrey.murzin.com.personcapital.PersonNavGraph
import andrey.murzin.com.personcapital.ui.home.HomeSections
import andrey.murzin.com.personcapital.ui.home.PersonCapitalBottomBar
import andrey.murzin.com.personcapital.ui.theme.PersonCapitalTheme
import android.util.Log
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
                Log.d("PersonCapitalApp", "paddingValue = $paddingValue")
                PersonNavGraph(
                    navController = navController,
                    startDestination = tabs.first().route,
                    modifier = Modifier.padding(paddingValue).statusBarsPadding(),
                )
            }
        }
    }
}
