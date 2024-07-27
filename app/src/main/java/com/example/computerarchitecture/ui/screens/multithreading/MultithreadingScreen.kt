package com.example.computerarchitecture.ui.screens.multithreading

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.PrimaryTabRow
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Tab
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import com.example.computerarchitecture.R
import com.example.computerarchitecture.ui.components.TopicTopBar
import com.example.computerarchitecture.ui.theme.ComputerArchitectureTheme
import com.example.computerarchitecture.ui.viewmodels.MultithreadingViewModel

/**
 * Displays the multithreading screen.
 *
 * @param navigateBack The function to navigate back
 * param modifier The modifier for the layout
 */
@Composable
fun MultithreadingScreen(
    navigateBack: () -> Unit,
    modifier: Modifier = Modifier,
    multithreadingViewModel: MultithreadingViewModel
) {
    val isStudyMode by multithreadingViewModel.isStudyMode.collectAsState()
    Scaffold(
        modifier = modifier,
        topBar = {
            TopicTopBar(
                title = stringResource(R.string.multithreading),
                navigateBack = navigateBack
            )
        }
    ) {
        MultithreadingScreenContent(
            isStudyMode,
            Modifier
                .padding(it)
                .padding(start = 16.dp, end = 16.dp),
        )
    }
}

/**
 * Displays the content for the multithreading screen.
 *
 * @param modifier The modifier for the layout
 * @param isStudyMode Whether the user is in study mode
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MultithreadingScreenContent(
    isStudyMode: Boolean,
    modifier: Modifier = Modifier,
) {
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
            0 -> HardwareLayer(Modifier.padding(8.dp), isStudyMode)
            1 -> SoftwareLayer(Modifier.padding(8.dp), isStudyMode)
        }
    }
}

/**
 * Displays previews for the multithreading screen.
 */
@PreviewLightDark
@Composable
private fun MultithreadingScreenPreview() {
    ComputerArchitectureTheme {
        MultithreadingScreenContent(
            isStudyMode = false,
            modifier = Modifier.padding(16.dp)
        )
    }
}

