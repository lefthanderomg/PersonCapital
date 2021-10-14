package andrey.murzin.com.personcapital.core.utils

import andrey.murzin.com.personcapital.feature.oprationhistory.model.Currency
import andrey.murzin.com.personcapital.feature.oprationhistory.model.Money
import java.math.BigDecimal
import javax.inject.Inject

class MoneyManager @Inject constructor() {

    fun getMoney(price: String, currency: String): Money =
        Money(
            value = BigDecimal(formattedToPriceString(price)),
            currency = mapCurrencyByIos(currency),
        )

    private fun mapCurrencyByIos(ios: String): Currency {
        if (ios.isEmpty()) return Currency.EMPTY
        return when (ios) {
            Currency.USD.ios -> Currency.USD
            Currency.RUB.ios -> Currency.RUB
            else -> throw IllegalArgumentException("Not found currency $ios")
        }
    }

    private fun formattedToPriceString(price: String): String = price.replace(",", ".")
}


