package andrey.murzin.com.personcapital.oprationhistory

import andrey.murzin.com.personcapital.core.base.BaseViewModel
import andrey.murzin.com.personcapital.core.base.Store
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class OperationHistoryViewModel @Inject constructor(
    store: Store<OperationHistoryAction, OperationHistoryState>
) : BaseViewModel<OperationHistoryAction, OperationHistoryState>(store) {

    init {
        action(OperationHistoryAction.GetOperationHistory)
    }
}





