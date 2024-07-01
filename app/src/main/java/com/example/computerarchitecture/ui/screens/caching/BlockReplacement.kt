package com.example.computerarchitecture.ui.screens.caching

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.ListItem
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
 * Displays a card with information about block replacement.
 *
 * @param modifier The modifier for the layout
 */
@Composable
fun BlockReplacement(modifier: Modifier = Modifier) {
    Card(modifier) {
        Column(Modifier.padding(16.dp)) {
            Text(
                text = stringResource(R.string.block_replacement),
                fontWeight = FontWeight.Bold
            )
            Text(text = stringResource(R.string.block_replacement_question))
            DirectMapping()
            SetAssociativeMapping()
            AssociativeMapping()
            Random(Modifier.padding(16.dp))
            LRU(Modifier.padding(16.dp))
            FIFO(Modifier.padding(16.dp))
            Clock(Modifier.padding(16.dp))
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
        supportingContent = { Text(text = stringResource(R.string.direct_mapping_block_replacement)) },
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
        supportingContent = { Text(text = stringResource(R.string.set_associative_mapping_block_replacement)) },
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
        supportingContent = { Text(text = stringResource(R.string.associative_mapping_block_replacement)) },
    )
}

/*
* Displays a column with information about random block replacement.
*
* @param modifier The modifier for the layout
*/
@Composable
private fun Random(modifier: Modifier = Modifier) {
    Column(modifier, Arrangement.spacedBy(8.dp)) {
        Text(
            text = stringResource(R.string.random),
            style = MaterialTheme.typography.titleMedium
        )
        Text(
            text = stringResource(R.string.random_description),
            style = MaterialTheme.typography.bodyMedium
        )
    }
}

/**
 * Displays a column with information about LRU block replacement.
 *
 * @param modifier The modifier for the layout
 */
@Composable
private fun LRU(modifier: Modifier = Modifier) {
    Column(modifier, Arrangement.spacedBy(8.dp)) {
        Text(
            text = stringResource(R.string.lru),
            style = MaterialTheme.typography.titleMedium
        )
        Text(
            text = stringResource(R.string.lru_description),
            style = MaterialTheme.typography.bodyMedium
        )
    }
}

/**
 * Displays a column with information about FIFO block replacement.
 *
 * @param modifier The modifier for the layout
 */
@Composable
private fun FIFO(modifier: Modifier = Modifier) {
    Column(modifier, Arrangement.spacedBy(8.dp)) {
        Text(
            text = stringResource(R.string.fifo),
            style = MaterialTheme.typography.titleMedium
        )
        Text(
            text = stringResource(R.string.fifo_description),
            style = MaterialTheme.typography.bodyMedium
        )
    }
}

/**
 * Displays a column with information about clock block replacement.
 *
 * @param modifier The modifier for the layout
 */
@Composable
private fun Clock(modifier: Modifier = Modifier) {
    Column(modifier, Arrangement.spacedBy(8.dp)) {
        Text(
            text = stringResource(R.string.clock),
            style = MaterialTheme.typography.titleMedium
        )
        Text(
            text = stringResource(R.string.clock_description),
            style = MaterialTheme.typography.bodyMedium
        )
    }
}

/**
 * Displays previews for the block replacement card.
 */
@PreviewLightDark
@PreviewDynamicColors
@Composable
private fun BlockReplacementPreviews() {
    ComputerArchitectureTheme {
        BlockReplacement()
    }
}