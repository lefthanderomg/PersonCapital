package andrey.murzin.com.personcapital.oprationhistory.domain

import andrey.murzin.com.personcapital.oprationhistory.model.BrokerReport
import andrey.murzin.com.personcapital.oprationhistory.model.ResultWrapper
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.Flow

interface IReportRepository {

    @FlowPreview
    fun getReports(): Flow<ResultWrapper<List<BrokerReport>>>

}