package andrey.murzin.com.personcapital.data.repository

import andrey.murzin.com.personcapital.R
import andrey.murzin.com.personcapital.data.parser.XLSXParser
import andrey.murzin.com.personcapital.domain.model.BrokerReport
import andrey.murzin.com.personcapital.domain.model.ResultWrapper
import andrey.murzin.com.personcapital.domain.repository.IReportRepository
import andrey.murzin.com.personcapital.utils.safeCall
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import javax.inject.Inject

/** Repository for broker reports */
class ReportRepository @Inject constructor(
    private val dispatcher: CoroutineDispatcher = Dispatchers.IO,
    private val parserXLSXParser: XLSXParser,
    private val resourceManager: ResourceManager,
) : IReportRepository {

    override suspend fun getReports(): ResultWrapper<List<BrokerReport>> = safeCall(dispatcher = dispatcher) {
        val stream = resourceManager.getRawStream(R.raw.mock_data)
        parserXLSXParser.parse(stream)
    }
}