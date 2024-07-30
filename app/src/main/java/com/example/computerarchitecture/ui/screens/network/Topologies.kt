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
 * Displays a column with information about network topologies.
 *
 * @param isStudyMode Whether the user is in study mode
 * @param modifier The modifier for the layout
 */
@Composable
fun Topologies(isStudyMode: Boolean, modifier: Modifier = Modifier) {
    Column(modifier.verticalScroll(rememberScrollState()), Arrangement.spacedBy(8.dp)) {
        Definition(isStudyMode, Modifier.fillMaxWidth())
        EvaluationCriteria(isStudyMode, Modifier.fillMaxWidth())
        LinearArray(isStudyMode, Modifier.fillMaxWidth())
        RingTopology(isStudyMode, Modifier.fillMaxWidth())
        Mesh(isStudyMode, Modifier.fillMaxWidth())
        Torus(isStudyMode, Modifier.fillMaxWidth())
        Tree(isStudyMode, Modifier.fillMaxWidth())
        FatTree(isStudyMode, Modifier.fillMaxWidth())
        RedundantFatTree(isStudyMode, Modifier.fillMaxWidth())
        Hypercube(isStudyMode, Modifier.fillMaxWidth())
    }
}

/**
 * Displays a card with information about the definition of network topologies.
 *
 * @param isStudyMode Whether the user is in study mode.
 * @param modifier The modifier for the layout.
 */
@Composable
private fun Definition(isStudyMode: Boolean, modifier: Modifier = Modifier) {
    var expanded by rememberSaveable { mutableStateOf(!isStudyMode) }
    Card({ expanded = !expanded }, modifier) {
        Column(Modifier.padding(8.dp)) {
            Text(stringResource(R.string.definition), style = MaterialTheme.typography.titleLarge)
            if (expanded) {
                Text(stringResource(R.string.topologies_description))
            }
        }
    }
}

/**
 * Displays a card with information about network evaluation criteria.
 *
 * @param isStudyMode Whether the user is in study mode
 * @param modifier The modifier for the layout.
 */
@Composable
private fun EvaluationCriteria(isStudyMode: Boolean, modifier: Modifier = Modifier) {
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


/**
 * Displays a card with information about linear arrays.
 *
 * @param isStudyMode Whether the user is in study mode
 * @param modifier The modifier for the layout.
 */
@Composable
private fun LinearArray(isStudyMode: Boolean, modifier: Modifier = Modifier) {
    var expanded by rememberSaveable { mutableStateOf(!isStudyMode) }
    Card({ expanded = !expanded }, modifier) {
        Column(Modifier.padding(8.dp)) {
            Text(stringResource(R.string.linear_array), style = MaterialTheme.typography.titleLarge)
            if (expanded) {
                Text(stringResource(R.string.degree_of_nodes), fontWeight = FontWeight.Bold)
                Text(stringResource(R.string.degree_of_nodes_linear_array))
                Text(stringResource(R.string.diameter), fontWeight = FontWeight.Bold)
                Text("N-1")
                Text(stringResource(R.string.bisection_bandwidth), fontWeight = FontWeight.Bold)
                Text("1")
                Text(stringResource(R.string.scalability), fontWeight = FontWeight.Bold)
                Text(stringResource(R.string.scalability_linear_array))
                Image(
                    painter = painterResource(R.drawable.linear_array),
                    contentDescription = stringResource(R.string.linear_array),
                    modifier = Modifier.fillMaxWidth()
                )
            }
        }
    }
}

/**
 * Displays a card with information about ring topologies.
 *
 * @param isStudyMode Whether the user is in study mode
 * @param modifier The modifier for the layout.
 */
@Composable
private fun RingTopology(isStudyMode: Boolean, modifier: Modifier = Modifier) {
    var expanded by rememberSaveable { mutableStateOf(!isStudyMode) }
    Card({ expanded = !expanded }, modifier) {
        Column(Modifier.padding(8.dp)) {
            Text(
                stringResource(R.string.ring_topology),
                style = MaterialTheme.typography.titleLarge
            )
            if (expanded) {
                Text(stringResource(R.string.degree_of_nodes), fontWeight = FontWeight.Bold)
                Text("2")
                Text(stringResource(R.string.diameter), fontWeight = FontWeight.Bold)
                Text(stringResource(R.string.diameter_ring_topology))
                Text(stringResource(R.string.bisection_bandwidth), fontWeight = FontWeight.Bold)
                Text("2")
                Text(stringResource(R.string.scalability), fontWeight = FontWeight.Bold)
                Text(stringResource(R.string.scalability_ring_topology))
                Image(
                    painter = painterResource(R.drawable.ring_topology),
                    contentDescription = stringResource(R.string.ring_topology),
                    modifier = Modifier.fillMaxWidth()
                )
            }
        }
    }
}

/**
 * Displays a card with information about mesh topologies.
 *
 * @param isStudyMode Whether the user is in study mode
 * @param modifier The modifier for the layout.
 */
@Composable
private fun Mesh(isStudyMode: Boolean, modifier: Modifier = Modifier) {
    var expanded by rememberSaveable { mutableStateOf(!isStudyMode) }
    Card({ expanded = !expanded }, modifier) {
        Column(Modifier.padding(8.dp)) {
            Text(stringResource(R.string.mesh), style = MaterialTheme.typography.titleLarge)
            if (expanded) {
                Text(stringResource(R.string.degree_of_nodes), fontWeight = FontWeight.Bold)
                Text(stringResource(R.string.degree_of_nodes_mesh))
                Text(stringResource(R.string.diameter), fontWeight = FontWeight.Bold)
                Text("k(√[k]N - 1)")
                Text(stringResource(R.string.bisection_bandwidth), fontWeight = FontWeight.Bold)
                Text("(√[k]N)^(k-1)")
                Image(
                    painter = painterResource(R.drawable.mesh),
                    contentDescription = null,
                    modifier = Modifier.fillMaxWidth()
                )
            }
        }
    }
}


/**
 * Displays a card with information about torus topologies.
 *
 * @param isStudyMode Whether the user is in study mode
 * @param modifier The modifier for the layout
 */
@Composable
private fun Torus(isStudyMode: Boolean, modifier: Modifier = Modifier) {
    var expanded by rememberSaveable { mutableStateOf(!isStudyMode) }
    Card({ expanded = !expanded }, modifier) {
        Column(Modifier.padding(8.dp)) {
            Text(stringResource(R.string.torus), style = MaterialTheme.typography.titleLarge)
            if (expanded) {
                Text(stringResource(R.string.degree_of_nodes), fontWeight = FontWeight.Bold)
                Text("2k")
                Text(stringResource(R.string.diameter), fontWeight = FontWeight.Bold)
                Text("k⌊√[k](N/2)⌋")
                Text(stringResource(R.string.bisection_bandwidth), fontWeight = FontWeight.Bold)
                Text("2(√[k]N)^(k-1)")
                Image(
                    painter = painterResource(R.drawable.torus),
                    contentDescription = null,
                    modifier = Modifier.fillMaxWidth()
                )
            }
        }
    }
}


/**
 * Displays a card with information about tree topologies.
 *
 * @param isStudyMode Whether the user is in study mode
 * @param modifier The modifier for the layout
 */
@Composable
private fun Tree(isStudyMode: Boolean, modifier: Modifier = Modifier) {
    var expanded by rememberSaveable { mutableStateOf(!isStudyMode) }
    Card({ expanded = !expanded }, modifier) {
        Column(Modifier.padding(8.dp)) {
            Text(stringResource(R.string.tree), style = MaterialTheme.typography.titleLarge)
            if (expanded) {
                Text(stringResource(R.string.degree_of_nodes), fontWeight = FontWeight.Bold)
                Text(stringResource(R.string.degree_of_nodes_tree))
                Text(stringResource(R.string.diameter), fontWeight = FontWeight.Bold)
                Text("2⌊log_2 N⌋")
                Text(stringResource(R.string.bisection_bandwidth), fontWeight = FontWeight.Bold)
                Text("1")
                Image(
                    painter = painterResource(R.drawable.tree),
                    contentDescription = null,
                    modifier = Modifier.fillMaxWidth()
                )
            }
        }
    }
}

/**
 * Displays a card with information about fat tree topologies.
 *
 * @param isStudyMode Whether the user is in study mode
 * @param modifier The modifier for the layout
 */
@Composable
private fun FatTree(isStudyMode: Boolean, modifier: Modifier = Modifier) {
    var expanded by rememberSaveable { mutableStateOf(!isStudyMode) }
    Card({ expanded = !expanded }, modifier) {
        Column(Modifier.padding(8.dp)) {
            Text(stringResource(R.string.fat_tree), style = MaterialTheme.typography.titleLarge)
            if (expanded) {
                Text(stringResource(R.string.degree_of_nodes), fontWeight = FontWeight.Bold)
                Text(stringResource(R.string.degree_of_nodes_fat_tree))
                Text(stringResource(R.string.diameter), fontWeight = FontWeight.Bold)
                Text("2⌊log_2 N⌋")
                Text(stringResource(R.string.bisection_bandwidth), fontWeight = FontWeight.Bold)
                Text("N/2")
                Image(
                    painter = painterResource(R.drawable.fat_tree),
                    contentDescription = null,
                    modifier = Modifier.fillMaxWidth()
                )
            }
        }
    }
}

/**
 * Displays a card with information about redundant fat tree topologies.
 *
 * @param isStudyMode Whether the user is in study mode
 * @param modifier The modifier for the layout
 */
@Composable
private fun RedundantFatTree(isStudyMode: Boolean, modifier: Modifier = Modifier) {
    var expanded by rememberSaveable { mutableStateOf(!isStudyMode) }
    Card({ expanded = !expanded }, modifier) {
        Column(Modifier.padding(8.dp)) {
            Text(
                stringResource(R.string.redundant_fat_tree),
                style = MaterialTheme.typography.titleLarge
            )
            if (expanded) {
                Text(stringResource(R.string.redundant_fat_tree_description))
                Image(
                    painter = painterResource(R.drawable.redundant_fat_tree),
                    contentDescription = null,
                    modifier = Modifier.fillMaxWidth()
                )
            }
        }
    }
}

/**
 * Displays information about hypercube topologies.
 *
 * @param isStudyMode Whether the user is in study mode
 * @param modifier The modifier for the layout
 */
@Composable
private fun Hypercube(isStudyMode: Boolean, modifier: Modifier = Modifier) {
    var expanded by rememberSaveable { mutableStateOf(!isStudyMode) }
    Card({ expanded = !expanded }, modifier) {
        Column(Modifier.padding(8.dp)) {
            Text(
                stringResource(R.string.hypercube),
                style = MaterialTheme.typography.titleLarge
            )
            if (expanded) {
                Text(stringResource(R.string.degree_of_nodes), fontWeight = FontWeight.Bold)
                Text("k = log_2(N)")
                Text(stringResource(R.string.diameter), fontWeight = FontWeight.Bold)
                Text("k")
                Text(stringResource(R.string.bisection_bandwidth), fontWeight = FontWeight.Bold)
                Text("2^(k-1)")
                Image(
                    painter = painterResource(R.drawable.hypercube),
                    contentDescription = null,
                    modifier = Modifier.fillMaxWidth()
                )
            }
        }
    }
}