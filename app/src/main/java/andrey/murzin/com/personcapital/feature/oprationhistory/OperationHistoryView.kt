package andrey.murzin.com.personcapital.feature.oprationhistory

import andrey.murzin.com.personcapital.core.utils.getText
import andrey.murzin.com.personcapital.feature.base.Loading
import andrey.murzin.com.personcapital.feature.oprationhistory.model.BrokerReport
import andrey.murzin.com.personcapital.theme.spaceMedium
import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun OperationHistory(modifier: Modifier, viewModel: OperationHistoryViewModel = hiltViewModel()) {
    val state = viewModel.state.collectAsState().value
    when {
        state.error != null -> ErrorScreen()
        state.isLoading -> Loading(modifier = modifier)
        state.reports.isNotEmpty() -> ReportsList(
            modifier = modifier,
            reports = state.reports,
            loadMore = { viewModel.action(OperationHistoryAction.LoadData) }
        )
        else -> EmptyScreen()
    }
}

@Composable
private fun ReportsList(
    modifier: Modifier,
    reports: List<BrokerReport>,
    loadMore: () -> Unit,
) {
    LazyColumn(modifier = modifier.fillMaxSize()) {
        itemsIndexed(reports) { index, item ->
            if (index == reports.lastIndex) {
                loadMore.invoke()
            }
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
private fun ErrorScreen() {

}

@Composable
private fun EmptyScreen() {

}
