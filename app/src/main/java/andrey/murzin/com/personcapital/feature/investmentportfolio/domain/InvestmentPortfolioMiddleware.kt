package andrey.murzin.com.personcapital.feature.investmentportfolio.domain

import andrey.murzin.com.personcapital.core.base.Middleware
import andrey.murzin.com.personcapital.core.utils.withLatestFrom
import andrey.murzin.com.personcapital.feature.investmentportfolio.InvestmentPortfolioAction
import andrey.murzin.com.personcapital.feature.investmentportfolio.InvestmentPortfolioState
import andrey.murzin.com.personcapital.feature.oprationhistory.model.ResultWrapper
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.*
import javax.inject.Inject

@FlowPreview
class InvestmentPortfolioMiddleware @Inject constructor(
    private val repository: IInvestmentPortfolioRepository
) : Middleware<InvestmentPortfolioAction, InvestmentPortfolioState> {

    override fun bind(
        actions: Flow<InvestmentPortfolioAction>,
        state: Flow<InvestmentPortfolioState>
    ): Flow<InvestmentPortfolioAction> =
        actions.filter { it is InvestmentPortfolioAction.GetInvestmentPortfolio }
            .flatMapConcat {
                flow {
                    val action = when (val result = repository.getInvestmentPortfolio()) {
                        is ResultWrapper.Success -> InvestmentPortfolioAction.Success(result.value)
                        is ResultWrapper.Error -> InvestmentPortfolioAction.Error(result.throwable)
                    }
                    this.emit(action)
                }.onStart { InvestmentPortfolioAction.Loading }
            }
}