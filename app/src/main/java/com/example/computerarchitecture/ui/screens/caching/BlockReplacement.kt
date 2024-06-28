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
import com.example.computerarchitecture.ui.theme.ComputerArchitectureTheme

/**
 * Displays the block replacement screen.
 *
 * @param modifier The modifier for the layout
 * @param navigateBack The function to navigate back
 */
@Composable
fun BlockReplacementContent(modifier: Modifier = Modifier, navigateBack: () -> Unit) {
    Scaffold(
        modifier = modifier,
        topBar = {
            TopicTopBar(
                title = stringResource(R.string.block_replacement),
                navigateBack = navigateBack
            )
        },
    ) { paddingValues ->
        BlockReplacementContent(Modifier.padding(paddingValues))
    }
}

/**
 * Displays the block replacement screen.
 *
 * @param modifier The modifier for the layout
 */
@Composable
fun BlockReplacementContent(modifier: Modifier = Modifier) {
    Column(modifier) {
            DirectMapping()
            SetAssociativeMapping()
            AssociativeMapping()
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
        BlockReplacementContent(
            navigateBack = {}
        )
    }
}