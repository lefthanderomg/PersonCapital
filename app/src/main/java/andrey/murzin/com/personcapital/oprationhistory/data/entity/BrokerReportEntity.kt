package andrey.murzin.com.personcapital.oprationhistory.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class BrokerReportEntity(
    @PrimaryKey
    val id: String,
    val date: String,
    val type: String,
    val shortName: String,
    val ticker: String,
    val count: String,
    val unitPrice: MoneyEntity,
    val totalPrice: MoneyEntity,
    val brokerCommissionPrice: MoneyEntity,
    val exchangeCommissionPrice: MoneyEntity,
    val clearingCenterCommissionPrice: MoneyEntity,
)