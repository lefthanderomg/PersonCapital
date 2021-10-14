package andrey.murzin.com.personcapital.feature.investmentportfolio

import andrey.murzin.com.personcapital.core.base.BaseViewModel
import andrey.murzin.com.personcapital.core.base.Store
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class InvestmentPortfolioViewModel @Inject constructor(
    store: Store<InvestmentPortfolioAction, InvestmentPortfolioState>
) : BaseViewModel<InvestmentPortfolioAction, InvestmentPortfolioState>(store) {

    init {
        action(InvestmentPortfolioAction.GetInvestmentPortfolio)
    }
}