package com.example.computerarchitecture.ui.screens


import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.Checkbox
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.tooling.preview.PreviewScreenSizes
import androidx.compose.ui.unit.dp
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
import com.example.computerarchitecture.ui.screens.multiprocessorsystems.MultiprocessorSystemsContent
import com.example.computerarchitecture.ui.screens.multithreading.MultithreadingContent
import com.example.computerarchitecture.ui.theme.ComputerArchitectureTheme
import com.example.computerarchitecture.ui.viewmodels.TopicsViewModel

/**
 * Displays a scrollable list of cards from which the user can navigate to other screens,
 * each of which represents a computer architecture topic.
 *
 * @param navigateTo The function to navigate to another composable function
 * @param windowWidthSizeClass The window size class of the device
 * @param topicsViewModel The view model for the topics screen
 * @param modifier The modifier for the layout
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopicsScreen(
    navigateTo: (String) -> Unit,
    windowWidthSizeClass: WindowWidthSizeClass,
    topicsViewModel: TopicsViewModel,
    modifier: Modifier = Modifier,
) {
    val isStudyMode by topicsViewModel.isStudyMode.collectAsStateWithLifecycle()
    val memorizedTopics by topicsViewModel.memorizedTopics.collectAsStateWithLifecycle()
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
                            topicsViewModel.updateStudyModePreference(checked)
                        }
                    ) {
                        Text(
                            text = stringResource(if (isStudyMode) R.string.study_mode else R.string.view_mode),
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
                    isStudyMode,
                    memorizedTopics,
                    topicsViewModel::updateMemorizedTopics,
                    Modifier
                        .padding(it)
                        .padding(start = 16.dp, end = 16.dp)
                ) { topic: Topic -> navigateTo(topic.navigationDestination.screenRoute) }
            }
            else -> {
                TopicsListAndDetail(
                    memorizedTopics,
                    topicsViewModel::updateMemorizedTopics,
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
 * @param memorizedTopics The list of topics that the user has memorized
 * @param updateMemorizedTopics The function to update the list of memorized topics
 * @param navigateTo The function to navigate to another composable function
 */
@Composable
private fun TopicsList(
    isStudyMode: Boolean,
    memorizedTopics: List<Topic>,
    updateMemorizedTopics: (List<Topic>) -> Unit,
    modifier: Modifier = Modifier,
    navigateTo: (Topic) -> Unit
) {
    Column(modifier.verticalScroll(rememberScrollState()), Arrangement.spacedBy(8.dp)) {
        Topic.entries.forEach { topic ->
            Card(
                { navigateTo(topic) }, Modifier.fillMaxWidth()
            ) {
                Row(Modifier.fillMaxWidth(), Arrangement.SpaceBetween, Alignment.CenterVertically) {
                    Text(
                        text = topic.title,
                        modifier = Modifier.padding(8.dp),
                        style = MaterialTheme.typography.titleLarge,
                    )
                    if (isStudyMode) {
                        var checked by rememberSaveable {
                            mutableStateOf(
                                memorizedTopics.contains(
                                    topic
                                )
                            )
                        }
                        Checkbox(checked = checked, onCheckedChange =
                        {
                            checked = it
                            if (it) {
                                updateMemorizedTopics(memorizedTopics + topic)
                            } else {
                                updateMemorizedTopics(memorizedTopics - topic)
                            }
                        }
                        )
                    }
                }
            }
        }
    }
}

/**
 * Displays the topics list and the detail screen for the selected topic.
 *
 * @param memorizedTopics The list of topics that the user has memorized
 * @param updateMemorizedTopics The function to update the list of memorized topics
 * @param isStudyMode Whether the user is in study mode
 * @param modifier The modifier for the layout
 */
@Composable
private fun TopicsListAndDetail(
    memorizedTopics: List<Topic>,
    updateMemorizedTopics: (List<Topic>) -> Unit,
    isStudyMode: Boolean,
    modifier: Modifier = Modifier
) {
    var selectedTopic by rememberSaveable { mutableStateOf(MULTITHREADING) }
    rememberNavController()
    Row(modifier, horizontalArrangement = Arrangement.spacedBy(16.dp)) {
        TopicsList(
            isStudyMode,
            memorizedTopics,
            updateMemorizedTopics,
            Modifier.weight(0.5f)
        ) { selectedTopic = it }
        when (selectedTopic) {
            MULTITHREADING -> MultithreadingContent(isStudyMode, Modifier.weight(1f))
            MULTIPROCESSOR_SYSTEMS -> MultiprocessorSystemsContent(isStudyMode, Modifier.weight(1f))
            GRAPHICS_PROCESSING_UNITS -> GPUsContent(isStudyMode, Modifier.weight(1f))
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
 * Displays a preview for the topics list.
 *
 */
@PreviewScreenSizes
@PreviewLightDark
@Composable
fun TopicsListPreview() {
    ComputerArchitectureTheme {
        TopicsList(isStudyMode = false, memorizedTopics = listOf(), updateMemorizedTopics = {}) {
        }
    }
}
