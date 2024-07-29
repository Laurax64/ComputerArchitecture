package com.example.computerarchitecture.ui.screens.multiprocessorsystems

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import com.example.computerarchitecture.R
import net.engawapg.lib.zoomable.rememberZoomState
import net.engawapg.lib.zoomable.zoomable

/**
 * Displays a column with information about cache coherence.
 *
 * @param isStudyMode Whether the user is in study mode
 * @param modifier The modifier for the layout
 */
@Composable
fun CacheCoherence(isStudyMode: Boolean, modifier: Modifier = Modifier) {
    Column(modifier, Arrangement.spacedBy(8.dp)) {
        Definition(isStudyMode, Modifier.fillMaxWidth())
        Maintenance(isStudyMode, Modifier.fillMaxWidth())
        MSIProtocol(isStudyMode, Modifier.fillMaxWidth())
    }
}

/**
 * Displays a card with information about cache coherence.
 *
 * @param isStudyMode Whether the user is in study mode
 * @param modifier The modifier for the layout
 */
@Composable
private fun Definition(isStudyMode: Boolean, modifier: Modifier = Modifier) {
    var expanded by rememberSaveable { mutableStateOf(!isStudyMode) }
    Card({ expanded = !expanded }, modifier) {
        Column(Modifier.padding(8.dp)) {
            Text(
                text = stringResource(R.string.cache_definition),
                style = MaterialTheme.typography.titleLarge,
            )
            if (expanded) {
                Text(text = stringResource(R.string.cache_coherence_description))
            }
        }
    }
}

/**
 * Displays a card with information about cache coherence maintenance.
 *
 * @param isStudyMode Whether the user is in study mode
 * @param modifier The modifier for the layout
 */
@Composable
private fun Maintenance(isStudyMode: Boolean, modifier: Modifier = Modifier) {
    var expanded by rememberSaveable { mutableStateOf(!isStudyMode) }
    Card({ expanded = !expanded }, modifier) {
        Column(Modifier.padding(8.dp), Arrangement.spacedBy(8.dp)) {
            Text(
                text = stringResource(R.string.maintenance),
                style = MaterialTheme.typography.titleLarge,
            )
            if (expanded) {
                SnoopingBasedCoherence(Modifier.fillMaxWidth())
                DirectoryBasedCoherence(Modifier.fillMaxWidth())
            }
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
    var showStateMachine by remember { mutableStateOf(false) }
    Card(modifier) {
        Column(Modifier.padding(8.dp)) {
            Text(
                text = stringResource(R.string.directory_based_coherence),
                fontWeight = FontWeight.Bold
            )
            Text(stringResource(R.string.directory_based_coherence_description))
            val painter = painterResource(R.drawable.directory_based_coherence)
            val zoomState = rememberZoomState(contentSize = painter.intrinsicSize)
            TextButton(onClick = { showStateMachine = true }) {
                Text(stringResource(R.string.state_machine))
            }
            if (showStateMachine) {
                Dialog({ showStateMachine = false }) {
                    Image(
                        painter = painterResource(R.drawable.directory_based_coherence),
                        contentDescription = null,
                        modifier = Modifier.zoomable(zoomState)
                    )
                }
            }
        }
    }
}

/**
 * Displays a card with information about the MSI protocol
 *
 * @param isStudyMode Whether the user is in study mode
 * @param modifier The modifier for the layout
 */
@Composable
private fun MSIProtocol(isStudyMode: Boolean, modifier: Modifier = Modifier) {
    var expanded by rememberSaveable { mutableStateOf(!isStudyMode) }
    var showStateMachine by rememberSaveable { mutableStateOf(false) }
    Card({ expanded = !expanded }, modifier) {
        Column(Modifier.padding(8.dp)) {
            Text(
                text = stringResource(R.string.msi_protocol),
                style = MaterialTheme.typography.titleLarge,
            )
            if (expanded) {
                val painter = painterResource(R.drawable.msi_protocol)
                val zoomState = rememberZoomState(contentSize = painter.intrinsicSize)
                TextButton(onClick = { showStateMachine = true }) {
                    Text(stringResource(R.string.state_machine))
                }
                if (showStateMachine) {
                    Dialog({ showStateMachine = false }) {
                        Image(
                            painter = painterResource(R.drawable.msi_protocol),
                            contentDescription = null,
                            modifier = Modifier.zoomable(zoomState)
                        )
                    }
                }
            }
        }
    }
}
