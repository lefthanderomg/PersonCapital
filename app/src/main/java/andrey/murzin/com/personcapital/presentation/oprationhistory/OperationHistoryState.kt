package andrey.murzin.com.personcapital.presentation.oprationhistory

import andrey.murzin.com.personcapital.domain.model.BrokerReport
import androidx.compose.runtime.Immutable

sealed class OperationHistoryState {

    @Immutable
    class Success(
        val reports: List<BrokerReport>
    ) : OperationHistoryState()

    @Immutable
    object Error : OperationHistoryState()

    @Immutable
    object Empty : OperationHistoryState()

    @Immutable
    object Loading: OperationHistoryState()
}