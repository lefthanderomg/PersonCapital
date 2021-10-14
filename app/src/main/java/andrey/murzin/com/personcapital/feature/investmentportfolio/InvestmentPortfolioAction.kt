package andrey.murzin.com.personcapital.feature.investmentportfolio

import andrey.murzin.com.personcapital.feature.investmentportfolio.model.InvestPortfolio

sealed class InvestmentPortfolioAction {
    class Success(val value: InvestPortfolio) : InvestmentPortfolioAction()
    class Error(throwable: Throwable): InvestmentPortfolioAction()
    object GetInvestmentPortfolio : InvestmentPortfolioAction()
    object Loading : InvestmentPortfolioAction()
}