package andrey.murzin.com.personcapital.presentation.oprationhistory

import andrey.murzin.com.personcapital.domain.model.ResultWrapper
import andrey.murzin.com.personcapital.domain.repository.IReportRepository
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

private val TAG = OperationHistoryViewModel::class.java.simpleName

@HiltViewModel
class OperationHistoryViewModel @Inject constructor(
    private val repository: IReportRepository
) : ViewModel() {

    private val _uiState: MutableStateFlow<OperationHistoryState> =
        MutableStateFlow(OperationHistoryState.Empty)

    val uiState: StateFlow<OperationHistoryState> = _uiState

    init {
        getReports()
    }

    private fun getReports() {
        viewModelScope.launch {
            _uiState.emit(OperationHistoryState.Loading)

            when (val result = repository.getReports()) {
                is ResultWrapper.Success -> {
                    _uiState.emit(OperationHistoryState.Success(result.value))
                }
                is ResultWrapper.Error -> {
                    Log.d(TAG, "getReports: error ${result.throwable}")
                    _uiState.emit(OperationHistoryState.Error)
                }
            }
        }
    }
}




