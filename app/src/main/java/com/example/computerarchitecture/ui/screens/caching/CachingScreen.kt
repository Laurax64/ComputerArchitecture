package com.example.computerarchitecture.ui.screens.caching

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
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
                .padding(16.dp)
                .verticalScroll(rememberScrollState()),
            Arrangement.spacedBy(16.dp)
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
 * @param modifier The modifier for the layout
 */
@Composable
fun CachingScreen(modifier: Modifier = Modifier) {
    Column(modifier.verticalScroll(rememberScrollState()), Arrangement.spacedBy(16.dp)) {
        AverageRuntimes(Modifier.fillMaxWidth())
        BlockPlacement(Modifier.fillMaxWidth())
        BlockIdentification(Modifier.fillMaxWidth())
        BlockReplacement(Modifier.fillMaxWidth())
        WriteStrategy(Modifier.fillMaxWidth())
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
