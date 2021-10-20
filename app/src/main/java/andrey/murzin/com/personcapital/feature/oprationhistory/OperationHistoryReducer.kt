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
            isRefreshing = false,
            isLoadingMore = false,
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
            isLoadingMore = false,
            error = null,
            isRefreshing = false,
            reports = action.result,
            canLoadMore = action.canLoadMore
        )
        is OperationHistoryAction.LoadingMore -> state.copy(isLoadingMore = true)
        is OperationHistoryAction.LoadData -> {
            if (!state.isLoading && !state.isLoadingMore && state.canLoadMore) {
                val page = state.page + 1
                state.copy(
                    page = page
                )
            } else {
                state
            }
        }
    }
}