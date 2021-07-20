package andrey.murzin.com.personcapital.oprationhistory

import andrey.murzin.com.personcapital.oprationhistory.model.BrokerReport
import androidx.compose.runtime.Immutable

@Immutable
data class OperationHistoryState(
    val reports: List<BrokerReport>,
    val isRefreshing: Boolean = false,
    val isLoading: Boolean = false,
    val error: Error? = null,
) {

    companion object {
        val EMPTY = OperationHistoryState(
            emptyList(),
            isRefreshing = false,
            isLoading = false,
            error = null
        )
    }
}