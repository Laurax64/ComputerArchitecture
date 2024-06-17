package com.example.computerarchitecture.ui.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp
import com.example.computerarchitecture.MainActivity
import com.example.computerarchitecture.R
import com.example.computerarchitecture.data.topics
import com.example.computerarchitecture.ui.navigation.NavigationDestination
import com.example.computerarchitecture.ui.theme.ComputerArchitectureTheme


/**
 * Represents a navigation destination for the topics screen.
 */
object TopicsDestination : NavigationDestination {
    override val route = "topics"
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
                    modifier = modifier.padding(it),
                    onUnitClick = navigateToTopic
                )
            }

            else -> {
                TopicsListAndDetail(modifier = modifier.padding(it))
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
    LazyColumn(modifier.fillMaxWidth()) {
        items(topics) {
            Row(
                Modifier
                    .fillMaxWidth()
                    .clickable { onUnitClick(it) }
                    .padding(24.dp),
                Arrangement.SpaceBetween
            ) {
                Text(
                    text = it,
                    style = MaterialTheme.typography.titleLarge,
                    fontWeight = FontWeight.Bold
                )
                Icon(Icons.AutoMirrored.Filled.KeyboardArrowRight, contentDescription = null) 
            }
        }
    }
}

@Composable
private fun TopicsListAndDetail(modifier: Modifier) {
    var selectedTopic by rememberSaveable { mutableStateOf(topics[0]) }

    Row(modifier.fillMaxWidth()) {
        TopicsList(
            modifier = modifier.weight(1f),
            onUnitClick = { selectedTopic = it }
        )
        TopicDetailScreen(topic = selectedTopic, modifier = modifier.weight(1f))
    }
}

@Composable
fun TopicDetailScreen(topic: String, modifier: Modifier = Modifier) {
    when (topic) {
        "Multithreading" -> {
            MultithreadingScreenContent(modifier)
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
            // CachingScreen({}, modifier)
        }

    }
}

/**
 * Displays a preview for the topics screen in light mode for compact screens
 */
@OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
@Preview
@Composable
private fun TopicsScreenCompactPreviewLight() {
    ComputerArchitectureTheme {
        TopicsScreen(
            navigateToTopic = {},
            windowSizeClass = WindowSizeClass.calculateFromSize(DpSize(400.dp, 400.dp))
        )
    }
}

/**
 * Displays a preview for the topics screen in dark mode for compact screens
 */
@OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
@Preview
@Composable
private fun TopicsScreenCompactPreviewDark() {
    ComputerArchitectureTheme(darkTheme = true) {
        TopicsScreen(
            navigateToTopic = {},
            windowSizeClass = WindowSizeClass.calculateFromSize(DpSize(400.dp, 400.dp))
        )
    }
}

/**
 * Displays a preview for the topics screen in light mode for medium screens
 */
@OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
@Preview(showBackground = true, widthDp = 700)
@Composable
private fun TopicsScreenMediumPreviewLight() {
    ComputerArchitectureTheme {
        TopicsScreen(
            navigateToTopic = {},
            windowSizeClass = WindowSizeClass.calculateFromSize(DpSize(700.dp, 700.dp))
        )
    }
}

/**
 * Displays a preview for the topics screen in dark mode for expanded screens
 */
@OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
@Preview(showBackground = true, widthDp = 1000)
@Composable
private fun TopicsScreenMediumPreviewDark() {
    ComputerArchitectureTheme(darkTheme = true) {
        TopicsScreen(
            navigateToTopic = {},
            windowSizeClass = WindowSizeClass.calculateFromSize(DpSize(1000.dp, 1000.dp))
        )
    }
}

