package andrey.murzin.com.personcapital.domain.repository

import andrey.murzin.com.personcapital.data.model.BrokerReportModel
import andrey.murzin.com.personcapital.data.model.ResultWrapper

interface IReportRepository {
    suspend fun getReports(): ResultWrapper<List<BrokerReportModel>>
}