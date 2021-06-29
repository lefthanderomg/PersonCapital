package andrey.murzin.com.personcapital.oprationhistory

import andrey.murzin.com.personcapital.oprationhistory.model.BrokerReport

sealed class OperationHistoryAction {
    class Success(val result: List<BrokerReport>) : OperationHistoryAction()
    class Error(val throwable: Throwable) : OperationHistoryAction()
    object Refresh : OperationHistoryAction()
    object Loading : OperationHistoryAction()
    object GetOperationHistory : OperationHistoryAction()
}