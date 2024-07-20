package com.example.computerarchitecture.ui.screens.multiprocessorsystems

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.computerarchitecture.R

/**
 * Displays a column with information about cache coherence.
 *
 * @param modifier The modifier for the layout
 */
@Composable
fun CacheCoherence(modifier: Modifier = Modifier) {
    Column(modifier, Arrangement.spacedBy(8.dp)) {
        Card(Modifier.fillMaxWidth()) {
            Column(Modifier.padding(8.dp)) {
                Text(
                    text = stringResource(R.string.cache_definition),
                    style = MaterialTheme.typography.titleLarge,
                    fontWeight = FontWeight.Bold
                )
                Text(text = stringResource(R.string.cache_coherence_description))
            }
        }
        Maintenance(Modifier.fillMaxWidth())
        MSIProtocol(Modifier.fillMaxWidth())
    }
}

/**
 * Displays a card with information about cache coherence maintenance.
 *
 * @param modifier The modifier for the layout
 */
@Composable
private fun Maintenance(modifier: Modifier = Modifier) {
    Card(modifier) {
        Column(Modifier.padding(8.dp), Arrangement.spacedBy(8.dp)) {
            Text(
                text = stringResource(R.string.maintenance),
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.Bold
            )
            SnoopingBasedCoherence(Modifier.fillMaxWidth())
            DirectoryBasedCoherence(Modifier.fillMaxWidth())
        }
    }
}

/**
 * Displays a card with information about snooping-based cache coherence maintenance.
 *
 * @param modifier The modifier for the layout
 */
@Composable
private fun SnoopingBasedCoherence(modifier: Modifier = Modifier) {
    Card(modifier) {
        Column(Modifier.padding(8.dp)) {
            Text(
                text = stringResource(R.string.snooping_based_coherence),
                fontWeight = FontWeight.Bold
            )
            Text(stringResource(R.string.snooping_based_coherence_description))
        }
    }
}

/**
 * Displays a card with information about directory-based cache coherence maintenance
 *
 * @param modifier The modifier for the layout
 */
@Composable
private fun DirectoryBasedCoherence(modifier: Modifier = Modifier) {
    Card(modifier) {
        Column(Modifier.padding(8.dp)) {
            Text(
                text = stringResource(R.string.directory_based_coherence),
                fontWeight = FontWeight.Bold
            )
            Text(stringResource(R.string.directory_based_coherence_description))
        }
    }
}

/**
 * Displays a card with information about the MSI protocol
 *
 * @param modifier The modifier for the layout
 */
@Composable
private fun MSIProtocol(modifier: Modifier = Modifier) {
    Card(modifier) {
        Column(Modifier.padding(8.dp)) {
            Text(
                text = stringResource(R.string.msi_protocol),
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.Bold
            )
            Image(
                painter = painterResource(R.drawable.msi_protocol),
                contentDescription = null,
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}
