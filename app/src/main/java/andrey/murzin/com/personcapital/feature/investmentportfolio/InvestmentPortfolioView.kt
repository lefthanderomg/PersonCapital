package andrey.murzin.com.personcapital.feature.investmentportfolio

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun InvestmentPortfolio(
    modifier: Modifier,
) {
    Box(modifier = modifier.fillMaxSize()) {
        Text(text = "InvestmentPortfolio")
    }
}