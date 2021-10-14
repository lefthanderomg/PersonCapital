package andrey.murzin.com.personcapital.feature.investmentportfolio.di

import andrey.murzin.com.personcapital.core.base.Store
import andrey.murzin.com.personcapital.feature.investmentportfolio.InvestmentPortfolioReducer
import andrey.murzin.com.personcapital.feature.investmentportfolio.InvestmentPortfolioState
import andrey.murzin.com.personcapital.feature.investmentportfolio.domain.IInvestmentPortfolioRepository
import andrey.murzin.com.personcapital.feature.investmentportfolio.domain.InvestmentPortfolioMiddleware
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@InstallIn(ViewModelComponent::class)
@Module
object InvestmentPortfolioModule {

    @ViewModelScoped
    @Provides
    fun provideOperationHistoryStore(
        repository: IInvestmentPortfolioRepository
    ) =
        Store(
            reducer = InvestmentPortfolioReducer(),
            middlewares = listOf(InvestmentPortfolioMiddleware(repository)),
            initialState = InvestmentPortfolioState.EMPTY
        )
}