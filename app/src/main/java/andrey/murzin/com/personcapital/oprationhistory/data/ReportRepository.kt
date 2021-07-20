package andrey.murzin.com.personcapital.oprationhistory.data

import andrey.murzin.com.personcapital.R
import andrey.murzin.com.personcapital.core.data.parser.XLSXParser
import andrey.murzin.com.personcapital.core.data.repository.ResourceManager
import andrey.murzin.com.personcapital.core.utils.safeCall
import andrey.murzin.com.personcapital.oprationhistory.data.mapper.BrokerReportMapper
import andrey.murzin.com.personcapital.oprationhistory.domain.IReportRepository
import andrey.murzin.com.personcapital.oprationhistory.model.BrokerReport
import andrey.murzin.com.personcapital.oprationhistory.model.ResultWrapper
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flatMapConcat
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

/** Repository for broker reports */
class ReportRepository @Inject constructor(
    private val dispatcher: CoroutineDispatcher = Dispatchers.IO,
    private val parserXLSXParser: XLSXParser,
    private val resourceManager: ResourceManager,
    private val reportDao: ReportDao,
    private val brokerReportMapper: BrokerReportMapper
) : IReportRepository {

    @FlowPreview
    override fun getReports(): Flow<ResultWrapper<List<BrokerReport>>> =
        reportDao.getAll()
            .flatMapConcat { result ->
                if (result.isEmpty()) {
                    getMockData()
                } else {
                    flow { emit(ResultWrapper.Success(brokerReportMapper.to(result))) }
                }
            }.flowOn(dispatcher)

    private fun getMockData() = flow {
        val result = safeCall(dispatcher = dispatcher) {
            val stream = resourceManager.getRawStream(R.raw.mock_data)
            val reports = parserXLSXParser.parse(stream)
            reportDao.insertAll(brokerReportMapper.from(reports))

            reports
        }

        emit(result)
    }
}