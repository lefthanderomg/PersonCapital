package andrey.murzin.com.personcapital.presentation.oprationhistory

import andrey.murzin.com.personcapital.domain.model.BrokerReport
import andrey.murzin.com.personcapital.presentation.theme.spaceMedium
import andrey.murzin.com.personcapital.utils.getText
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun OperationHistory(modifier: Modifier, viewModel: OperationHistoryViewModel = hiltViewModel()) {
    when (val state =
        viewModel.uiState.collectAsState(initial = OperationHistoryState.Empty).value) {
        is OperationHistoryState.Empty -> {
        }
        is OperationHistoryState.Error -> {
        }
        is OperationHistoryState.Success -> ReportsList(modifier, state.reports)
        is OperationHistoryState.Loading -> Loading(modifier)
    }

}

@Composable
private fun ReportsList(modifier: Modifier, reports: List<BrokerReport>) {
    LazyColumn(modifier = modifier.fillMaxSize()) {
        items(reports) { item ->
            Column(modifier = Modifier.fillMaxWidth()) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable {
                        },
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = item.shortName,
                        style = MaterialTheme.typography.subtitle1,
                        modifier = Modifier.padding(spaceMedium)
                    )
                    Text(
                        text = item.totalPrice.getText(),
                        style = MaterialTheme.typography.caption,
                        modifier = Modifier.padding(end = spaceMedium)
                    )
                }
                Divider()
            }
        }
    }
}

@Composable
private fun Loading(modifier: Modifier) {
    Box(contentAlignment = Alignment.Center, modifier = modifier.fillMaxSize()) {
        CircularProgressIndicator()
    }
}
