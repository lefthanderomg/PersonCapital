package andrey.murzin.com.personcapital.feature.oprationhistory.model

/**
 * Domain model for currency
 */
enum class Currency(
    val ios: String,
    val symbol: String,
) {
    RUB("RUB", "₽"),
    USD("USD", "$"),
    EMPTY("", "");
}