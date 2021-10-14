package andrey.murzin.com.personcapital.feature.investmentportfolio

import androidx.compose.runtime.Immutable

@Immutable
data class InvestmentPortfolioState(
    val totalPrice: String,
    val isLoading: Boolean = false,
) {

    companion object {
        val EMPTY = InvestmentPortfolioState("", false)
    }
}