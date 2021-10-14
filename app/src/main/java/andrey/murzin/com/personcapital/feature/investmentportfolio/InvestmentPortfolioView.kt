package andrey.murzin.com.personcapital.feature.investmentportfolio

import android.util.Log
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun InvestmentPortfolio(
    modifier: Modifier,
    viewModel: InvestmentPortfolioViewModel = hiltViewModel()
) {
    Box(modifier = modifier.fillMaxSize()) {
        val state = viewModel.state.collectAsState().value
        Log.d("TEST", state.toString())
        Text(text = state.totalPrice)
    }
}