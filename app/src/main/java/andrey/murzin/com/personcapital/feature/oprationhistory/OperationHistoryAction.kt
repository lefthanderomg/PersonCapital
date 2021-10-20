package andrey.murzin.com.personcapital.feature.oprationhistory

import andrey.murzin.com.personcapital.feature.oprationhistory.model.BrokerReport

sealed class OperationHistoryAction {
    class Success(val result: List<BrokerReport>, val canLoadMore: Boolean) : OperationHistoryAction()
    class Error(val throwable: Throwable) : OperationHistoryAction()
    object Refresh : OperationHistoryAction()
    object Loading : OperationHistoryAction()
    object LoadingMore : OperationHistoryAction()
    object LoadData : OperationHistoryAction()
}