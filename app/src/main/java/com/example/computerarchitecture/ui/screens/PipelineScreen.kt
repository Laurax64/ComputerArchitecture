package com.example.computerarchitecture.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
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
import com.example.computerarchitecture.ui.viewmodels.PipelineViewModel

/**
 * Displays a screen with information about the pipeline.
 *
 * @param navigateBack The function to navigate back
 * @param modifier The modifier for the layout
 */
@Composable
fun PipelineScreen(
    navigateBack: () -> Unit,
    pipelineViewModel: PipelineViewModel,
    modifier: Modifier = Modifier,
) {
    Scaffold(
        modifier = modifier,
        topBar = {
            TopicTopBar(
                title = stringResource(R.string.pipeline),
                navigateBack = navigateBack
            )
        },
    ) {
        PipelineScreen(
            isStudyMode = pipelineViewModel.isStudyMode,
            Modifier
                .padding(it)
                .padding(start = 16.dp, end = 16.dp)
        )
    }
}

/**
 * Displays a screen with information about the pipeline.
 *
 * @param isStudyMode Whether the user is in study mode
 * @param modifier The modifier for the layout
 */
@Composable
fun PipelineScreen(isStudyMode: Boolean, modifier: Modifier = Modifier) {
    Column(modifier.verticalScroll(rememberScrollState()), Arrangement.spacedBy(8.dp)) {
        DataDependencies(isStudyMode, Modifier.fillMaxWidth())
    }
}

/**
 * Displays a card with information about data dependencies.
 *
 * @param isStudyMode Whether the user is in study mode
 * @param modifier The modifier for the layout
 */
@Composable
fun DataDependencies(isStudyMode: Boolean, modifier: Modifier = Modifier) {
    var expanded by rememberSaveable { mutableStateOf(!isStudyMode) }
    Card({ expanded = !expanded }, modifier) {
        Column(Modifier.padding(8.dp), Arrangement.spacedBy(8.dp)) {
            Text(
                text = stringResource(R.string.data_dependencies),
                style = MaterialTheme.typography.titleLarge,
            )
            if (expanded) {
                RAWDependencies(Modifier.fillMaxWidth())
                WARDependencies(Modifier.fillMaxWidth())
                WAWDependencies(Modifier.fillMaxWidth())
            }
        }
    }
}

/**
 * Displays a card with information about RAW dependencies.
 *
 * @param modifier The modifier for the layout
 */
@Composable
private fun RAWDependencies(modifier: Modifier = Modifier) {
    var showExample by rememberSaveable { mutableStateOf(false) }
    Card(modifier) {
        Column(Modifier.padding(8.dp), Arrangement.spacedBy(8.dp)) {
            Text(
                text = stringResource(R.string.read_after_write),
                style = MaterialTheme.typography.titleMedium,
            )
            Text(text = stringResource(R.string.read_after_write_description))

            OutlinedCard(
                modifier = Modifier.fillMaxWidth(),
                onClick = { showExample = !showExample }
            ) {
                if (!showExample) {
                    Text(
                        text = stringResource(R.string.example),
                        color = MaterialTheme.colorScheme.primary,
                        modifier = Modifier.padding(8.dp)
                    )
                } else {
                    Text(
                        text = stringResource(R.string.data_dependencies_code),
                        style = MaterialTheme.typography.titleMedium,
                        modifier = Modifier.padding(8.dp)
                    )
                    Text(
                        text = stringResource(R.string.raw_example_description),
                        style = MaterialTheme.typography.bodyMedium,
                        modifier = Modifier.padding(8.dp)
                    )
                }
            }
        }
    }
}

/**
 * Displays a card with information about WAR dependencies.
 *
 * @param modifier The modifier for the layout
 */
@Composable
private fun WARDependencies(modifier: Modifier = Modifier) {
    var showExample by rememberSaveable { mutableStateOf(false) }
    Card(modifier) {
        Column(Modifier.padding(8.dp), Arrangement.spacedBy(8.dp)) {
            Text(
                text = stringResource(R.string.write_after_read),
                style = MaterialTheme.typography.titleMedium,
            )
            Text(text = stringResource(R.string.write_after_read_description))
            OutlinedCard(
                modifier = Modifier.fillMaxWidth(),
                onClick = { showExample = !showExample }
            ) {
                if (!showExample) {
                    Text(
                        text = stringResource(R.string.example),
                        color = MaterialTheme.colorScheme.primary,
                        modifier = Modifier.padding(8.dp)
                    )
                } else {
                    Text(
                        text = stringResource(R.string.data_dependencies_code),
                        style = MaterialTheme.typography.titleMedium,
                        modifier = Modifier.padding(8.dp)
                    )
                    Text(
                        text = stringResource(R.string.war_example_description),
                        style = MaterialTheme.typography.bodyMedium,
                        modifier = Modifier.padding(8.dp)
                    )
                }
            }
        }
    }
}

/**
 * Displays a card with information about WAW dependencies.
 *
 * @param modifier The modifier for the layout
 */
@Composable
private fun WAWDependencies(modifier: Modifier = Modifier) {
    var showExample by rememberSaveable { mutableStateOf(false) }
    Card(modifier) {
        Column(Modifier.padding(8.dp), Arrangement.spacedBy(8.dp)) {
            Text(
                text = stringResource(R.string.write_after_write),
                style = MaterialTheme.typography.titleMedium,
            )
            Text(text = stringResource(R.string.write_after_write_description))
            OutlinedCard(
                modifier = Modifier.fillMaxWidth(),
                onClick = { showExample = !showExample }
            ) {
                if (!showExample) {
                    Text(
                        text = stringResource(R.string.example),
                        color = MaterialTheme.colorScheme.primary,
                        modifier = Modifier.padding(8.dp)
                    )
                } else {
                    Text(
                        text = stringResource(R.string.data_dependencies_code),
                        style = MaterialTheme.typography.titleMedium,
                        modifier = Modifier.padding(8.dp)
                    )
                    Text(
                        text = stringResource(R.string.waw_example_description),
                        style = MaterialTheme.typography.bodyMedium,
                        modifier = Modifier.padding(8.dp)
                    )
                }
            }
        }
    }
}

/**
 * Displays previews for the pipeline screen.
 */
@PreviewLightDark
@PreviewScreenSizes
@Composable
fun PipelineScreenPreview() {
    ComputerArchitectureTheme {
        PipelineScreen(false)
    }
}