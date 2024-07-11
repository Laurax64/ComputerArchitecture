package com.example.computerarchitecture.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.ListItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.tooling.preview.PreviewScreenSizes
import androidx.compose.ui.unit.dp
import com.example.computerarchitecture.R
import com.example.computerarchitecture.ui.components.TopicTopBar
import com.example.computerarchitecture.ui.theme.ComputerArchitectureTheme

/**
 * Displays the jump prediction screen with an app scaffold.
 *
 * @param navigateBack The function to navigate back
 * @param modifier The modifier for the layout
 */
@Composable
fun BranchPredictionScreen(
    navigateBack: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Scaffold(
        modifier = modifier,
        topBar = {
            TopicTopBar(
                title = stringResource(R.string.branch_prediction),
                navigateBack = navigateBack
            )
        },
    ) { paddingValues ->
        BranchPredictionScreen(
            modifier
                .padding(paddingValues)
                .padding(16.dp)
        )
    }
}

/**
 * Displays the jump prediction screen.
 *
 * @param modifier The modifier for the layout
 */
@Composable
fun BranchPredictionScreen(modifier: Modifier = Modifier) {
    Column(modifier.verticalScroll(rememberScrollState())) {
        LocalPredictors()
        CorrelatingPredictors()
        TournamentPredictors()
        BranchTargetBuffer()
        ReturnAddressBuffer()
    }
}


@Composable
private fun LocalPredictors(modifier: Modifier = Modifier) {
    Card(modifier) {
        Column(Modifier.padding(6.dp)) {
            Text(
                text = stringResource(R.string.local_predictors),
                fontWeight = FontWeight.Bold
            )
            OneBitPredictors()
            TwoBitPredictors()
        }
    }
}

@Composable
private fun OneBitPredictors(modifier: Modifier = Modifier) {
    ListItem(
        headlineContent = { Text(stringResource(R.string.on_bit_predictors)) },
        modifier = modifier,
        supportingContent = { Text(stringResource(R.string.one_bit_predictors_description)) }
    )
}

@Composable
private fun TwoBitPredictors(modifier: Modifier = Modifier) {
    ListItem(
        headlineContent = { Text(stringResource(R.string.two_bit_predictors)) },
        modifier = modifier,
        supportingContent = { Text("In development") }
    )
}

@Composable
private fun NBitPredictors(modifier: Modifier = Modifier) {

}

@Composable
private fun CorrelatingPredictors(modifier: Modifier = Modifier) {

}

@Composable
private fun TournamentPredictors(modifier: Modifier = Modifier) {

}

@Composable
private fun BranchTargetBuffer(modifier: Modifier = Modifier) {

}

@Composable
private fun ReturnAddressBuffer(modifier: Modifier = Modifier) {

}

/**
 * Displays previews for the caching screen.
 */
@PreviewLightDark
@PreviewScreenSizes
@Composable
private fun BranchPredictionScreenPreview() {
    ComputerArchitectureTheme {
        BranchPredictionScreen(
            navigateBack = {},
        )
    }
}
