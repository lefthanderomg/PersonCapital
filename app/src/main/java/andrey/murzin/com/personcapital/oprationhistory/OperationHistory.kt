package andrey.murzin.com.personcapital.oprationhistory

import andrey.murzin.com.personcapital.core.theme.spaceMedium
import andrey.murzin.com.personcapital.core.utils.getText
import andrey.murzin.com.personcapital.oprationhistory.model.BrokerReport
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.google.accompanist.swiperefresh.SwipeRefresh
import com.google.accompanist.swiperefresh.rememberSwipeRefreshState

@Composable
fun OperationHistory(modifier: Modifier, viewModel: OperationHistoryViewModel = hiltViewModel()) {
    val state = viewModel.state.collectAsState().value
    val refresh = { viewModel.action(OperationHistoryAction.GetOperationHistory) }
    when {
        state.error != null -> ErrorScreen(state.isRefreshing, refresh)
        state.isLoading -> Loading(modifier = modifier)
        state.reports.isNotEmpty() -> ReportsList(
            modifier = modifier,
            reports = state.reports,
            isRefreshing = state.isRefreshing,
            refresh = refresh
        )
        else -> EmptyScreen(isRefreshing = state.isRefreshing, refresh)
    }
}

@Composable
private fun ReportsList(
    modifier: Modifier,
    reports: List<BrokerReport>,
    isRefreshing: Boolean,
    refresh: () -> Unit
) {
    SwipeRefresh(
        state = rememberSwipeRefreshState(isRefreshing),
        onRefresh = refresh,
    ) {
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
}

@Composable
private fun Loading(modifier: Modifier) {
    Box(contentAlignment = Alignment.Center, modifier = modifier.fillMaxSize()) {
        CircularProgressIndicator()
    }
}

@Composable
private fun ErrorScreen(isRefreshing: Boolean, refresh: () -> Unit) {
    SwipeRefresh(
        state = rememberSwipeRefreshState(isRefreshing),
        onRefresh = refresh,
    ) {}
}

@Composable
private fun EmptyScreen(isRefreshing: Boolean, refresh: () -> Unit) {
    SwipeRefresh(
        state = rememberSwipeRefreshState(isRefreshing),
        onRefresh = refresh,
    ) {}
}
