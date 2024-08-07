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
import androidx.compose.runtime.mutableStateOf
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
import com.example.computerarchitecture.ui.viewmodels.InstructionSchedulingViewModel

/**
 * Displays the instruction scheduling screen.
 *
 * @param navigateBack The function to navigate back
 * @param instructionSchedulingViewModel The view model for the instruction scheduling screen
 * @param modifier The modifier for the layout
 */
@Composable
fun InstructionSchedulingScreen(
    navigateBack: () -> Unit,
    instructionSchedulingViewModel: InstructionSchedulingViewModel,
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
        InstructionSchedulingContent(
            isStudyMode = instructionSchedulingViewModel.isStudyMode,
            modifier = Modifier
                .padding(it)
                .padding(start = 16.dp, end = 16.dp)
        )
    }
}

/**
 * Displays the instruction scheduling screen content.
 *
 * @param isStudyMode Whether the user is in study mode
 * @param modifier The modifier for the layout
 */
@Composable
fun InstructionSchedulingContent(isStudyMode: Boolean, modifier: Modifier = Modifier) {
    var state by rememberSaveable { mutableIntStateOf(0) }
    val titles = listOf(R.string.static_scheduling, R.string.dynamic_scheduling)
    Column(modifier, Arrangement.spacedBy(8.dp)) {
        TabRow(selectedTabIndex = state) {
            titles.forEachIndexed { index, title ->
                Tab(
                    selected = state == index,
                    onClick = { state = index },
                    text = { Text(text = stringResource(title)) }
                )
            }
        }
        when (state) {
            0 -> StaticScheduling(isStudyMode, Modifier.fillMaxWidth())
            1 -> DynamicScheduling(isStudyMode, Modifier.fillMaxWidth())
        }
    }
}

/**
 * Displays a column with information about static scheduling.
 *
 * @param isStudyMode Whether the user is in study mode
 * @param modifier The modifier for the layout
 */
@Composable
private fun StaticScheduling(isStudyMode: Boolean, modifier: Modifier = Modifier) {
    Column(modifier, Arrangement.spacedBy(8.dp)) {
        StaticSchedulingParallelism(isStudyMode, Modifier.fillMaxWidth())
        StaticSchedulingExecutionOrder(isStudyMode, Modifier.fillMaxWidth())
    }
}

/**
 * Displays a card with information about static scheduling parallelism.
 *
 * @param isStudyMode Whether the user is in study mode
 * @param modifier The modifier for the layout
 */
@Composable
private fun StaticSchedulingParallelism(isStudyMode: Boolean, modifier: Modifier = Modifier) {
    var expanded by rememberSaveable { mutableStateOf(!isStudyMode) }
    Card({ expanded = !expanded }, modifier = modifier) {
        Column(Modifier.padding(8.dp)) {
            Text(
                text = stringResource(R.string.parallelism),
                style = MaterialTheme.typography.titleLarge
            )
            if (expanded) {
                Text(stringResource(R.string.static_scheduling_parallelism_description))
            }
        }
    }
}

/**
 * Displays a card with information about static scheduling execution order.
 *
 * @param isStudyMode Whether the user is in study mode
 * @param modifier The modifier for the layout
 */
@Composable
private fun StaticSchedulingExecutionOrder(isStudyMode: Boolean, modifier: Modifier = Modifier) {
    var expanded by rememberSaveable { mutableStateOf(!isStudyMode) }
    Card({ expanded = !expanded }, modifier = modifier) {
        Column(Modifier.padding(8.dp)) {
            Text(
                text = stringResource(R.string.execution_order),
                style = MaterialTheme.typography.titleLarge
            )
            if (expanded) {
                Text(stringResource(R.string.static_scheduling_execution_order_description))
            }
        }
    }
}

/**
 * Displays a column with information about dynamic scheduling.
 *
 * @param isStudyMode Whether the user is in study mode
 * @param modifier The modifier for the layout
 */
@Composable
private fun DynamicScheduling(isStudyMode: Boolean, modifier: Modifier = Modifier) {
    Column(modifier, Arrangement.spacedBy(8.dp)) {
        DynamicSchedulingParallelism(isStudyMode, Modifier.fillMaxWidth())
        DynamicSchedulingExecutionOrder(isStudyMode, Modifier.fillMaxWidth())
        Scorboarding(isStudyMode, Modifier.fillMaxWidth())
        TomasulosAlgorithm(isStudyMode, Modifier.fillMaxWidth())
    }
}

/**
 * Displays a card with information about dynamic scheduling parallelism.
 *
 * @param isStudyMode Whether the user is in study mode
 * @param modifier The modifier for the layout
 */
@Composable
private fun DynamicSchedulingParallelism(isStudyMode: Boolean, modifier: Modifier = Modifier) {
    var expanded by rememberSaveable { mutableStateOf(!isStudyMode) }
    Card({ expanded = !expanded }, modifier = modifier) {
        Column(
            Modifier
                .padding(8.dp)
                .horizontalScroll(rememberScrollState())
        ) {
            Text(
                text = stringResource(R.string.parallelism),
                style = MaterialTheme.typography.titleLarge
            )
            if (expanded) {
                Text(stringResource(R.string.dynamic_scheduling_parallelism_description))
            }
        }
    }
}

/**
 * Displays a card with information about dynamic scheduling execution order.
 *
 * @param isStudyMode Whether the user is in study mode
 * @param modifier The modifier for the layout
 */
@Composable
private fun DynamicSchedulingExecutionOrder(isStudyMode: Boolean, modifier: Modifier = Modifier) {
    var expanded by rememberSaveable { mutableStateOf(!isStudyMode) }
    Card({ expanded = !expanded }, modifier = modifier) {
        Column(Modifier.padding(8.dp)) {
            Text(
                text = stringResource(R.string.execution_order),
                style = MaterialTheme.typography.titleLarge
            )
            if (expanded) {
                Text(stringResource(R.string.dynamic_scheduling_execution_order_description))
            }
        }
    }
}

/**
 * Displays a card with information about scorboarding.
 *
 * @param isStudyMode Whether the user is in study mode
 * @param modifier The modifier for the layout
 */
@Composable
private fun Scorboarding(isStudyMode: Boolean, modifier: Modifier = Modifier) {
    var expanded by rememberSaveable { mutableStateOf(!isStudyMode) }
    Card({ expanded = !expanded }, modifier = modifier) {
        Column(Modifier.padding(8.dp)) {
            Text(
                text = stringResource(R.string.scorboarding),
                style = MaterialTheme.typography.titleLarge
            )
            if (expanded) {
                Text(stringResource(R.string.scorboarding_description))
            }
        }
    }
}

/**
 * Displays a card with information about Tomasulo's algorithm.
 *
 * @param isStudyMode Whether the user is in study mode
 * @param modifier The modifier for the layout
 */
@Composable
private fun TomasulosAlgorithm(isStudyMode: Boolean, modifier: Modifier = Modifier) {
    var expanded by rememberSaveable { mutableStateOf(!isStudyMode) }
    Card({ expanded = !expanded }, modifier) {
        Column(Modifier.padding(8.dp)) {
            Text(
                text = stringResource(R.string.tomasulos_algorithm),
                style = MaterialTheme.typography.titleLarge
            )
            if (expanded) {
                Text(stringResource(R.string.tomasulo_algorithm_description))
            }
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
        InstructionSchedulingContent(isStudyMode = false)
    }
}
