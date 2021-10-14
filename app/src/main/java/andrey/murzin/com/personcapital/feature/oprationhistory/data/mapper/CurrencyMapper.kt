package andrey.murzin.com.personcapital.feature.oprationhistory.data.mapper

import andrey.murzin.com.personcapital.feature.oprationhistory.model.Currency
import javax.inject.Inject

class CurrencyMapper @Inject constructor() {
    fun from(from: String): Currency = when (from) {
        Currency.RUB.ios -> Currency.RUB
        Currency.USD.ios -> Currency.USD
        else -> Currency.EMPTY
    }
}