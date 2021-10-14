package andrey.murzin.com.personcapital.feature.settings.data

import andrey.murzin.com.personcapital.R
import andrey.murzin.com.personcapital.core_data.parser.XLSXParser
import andrey.murzin.com.personcapital.core_data.repository.ResourceManager
import andrey.murzin.com.personcapital.core.utils.safeCall
import andrey.murzin.com.personcapital.feature.oprationhistory.data.ReportDao
import andrey.murzin.com.personcapital.feature.oprationhistory.data.mapper.BrokerReportMapper
import andrey.murzin.com.personcapital.feature.oprationhistory.model.ResultWrapper
import andrey.murzin.com.personcapital.feature.settings.domain.ISettingsRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class SettingsRepository @Inject constructor(
    private val dispatcher: CoroutineDispatcher = Dispatchers.IO,
    private val parserXLSXParser: XLSXParser,
    private val resourceManager: ResourceManager,
    private val reportDao: ReportDao,
    private val brokerReportMapper: BrokerReportMapper,
) : ISettingsRepository{

    override suspend fun initMockData(): ResultWrapper<Unit> =
        safeCall(dispatcher = dispatcher) {
            val stream = resourceManager.getRawStream(R.raw.mock_data)
            val reports = parserXLSXParser.parse(stream)
            reportDao.insertAll(brokerReportMapper.from(reports))
        }
}