package andrey.murzin.com.personcapital.oprationhistory.domain

import andrey.murzin.com.personcapital.oprationhistory.model.ResultWrapper
import andrey.murzin.com.personcapital.core.base.Middleware
import andrey.murzin.com.personcapital.oprationhistory.OperationHistoryAction
import andrey.murzin.com.personcapital.oprationhistory.OperationHistoryState
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.*
import javax.inject.Inject

class OperationHistoryMiddleware @Inject constructor(
    private val reportRepository: IReportRepository
) : Middleware<OperationHistoryAction, OperationHistoryState> {

    @FlowPreview
    override fun bind(
        actions: Flow<OperationHistoryAction>,
        state: Flow<OperationHistoryState>
    ): Flow<OperationHistoryAction> =
        actions.filter { it is OperationHistoryAction.GetOperationHistory }
            .flatMapConcat {
                reportRepository.getReports()
                    .map {
                        when (val result = it) {
                            is ResultWrapper.Success -> OperationHistoryAction.Success(result.value)
                            is ResultWrapper.Error -> OperationHistoryAction.Error(result.throwable)
                        }
                    }.onStart { emit(OperationHistoryAction.Loading) }
            }
}