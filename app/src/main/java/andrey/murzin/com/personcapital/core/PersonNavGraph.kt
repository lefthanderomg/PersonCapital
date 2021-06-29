package andrey.murzin.com.personcapital

import andrey.murzin.com.personcapital.home.addHomeGraph
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController

@Composable
fun PersonNavGraph(
    navController: NavHostController = rememberNavController(),
    startDestination: String,
    modifier: Modifier
) {
    NavHost(
        navController = navController,
        startDestination = startDestination,
    ) {
        addHomeGraph(modifier)
    }
}