package com.example.computerarchitecture.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.PrimaryTabRow
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Tab
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
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
 * Displays the multithreading screen
 *
 * @param navigateBack The function to navigate back
 * @param modifier The modifier for the layout
 */
@OptIn(ExperimentalMaterial3Api::class)
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
    ) { paddingValues ->
        var state by rememberSaveable { mutableIntStateOf(0) }
        val titles = listOf(R.string.hardware_layer, R.string.software_layer)

        Column(Modifier.fillMaxWidth()) {
            PrimaryTabRow(selectedTabIndex = state, modifier = Modifier.padding(paddingValues)) {
                titles.forEachIndexed { index, title ->
                    Tab(
                        selected = state == index,
                        onClick = { state = index },
                        text = { Text(text = stringResource(title)) })
                }
            }
            when (state) {
                0 -> HardwareLayerTab()
                1 -> SoftwareLayerTab()
            }
        }
    }
}

/**
 * Displays the hardware layer tab, including descriptions for coarse grain
 * multithreading, fine grain multithreading, and simultaneous multithreading.
 */
@Composable
fun HardwareLayerTab(modifier: Modifier = Modifier) {
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
 * Displays the software layer tab, including //TODO add descriptions
 */
@Composable
fun SoftwareLayerTab(modifier: Modifier = Modifier) {
    Column(
        modifier
            .fillMaxWidth()
            .padding(24.dp)
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.spacedBy(12.dp),
    ) {

    }

}

/**
 * Displays a preview for the multithreading screen in light mode
 */
@Preview
@Composable
private fun MultithreadingLightPreview() {
    ComputerArchitectureTheme {
        MultithreadingScreen(
            navigateBack = {},
        )
    }
}

/**
 * Displays a preview for the poi intent screen in dark mode
 */
@Preview
@Composable
private fun MultithreadingDarkPreview() {
    ComputerArchitectureTheme(true) {
        MultithreadingScreen(
            navigateBack = {},
        )
    }
}
