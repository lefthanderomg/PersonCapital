package andrey.murzin.com.personcapital.feature.oprationhistory.domain

import andrey.murzin.com.personcapital.feature.oprationhistory.model.BrokerReport
import andrey.murzin.com.personcapital.feature.oprationhistory.model.ResultWrapper
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.Flow

interface IReportRepository {
    suspend fun getReports(page: Int): ResultWrapper<List<BrokerReport>>
}