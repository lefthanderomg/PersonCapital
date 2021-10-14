package andrey.murzin.com.personcapital.feature.oprationhistory

import andrey.murzin.com.personcapital.feature.oprationhistory.model.BrokerReport
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