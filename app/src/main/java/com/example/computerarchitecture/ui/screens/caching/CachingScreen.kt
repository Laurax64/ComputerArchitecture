package com.example.computerarchitecture.ui.screens.caching

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material3.ListItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.PreviewDynamicColors
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.tooling.preview.PreviewScreenSizes
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
 * @param modifier The modifier for the layout
 */
@Composable
fun CachingScreen(
    navigateBack: () -> Unit,
    navigateTo: (String) -> Unit,
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
        Column(Modifier.padding(paddingValues)) {
            AverageRuntimes(Modifier.fillMaxWidth(), navigateTo)
            BlockPlacement(Modifier.fillMaxWidth(), navigateTo)
            BlockIdentification(Modifier.fillMaxWidth(), navigateTo)
            BlockReplacement(Modifier.fillMaxWidth(), navigateTo)
            WriteStrategy(Modifier.fillMaxWidth(), navigateTo)
        }
    }
}

/**
 * Displays a list item for the average runtimes.
 *
 * @param modifier The modifier for the layout
 * @param navigateTo The function to navigate to a new screen
 */
@Composable
private fun AverageRuntimes(modifier: Modifier = Modifier, navigateTo: (String) -> Unit) {
    ListItem(
        headlineContent = {
            Text(
                text = stringResource(id = R.string.average_runtimes),
                fontWeight = FontWeight.Bold
            )
        },
        modifier = modifier.clickable { navigateTo(AverageRuntimesDestination.route) },
        trailingContent = {
            Image(
                imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight,
                contentDescription =
                stringResource(R.string.navigate_to) + stringResource(R.string.average_runtimes)
            )
        }
    )
}

/**
 * Displays a list item for the block placement.
 *
 * @param modifier The modifier for the layout
 * @param navigateTo The function to navigate to a new screen
 */
@Composable
private fun BlockPlacement(modifier: Modifier = Modifier, navigateTo: (String) -> Unit) {
    ListItem(
        headlineContent = {
            Text(
                text = stringResource(R.string.block_placement),
                fontWeight = FontWeight.Bold
            )
        },
        modifier = modifier.clickable { navigateTo(BlockPlacementDestination.route) },
        supportingContent =
        {
            Text(stringResource(R.string.block_placement_question))
        },
        trailingContent = {
            Image(
                imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight,
                contentDescription =
                stringResource(R.string.navigate_to) + stringResource(R.string.block_placement_question)
            )
        }
    )
}

/**
 * Displays a list item for the block identification.
 *
 * @param modifier The modifier for the layout
 * @param navigateTo The function to navigate to a new screen
 */
@Composable
private fun BlockIdentification(modifier: Modifier = Modifier, navigateTo: (String) -> Unit) {
    ListItem(headlineContent = {
        Text(
            text = stringResource(R.string.block_identification),
            fontWeight = FontWeight.Bold
        )
    },
        modifier = modifier.clickable { navigateTo(BlockIdentificationDestination.route) },
        supportingContent =
        {
            Text(stringResource(R.string.block_identification_question))
        },
        trailingContent = {
            Image(
                imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight,
                contentDescription =
                stringResource(R.string.navigate_to) + stringResource(R.string.block_placement)
            )
        }
    )
}

/**
 * Displays a list item for the block replacement.
 *
 * @param modifier The modifier for the layout
 * @param navigateTo The function to navigate to a new screen
 */
@Composable
private fun BlockReplacement(modifier: Modifier = Modifier, navigateTo: (String) -> Unit) {
    ListItem(headlineContent = {
        Text(
            text = stringResource(R.string.block_replacement),
            fontWeight = FontWeight.Bold
        )
    },
        modifier = modifier.clickable { navigateTo(BlockReplacementDestination.route) },
        supportingContent =
        {
            Text(stringResource(R.string.block_replacement_question))
        },
        trailingContent = {
            Image(
                imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight,
                contentDescription =
                stringResource(R.string.navigate_to) + stringResource(R.string.block_replacement)
            )
        }
    )
}

/**
 * Displays a list item for the write strategy.
 *
 * @param modifier The modifier for the layout
 * @param navigateTo The function to navigate to a new screen
 */
@Composable
private fun WriteStrategy(modifier: Modifier = Modifier, navigateTo: (String) -> Unit) {
    ListItem(headlineContent = {
        Text(
            text = stringResource(R.string.write_strategy),
            fontWeight = FontWeight.Bold
        )
    },
        modifier = modifier.clickable { navigateTo(WriteStrategyDestination.route) },
        supportingContent =
        {
            Text(stringResource(R.string.write_strategy_question))
        },
        trailingContent = {
            Image(
                imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight,
                contentDescription =
                stringResource(R.string.navigate_to) + stringResource(R.string.block_replacement)
            )
        }
    )
}

/**
 * Displays previews for the caching screen for light and dark modes, different screen sizes and
 * dynamic colors.
 */
@PreviewLightDark
@PreviewScreenSizes
@PreviewDynamicColors
@Composable
private fun CachingScreenPreviews() {
    ComputerArchitectureTheme {
        CachingScreen(
            navigateBack = {},
            navigateTo = {},
        )
    }
}
