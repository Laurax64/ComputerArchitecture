package com.example.computerarchitecture.ui.screens.network

import androidx.compose.foundation.Image
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.computerarchitecture.R

/**
 * Displays a card with information about switches.
 *
 * @param modifier The modifier for the layout.
 */
@Composable
fun Switches(modifier: Modifier = Modifier) {
    Column(modifier) {
        CrossBar(Modifier.fillMaxWidth())
        OmegaNetwork(Modifier.fillMaxWidth())
        BenesNetwork(Modifier.fillMaxWidth())
    }
}

/**
 * Displays a card with information about cross bars.
 *
 * @param modifier The modifier for the layout.
 */
@Composable
private fun CrossBar(modifier: Modifier = Modifier) {
    var expanded by rememberSaveable { mutableStateOf(false) }
    Card({ expanded = !expanded }, modifier) {
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
 * @param modifier The modifier for the layout.
 */
@Composable
private fun OmegaNetwork(modifier: Modifier = Modifier) {
    var expanded by rememberSaveable { mutableStateOf(false) }
    Card({ expanded = !expanded }, modifier) {
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
 * @param modifier The modifier for the layout.
 */
@Composable
private fun BenesNetwork(modifier: Modifier = Modifier) {
    var expanded by rememberSaveable { mutableStateOf(false) }
    Card({ expanded = !expanded }, modifier) {
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