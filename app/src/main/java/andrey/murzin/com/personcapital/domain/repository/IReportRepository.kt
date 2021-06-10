package andrey.murzin.com.personcapital.domain.repository

import andrey.murzin.com.personcapital.domain.model.BrokerReport
import andrey.murzin.com.personcapital.domain.model.ResultWrapper

interface IReportRepository {
    suspend fun getReports(): ResultWrapper<List<BrokerReport>>
}