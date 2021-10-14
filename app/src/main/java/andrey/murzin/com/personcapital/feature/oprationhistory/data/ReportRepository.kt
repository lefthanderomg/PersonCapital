package andrey.murzin.com.personcapital.feature.oprationhistory.data

import andrey.murzin.com.personcapital.feature.oprationhistory.data.mapper.BrokerReportMapper
import andrey.murzin.com.personcapital.feature.oprationhistory.domain.IReportRepository
import andrey.murzin.com.personcapital.feature.oprationhistory.model.BrokerReport
import andrey.murzin.com.personcapital.feature.oprationhistory.model.ResultWrapper
import android.util.Log
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

/** Repository for broker reports */
class ReportRepository @Inject constructor(
    private val dispatcher: CoroutineDispatcher = Dispatchers.IO,
    private val reportDao: ReportDao,
    private val brokerReportMapper: BrokerReportMapper
) : IReportRepository {

    override suspend fun getReports(): ResultWrapper<List<BrokerReport>> = withContext(dispatcher) {
        val reports = reportDao.getAll()

        ResultWrapper.Success(brokerReportMapper.to(reports))
    }
}