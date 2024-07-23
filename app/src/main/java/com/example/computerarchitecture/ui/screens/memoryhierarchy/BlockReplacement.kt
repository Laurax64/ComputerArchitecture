package com.example.computerarchitecture.ui.screens.memoryhierarchy

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
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
    val focusManager = LocalFocusManager.current
    Card(modifier
        .pointerInput(Unit) {
            detectTapGestures(onTap = {
                focusManager.clearFocus()
            })
        }
    )
    {
        Column(Modifier.padding(8.dp), Arrangement.spacedBy(8.dp)) {
            Text(
                text = stringResource(R.string.block_replacement),
                style = MaterialTheme.typography.titleLarge,
            )
            Text(stringResource(R.string.block_replacement_question))

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
                fontWeight = FontWeight.Bold
            )
            Text(
                text = stringResource(R.string.direct_mapping_block_replacement),
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
                fontWeight = FontWeight.Bold
            )
            Text(
                text = stringResource(R.string.set_associative_mapping_block_replacement),
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
                fontWeight = FontWeight.Bold
            )
            Text(
                text = stringResource(R.string.associative_mapping_block_replacement),

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
    Card({ expanded = !expanded }, modifier) {
        Column(Modifier.padding(8.dp)) {
            Text(
                text = stringResource(R.string.random),
                fontWeight = FontWeight.Bold
            )
            if (expanded) {
                Text(
                    text = stringResource(R.string.random_description),
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
    Card(modifier) {
        Column(Modifier.padding(8.dp)) {
            Text(
                text = stringResource(R.string.lru),
                style = MaterialTheme.typography.titleMedium
            )
                Text(
                    text = stringResource(R.string.lru_description),
                )
            LinkedList()
            TriangularMatrix()
        }
    }
}

/**
 * Displays a text button that shows a dialog with information about the linked list LRU.
 *
 * @param modifier The modifier for the layout
 */
@Composable
private fun LinkedList(modifier: Modifier = Modifier) {
    var expanded by rememberSaveable { mutableStateOf(false) }
    TextButton({ expanded = !expanded }, modifier) {
        Text(stringResource(R.string.linked_list))
    }
    if (expanded) {
        Card {
            Column(Modifier.padding(8.dp), Arrangement.spacedBy(8.dp)) {
                Text(
                    text = stringResource(R.string.lru_linked_list_data_structure),
                )
                Column {
                    Text(
                        text = stringResource(R.string.lru_linked_list_access),
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        text = stringResource(R.string.lru_linked_list_access_description),
                    )
                }
                Column {
                    Text(
                        text = stringResource(R.string.lru_linked_list_supplanting),
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        text = stringResource(R.string.lru_linked_list_supplanting_description),
                    )
                }
            }
        }
    }
}

/**
 * Displays a text button that shows a dialog with information about the triangular matrix LRU.
 *
 * @param modifier The modifier for the layout
 */
@Composable
private fun TriangularMatrix(modifier: Modifier = Modifier) {
    var expanded by rememberSaveable { mutableStateOf(false) }
    TextButton({ expanded = !expanded }, modifier) {
        Text(stringResource(R.string.triangular_matrix))
    }
    if (expanded) {
        Card {
            Column(Modifier.padding(8.dp), Arrangement.spacedBy(8.dp)) {
                Text(stringResource(R.string.triangular_matrix_description))
                Operations(Modifier.fillMaxWidth())
                LRUCacheMatrix(Modifier.fillMaxWidth())
                }
        }
    }
}


/**
 * Displays a column with information about the operations in the LRU triangular matrix.
 *
 * @param modifier The modifier for the layout
 */
@Composable
private fun Operations(modifier: Modifier = Modifier) {
    Column(modifier, Arrangement.spacedBy(8.dp)) {

        Column {
            Text(
                stringResource(R.string.triangular_matrix_initialization),
                fontWeight = FontWeight.Bold
            )
            Text(stringResource(R.string.triangular_matrix_initialization_description))
        }
        Column {
            Text(
                stringResource(R.string.triangular_matrix_access),
                fontWeight = FontWeight.Bold
            )
            Text(stringResource(R.string.triangular_matrix_access_description))
        }
        Column {
            Text(
                stringResource(R.string.triangular_matrix_cache_miss),
                fontWeight = FontWeight.Bold
            )
            Text(stringResource(R.string.triangular_matrix_cache_miss_description))
        }
        }
    }

/**
 * Displays a card with information about LRU cache matrix.
 */
@Composable
fun LRUCacheMatrix(modifier: Modifier = Modifier) {
    var matrix by rememberSaveable {
        mutableStateOf(
            listOf(
                listOf("Entry", "0", "1", "2", "3"),
                listOf("0", "", "1", "1", "1"),
                listOf("1", "", "", "1", "1"),
                listOf("2", "", "", "", "1")
            )
        )
    }
    Column(modifier, Arrangement.spacedBy(8.dp), Alignment.CenterHorizontally) {
            MatrixDisplay(Modifier, matrix)
            CacheControls(Modifier, matrix) { updatedMatrix ->
                matrix = updatedMatrix
            }
        }

}

/**
 * Displays the given matrix in a grid layout.
 *
 * @param modifier The modifier for the layout
 * @param matrix The matrix to display
 */
@Composable
fun MatrixDisplay(modifier: Modifier = Modifier, matrix: List<List<String>>) {
    Column(modifier) {
        for (row in matrix) {
            Row {
                for (item in row) {
                    Box(
                        Modifier
                            .size(50.dp)
                            .border(1.dp, MaterialTheme.colorScheme.onSurface)
                            .background(MaterialTheme.colorScheme.surface),
                        Alignment.Center
                    ) {
                        Text(
                            text = item
                        )
                    }
                }
            }
        }
    }
}

/**
 * Displays a text field for the user to input the most entry to access in the LRU cache matrix.
 *
 * @param modifier The modifier for the layout
 * @param matrix The current matrix
 * @param onMatrixUpdate The callback to update the matrix
 */
@Composable
fun CacheControls(
    modifier: Modifier = Modifier,
    matrix: List<List<String>>,
    onMatrixUpdate: (List<List<String>>) -> Unit
) {
    var inputValue by remember { mutableStateOf("") }
    TextField(
        value = inputValue,
        onValueChange = {
            inputValue = it
            val entry = inputValue.toIntOrNull()
            if (entry != null && entry in 0..2) {
                val updatedMatrix = updateMatrix(matrix, entry)
                onMatrixUpdate(updatedMatrix)
            }
        },
        modifier = modifier,
        label = { Text(stringResource(id = R.string.access_entry)) }
    )

}

/**
 * Updates the LRU cache matrix with the most recent entry.
 *
 * @param matrix The current matrix
 * @return The updated matrix
 */
private fun updateMatrix(matrix: List<List<String>>, k: Int): List<List<String>> {
    val newMatrix = matrix.map { it.toMutableList() }.toMutableList()

    // Access to k, k becomes the most recent entry
    for (j in k + 2 until newMatrix[0].size) {
        newMatrix[k + 1][j] = "0"
    }
    for (i in 1 until k + 1) {
        newMatrix[i][k + 1] = "1"
    }

    return newMatrix
}

/**
 * Displays a card with information about FIFO block replacement.
 *
 * @param modifier The modifier for the layout
 */
@Composable
private fun FIFO(modifier: Modifier = Modifier) {
    var expanded by rememberSaveable { mutableStateOf(false) }
    Card({ expanded = !expanded }, modifier) {
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
    Card({ expanded = !expanded }, modifier) {
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
@Composable
private fun BlockReplacementPreviews() {
    ComputerArchitectureTheme {
        BlockReplacement()
    }
}