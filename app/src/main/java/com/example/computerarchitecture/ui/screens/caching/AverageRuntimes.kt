package com.example.computerarchitecture.ui.screens.caching

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import com.example.computerarchitecture.R
import com.example.computerarchitecture.ui.theme.ComputerArchitectureTheme

/**
 * Displays a card with information about average runtimes for different cache configurations.
 *
 * @param modifier The modifier for the layout
 */
@Composable
fun AverageRuntimes(modifier: Modifier = Modifier) {
    Card(modifier) {
        Text(
            text = stringResource(id = R.string.average_runtimes),
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(16.dp)
        )

    }
}

/**
 * Displays preview for the average runtimes card.
 */
@PreviewLightDark
@Composable
fun AverageRuntimesPreview() {
    ComputerArchitectureTheme {
        AverageRuntimes()
    }
}