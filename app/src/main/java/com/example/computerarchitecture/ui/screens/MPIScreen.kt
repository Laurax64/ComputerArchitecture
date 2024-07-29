package com.example.computerarchitecture.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.tooling.preview.PreviewScreenSizes
import androidx.compose.ui.unit.dp
import com.example.computerarchitecture.R
import com.example.computerarchitecture.ui.components.TopicTopBar
import com.example.computerarchitecture.ui.theme.ComputerArchitectureTheme
import com.example.computerarchitecture.ui.viewmodels.MPIViewModel

/**
 * Displays the MPI screen.
 *
 * @param navigateBack The function to navigate back
 * @param mpiViewModel The view model for the MPI screen
 * @param modifier The modifier for the layout
 */
@Composable
fun MPIScreen(
    navigateBack: () -> Unit,
    mpiViewModel: MPIViewModel,
    modifier: Modifier = Modifier
) {
    Scaffold(
        modifier = modifier,
        topBar = {
            TopicTopBar(
                title = stringResource(R.string.message_passing_interface),
                navigateBack = navigateBack
            )
        },
    ) {
        MPIScreen(
            mpiViewModel.isStudyMode,
            Modifier
                .padding(it)
                .padding(start = 16.dp, end = 16.dp)
        )
    }
}

/**
 * Displays the MPI screen.
 *
 * @param isStudyMode Whether the user is in study mode
 * @param modifier The modifier for the layout
 */
@Composable
fun MPIScreen(isStudyMode: Boolean, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier.verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.spacedBy(12.dp),
    ) {
        Send(isStudyMode, Modifier.fillMaxWidth())
        Receive(isStudyMode, Modifier.fillMaxWidth())
        DataTypes(isStudyMode, Modifier.fillMaxWidth())
        DerivedDataTypes(isStudyMode, Modifier.fillMaxWidth())
        CommunicationPatterns(isStudyMode, Modifier.fillMaxWidth())
    }
}

/**
 * Displays a card with information about MPI_Send.
 *
 * @param isStudyMode Whether the user is in study mode
 * @param modifier The modifier for the layout
 */
@Composable
private fun Send(isStudyMode: Boolean, modifier: Modifier = Modifier) {
    var expanded by rememberSaveable { mutableStateOf(!isStudyMode) }
    Card(onClick = { expanded = !expanded }, modifier = modifier) {
        Column(Modifier.padding(8.dp), Arrangement.spacedBy(8.dp)) {
            Text(
                text = stringResource(R.string.send_api),
                style = MaterialTheme.typography.titleLarge,
            )
            if (expanded) {
                Text(
                    text = stringResource(R.string.send_syntax),
                    fontWeight = FontWeight.Bold
                )
                Text(stringResource(R.string.send_description))
            }
        }
    }
}

/**
 * Displays a card with information about MPI_Receive.
 *
 * @param isStudyMode Whether the user is in study mode
 * @param modifier The modifier for the layout
 */
@Composable
private fun Receive(isStudyMode: Boolean, modifier: Modifier = Modifier) {
    var expanded by rememberSaveable { mutableStateOf(!isStudyMode) }
    Card(onClick = { expanded = !expanded }, modifier = modifier) {
        Column(Modifier.padding(8.dp)) {
            Text(
                text = stringResource(R.string.receive_api),
                style = MaterialTheme.typography.titleLarge
            )
            if (expanded) {
                Text(
                    text = stringResource(R.string.receive_syntax),
                    fontWeight = FontWeight.Bold
                )
                Text(stringResource(R.string.receive_description))
            }
        }
    }
}

/**
 * Displays a card with information about MPI data types.
 *
 * @param isStudyMode Whether the user is in study mode
 * @param modifier The modifier for the layout
 */
@Composable
private fun DataTypes(isStudyMode: Boolean, modifier: Modifier = Modifier) {
    var expanded by rememberSaveable { mutableStateOf(!isStudyMode) }
    Card(onClick = { expanded = !expanded }, modifier = modifier) {
        Column(Modifier.padding(8.dp)) {
            Text(
                text = stringResource(R.string.data_types),
                style = MaterialTheme.typography.titleLarge
            )
            if (expanded) {
                Text(stringResource(R.string.data_types_description))
            }
        }
    }
}

/**
 * Displays a card with information about derived MPI data types.
 *
 * @param isStudyMode Whether the user is in study mode
 * @param modifier The modifier for the layout
 */
@Composable
private fun DerivedDataTypes(isStudyMode: Boolean, modifier: Modifier = Modifier) {
    var expanded by rememberSaveable { mutableStateOf(!isStudyMode) }
    Card(onClick = { expanded = !expanded }, modifier = modifier) {
        Column(Modifier.padding(8.dp)) {
            Text(
                text = stringResource(R.string.derived_data_types),
                style = MaterialTheme.typography.titleLarge
            )
            if (expanded) {
                Text(stringResource(R.string.derived_data_types_description))
            }
        }
    }
}

/**
 * Displays a card with information about MPI communication patterns.
 *
 * @param isStudyMode Whether the user is in study mode
 * @param modifier The modifier for the layout
 */
@Composable
private fun CommunicationPatterns(isStudyMode: Boolean, modifier: Modifier = Modifier) {
    var expanded by rememberSaveable { mutableStateOf(!isStudyMode) }
    Card(onClick = { expanded = !expanded }, modifier = modifier) {
        Column(Modifier.padding(8.dp)) {
            Text(
                text = stringResource(R.string.communication_patterns),
                style = MaterialTheme.typography.titleLarge
            )
            if (expanded) {
                MPIBcast(Modifier.fillMaxWidth())
                MPIReduce(Modifier.fillMaxWidth())
                MPIScatter(Modifier.fillMaxWidth())
                MPIGather(Modifier.fillMaxWidth())
                MPIAllReduce(Modifier.fillMaxWidth())
                MPIAllGather(Modifier.fillMaxWidth())
                MPIBarrier(Modifier.fillMaxWidth())
            }
        }
    }
}

/**
 * Displays a card with information about MPI_Bcast.
 *
 * @param modifier The modifier for the layout
 */
@Composable
private fun MPIBcast(modifier: Modifier = Modifier) {
    Card(modifier) {
        Column(Modifier.padding(8.dp)) {
            Text(
                text = stringResource(R.string.mpi_bcast),
                fontWeight = FontWeight.Bold
            )
            Text(stringResource(R.string.mpi_bcast_description))
        }
    }
}

/**
 * Displays a card with information about MPI_Reduce.
 *
 * @param modifier The modifier for the layout
 */
@Composable
private fun MPIReduce(modifier: Modifier = Modifier) {
    Card(modifier) {
        Column(Modifier.padding(8.dp)) {
            Text(
                text = stringResource(R.string.mpi_reduce),
                fontWeight = FontWeight.Bold
            )
            Text(stringResource(R.string.mpi_reduce_description))
        }
    }
}

/**
 * Displays a card with information about MPI_Scatter.
 *
 * @param modifier The modifier for the layout
 */
@Composable
private fun MPIScatter(modifier: Modifier = Modifier) {
    Card(modifier) {
        Column(Modifier.padding(8.dp)) {
            Text(
                text = stringResource(R.string.mpi_scatter),
                fontWeight = FontWeight.Bold
            )
            Text(stringResource(R.string.mpi_scatter_description))
        }
    }
}

/**
 * Displays a card with information about MPI_Gather.
 *
 * @param modifier The modifier for the layout
 */
@Composable
private fun MPIGather(modifier: Modifier = Modifier) {
    Card(modifier) {
        Column(Modifier.padding(8.dp)) {
            Text(
                text = stringResource(R.string.mpi_gather),
                fontWeight = FontWeight.Bold
            )
            Text(stringResource(R.string.mpi_gather_description))
        }
    }
}

/**
 * Displays a card with information about MPI_AllReduce.
 *
 * @param modifier The modifier for the layout
 */
@Composable
private fun MPIAllReduce(modifier: Modifier = Modifier) {
    Card(modifier) {
        Column(Modifier.padding(8.dp)) {
            Text(
                text = stringResource(R.string.mpi_all_reduce),
                fontWeight = FontWeight.Bold
            )
            Text(stringResource(R.string.mpi_all_reduce_description))
        }
    }
}

/**
 * Displays a card with information about MPI_AllGather.
 *
 * @param modifier The modifier for the layout
 */
@Composable
private fun MPIAllGather(modifier: Modifier = Modifier) {
    Card(modifier) {
        Column(Modifier.padding(8.dp)) {
            Text(
                text = stringResource(R.string.mpi_all_gather),
                fontWeight = FontWeight.Bold
            )
            Text(stringResource(R.string.mpi_all_gather_description))
        }
    }
}

/**
 * Displays a card with information about MPI_Barrier.
 *
 * @param modifier The modifier for the layout
 */
@Composable
private fun MPIBarrier(modifier: Modifier = Modifier) {
    Card(modifier) {
        Column(Modifier.padding(8.dp)) {
            Text(
                text = stringResource(R.string.mpi_barrier),
                fontWeight = FontWeight.Bold
            )
            Text(stringResource(R.string.mpi_barrier_description))
        }
    }
}

/**
 * Displays previews for the MPI screen.
 */
@PreviewLightDark
@PreviewScreenSizes
@Composable
fun PreviewMPIScreen() {
    ComputerArchitectureTheme {
        MPIScreen(false)
    }
}
