package com.example.computerarchitecture.ui.screens.caching

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ListItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.PreviewDynamicColors
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.tooling.preview.PreviewScreenSizes
import com.example.computerarchitecture.R
import com.example.computerarchitecture.ui.components.TopicTopBar
import com.example.computerarchitecture.ui.navigation.NavigationDestination
import com.example.computerarchitecture.ui.theme.ComputerArchitectureTheme

/**
 * Represents a navigation destination for the block placement screen.
 */
object BlockPlacementDestination : NavigationDestination {
    override val route = "Block Placement"
}

/**
 * Displays the block placement screen.
 *
 * @param modifier The modifier for the layout
 * @param navigateBack The function to navigate back
 */
@Composable
fun BlockPlacementScreen(modifier: Modifier = Modifier, navigateBack: () -> Unit) {
    Scaffold(
        modifier = modifier,
        topBar = {
            TopicTopBar(
                title = stringResource(R.string.block_placement),
                navigateBack = navigateBack
            )
        },
    ) { paddingValues ->
        Column(Modifier.padding(paddingValues)) {
            DirectMapping()
            SetAssociativeMapping()
            AssociativeMapping()
        }
    }
}

/**
 * Displays a list item for direct mapping.
 *
 * @param modifier The modifier for the layout
 */
@Composable
private fun DirectMapping(modifier: Modifier = Modifier) {
    ListItem(
        headlineContent = { Text(text = stringResource(R.string.direct_mapping)) },
        modifier = modifier,
        supportingContent = { Text(text = stringResource(R.string.direct_mapping_block_placement)) },
    )
}

/**
 * Displays a list item for set associative mapping.
 *
 * @param modifier The modifier for the layout
 */
@Composable
private fun SetAssociativeMapping(modifier: Modifier = Modifier) {
    ListItem(
        headlineContent = { Text(text = stringResource(R.string.set_associative_mapping)) },
        modifier = modifier,
        supportingContent = { Text(text = stringResource(R.string.set_associative_mapping_block_placement)) },
    )
}

/**
 * Displays a list item for associative mapping.
 *
 * @param modifier The modifier for the layout
 */
@Composable
private fun AssociativeMapping(modifier: Modifier = Modifier) {
    ListItem(
        headlineContent = { Text(text = stringResource(R.string.associative_mapping)) },
        modifier = modifier,
        supportingContent = { Text(text = stringResource(R.string.associative_mapping_block_placement)) },
    )
}

/**
 * Displays previews for the block placement screen for light and dark modes, different screen sizes and
 * dynamic colors.
 */
@PreviewLightDark
@PreviewScreenSizes
@PreviewDynamicColors
@Composable
private fun BlockPlacementScreenPreviews() {
    ComputerArchitectureTheme {
        BlockPlacementScreen(
            navigateBack = {}
        )
    }
}