package com.example.computerarchitecture.ui.screens.caching

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.PreviewDynamicColors
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.tooling.preview.PreviewScreenSizes
import androidx.compose.ui.unit.dp
import com.example.computerarchitecture.R
import com.example.computerarchitecture.ui.components.TopicTopBar
import com.example.computerarchitecture.ui.navigation.NavigationDestination
import com.example.computerarchitecture.ui.theme.ComputerArchitectureTheme

/**
 * Represents a navigation destination for the block identification screen.
 */
object BlockIdentificationDestination : NavigationDestination {
    override val route = "Block Identification"
}

/**
 * Displays the block identification screen.
 *
 * @param modifier The modifier for the layout
 * @param navigateBack The function to navigate back
 */
@Composable
fun BlockIdentificationScreen(modifier: Modifier = Modifier, navigateBack: () -> Unit) {
    Scaffold(
        modifier = modifier,
        topBar = {
            TopicTopBar(
                title = stringResource(R.string.block_identification),
                navigateBack = navigateBack
            )
        },
    ) { paddingValues ->
        Column(Modifier.padding(paddingValues)) {
            DirectMapping(Modifier.padding(16.dp))
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
    Row(
        modifier
            .fillMaxWidth()
            .border(1.dp, MaterialTheme.colorScheme.onSurface)) {
        Box(
            modifier = Modifier.weight(20f),
            contentAlignment = Alignment.Center
        ) {
            Text(text = stringResource(R.string.tag))
        }
        Box(
            modifier = Modifier
                .border(1.dp, MaterialTheme.colorScheme.onSurface)
                .weight(6f),
            contentAlignment = Alignment.Center
        ) {
            Text(text = stringResource(R.string.index))
        }
        Box(
            modifier = Modifier.weight(6f),
            contentAlignment = Alignment.Center
        ) {
            Text(text = stringResource(R.string.offset))
        }
    }
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
 * Displays previews for the block identification screen for light and dark modes, different screen sizes and
 * dynamic colors.
 */
@PreviewLightDark
@PreviewScreenSizes
@PreviewDynamicColors
@Composable
private fun BlockIdentificationScreenPreviews() {
    ComputerArchitectureTheme {
        BlockIdentificationScreen(
            navigateBack = {}
        )
    }
}