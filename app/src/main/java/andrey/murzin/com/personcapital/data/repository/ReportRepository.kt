package andrey.murzin.com.personcapital.data.repository

import andrey.murzin.com.personcapital.R
import andrey.murzin.com.personcapital.data.model.BrokerReportModel
import andrey.murzin.com.personcapital.data.parser.XLSXParser
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

/** Repository for broker reports */
class ReportRepository(
    private val dispatcher: CoroutineDispatcher = Dispatchers.IO,
    private val parserXLSXParser: XLSXParser<List<BrokerReportModel>>,
    private val resourceManager: ResourceManager,
) {

    suspend fun getReports(): List<BrokerReportModel> = withContext(dispatcher) {
        val stream = resourceManager.getRawStream(R.raw.mock_data)
        parserXLSXParser.parse(stream)
    }
}