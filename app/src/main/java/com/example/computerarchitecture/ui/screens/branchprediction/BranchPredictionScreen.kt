package com.example.computerarchitecture.ui.screens.branchprediction

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.tooling.preview.PreviewScreenSizes
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import com.example.computerarchitecture.R
import com.example.computerarchitecture.ui.components.TopicTopBar
import com.example.computerarchitecture.ui.theme.ComputerArchitectureTheme
import net.engawapg.lib.zoomable.rememberZoomState
import net.engawapg.lib.zoomable.zoomable

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
                title = stringResource(R.string.branch_prediction), navigateBack = navigateBack
            )
        },
    ) { paddingValues ->
        BranchPredictionScreen(
            modifier
                .padding(paddingValues)
                .padding(start = 24.dp, end = 24.dp)
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
    Column(modifier.verticalScroll(rememberScrollState()), Arrangement.spacedBy(8.dp)) {
        LocalPredictors(Modifier.fillMaxWidth())
        CorrelatingPredictors(Modifier.fillMaxWidth())
        TournamentPredictors(Modifier.fillMaxWidth())
        BranchTargetBuffer(Modifier.fillMaxWidth())
        ReturnAddressBuffer(Modifier.fillMaxWidth())
    }
}

/**
 * Displays a card with information about local predictors.
 *
 * @param modifier The modifier for the layout
 */
@Composable
private fun LocalPredictors(modifier: Modifier = Modifier) {
    Card(modifier) {
        Column(Modifier.padding(8.dp), Arrangement.spacedBy(8.dp)) {
            Text(
                text = stringResource(R.string.local_predictors),
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.Bold
            )
            OneBitPredictors(Modifier.fillMaxWidth())
            TwoBitPredictors(Modifier.fillMaxWidth())
            NBitPredictors(Modifier.fillMaxWidth())
        }
    }
}

@Composable
private fun OneBitPredictors(modifier: Modifier = Modifier) {
    Card(modifier) {
        Column(Modifier.padding(8.dp)) {
            Text(
                text = stringResource(R.string.one_bit_predictors), fontWeight = FontWeight.Bold
            )
            Text(stringResource(R.string.one_bit_predictors_description))
        }
    }

}

/**
 * Displays a card with information about two bit predictors.
 *
 * @param modifier The modifier for the layout
 */
@Composable
private fun NBitPredictors(modifier: Modifier = Modifier) {
    Card(modifier) {
        Column(Modifier.padding(8.dp)) {
            Text(
                text = stringResource(R.string.n_bit_predictors), fontWeight = FontWeight.Bold
            )
            Text(stringResource(R.string.n_bit_predictors_description))
        }
    }
}

/**
 * Displays a card with information about correlating predictors.
 *
 * @param modifier The modifier for the layout
 */
@Composable
private fun CorrelatingPredictors(modifier: Modifier = Modifier) {
    Card(modifier) {
        Column(Modifier.padding(8.dp), Arrangement.spacedBy(8.dp)) {
            Text(
                text = stringResource(R.string.correlating_predictors),
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.Bold
            )
            Text(stringResource(R.string.correlating_predictors_description))

        }
    }
}

/**
 * Displays a card with information about tournament predictors.
 *
 * @param modifier The modifier for the layout
 */
@Composable
private fun TournamentPredictors(modifier: Modifier = Modifier) {
    Card(modifier) {
        Column(Modifier.padding(8.dp), Arrangement.spacedBy(8.dp)) {
            Text(
                text = stringResource(R.string.tournament_predictors),
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.Bold
            )
            Text(stringResource(R.string.tournament_predictors_description))
        }
    }
}

/**
 * Displays a card with information about the branch target buffer.
 *
 * @param modifier The modifier for the layout
 */
@Composable
private fun BranchTargetBuffer(modifier: Modifier = Modifier) {
    var showPipeline by rememberSaveable { mutableStateOf(false) }
    Card(modifier) {
        Column(Modifier.padding(8.dp), Arrangement.spacedBy(8.dp)) {
            Text(
                text = stringResource(R.string.branch_target_buffer),
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.Bold
            )
            Text(stringResource(R.string.branch_target_buffer_description))
            val painter = painterResource(id = R.drawable.branch_target_buffer_steps)
            val zoomState = rememberZoomState(contentSize = painter.intrinsicSize)
            OutlinedButton(onClick = { showPipeline = true }) {
                Text(stringResource(R.string.steps_in_the_pipeline))
            }
            if (showPipeline) {
                Dialog({ showPipeline = false }) {
                    Image(
                        painter = painter,
                        contentDescription = null, // TODO add content description
                        modifier = Modifier
                            .fillMaxWidth()
                            .zoomable(zoomState)
                    )
                }
            }
        }
    }
}

@Composable
private fun ReturnAddressBuffer(modifier: Modifier = Modifier) {
    Card(modifier) {
        Column(Modifier.padding(8.dp), Arrangement.spacedBy(8.dp)) {
            Text(
                text = stringResource(R.string.return_address_buffer),
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.Bold
            )
            Text(stringResource(R.string.return_address_buffer_description))
        }
    }
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
