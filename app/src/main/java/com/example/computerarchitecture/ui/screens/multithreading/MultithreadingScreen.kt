package com.example.computerarchitecture.ui.screens.multithreading

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.PrimaryTabRow
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Tab
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewLightDark
import com.example.computerarchitecture.R
import com.example.computerarchitecture.ui.components.TopicTopBar
import com.example.computerarchitecture.ui.theme.ComputerArchitectureTheme

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
