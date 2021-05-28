package andrey.murzin.com.personcapital.data.model

/**
 * Data model broker report
 *
 */
class BrokerReportModel(
    val id: String,
    val date: String,
    val type: String,
    val shortName: String,
    val ticker: String,
    val unitPrice: String,
    val unitCurrency: String,
    val count: String,
    val totalPrice: String,
    val brokerCommissionPrice: String,
    val brokerCommissionCurrency: String,
    val exchangeCommissionPrice: String,
    val exchangeCommissionCurrency: String,
    val clearingCenterCommissionPrice: String,
    val clearingCenterCommissionCurrency: String,
)

