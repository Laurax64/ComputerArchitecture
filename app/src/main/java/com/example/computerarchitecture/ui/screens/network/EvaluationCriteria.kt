package com.example.computerarchitecture.ui.screens.network

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
import androidx.compose.ui.unit.dp
import com.example.computerarchitecture.R

/**
 * Displays a card with information about network evaluation criteria.
 *
 * @param isStudyMode Whether the user is in study mode
 * @param modifier The modifier for the layout.
 */
@Composable
fun EvaluationCriteria(isStudyMode: Boolean, modifier: Modifier = Modifier) {
    var expanded by rememberSaveable { mutableStateOf(!isStudyMode) }
    Card({ expanded = !expanded }, modifier) {
        Column(Modifier.padding(8.dp), Arrangement.spacedBy(8.dp)) {
            Text(
                stringResource(R.string.evaluation_criteria),
                style = MaterialTheme.typography.titleLarge
            )
            if (expanded) {
                NodeDegree(Modifier.fillMaxWidth())
                NetworkDegree(Modifier.fillMaxWidth())
                Diameter(Modifier.fillMaxWidth())
                BisectionBandwidth(Modifier.fillMaxWidth())
            }
        }
    }
}

/**
 * Displays a card with information about node degree.
 *
 * @param modifier The modifier for the layout.
 */
@Composable
private fun NodeDegree(modifier: Modifier = Modifier) {
    Card(modifier) {
        Column(Modifier.padding(8.dp)) {
            Text(stringResource(R.string.node_degree), fontWeight = FontWeight.Bold)
            Text(stringResource(R.string.node_degree_description))
        }
    }
}

/**
 * Displays a card with information about network degree.
 *
 * @param modifier The modifier for the layout.
 */
@Composable
private fun NetworkDegree(modifier: Modifier = Modifier) {
    Card(modifier) {
        Column(Modifier.padding(8.dp)) {
            Text(stringResource(R.string.network_degree), fontWeight = FontWeight.Bold)
            Text(stringResource(R.string.network_degree_description))
        }
    }
}

/**
 * Displays a card with information about diameter.
 *
 * @param modifier The modifier for the layout.
 */
@Composable
private fun Diameter(modifier: Modifier = Modifier) {
    Card(modifier) {
        Column(Modifier.padding(8.dp)) {
            Text(stringResource(R.string.diameter), fontWeight = FontWeight.Bold)
            Text(stringResource(R.string.diameter_description))
        }
    }
}

/**
 * Displays a card with information about bisection bandwidth.
 *
 * @param modifier The modifier for the layout.
 */
@Composable
private fun BisectionBandwidth(modifier: Modifier = Modifier) {
    Card(modifier) {
        Column(Modifier.padding(8.dp)) {
            Text(stringResource(R.string.bisection_bandwidth), fontWeight = FontWeight.Bold)
            Text(stringResource(R.string.bisection_bandwidth_description))
        }
    }
}
