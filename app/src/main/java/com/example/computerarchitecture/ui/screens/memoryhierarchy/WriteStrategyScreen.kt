package com.example.computerarchitecture.ui.screens.memoryhierarchy

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.PreviewDynamicColors
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import com.example.computerarchitecture.R
import com.example.computerarchitecture.ui.theme.ComputerArchitectureTheme

/**
 * Displays a card with information about write strategy.
 *
 * @param modifier The modifier for the layout
 */
@Composable
fun WriteStrategy(modifier: Modifier = Modifier) {
    Card(modifier) {
        Column(Modifier.padding(16.dp)) {
            Text(
                text = stringResource(R.string.write_strategy),
                fontWeight = FontWeight.Bold
            )
            Text(text = stringResource(R.string.write_strategy_question))
            WriteAllocate(Modifier.fillMaxWidth())
            NoWriteAllocate(Modifier.fillMaxWidth())
        }
    }
}

/**
 * Displays a card with information about write allocate.
 *
 * @param modifier The modifier for the layout
 */
@Composable
private fun WriteAllocate(modifier: Modifier = Modifier) {
    Card(modifier) {
        Column(Modifier.padding(8.dp), Arrangement.spacedBy(8.dp)) {
            Text(
                text = stringResource(R.string.write_allocate),
                fontWeight = FontWeight.Bold
            )
            Text(
                text = stringResource(R.string.write_allocate_description),
                style = MaterialTheme.typography.bodyMedium
            )
        }
    }
}

/**
 * Displays a card with information about no write allocate.
 *
 * @param modifier The modifier for the layout
 */
@Composable
private fun NoWriteAllocate(modifier: Modifier = Modifier) {
    Card(modifier) {}
    Column(Modifier.padding(8.dp), Arrangement.spacedBy(8.dp)) {
        Text(
            text = stringResource(R.string.no_write_allocate),
            fontWeight = FontWeight.Bold
        )
        Text(
            text = stringResource(R.string.no_write_allocate_description),
            style = MaterialTheme.typography.bodyMedium
        )
    }
}

/**
 * Displays previews for the write strategy card.
 */
@PreviewLightDark
@PreviewDynamicColors
@Composable
private fun WriteStrategyPreviews() {
    ComputerArchitectureTheme {
        WriteStrategy()
    }
}