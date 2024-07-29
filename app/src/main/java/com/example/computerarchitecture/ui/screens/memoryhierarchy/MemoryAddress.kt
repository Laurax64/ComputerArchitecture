package com.example.computerarchitecture.ui.screens.memoryhierarchy

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.computerarchitecture.R
import com.example.computerarchitecture.ui.theme.ComputerArchitectureTheme

/**
 * Displays a card with information about memory addresses.
 *
 * @param isStudyMode Whether the user is in study mode
 * @param modifier The modifier for the layout
 */
@Composable
fun MemoryAddress(isStudyMode: Boolean, modifier: Modifier = Modifier) {
    var expanded by rememberSaveable { mutableStateOf(!isStudyMode) }
    Card({ expanded = !expanded }, modifier) {
        Column(Modifier.padding(8.dp), Arrangement.spacedBy(8.dp)) {
            Text(
                text = stringResource(R.string.memory_address),
                style = MaterialTheme.typography.titleLarge
            )
            if (expanded) {
                Row(
                    Modifier
                        .fillMaxWidth()
                        .border(1.dp, MaterialTheme.colorScheme.onSurface)
                ) {
                    Box(
                        Modifier.weight(20f),
                        Alignment.Center
                    ) { Text(text = stringResource(R.string.tag)) }
                    Box(
                        Modifier
                            .border(1.dp, MaterialTheme.colorScheme.onSurface)
                            .weight(6f), Alignment.Center
                    ) {
                        Text(stringResource(R.string.index))
                    }
                    Box(
                        Modifier.weight(6f), Alignment.Center
                    ) {
                        Text(stringResource(R.string.offset))
                    }
                }
                Tag(Modifier.fillMaxWidth())
                Index(Modifier.fillMaxWidth())
                Offset(Modifier.fillMaxWidth())
            }
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
    Card(modifier) {
        Column(Modifier.padding(8.dp)) {
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

}

/**
 * Displays a column for the index.
 *
 * @param modifier The modifier for the layout
 */
@Composable
private fun Index(modifier: Modifier = Modifier) {

    Card(modifier) {
        Column(Modifier.padding(8.dp)) {
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
}

/**
 * Displays a column for the offset.
 *
 * @param modifier The modifier for the layout
 */
@Composable
private fun Offset(modifier: Modifier = Modifier) {

    Card(modifier) {
        Column(Modifier.padding(8.dp)) {
            Text(
                text = stringResource(R.string.offset),
                style = MaterialTheme.typography.titleMedium
            )
            Text(
                text = stringResource(R.string.offset_length),
                style = MaterialTheme.typography.labelMedium
            )
            Text(
                text = stringResource(R.string.offset_description),
                style = MaterialTheme.typography.bodyMedium
            )
        }
    }
}

/**
 * Displays a preview of the memory address card.
 */
@Preview
@Composable
fun MemoryAddressPreview() {
    ComputerArchitectureTheme {
        MemoryAddress(false)
    }
}
