package andrey.murzin.com.personcapital.ui.home

import andrey.murzin.com.personcapital.R
import andrey.murzin.com.personcapital.ui.investmentportfolio.InvestmentPortfolio
import andrey.murzin.com.personcapital.ui.oprationhistory.OperationHistory
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import com.google.accompanist.insets.navigationBarsPadding

enum class HomeSections(
    @StringRes val title: Int,
    @DrawableRes val icon: Int,
    val route: String
) {
    INVESTMENT_PORTFOLIO(R.string.investment_portfolio, R.drawable.ic_investment, "home/portfolio"),
    OPERATION_HISTORY(R.string.operation_history, R.drawable.ic_history, "home/history")
}

@Composable
fun PersonCapitalBottomBar(
    tabs: List<HomeSections>,
    navController: NavHostController,
) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    BottomNavigation(
        modifier = Modifier.navigationBarsPadding(left = false, right = false)
    ) {
        tabs.forEach { tab ->
            BottomNavigationItem(
                selected = tab.route == currentRoute,
                label = { Text(text = stringResource(tab.title)) },
                icon = {
                    Icon(
                        painter = painterResource(tab.icon),
                        contentDescription = stringResource(tab.title)
                    )
                },
                onClick = {
                    if (currentRoute != tab.route) {
                        navController.navigate(tab.route)
                    }
                }
            )
        }
    }
}

fun NavGraphBuilder.addHomeGraph(modifier: Modifier) {
    composable(HomeSections.OPERATION_HISTORY.route) { OperationHistory(modifier) }
    composable(HomeSections.INVESTMENT_PORTFOLIO.route) { InvestmentPortfolio(modifier) }
}