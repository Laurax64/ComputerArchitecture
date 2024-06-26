package com.example.computerarchitecture.ui.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.PrimaryTabRow
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Tab
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import com.example.computerarchitecture.OpenWebView
import com.example.computerarchitecture.R
import com.example.computerarchitecture.ui.components.TopicTopBar
import com.example.computerarchitecture.ui.navigation.NavigationDestination
import com.example.computerarchitecture.ui.theme.ComputerArchitectureTheme


/**
 * Represents a navigation destination for the  screen
 */
object MultithreadingDestination : NavigationDestination {
    override val route = "Multithreading"
}

/**
 * Displays the multithreading screen.
 *
 * @param navigateBack The function to navigate back
 * @param modifier The modifier for the layout
 */
@Composable
fun MultithreadingScreen(
    navigateBack: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Scaffold(
        modifier = modifier,
        topBar = {
            TopicTopBar(
                title = stringResource(R.string.multithreading),
                navigateBack = navigateBack
            )
        },
    ) {
        MultithreadingScreen(modifier.padding(it))
    }
}

/**
 * Displays the content for the multithreading screen.
 *
 * @param modifier The modifier for the layout
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MultithreadingScreen(modifier: Modifier = Modifier) {
    var state by rememberSaveable { mutableIntStateOf(0) }
    val titles = listOf(R.string.hardware_layer, R.string.software_layer)

    Column(modifier) {
        PrimaryTabRow(selectedTabIndex = state) {
            titles.forEachIndexed { index, title ->
                Tab(
                    selected = state == index,
                    onClick = { state = index },
                    text = { Text(text = stringResource(title)) })
            }
        }
        when (state) {
            0 -> HardwareLayer()
            1 -> SoftwareLayer()
        }
    }
}

/**
 * Displays the hardware layer tab, including descriptions for coarse grain
 * multithreading, fine grain multithreading, and simultaneous multithreading.
 *
 * @param modifier The modifier for the layout
 */
@Composable
fun HardwareLayer(modifier: Modifier = Modifier) {
    Column(
        modifier
            .fillMaxWidth()
            .padding(24.dp)
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.spacedBy(12.dp),
    ) {
        Text(
            text = stringResource(R.string.coarse_grained_multithreading),
            style = MaterialTheme.typography.titleLarge,
            fontWeight = FontWeight.Bold
        )
        Text(stringResource(R.string.cgmt_description))
        Text(
            text = stringResource(R.string.fine_grained_multithreading),
            style = MaterialTheme.typography.titleLarge,
            fontWeight = FontWeight.Bold
        )
        Text(stringResource(R.string.fgmt_description))
        Text(
            text = stringResource(R.string.simultanious_multithreading),
            style = MaterialTheme.typography.titleLarge,
            fontWeight = FontWeight.Bold
        )
        Text(stringResource(R.string.smt_description))
    }
}

/**
 * Displays the software layer tab, including descriptions for POSIX threads.
 */
@Composable
fun SoftwareLayer(modifier: Modifier = Modifier) {
    Column(
        modifier
            .fillMaxWidth()
            .padding(24.dp)
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.spacedBy(12.dp),
    ) {
        Text(
            text = stringResource(R.string.posix_threads),
            style = MaterialTheme.typography.titleLarge,
            fontWeight = FontWeight.Bold
        )
        PThreadIncludes()
        PThreadCreation()
    }
}

/**
 * Displays the includes section for POSIX treads in the software layer tab.
 */
@Composable
fun PThreadIncludes(modifier: Modifier = Modifier) {
    Column(modifier) {
        Text(
            text = stringResource(R.string.includes),
            style = MaterialTheme.typography.titleMedium,
            fontWeight = FontWeight.Bold
        )
        Text(stringResource(R.string.pthread_include))
    }
}

/**
 * Displays the pthread_create section for POSIX treads in the software layer tab.
 *
 * @param modifier The modifier for the layout
 */
@Composable
fun PThreadCreation(modifier: Modifier = Modifier) {
    var openWebView by rememberSaveable { mutableStateOf(false) }
    if (openWebView) {
        OpenWebView("https://hpc-tutorials.llnl.gov/posix/creating_and_terminating/#creating-threads")
    } else {
        Column(modifier) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable { openWebView = true },
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Column {
                    Text(
                        text = stringResource(R.string.thread_creation),
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.Bold
                    )
                    Text(stringResource(R.string.pthread_create))
                }
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight,
                    contentDescription = "Navigate forward"
                )
            }


        }
    }
}

/**
 * Displays previews for the multithreading screen for compact screens.
 */
@PreviewLightDark
@Composable
private fun MultithreadingScreenCompactPreview() {
    ComputerArchitectureTheme {
        MultithreadingScreen(
            navigateBack = {},
        )
    }
}

/**
 * Displays previews for the multithreading screen for medium screens.
 */
@Preview(widthDp = 800, heightDp = 800)
@Composable
private fun MultithreadingScreenMediumPreview() {
    ComputerArchitectureTheme {
        MultithreadingScreen(
            navigateBack = {},
        )
    }
}

/**
 * Displays previews for the multithreading screen for expanded screens.
 */
@Preview(widthDp = 1100, heightDp = 1100)
@Composable
private fun MultithreadingScreenExpandedPreview() {
    ComputerArchitectureTheme {
        MultithreadingScreen(
            navigateBack = {},
        )
    }
}
