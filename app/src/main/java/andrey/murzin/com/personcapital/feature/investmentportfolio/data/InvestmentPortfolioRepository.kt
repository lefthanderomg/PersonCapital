package andrey.murzin.com.personcapital.feature.investmentportfolio.data

import andrey.murzin.com.personcapital.feature.investmentportfolio.domain.IInvestmentPortfolioRepository
import andrey.murzin.com.personcapital.feature.investmentportfolio.model.InvestPortfolio
import andrey.murzin.com.personcapital.feature.oprationhistory.data.ReportDao
import andrey.murzin.com.personcapital.feature.oprationhistory.model.Currency
import andrey.murzin.com.personcapital.feature.oprationhistory.model.ResultWrapper
import android.util.Log
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.math.BigDecimal
import javax.inject.Inject

class InvestmentPortfolioRepository @Inject constructor(
    private val reportDao: ReportDao,
    private val dispatcher: CoroutineDispatcher = Dispatchers.IO
) : IInvestmentPortfolioRepository {

    override suspend fun getInvestmentPortfolio(): ResultWrapper<InvestPortfolio> =
        withContext(dispatcher) {
            val reports = reportDao.getAll()

            val investPortfolio = InvestPortfolio(
                totalCoast = reports.sumOf {
                    val rawPrice = it.totalPrice.value.toBigDecimal()
                    if (it.totalPrice.currency != Currency.RUB.ios) {
                        rawPrice.multiply(BigDecimal(MOCK_USD))
                    } else {
                        rawPrice
                    }
                }.toPlainString() + " ${Currency.RUB.symbol}"
            )

            ResultWrapper.Success(investPortfolio)
        }

    companion object {
        private const val MOCK_USD = 71
    }
}