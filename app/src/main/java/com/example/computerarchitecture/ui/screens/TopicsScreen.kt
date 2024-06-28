package com.example.computerarchitecture.ui.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
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
import com.example.computerarchitecture.R
import com.example.computerarchitecture.data.topics
import com.example.computerarchitecture.ui.navigation.NavigationDestination
import com.example.computerarchitecture.ui.screens.caching.CachingScreen
import com.example.computerarchitecture.ui.theme.ComputerArchitectureTheme


/**
 * Represents a navigation destination for the topics screen.
 */
object TopicsDestination : NavigationDestination {
    override val route = "Topics"
}

/**
 * Displays a scrollable list of rows from which the user can navigate to other screens,
 * each of which represents a computer architecture topic.
 *
 * @param navigateTo The function to navigate to other screens
 * @param windowWidthSizeClass The window size class of the device
 * @param modifier The modifier for the layout
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopicsScreen(
    navigateTo: (String) -> Unit,
    windowWidthSizeClass: WindowWidthSizeClass,
    modifier: Modifier = Modifier,
) {
    Scaffold(
        modifier = modifier,
        topBar = {
            TopAppBar(
                {
                    Text(
                        text = stringResource(R.string.computer_architecture),
                        style = MaterialTheme.typography.titleLarge
                    )
                }
            )
        },
    ) {
        when (windowWidthSizeClass) {
            WindowWidthSizeClass.Compact -> {
                TopicsList(
                    Modifier
                        .padding(it)
                        .padding(16.dp),
                    navigateTo
                )
            }
            else -> {
                TopicsListAndDetail(
                    windowWidthSizeClass,
                    Modifier
                        .padding(it)
                        .padding(16.dp)
                )
            }
        }
    }
}

/**
 * Displays a scrollable list of topics that the user can click on to navigate to other screens
 *
 * @param modifier The modifier for the layout
 * @param navigateTo The function to navigate to other screens
 */
@Composable
private fun TopicsList(modifier: Modifier = Modifier, navigateTo: (String) -> Unit) {
    LazyColumn(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        items(topics) {
            Card(
                Modifier
                    .clickable { navigateTo(it) }
                    .fillParentMaxWidth()) {
                Text(
                    text = it,
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
 * @param windowWidthSizeClass The window width size class
 * @param modifier The modifier for the layout
 */
@Composable
private fun TopicsListAndDetail(
    windowWidthSizeClass: WindowWidthSizeClass,
    modifier: Modifier = Modifier
) {
    var selectedTopic by rememberSaveable { mutableStateOf(topics[0]) }

    Row(modifier) {
        TopicsList(Modifier.weight(0.5f)) { selectedTopic = it }
        TopicDetailScreen(
            selectedTopic, windowWidthSizeClass,
            Modifier
                .weight(1f)
                .padding(16.dp)
        )
    }
}

/**
 * Displays the detail screen for the given topic.
 *
 * @param topic The topic to display
 * @param windowWidthSizeClass The window width size class
 * @param modifier The modifier for the layout
 */
@Composable
fun TopicDetailScreen(
    topic: String,
    windowWidthSizeClass: WindowWidthSizeClass,
    modifier: Modifier = Modifier
) {
    when (topic) {
        "Multithreading" -> {
            MultithreadingScreen(modifier)
        }

        "Multiprocessor Systems" -> {
            // MultiprocessorSystemsScreenContent({}, modifier)
        }

        "Graphics Processing Units" -> {
            // GPUsScreenContent({}, modifier)
        }

        "OpenMP" -> {
            // OpenMPScreen({}, modifier)
        }

        "MPI" -> {
            // MPIScreen({},modifier)
        }

        "Networks" -> {
            // NetworksScreen({}, modifier)
        }

        "Energy Efficiency" -> {
            // EnergyEfficiencyScreen({}, modifier)
        }

        "Instruction Scheduling" -> {
            // InstructionSchedulingScreen({},modifier)
        }

        "Reliability" -> {
            // ReliabilityScreen({}, modifier)
        }

        "Jump Prediction" -> {
            //  JumpPredictionScreen({}, modifier)
        }

        "Superscalarity" -> {
            // SuperscalarityScreen({}, modifier)
        }

        "Memory hierarchy" -> {
            // MemoryHierarchyScreen({}, modifier)
        }

        "Flash Memory" -> {
            // FlashMemoryScreen({}, modifier)
        }

        "Caching" -> {
            CachingScreen(modifier)
        }

    }
}

/**
 * Displays previews for the topics screen for compact screens.
 */
@PreviewLightDark
@Composable
private fun TopicsScreenCompactPreview() {
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

