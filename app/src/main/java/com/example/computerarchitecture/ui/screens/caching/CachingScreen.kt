package com.example.computerarchitecture.ui.screens.caching

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.tooling.preview.PreviewScreenSizes
import androidx.compose.ui.unit.dp
import com.example.computerarchitecture.R
import com.example.computerarchitecture.ui.components.TopicTopBar
import com.example.computerarchitecture.ui.navigation.NavigationDestination
import com.example.computerarchitecture.ui.theme.ComputerArchitectureTheme

/**
 * Represents a navigation destination for the caching screen.
 */
object CachingDestination : NavigationDestination {
    override val route = "Caching"
}

/**
 * Displays the caching screen.
 *
 * @param navigateBack The function to navigate back
 * @param navigateTo The function to navigate to another screen
 * @param modifier The modifier for the layout
 */
@Composable
fun CachingScreen(
    navigateBack: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Scaffold(
        modifier = modifier,
        topBar = {
            TopicTopBar(
                title = stringResource(R.string.caching),
                navigateBack = navigateBack
            )
        },
    ) { paddingValues ->
        Column(
            Modifier
                .padding(paddingValues)
                .padding(16.dp), Arrangement.spacedBy(16.dp)
        ) {
            AverageRuntimes(Modifier.fillMaxWidth())
            BlockPlacement(Modifier.fillMaxWidth())
            BlockIdentification(Modifier.fillMaxWidth())
            BlockReplacement(Modifier.fillMaxWidth())
            WriteStrategy(Modifier.fillMaxWidth())
        }
    }
}

/**
 * Displays the caching screen.
 *
 * @param navigateTo The function to navigate to a new screen
 * @param modifier The modifier for the layout
 */
@Composable
fun CachingScreen(
    modifier: Modifier = Modifier,
) {
    Column(modifier.verticalScroll(rememberScrollState()), Arrangement.spacedBy(16.dp)) {
        AverageRuntimes(Modifier.fillMaxWidth())
        BlockPlacement(Modifier.fillMaxWidth())
        BlockIdentification(Modifier.fillMaxWidth())
        BlockReplacement(Modifier.fillMaxWidth())
        WriteStrategy(Modifier.fillMaxWidth())
    }

}


/**
 * Displays a list item for the average runtimes.
 *
 * @param modifier The modifier for the layout
 */
@Composable
private fun AverageRuntimes(modifier: Modifier = Modifier) {
    Card(modifier) {
        Text(
            text = stringResource(id = R.string.average_runtimes),
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(16.dp)
        )
        AverageRuntimesContent()
    }
}

/**
 * Displays a list item for the block placement.
 *
 * @param modifier The modifier for the layout
 */
@Composable
private fun BlockPlacement(modifier: Modifier = Modifier) {
    Card(modifier) {
        Column(Modifier.padding(16.dp)) {
            Text(
                text = stringResource(R.string.block_placement),
                fontWeight = FontWeight.Bold
            )
            Text(text = stringResource(R.string.block_placement_question))
            BlockPlacementContent()
        }

    }
}

/**
 * Displays a list item for the block identification.
 *
 * @param modifier The modifier for the layout
 * @param navigateTo The function to navigate to a new screen
 */
@Composable
private fun BlockIdentification(modifier: Modifier = Modifier) {
    Card(modifier) {
        Column(Modifier.padding(16.dp)) {
            Text(
                text = stringResource(R.string.block_identification),
                fontWeight = FontWeight.Bold
            )
            Text(text = stringResource(R.string.block_identification_question))
            BlockIdentificationContent(Modifier.fillMaxWidth())
        }

    }
}

/**
 * Displays a list item for the block replacement.
 *
 * @param modifier The modifier for the layout
 */
@Composable
private fun BlockReplacement(modifier: Modifier = Modifier) {
    Card(modifier) {
        Column(Modifier.padding(16.dp)) {
            Text(
                text = stringResource(R.string.block_replacement),
                fontWeight = FontWeight.Bold
            )
            Text(text = stringResource(R.string.block_replacement_question))
            BlockReplacementContent(Modifier.fillMaxWidth())
        }
    }
}

/**
 * Displays a list item for the write strategy.
 *
 * @param modifier The modifier for the layout
 */
@Composable
private fun WriteStrategy(modifier: Modifier = Modifier) {
    Card(modifier) {
        Column(Modifier.padding(16.dp)) {
            Text(
                text = stringResource(R.string.write_strategy),
                fontWeight = FontWeight.Bold
            )
            Text(text = stringResource(R.string.write_strategy_question))
            WriteStrategyContent(Modifier.fillMaxWidth())
        }
    }
}

/**
 * Displays previews for the caching screen.
 */
@PreviewLightDark
@PreviewScreenSizes
@Composable
private fun CachingScreenPreview() {
    ComputerArchitectureTheme {
        CachingScreen(
            navigateBack = {},
        )
    }
}