package andrey.murzin.com.personcapital.feature.investmentportfolio.domain

import andrey.murzin.com.personcapital.feature.investmentportfolio.model.InvestPortfolio
import andrey.murzin.com.personcapital.feature.oprationhistory.model.ResultWrapper

interface IInvestmentPortfolioRepository {
    suspend fun getInvestmentPortfolio(): ResultWrapper<InvestPortfolio>
}