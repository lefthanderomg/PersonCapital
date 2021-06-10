package andrey.murzin.com.personcapital.domain.model

/**
 * Domain model broker report
 */
class BrokerReport(
    val id: String,
    val date: String,
    val type: String,
    val shortName: String,
    val ticker: String,
    val count: String,
    val unitPrice: Money,
    val totalPrice: Money,
    val brokerCommissionPrice: Money,
    val exchangeCommissionPrice: Money,
    val clearingCenterCommissionPrice: Money,
)

