package andrey.murzin.com.personcapital.feature.oprationhistory.model

import java.math.BigDecimal

/**
 * Domain model for price
 */
data class Money(
    val value: BigDecimal,
    val currency: Currency,
) {
    companion object {
        val EMPTY = Money(BigDecimal(-1), Currency.EMPTY)
    }
}