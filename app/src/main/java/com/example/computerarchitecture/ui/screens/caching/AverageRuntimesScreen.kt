package com.example.computerarchitecture.ui.screens.caching

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.example.computerarchitecture.R
import com.example.computerarchitecture.ui.components.TopicTopBar
import com.example.computerarchitecture.ui.navigation.NavigationDestination

/**
 * Represents a navigation destination for the average runtimes screen.
 */
object AverageRuntimesDestination : NavigationDestination {
    override val route = "Average Runtimes"
}


/**
 * Displays the average runtimes screen.
 *
 * @param modifier The modifier for the layout
 * @param navigateBack The function to navigate back
 */
@Composable
fun AverageRuntimesScreen(modifier: Modifier = Modifier, navigateBack: () -> Unit) {
    Scaffold(
        modifier = modifier,
        topBar = {
            TopicTopBar(
                title = stringResource(R.string.average_runtimes),
                navigateBack = navigateBack
            )
        },
    ) { paddingValues ->
        Column(Modifier.padding(paddingValues)) {

        }
    }
}