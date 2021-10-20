package andrey.murzin.com.personcapital.feature.oprationhistory.domain

import andrey.murzin.com.personcapital.core.base.Middleware
import andrey.murzin.com.personcapital.core.utils.withLatestFrom
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
        actions.filter { it is OperationHistoryAction.LoadData }
            .withLatestFrom(state) { _, operationHistoryState -> operationHistoryState }
            .filter { !it.isLoading && !it.isLoadingMore }
            .flatMapConcat { operationHistoryState ->
                flow { this.emit(reportRepository.getReports(operationHistoryState.page)) }
                    .map {
                        when (val result = it) {
                            is ResultWrapper.Success -> OperationHistoryAction.Success(operationHistoryState.reports + result.value, result.value.isNotEmpty())
                            is ResultWrapper.Error -> OperationHistoryAction.Error(result.throwable)
                        }
                    }.onStart {
                        emit(if (operationHistoryState.page == 1) OperationHistoryAction.Loading else OperationHistoryAction.LoadingMore)
                    }
            }

}