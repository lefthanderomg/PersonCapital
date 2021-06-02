package andrey.murzin.com.personcapital.presentation.oprationhistory

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun OperationHistory(modifier: Modifier, viewModel: OperationHistoryViewModel = hiltViewModel()) {
    Box(modifier = modifier.fillMaxSize()) {
        Text(text = "OperationHistory")
    }
}