package andrey.murzin.com.personcapital.feature.oprationhistory

import andrey.murzin.com.personcapital.feature.oprationhistory.model.BrokerReport
import androidx.compose.runtime.Immutable

@Immutable
data class OperationHistoryState(
    val reports: List<BrokerReport> = emptyList(),
    val isRefreshing: Boolean = false,
    val isLoading: Boolean = false,
    val error: Error? = null,
    val isLoadingMore: Boolean = false,
    val page: Int = 0,
    val canLoadMore: Boolean = true,
)