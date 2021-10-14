package andrey.murzin.com.personcapital.feature.oprationhistory.data.mapper

import andrey.murzin.com.personcapital.feature.oprationhistory.data.entity.BrokerReportEntity
import andrey.murzin.com.personcapital.feature.oprationhistory.model.BrokerReport
import javax.inject.Inject

class BrokerReportMapper @Inject constructor(
    private val moneyMapper: MoneyMapper
) {

    fun from(from: List<BrokerReport>): List<BrokerReportEntity> = from.map(::from)

    private fun from(from: BrokerReport): BrokerReportEntity = from.run {
        BrokerReportEntity(
            id = id,
            date = date,
            type = type,
            shortName = shortName,
            ticker = ticker,
            count = count,
            unitPrice = moneyMapper.from(unitPrice),
            totalPrice = moneyMapper.from(totalPrice),
            brokerCommissionPrice = moneyMapper.from(brokerCommissionPrice),
            exchangeCommissionPrice = moneyMapper.from(exchangeCommissionPrice),
            clearingCenterCommissionPrice = moneyMapper.from(clearingCenterCommissionPrice),
        )
    }

    fun to(to : List<BrokerReportEntity>) : List<BrokerReport> = to.map(::to)

    private fun to(to: BrokerReportEntity): BrokerReport = to.run  {
        BrokerReport(
            id = id,
            date = date,
            type = type,
            shortName = shortName,
            ticker = ticker,
            count = count,
            unitPrice = moneyMapper.to(unitPrice),
            totalPrice = moneyMapper.to(totalPrice),
            brokerCommissionPrice = moneyMapper.to(brokerCommissionPrice),
            exchangeCommissionPrice = moneyMapper.to(exchangeCommissionPrice),
            clearingCenterCommissionPrice = moneyMapper.to(clearingCenterCommissionPrice),
        )
    }
}



