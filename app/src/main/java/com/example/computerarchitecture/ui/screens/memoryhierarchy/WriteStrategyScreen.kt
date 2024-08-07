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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.computerarchitecture.R
import com.example.computerarchitecture.ui.theme.ComputerArchitectureTheme

/**
 * Displays a card with information about write strategy.
 *
 * @param isStudyMode Whether the user is in study mode
 * @param modifier The modifier for the layout
 */
@Composable
fun WriteStrategy(isStudyMode: Boolean, modifier: Modifier = Modifier) {
    var expanded by rememberSaveable { mutableStateOf(!isStudyMode) }
    Card({ expanded = !expanded }, modifier) {
        Column(Modifier.padding(8.dp), Arrangement.spacedBy(8.dp)) {
            Text(
                text = stringResource(R.string.write_strategy),
                style = MaterialTheme.typography.titleLarge,
            )
            if (expanded) {
                Text(stringResource(R.string.write_strategy_question))
                WriteAllocate(Modifier.fillMaxWidth())
                NoWriteAllocate(Modifier.fillMaxWidth())
            }
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
        Column(Modifier.padding(8.dp)) {
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
    Card(modifier) {
        Column(Modifier.padding(8.dp)) {
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
}

/**
 * Displays previews for the write strategy card.
 */
@Preview(showBackground = true)
@Composable
private fun WriteStrategyPreviews() {
    ComputerArchitectureTheme {
        WriteStrategy(false)
    }
}