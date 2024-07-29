package com.example.computerarchitecture.ui.screens.memoryhierarchy

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
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
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import com.example.computerarchitecture.R
import com.example.computerarchitecture.ui.theme.ComputerArchitectureTheme

/**
 * Displays a card with information about block identification.
 *
 * @param isStudyMode Whether the user is in study mode
 * @param modifier The modifier for the layout
 */
@Composable
fun BlockIdentification(isStudyMode: Boolean, modifier: Modifier = Modifier) {
    var expanded by rememberSaveable { mutableStateOf(!isStudyMode) }
    Card({ expanded = !expanded }, modifier) {
        Column(Modifier.padding(8.dp), Arrangement.spacedBy(8.dp)) {
            Text(
                text = stringResource(R.string.block_identification),
                style = MaterialTheme.typography.titleLarge,
            )
            if (expanded) {
                Text(text = stringResource(R.string.block_identification_question))
                DirectMapping(Modifier.fillMaxWidth())
                SetAssociativeMapping(Modifier.fillMaxWidth())
                AssociativeMapping(Modifier.fillMaxWidth())
            }
        }
    }
}

/**
 * Displays a card with information about block identification in direct mapping.
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
                text = stringResource(R.string.direct_mapping_block_identification),
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
                text = stringResource(R.string.set_associative_mapping_block_identification),
                style = MaterialTheme.typography.bodyMedium
            )
        }
    }
}

/**
 * Displays a card with information about block identification in associative mapping.
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
                text = stringResource(R.string.associative_mapping_block_identification),
                style = MaterialTheme.typography.bodyMedium
            )
        }
    }
}


/**
 * Displays previews for the block identification card.
 */
@PreviewLightDark
@Composable
private fun BlockIdentificationPreview() {
    ComputerArchitectureTheme {
        BlockIdentification(false)
    }
}