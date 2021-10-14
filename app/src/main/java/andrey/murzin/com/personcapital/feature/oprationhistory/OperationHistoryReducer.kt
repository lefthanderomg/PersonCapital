package andrey.murzin.com.personcapital.feature.oprationhistory

import andrey.murzin.com.personcapital.core.base.Reducer

class OperationHistoryReducer : Reducer<OperationHistoryState, OperationHistoryAction> {

    override fun reduce(
        state: OperationHistoryState,
        action: OperationHistoryAction
    ): OperationHistoryState = when (action) {
        is OperationHistoryAction.Error -> state.copy(
            error = Error(action.throwable.message.orEmpty()),
            isLoading = false,
            isRefreshing = false
        )
        is OperationHistoryAction.Loading -> state.copy(
            isLoading = true,
            error = null,
            isRefreshing = false
        )
        is OperationHistoryAction.Refresh -> state.copy(
            isRefreshing = true,
            error = null,
            isLoading = false
        )
        is OperationHistoryAction.Success -> state.copy(
            isLoading = false,
            error = null,
            isRefreshing = false,
            reports = action.result
        )
        is OperationHistoryAction.GetOperationHistory -> state
    }
}