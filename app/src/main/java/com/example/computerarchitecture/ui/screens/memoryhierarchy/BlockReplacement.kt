package com.example.computerarchitecture.ui.screens.memoryhierarchy

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
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
        Column(Modifier.padding(8.dp), Arrangement.spacedBy(8.dp)) {
            Text(
                text = stringResource(R.string.block_replacement),
                style = MaterialTheme.typography.titleLarge,
            )
            Text(text = stringResource(R.string.block_replacement_question))

            DirectMapping(Modifier.fillMaxWidth())
            SetAssociativeMapping(Modifier.fillMaxWidth())
            AssociativeMapping(Modifier.fillMaxWidth())
            Random(Modifier.fillMaxWidth())
            LRU(Modifier.fillMaxWidth())
            FIFO(Modifier.fillMaxWidth())
            Clock(Modifier.fillMaxWidth())
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
    Card(modifier) {
        Column(Modifier.padding(8.dp)) {
            Text(
                text = stringResource(R.string.direct_mapping),
                style = MaterialTheme.typography.titleMedium
            )
            Text(
                text = stringResource(R.string.direct_mapping_block_replacement),
                style = MaterialTheme.typography.bodyMedium
            )
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
    Card(modifier) {
        Column(Modifier.padding(8.dp)) {
            Text(
                text = stringResource(R.string.set_associative_mapping),
                style = MaterialTheme.typography.titleMedium
            )
            Text(
                text = stringResource(R.string.set_associative_mapping_block_replacement),
                style = MaterialTheme.typography.bodyMedium
            )
        }
    }
}

/**
 * Displays a list item for associative mapping.
 *
 * @param modifier The modifier for the layout
 */
@Composable
private fun AssociativeMapping(modifier: Modifier = Modifier) {
    Card(modifier) {
        Column(Modifier.padding(8.dp)) {
            Text(
                text = stringResource(R.string.associative_mapping),
                style = MaterialTheme.typography.titleMedium
            )
            Text(
                text = stringResource(R.string.associative_mapping_block_replacement),
                style = MaterialTheme.typography.bodyMedium
            )
        }
    }
}

/*
* Displays a card with information about random block replacement.
*
* @param modifier The modifier for the layout
*/
@Composable
private fun Random(modifier: Modifier = Modifier) {
    var expanded by rememberSaveable { mutableStateOf(false) }
    OutlinedCard({ expanded = !expanded }, modifier) {
        Column(Modifier.padding(8.dp)) {
            Text(
                text = stringResource(R.string.random),
                style = MaterialTheme.typography.titleMedium
            )
            if (expanded) {
                Text(
                    text = stringResource(R.string.random_description),
                    style = MaterialTheme.typography.bodyMedium
                )
            }
        }
    }
}

/**
 * Displays a card with information about LRU block replacement.
 *
 * @param modifier The modifier for the layout
 */
@Composable
private fun LRU(modifier: Modifier = Modifier) {
    var expanded by rememberSaveable { mutableStateOf(true) }
    var showLinkedList by rememberSaveable { mutableStateOf(false) }
    var showTriangularMatrix by rememberSaveable { mutableStateOf(false) }
    OutlinedCard({ expanded = !expanded }, modifier) {
        Column(Modifier.padding(8.dp)) {
            Text(
                text = stringResource(R.string.lru),
                style = MaterialTheme.typography.titleMedium
            )
            if (expanded) {
                Text(
                    text = stringResource(R.string.lru_description),
                    style = MaterialTheme.typography.bodyMedium
                )
                OutlinedCard({ showLinkedList = !showLinkedList }, Modifier.fillMaxWidth()) {
                    Column(Modifier.padding(8.dp), Arrangement.spacedBy(8.dp)) {
                        Text(
                            text = stringResource(R.string.linked_list),
                        )
                        if (showLinkedList) {
                            Text(
                                text = stringResource(R.string.lru_linked_list_data_structure),
                                style = MaterialTheme.typography.titleSmall
                            )
                            Column {
                                Text(
                                    text = stringResource(R.string.lru_linked_list_access),
                                    style = MaterialTheme.typography.titleSmall
                                )
                                Text(
                                    text = stringResource(R.string.lru_linked_list_access_description),
                                    style = MaterialTheme.typography.bodySmall
                                )
                            }
                            Column {
                                Text(
                                    text = stringResource(R.string.lru_linked_list_supplanting),
                                    style = MaterialTheme.typography.titleSmall
                                )
                                Text(
                                    text = stringResource(R.string.lru_linked_list_supplanting_description),
                                    style = MaterialTheme.typography.bodySmall
                                )
                            }
                        }
                    }
                }
                OutlinedCard({}, Modifier.fillMaxWidth()) {
                    Column(Modifier.padding(8.dp), Arrangement.spacedBy(8.dp)) {
                        Text(
                            text = stringResource(R.string.triangular_matrix)
                        )
                        if (showTriangularMatrix) {

                        }
                    }

                }
            }
        }
    }
}

/**
 * Displays a card with information about FIFO block replacement.
 *
 * @param modifier The modifier for the layout
 */
@Composable
private fun FIFO(modifier: Modifier = Modifier) {
    var expanded by rememberSaveable { mutableStateOf(false) }
    OutlinedCard({ expanded = !expanded }, modifier) {
        Column(Modifier.padding(8.dp)) {
            Text(
                text = stringResource(R.string.fifo),
                style = MaterialTheme.typography.titleMedium
            )
            if (expanded) {
                Text(
                    text = stringResource(R.string.fifo_description),
                    style = MaterialTheme.typography.bodyMedium
                )
            }
        }
    }
}

/**
 * Displays a card with information about clock block replacement.
 *
 * @param modifier The modifier for the layout
 */
@Composable
private fun Clock(modifier: Modifier = Modifier) {
    var expanded by rememberSaveable { mutableStateOf(false) }
    OutlinedCard({ expanded = !expanded }, modifier) {
        Column(Modifier.padding(8.dp)) {
            Text(
                text = stringResource(R.string.clock),
                style = MaterialTheme.typography.titleMedium
            )
            if (expanded) {
                Text(
                    text = stringResource(R.string.clock_description),
                    style = MaterialTheme.typography.bodyMedium
                )
            }
        }
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