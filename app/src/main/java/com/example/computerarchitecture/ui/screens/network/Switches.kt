package com.example.computerarchitecture.ui.screens.network

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.computerarchitecture.R

/**
 * Displays a column with information about switches.
 *
 * @param isStudyMode Whether the user is in study mode
 * @param modifier The modifier for the layout.
 */
@Composable
fun Switches(isStudyMode: Boolean, modifier: Modifier = Modifier) {
    Column(modifier.verticalScroll(rememberScrollState()), Arrangement.spacedBy(8.dp)) {
        CrossBar(isStudyMode, Modifier.fillMaxWidth())
        OmegaNetwork(isStudyMode, Modifier.fillMaxWidth())
        BenesNetwork(isStudyMode, Modifier.fillMaxWidth())
    }
}

/**
 * Displays a card with information about cross bars.
 *
 * @param isStudyMode Whether the user is in study mode
 * @param modifier The modifier for the layout.
 */
@Composable
private fun CrossBar(isStudyMode: Boolean, modifier: Modifier = Modifier) {
    var expanded by rememberSaveable { mutableStateOf(!isStudyMode) }
    Card(onClick = { expanded = !expanded }, modifier = modifier) {
        Column(Modifier.padding(8.dp)) {
            Text(stringResource(R.string.cross_bar), style = MaterialTheme.typography.titleLarge)
            if (expanded) {
                Text(stringResource(R.string.cross_bar_description))
                Text(stringResource(R.string.advantages), fontWeight = FontWeight.Bold)
                Text(stringResource(R.string.cross_bar_benefits))
                Text(stringResource(R.string.disadvantages), fontWeight = FontWeight.Bold)
                Text(stringResource(R.string.cross_bar_disadvantages))
                Image(
                    painter = painterResource(R.drawable.cross_bar),
                    contentDescription = null,
                    modifier = Modifier.fillMaxWidth()
                )
            }
        }
    }
}

/**
 * Displays a card with information about omega networks.
 *
 * @param isStudyMode Whether the user is in study mode
 * @param modifier The modifier for the layout.
 */
@Composable
private fun OmegaNetwork(isStudyMode: Boolean, modifier: Modifier = Modifier) {
    var expanded by rememberSaveable { mutableStateOf(!isStudyMode) }
    Card(onClick = { expanded = !expanded }, modifier = modifier) {
        Column(Modifier.padding(8.dp)) {
            Text(
                stringResource(R.string.omega_network),
                style = MaterialTheme.typography.titleLarge
            )
            if (expanded) {
                Text(stringResource(R.string.omega_network_description))
                Text(stringResource(R.string.advantages), fontWeight = FontWeight.Bold)
                Text(stringResource(R.string.omega_network_benefits))
                Text(stringResource(R.string.disadvantages), fontWeight = FontWeight.Bold)
                Text(stringResource(R.string.omega_network_disadvantages))
                Image(
                    painter = painterResource(R.drawable.omega_network),
                    contentDescription = null,
                    modifier = Modifier.fillMaxWidth()
                )
            }
        }
    }
}

/**
 * Displays a card with information about Benes networks.
 *
 * @param isStudyMode Whether the user is in study mode
 * @param modifier The modifier for the layout.
 */
@Composable
private fun BenesNetwork(isStudyMode: Boolean, modifier: Modifier = Modifier) {
    var expanded by rememberSaveable { mutableStateOf(!isStudyMode) }
    Card(onClick = { expanded = !expanded }, modifier = modifier) {
        Column(Modifier.padding(8.dp)) {
            Text(
                stringResource(R.string.benes_network),
                style = MaterialTheme.typography.titleLarge
            )
            if (expanded) {
                Text(stringResource(R.string.benes_network_description))
                Image(
                    painter = painterResource(R.drawable.benes_network),
                    contentDescription = null,
                    modifier = Modifier.fillMaxWidth()
                )
            }
        }
    }
}
