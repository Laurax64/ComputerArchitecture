package com.example.computerarchitecture.ui.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.compose.rememberNavController
import com.example.computerarchitecture.R
import com.example.computerarchitecture.data.Topic
import com.example.computerarchitecture.data.Topic.BRANCH_PREDICTION
import com.example.computerarchitecture.data.Topic.CACHING
import com.example.computerarchitecture.data.Topic.ENERGY_EFFICIENCY
import com.example.computerarchitecture.data.Topic.GRAPHICS_PROCESSING_UNITS
import com.example.computerarchitecture.data.Topic.INSTRUCTION_SCHEDULING
import com.example.computerarchitecture.data.Topic.MEMORY_HIERARCHY
import com.example.computerarchitecture.data.Topic.MPI
import com.example.computerarchitecture.data.Topic.MULTIPROCESSOR_SYSTEMS
import com.example.computerarchitecture.data.Topic.MULTITHREADING
import com.example.computerarchitecture.data.Topic.NETWORKS
import com.example.computerarchitecture.data.Topic.OPENMP
import com.example.computerarchitecture.data.Topic.PIPELINE
import com.example.computerarchitecture.data.Topic.SPECTRE
import com.example.computerarchitecture.ui.screens.multithreading.MultithreadingScreenContent
import com.example.computerarchitecture.ui.theme.ComputerArchitectureTheme
import com.example.computerarchitecture.ui.viewmodels.TopicsViewModel

/**
 * Displays a scrollable list of cards from which the user can navigate to other screens,
 * each of which represents a computer architecture topic.
 *
 * @param navigateTo The function to navigate to another composable function
 * @param windowWidthSizeClass The window size class of the device
 * @param modifier The modifier for the layout
 * @param topicsViewModel The view model for the topics screen
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopicsScreen(
    navigateTo: (String) -> Unit,
    windowWidthSizeClass: WindowWidthSizeClass,
    modifier: Modifier = Modifier,
    topicsViewModel: TopicsViewModel = hiltViewModel<TopicsViewModel>()
) {
    val isStudyMode by topicsViewModel.isStudyMode.collectAsStateWithLifecycle()
    var checked by rememberSaveable { mutableStateOf(isStudyMode) }
    Scaffold(
        modifier = modifier,
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        stringResource(R.string.computer_architecture),
                        style = MaterialTheme.typography.titleLarge
                    )
                },
                actions = {
                    TextButton(
                        onClick = {
                            checked = !isStudyMode
                            topicsViewModel.saveStudyModePreference(checked)
                        }
                    ) {
                        Text(
                            text = stringResource(if (isStudyMode) R.string.study_mode else R.string.normal_mode),
                            style = MaterialTheme.typography.labelSmall,
                            modifier = Modifier.padding(end = 8.dp)
                        )

                    }
                })
        }

    ) {
        when (windowWidthSizeClass) {
            WindowWidthSizeClass.Compact -> {
                TopicsList(
                    Modifier
                        .padding(it)
                        .padding(start = 16.dp, end = 16.dp)
                ) { topic: Topic -> navigateTo(topic.navigationDestination.screenRoute) }
            }
            else -> {
                TopicsListAndDetail(
                    isStudyMode,
                    Modifier
                        .padding(it)
                        .padding(start = 16.dp, end = 16.dp)
                )
            }
        }
    }
}

/**
 * Displays a scrollable list of topics that the user can click on to navigate to other screens
 *
 * @param modifier The modifier for the layout
 * @param navigateTo The function to navigate to another composable function
 */
@Composable
private fun TopicsList(
    modifier: Modifier = Modifier,
    navigateTo: (Topic) -> Unit
) {
    Column(
        modifier = modifier.verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Topic.entries.forEach {
            Card(
                Modifier
                    .clickable { navigateTo(it) }
                    .fillMaxWidth()
            ) {
                Text(
                    text = it.title,
                    modifier = Modifier.padding(16.dp),
                    style = MaterialTheme.typography.titleMedium,
                )
            }
        }
    }
}

/**
 * Displays the topics list and the detail screen for the selected topic.
 *
 * @param isStudyMode Whether the user is in study mode
 * @param modifier The modifier for the layout
 */
@Composable
private fun TopicsListAndDetail(
    isStudyMode: Boolean,
    modifier: Modifier = Modifier
) {
    var selectedTopic by rememberSaveable { mutableStateOf(MULTITHREADING) }
    val navController = rememberNavController()
    Row(modifier, horizontalArrangement = Arrangement.spacedBy(16.dp)) {
        TopicsList(Modifier.weight(0.5f)) { selectedTopic = it }
        when (selectedTopic) {
            MULTITHREADING -> MultithreadingScreenContent(isStudyMode, Modifier.weight(1f))
            MULTIPROCESSOR_SYSTEMS -> TODO()
            GRAPHICS_PROCESSING_UNITS -> TODO()
            OPENMP -> TODO()
            MPI -> TODO()
            NETWORKS -> TODO()
            ENERGY_EFFICIENCY -> TODO()
            INSTRUCTION_SCHEDULING -> TODO()
            BRANCH_PREDICTION -> TODO()
            MEMORY_HIERARCHY -> TODO()
            CACHING -> TODO()
            SPECTRE -> TODO()
            PIPELINE -> TODO()
        }
    }
}

/**
 * Displays previews for the topics screen for compact screens.
 */
@PreviewLightDark
@Composable
private fun TopicsScreenPreview() {
    ComputerArchitectureTheme {
        TopicsScreen(
            navigateTo = {},
            windowWidthSizeClass = WindowWidthSizeClass.Compact
        )
    }
}

/**
 * Displays previews for the topics screen for medium screens.
 */
@Preview(widthDp = 800, heightDp = 800)
@Composable
private fun TopicsScreenMediumPreview() {
    ComputerArchitectureTheme {
        TopicsScreen(
            navigateTo = {},
            windowWidthSizeClass = WindowWidthSizeClass.Medium
        )
    }
}

/**
 * Displays previews for the topics screen for expanded screens.
 */
@Preview(widthDp = 1100, heightDp = 1100)
@Composable
private fun TopicsScreenExpandedPreview() {
    ComputerArchitectureTheme {
        TopicsScreen(
            navigateTo = {},
            windowWidthSizeClass = WindowWidthSizeClass.Expanded
        )
    }
}
