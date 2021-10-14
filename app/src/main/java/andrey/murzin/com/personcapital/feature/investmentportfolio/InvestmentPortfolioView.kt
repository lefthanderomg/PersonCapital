package andrey.murzin.com.personcapital.feature.investmentportfolio

import andrey.murzin.com.personcapital.R
import andrey.murzin.com.personcapital.feature.base.Loading
import andrey.murzin.com.personcapital.theme.spaceMedium
import andrey.murzin.com.personcapital.theme.spaceXTiny
import andrey.murzin.com.personcapital.theme.textLargeMedium
import andrey.murzin.com.personcapital.theme.textMedium
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun InvestmentPortfolio(
    modifier: Modifier = Modifier,
    viewModel: InvestmentPortfolioViewModel = hiltViewModel()
) {
    val state = viewModel.state.collectAsState().value
    if (state.isLoading) {
        Loading(modifier)
    } else {
        Box(modifier = modifier.fillMaxWidth()) {
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(spaceMedium),
                backgroundColor = MaterialTheme.colors.primary
            ) {
                Column(Modifier.fillMaxWidth()) {
                    NameWithValue(
                        modifier = Modifier
                            .padding(spaceMedium)
                            .fillMaxWidth(),
                        name = stringResource(id = R.string.total_price),
                        value = state.totalPrice
                    )
                    Divider(
                        thickness = spaceXTiny,
                        color = MaterialTheme.colors.background,
                        modifier = Modifier.padding(horizontal = spaceMedium)
                    )
                }
            }
        }
    }
}

@Composable
fun NameWithValue(modifier: Modifier = Modifier, name: String, value: String) =
    Row(
        modifier,
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = name,
            fontSize = textLargeMedium
        )
        Text(text = value, fontSize = textMedium)
    }