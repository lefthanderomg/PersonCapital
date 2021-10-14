package andrey.murzin.com.personcapital.feature.investmentportfolio

import andrey.murzin.com.personcapital.core.base.Reducer

class InvestmentPortfolioReducer : Reducer<InvestmentPortfolioState, InvestmentPortfolioAction> {
    override fun reduce(
        state: InvestmentPortfolioState,
        action: InvestmentPortfolioAction
    ): InvestmentPortfolioState = when (action) {
        is InvestmentPortfolioAction.GetInvestmentPortfolio -> state
        is InvestmentPortfolioAction.Success -> state.copy(
            totalPrice = action.value.totalCoast,
            isLoading = true
        )
        is InvestmentPortfolioAction.Error -> state
        is InvestmentPortfolioAction.Loading -> state.copy(isLoading = true)
    }

}