package com.example.computerarchitecture.ui.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.WindowSizeClass
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.PreviewDynamicColors
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.tooling.preview.PreviewScreenSizes
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp
import com.example.computerarchitecture.MainActivity
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
 * @param modifier The modifier for the layout
 * @param navigateToTopic The function to navigate to other screens
 * @param windowSizeClass The window size class of the device
 */
@OptIn(ExperimentalMaterial3Api::class, ExperimentalMaterial3WindowSizeClassApi::class)
@Composable
fun TopicsScreen(
    navigateToTopic: (String) -> Unit,
    modifier: Modifier = Modifier,
    windowSizeClass: WindowSizeClass = calculateWindowSizeClass(LocalContext.current as MainActivity),
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
        when (windowSizeClass.widthSizeClass) {
            WindowWidthSizeClass.Compact -> {
                TopicsList(
                    modifier = modifier
                        .padding(it)
                        .padding(16.dp),
                    onUnitClick = navigateToTopic
                )
            }
            else -> {
                TopicsListAndDetail(
                    modifier = modifier
                        .padding(it)
                        .padding(16.dp),
                    navigateTo = navigateToTopic
                )
            }
        }
    }
}

/**
 * Displays a scrollable list of topics that the user can click on to navigate to other screens
 *
 * @param modifier The modifier for the layout
 * @param onUnitClick The function to call when an intent is clicked
 */
@Composable
private fun TopicsList(modifier: Modifier = Modifier, onUnitClick: (String) -> Unit) {
    LazyColumn(
        modifier = modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        items(topics) {
            Card(
                Modifier
                    .clickable { onUnitClick(it) }
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
 * @param navigateTo The function to navigate to another screen
 * @param modifier The modifier for the layout
 */
@Composable
private fun TopicsListAndDetail(
    navigateTo: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    var selectedTopic by rememberSaveable { mutableStateOf(topics[0]) }

    Row(modifier.fillMaxWidth()) {
        TopicsList(
            modifier = Modifier.weight(1f),
            onUnitClick = { selectedTopic = it }
        )
        TopicDetailScreen(
            topic = selectedTopic,
            navigateTo = navigateTo,
            modifier = Modifier.weight(1f)
        )
    }
}

/**
 * Displays the detail screen for the given topic.
 *
 * @param topic The topic to display
 * @param navigateTo The function to navigate to another screen
 * @param modifier The modifier for the layout
 */
@Composable
fun TopicDetailScreen(
    topic: String,
    navigateTo: (String) -> Unit,
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
            CachingScreen({}, navigateTo, modifier)
        }

    }
}

/**
 * Displays previews for the topics screen for light and dark modes, different screen sizes and
 * dynamic colors.
 */
@OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
@PreviewLightDark
@PreviewScreenSizes
@PreviewDynamicColors
@Composable
private fun TopicsScreenPreview() {
    ComputerArchitectureTheme {
        TopicsScreen(
            navigateToTopic = {},
            windowSizeClass = WindowSizeClass.calculateFromSize(DpSize(400.dp, 400.dp))
        )
    }
}

