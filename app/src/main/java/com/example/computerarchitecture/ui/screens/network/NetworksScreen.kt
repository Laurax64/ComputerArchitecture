package com.example.computerarchitecture.ui.screens.network

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.ScrollableTabRow
import androidx.compose.material3.Tab
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
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
import com.example.computerarchitecture.ui.viewmodels.NetworksViewModel

/**
 * Displays the networks screen.
 *
 * @param navigateBack The function to navigate back
 * @param networksViewModel The view model for the networks screen
 * @param modifier The modifier for the layout
 */
@Composable
fun NetworksScreen(
    navigateBack: () -> Unit,
    networksViewModel: NetworksViewModel,
    modifier: Modifier = Modifier,
) {
    Scaffold(
        modifier = modifier,
        topBar = {
            TopicTopBar(
                title = stringResource(R.string.networks),
                navigateBack = navigateBack
            )
        },
    ) {
        NetworksScreen(
            networksViewModel.isStudyMode,
            Modifier
                .padding(it)
                .padding(start = 16.dp, end = 16.dp)
        )
    }
}

/**
 * Displays the flash memory screen.
 *
 * @param isStudyMode Whether the user is in study mode
 * @param modifier The modifier for the layout
 */
@Composable
fun NetworksScreen(isStudyMode: Boolean, modifier: Modifier = Modifier) {
    val titles = listOf(R.string.topologies, R.string.switches, R.string.routing)
    var selectedTabIndex by rememberSaveable { mutableIntStateOf(0) }
    Column(modifier) {
        ScrollableTabRow(selectedTabIndex) {
            titles.forEachIndexed { index, title ->
                Tab(
                    text = { Text(stringResource(title)) },
                    selected = index == selectedTabIndex,
                    onClick = { selectedTabIndex = index }
                )
            }
        }
        when (selectedTabIndex) {
            0 -> Topologies(isStudyMode, Modifier.padding(8.dp))
            1 -> Switches(isStudyMode, Modifier.padding(8.dp))
            2 -> Routing(isStudyMode, Modifier.padding(8.dp))
        }
    }
}

/**
 * Displays previews for the networks screen.
 */
@PreviewLightDark
@PreviewScreenSizes
@Composable
fun NetworksScreenPreview() {
    ComputerArchitectureTheme {
        NetworksScreen(false)
    }
}