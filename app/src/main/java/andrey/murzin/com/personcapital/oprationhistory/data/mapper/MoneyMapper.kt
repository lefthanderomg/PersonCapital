package andrey.murzin.com.personcapital.oprationhistory.data.mapper

import andrey.murzin.com.personcapital.oprationhistory.data.entity.MoneyEntity
import andrey.murzin.com.personcapital.oprationhistory.model.Money
import java.math.BigDecimal
import javax.inject.Inject

class MoneyMapper @Inject constructor(
    private val currencyMapper: CurrencyMapper
) {

    fun from(from: Money) : MoneyEntity = from.run {
        MoneyEntity(
            value = value.toString(),
            currency = currency.ios
        )
    }

    fun to(to: MoneyEntity) = to.run {
        Money(
            value = BigDecimal(value),
            currency = currencyMapper.from(currency)
        )
    }
}