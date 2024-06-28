package com.example.computerarchitecture.ui.screens.caching

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.ListItem
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.computerarchitecture.R

/**
 * Displays the block identification content.
 *
 * @param modifier The modifier for the layout
 */
@Composable
fun BlockIdentificationContent(modifier: Modifier = Modifier) {
    Column(modifier) {
            DirectMapping()
            SetAssociativeMapping()
            AssociativeMapping()
            HorizontalDivider()
            MemoryAddress(Modifier.padding(16.dp))
            Tag(Modifier.padding(16.dp))
            Index(Modifier.padding(16.dp))
            Offset(Modifier.padding(16.dp))
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
        supportingContent = { Text(text = stringResource(R.string.direct_mapping_block_identification)) },
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
        supportingContent = { Text(text = stringResource(R.string.set_associative_mapping_block_identification)) },
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
        supportingContent = { Text(text = stringResource(R.string.associative_mapping_block_identification)) },
    )
}

/**
 * Displays the structure of an address.
 *
 * @param modifier The modifier for the layout
 */
@Composable
private fun MemoryAddress(modifier: Modifier = Modifier) {
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
 * Displays a column for the tag.
 *
 * @param modifier The modifier for the layout
 */
@Composable
private fun Tag(modifier: Modifier = Modifier) {
    Column(modifier, Arrangement.spacedBy(8.dp)) {
        Text(
            text = stringResource(R.string.tag),
            style = MaterialTheme.typography.titleMedium
        )
        Text(
            text = stringResource(R.string.tag_length),
            style = MaterialTheme.typography.labelMedium
        )
        Text(
            text = stringResource(R.string.tag_description),
            style = MaterialTheme.typography.bodyMedium
        )
    }
}

/**
 * Displays a column for the index.
 *
 * @param modifier The modifier for the layout
 */
@Composable
private fun Index(modifier: Modifier = Modifier) {
    Column(modifier, Arrangement.spacedBy(8.dp)) {
        Text(
            text = stringResource(R.string.index),
            style = MaterialTheme.typography.titleMedium
        )
        Text(
            text = stringResource(R.string.index_length),
            style = MaterialTheme.typography.labelMedium
        )
        Text(
            text = stringResource(R.string.index_description),
            style = MaterialTheme.typography.bodyMedium
        )
    }
}

/**
 * Displays a column for the offset.
 *
 * @param modifier The modifier for the layout
 */
@Composable
private fun Offset(modifier: Modifier = Modifier) {
    Column(modifier, Arrangement.spacedBy(8.dp)) {
        Text(
            text = stringResource(R.string.offset),
            style = MaterialTheme.typography.titleMedium
        )
        Text(
            text = stringResource(R.string.offset_length),
            style = MaterialTheme.typography.labelSmall
        )
        Text(
            text = stringResource(R.string.offset_description),
            style = MaterialTheme.typography.bodyMedium
        )
    }
}