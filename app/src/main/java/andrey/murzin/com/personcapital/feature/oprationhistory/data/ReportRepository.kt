package andrey.murzin.com.personcapital.feature.oprationhistory.data

import andrey.murzin.com.personcapital.feature.oprationhistory.data.mapper.BrokerReportMapper
import andrey.murzin.com.personcapital.feature.oprationhistory.domain.IReportRepository
import andrey.murzin.com.personcapital.feature.oprationhistory.model.BrokerReport
import andrey.murzin.com.personcapital.feature.oprationhistory.model.ResultWrapper
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
    private val reportDao: ReportDao,
    private val brokerReportMapper: BrokerReportMapper
) : IReportRepository {

    @FlowPreview
    override fun getReports(): Flow<ResultWrapper<List<BrokerReport>>> =
        reportDao.getAll()
            .flatMapConcat { result ->
                flow { emit(ResultWrapper.Success(brokerReportMapper.to(result))) }
            }.flowOn(dispatcher)
}