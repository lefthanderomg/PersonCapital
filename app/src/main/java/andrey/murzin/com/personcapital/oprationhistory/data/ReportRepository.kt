package andrey.murzin.com.personcapital.oprationhistory.data

import andrey.murzin.com.personcapital.R
import andrey.murzin.com.personcapital.core.data.parser.XLSXParser
import andrey.murzin.com.personcapital.core.data.repository.ResourceManager
import andrey.murzin.com.personcapital.oprationhistory.model.BrokerReport
import andrey.murzin.com.personcapital.oprationhistory.model.ResultWrapper
import andrey.murzin.com.personcapital.oprationhistory.domain.IReportRepository
import andrey.murzin.com.personcapital.core.utils.safeCall
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

/** Repository for broker reports */
class ReportRepository @Inject constructor(
    private val dispatcher: CoroutineDispatcher = Dispatchers.IO,
    private val parserXLSXParser: XLSXParser,
    private val resourceManager: ResourceManager,
    private val reportDao: ReportDao,
) : IReportRepository {

    override fun getReports(): Flow<ResultWrapper<List<BrokerReport>>> = flow {
        val result = safeCall(dispatcher = dispatcher) {
            val stream = resourceManager.getRawStream(R.raw.mock_data)
            parserXLSXParser.parse(stream)
        }
        emit(result)
    }.flowOn(dispatcher)
}