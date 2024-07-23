package com.example.computerarchitecture.ui.screens.instructionscheduling

import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.tooling.preview.PreviewScreenSizes
import androidx.compose.ui.unit.dp
import com.example.computerarchitecture.R
import com.example.computerarchitecture.ui.components.TopicTopBar
import com.example.computerarchitecture.ui.theme.ComputerArchitectureTheme

/**
 * Displays the instruction scheduling screen.
 *
 * @param navigateBack The function to navigate back
 * @param modifier The modifier for the layout
 */
@Composable
fun InstructionSchedulingScreen(
    navigateBack: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Scaffold(
        modifier = modifier,
        topBar = {
            TopicTopBar(
                title = stringResource(R.string.instruction_scheduling),
                navigateBack = navigateBack
            )
        },
    ) {
        InstructionSchedulingScreen(
            Modifier
                .padding(it)
                .padding(start = 16.dp, end = 16.dp)
        )
    }
}

/**
 * Displays the instruction scheduling screen.
 *
 * @param modifier The modifier for the layout
 */
@Composable
fun InstructionSchedulingScreen(modifier: Modifier = Modifier) {
    var state by rememberSaveable { mutableIntStateOf(0) }
    val titles = listOf(R.string.static_scheduling, R.string.dynamic_scheduling)
    Column(modifier, Arrangement.spacedBy(8.dp)) {
        TabRow(state) {
            titles.forEachIndexed { index, title ->
                Tab(
                    selected = state == index,
                    onClick = { state = index },
                    text = { Text(text = stringResource(title)) })
            }
        }
        when (state) {
            0 -> StaticScheduling(Modifier.fillMaxWidth())
            1 -> DynamicScheduling(Modifier.fillMaxWidth())
        }
    }
}

/**
 * Displays a column with information about static scheduling.
 *
 * @param modifier The modifier for the layout
 */
@Composable
private fun StaticScheduling(modifier: Modifier = Modifier) {
    Column(modifier, Arrangement.spacedBy(8.dp)) {
        StaticSchedulingParallelism(Modifier.fillMaxWidth())
        StaticSchedulingExecutionOrder(Modifier.fillMaxWidth())
    }
}

/**
 * Displays a card with information about static scheduling parallelism.
 *
 * @param modifier The modifier for the layout
 */
@Composable
private fun StaticSchedulingParallelism(modifier: Modifier = Modifier) {
    Card(modifier) {
        Column(Modifier.padding(8.dp)) {
            Text(
                text = stringResource(R.string.parallelism),
                style = MaterialTheme.typography.titleLarge
            )
            Text(stringResource(R.string.static_scheduling_parallelism_description))
        }
    }
}

/**
 * Displays a card with information about static scheduling execution order.
 *
 * @param modifier The modifier for the layout
 */
@Composable
private fun StaticSchedulingExecutionOrder(modifier: Modifier = Modifier) {
    Card(modifier) {
        Column(Modifier.padding(8.dp)) {
            Text(
                text = stringResource(R.string.execution_order),
                style = MaterialTheme.typography.titleLarge
            )
            Text(stringResource(R.string.static_scheduling_execution_order_description))
        }
    }
}

/**
 * Displays a column with information about dynamic scheduling.
 *
 * @param modifier The modifier for the layout
 */
@Composable
private fun DynamicScheduling(modifier: Modifier = Modifier) {
    Column(modifier, Arrangement.spacedBy(8.dp)) {
        DynamicSchedulingParallelism(Modifier.fillMaxWidth())
        DynamicSchedulingExecutionOrder(Modifier.fillMaxWidth())
        Scorboarding(Modifier.fillMaxWidth())
        TomasulosAlgorithm(Modifier.fillMaxWidth())
    }
}

/**
 * Displays a card with information about dynamic scheduling parallelism.
 *
 * @param modifier The modifier for the layout
 */
@Composable
private fun DynamicSchedulingParallelism(modifier: Modifier = Modifier) {
    Card(modifier) {
        Column(
            Modifier
                .padding(8.dp)
                .horizontalScroll(rememberScrollState())) {
            Text(
                text = stringResource(R.string.parallelism),
                style = MaterialTheme.typography.titleLarge,
            )
            Text(stringResource(R.string.dynamic_scheduling_parallelism_description))
        }
    }
}

@Composable
private fun DynamicSchedulingExecutionOrder(modifier: Modifier = Modifier) {
    Card(modifier) {
        Column(Modifier.padding(8.dp)) {
            Text(
                text = stringResource(R.string.execution_order),
                style = MaterialTheme.typography.titleLarge
            )
            Text(stringResource(R.string.dynamic_scheduling_execution_order_description))
        }
    }
}

/**
 * Displays a card with information about scorboarding.
 *
 * @param modifier The modifier for the layout
 */
@Composable
private fun Scorboarding(modifier: Modifier = Modifier) {
    Card(modifier) {
        Column(Modifier.padding(8.dp)) {
            Text(
                text = stringResource(R.string.scorboarding),
                style = MaterialTheme.typography.titleLarge
            )
            Text(stringResource(R.string.scorboarding_description))
        }
    }
}

/**
 * Displays a card with information about multiprocessor systems.
 *
 * @param modifier The modifier for the layout
 */
@Composable
private fun TomasulosAlgorithm(modifier: Modifier = Modifier) {
    Card(modifier) {
        Column(Modifier.padding(8.dp)) {
            Text(
                text = stringResource(R.string.tomasulos_algorithm),
                style = MaterialTheme.typography.titleLarge
            )
            Text(stringResource(R.string.tomasulo_algorithm_description))
        }
    }
}

/**
 * Displays previews for the instruction scheduling screen.
 */
@PreviewLightDark
@PreviewScreenSizes
@Composable
fun InstructionSchedulingScreenPreview() {
    ComputerArchitectureTheme {
        InstructionSchedulingScreen(navigateBack = {})
    }
}