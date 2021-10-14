package andrey.murzin.com.personcapital.feature.oprationhistory.domain

import andrey.murzin.com.personcapital.core.base.Middleware
import andrey.murzin.com.personcapital.feature.oprationhistory.OperationHistoryAction
import andrey.murzin.com.personcapital.feature.oprationhistory.OperationHistoryState
import andrey.murzin.com.personcapital.feature.oprationhistory.model.ResultWrapper
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.*

@FlowPreview
class OperationHistoryMiddleware(
    private val reportRepository: IReportRepository
) : Middleware<OperationHistoryAction, OperationHistoryState> {

    override fun bind(
        actions: Flow<OperationHistoryAction>,
        state: Flow<OperationHistoryState>
    ): Flow<OperationHistoryAction> =
        actions.filter { it is OperationHistoryAction.GetOperationHistory }
            .flatMapConcat { _ ->
                flow { this.emit(reportRepository.getReports()) }
                    .map {
                        when (val result = it) {
                            is ResultWrapper.Success -> OperationHistoryAction.Success(result.value)
                            is ResultWrapper.Error -> OperationHistoryAction.Error(result.throwable)
                        }
                    }.onStart {
                        emit(OperationHistoryAction.Loading)
                    }
            }
}