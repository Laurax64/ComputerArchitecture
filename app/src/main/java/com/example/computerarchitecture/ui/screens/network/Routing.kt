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
 * Displays a column with information about routing.
 *
 * @param isStudyMode Whether the user is in study mode
 * @param modifier The modifier for the layout
 */
@Composable
fun Routing(isStudyMode: Boolean, modifier: Modifier = Modifier) {
    Column(modifier.verticalScroll(rememberScrollState()), Arrangement.spacedBy(8.dp)) {
        RoutingMechanisms(isStudyMode, Modifier.fillMaxWidth())
        CollisionHandling(isStudyMode, Modifier.fillMaxWidth())
        ExclusiveChannelOccupation(isStudyMode, Modifier.fillMaxWidth())
    }
}

/**
 * Displays a card with information about routing mechanisms.
 *
 * @param isStudyMode Whether the user is in study mode
 * @param modifier The modifier for the layout.
 */
@Composable
private fun RoutingMechanisms(isStudyMode: Boolean, modifier: Modifier = Modifier) {
    var expanded by rememberSaveable { mutableStateOf(!isStudyMode) }
    Card({ expanded = !expanded }, modifier) {
        Column(Modifier.padding(8.dp), Arrangement.spacedBy(8.dp)) {
            Text(
                stringResource(R.string.routing_mechanisms),
                style = MaterialTheme.typography.titleLarge
            )
            if (expanded) {
                StoreAndForward(isStudyMode, Modifier.fillMaxWidth())
                CutThroughRouting(isStudyMode, Modifier.fillMaxWidth())
            }
        }
    }
}

/**
 * Displays a card with information about store-and-forward routing.
 *
 * @param isStudyMode Whether the user is in study mode
 * @param modifier The modifier for the layout.
 */
@Composable
private fun StoreAndForward(isStudyMode: Boolean, modifier: Modifier = Modifier) {
    var expanded by rememberSaveable { mutableStateOf(!isStudyMode) }
    Card(onClick = { expanded = !expanded }, modifier = modifier) {
        Column(Modifier.padding(8.dp)) {
            Text(stringResource(R.string.store_and_forward), fontWeight = FontWeight.Bold)
            if (expanded) {
                Text(stringResource(R.string.store_and_forward_description))
                Image(
                    painter = painterResource(R.drawable.store_and_forward),
                    contentDescription = null,
                    modifier = Modifier.fillMaxWidth()
                )
            }
        }
    }
}

/**
 * Displays a card with information about cut-through routing.
 *
 * @param isStudyMode Whether the user is in study mode
 * @param modifier The modifier for the layout.
 */
@Composable
private fun CutThroughRouting(isStudyMode: Boolean, modifier: Modifier = Modifier) {
    var expanded by rememberSaveable { mutableStateOf(!isStudyMode) }
    Card(onClick = { expanded = !expanded }, modifier = modifier) {
        Column(Modifier.padding(8.dp)) {
            Text(stringResource(R.string.cut_through_routing), fontWeight = FontWeight.Bold)
            if (expanded) {
                Text(stringResource(R.string.cut_through_routing_description))
                Image(
                    painter = painterResource(R.drawable.cut_through_routing),
                    contentDescription = null,
                    modifier = Modifier.fillMaxWidth()
                )
            }
        }
    }
}

/**
 * Displays a card with information about collision handling.
 *
 * @param isStudyMode Whether the user is in study mode
 * @param modifier The Modifier for the layout
 */
@Composable
private fun CollisionHandling(isStudyMode: Boolean, modifier: Modifier = Modifier) {
    var expanded by rememberSaveable { mutableStateOf(!isStudyMode) }
    Card(onClick = { expanded = !expanded }, modifier = modifier) {
        Column(Modifier.padding(8.dp)) {
            Text(
                stringResource(R.string.collision_handling),
                style = MaterialTheme.typography.titleLarge
            )
            if (expanded) {
                Text(stringResource(R.string.package_discarding), fontWeight = FontWeight.Bold)
                Text(stringResource(R.string.package_discarding_description))
                Text(
                    stringResource(R.string.buffering_blocked_transmission),
                    fontWeight = FontWeight.Bold
                )
                Text(stringResource(R.string.buffering_blocked_transmission_description))
                Text(
                    stringResource(R.string.blocking_further_transmission),
                    fontWeight = FontWeight.Bold
                )
                Text(stringResource(R.string.blocking_further_transmission_description))
                Text(stringResource(R.string.redirection_of_packets), fontWeight = FontWeight.Bold)
                Text(stringResource(R.string.redirection_of_packets_description))
            }
        }
    }
}

/**
 * Displays a card with information about exclusive channel occupation.
 *
 * @param isStudyMode Whether the user is in study mode
 * @param modifier The Modifier for the layout
 */
@Composable
private fun ExclusiveChannelOccupation(isStudyMode: Boolean, modifier: Modifier = Modifier) {
    var expanded by rememberSaveable { mutableStateOf(!isStudyMode) }
    Card(onClick = { expanded = !expanded }, modifier = modifier) {
        Column(Modifier.padding(8.dp)) {
            Text(
                stringResource(R.string.exclusive_channel_occupation),
                style = MaterialTheme.typography.titleLarge
            )
            if (expanded) {
                Text(stringResource(R.string.exclusive_channel_occupation_description))
                Text(stringResource(R.string.solutions), fontWeight = FontWeight.Bold)
                Text(stringResource(R.string.exclusive_channel_occupation_solutions))
            }
        }
    }
}
