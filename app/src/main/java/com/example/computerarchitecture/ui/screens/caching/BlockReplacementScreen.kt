package com.example.computerarchitecture.ui.screens.caching

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
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
 * Represents a navigation destination for the block replacement screen.
 */
object BlockReplacementDestination : NavigationDestination {
    override val route = "Block Replacement"
}

@Composable
fun BlockReplacementScreen(modifier: Modifier = Modifier, navigateBack: () -> Unit) {
    Scaffold(
        modifier = modifier,
        topBar = {
            TopicTopBar(
                title = stringResource(R.string.block_replacement),
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

}

/**
 * Displays a list item for set associative mapping.
 *
 * @param modifier The modifier for the layout
 */
@Composable
private fun SetAssociativeMapping(modifier: Modifier = Modifier) {
}

/**
 * Displays a list item for associative mapping.
 *
 * @param modifier The modifier for the layout
 */
@Composable
private fun AssociativeMapping(modifier: Modifier = Modifier) {
}

/**
 * Displays previews for the block replacement screen for light and dark modes, different screen sizes and
 * dynamic colors.
 */
@PreviewLightDark
@PreviewScreenSizes
@PreviewDynamicColors
@Composable
private fun BlockReplacementScreenPreviews() {
    ComputerArchitectureTheme {
        BlockReplacementScreen(
            navigateBack = {}
        )
    }
}