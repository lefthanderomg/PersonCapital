package andrey.murzin.com.personcapital.presentation.oprationhistory

import andrey.murzin.com.personcapital.data.model.ResultWrapper
import andrey.murzin.com.personcapital.domain.repository.IReportRepository
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

private val TAG = OperationHistoryViewModel::class.java.simpleName

@HiltViewModel
class OperationHistoryViewModel @Inject constructor(
    private val repository: IReportRepository
) : ViewModel() {

    init {
        getReports()
    }

    private fun getReports() {
        viewModelScope.launch {
            when (val reports = repository.getReports()) {
                is ResultWrapper.Success -> {
                    Log.d(TAG, "getReports: $reports")
                }
                is ResultWrapper.Error -> {
                    Log.d(TAG, "getReports: Error")
                }
            }
        }
    }
}




