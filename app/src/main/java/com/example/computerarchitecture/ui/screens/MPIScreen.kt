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
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.tooling.preview.PreviewScreenSizes
import androidx.compose.ui.unit.dp
import com.example.computerarchitecture.R
import com.example.computerarchitecture.ui.components.TopicTopBar
import com.example.computerarchitecture.ui.theme.ComputerArchitectureTheme

/**
 * Displays the MPI screen.
 *
 * @param navigateBack The function to navigate back
 * @param modifier The modifier for the layout
 */
@Composable
fun MPIScreen(
    navigateBack: () -> Unit,
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
            Modifier
                .padding(it)
                .padding(24.dp))
}

}

/**
 * Displays the MPI screen.
 *
 * @param modifier The modifier for the layout
 */
@Composable
fun MPIScreen(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier.verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.spacedBy(12.dp),
    ) {
        Send(Modifier.fillMaxWidth())
        Receive(Modifier.fillMaxWidth())
        DataTypes(Modifier.fillMaxWidth())
        DerivedDataTypes(Modifier.fillMaxWidth())
        CommunicationPatterns(Modifier.fillMaxWidth())
    }
}

/**
 * Displays a card with information about MPI_Send.
 *
 * @param modifier The modifier for the layout
 */
@Composable
private fun Send(modifier: Modifier = Modifier) {
    Card(modifier) {
        Column(Modifier.padding(8.dp)) {
            Text(
                text = stringResource(R.string.send_syntax),
                fontWeight = FontWeight.Bold
            )
            Text(stringResource(R.string.send_description))
        }
    }
}

/**
 * Displays a card with information about MPI_Receive.
 *
 * @param modifier The modifier for the layout
 */
@Composable
private fun Receive(modifier: Modifier = Modifier) {
    Card(modifier) {
        Column(Modifier.padding(8.dp)) {
            Text(
                text = stringResource(R.string.receive_syntax),
                fontWeight = FontWeight.Bold
            )
            Text(stringResource(R.string.receive_description))
        }
    }
}

/**
 * Displays a card with information about MPI data types.
 *
 * @param modifier The modifier for the layout
 */
@Composable
private fun DataTypes(modifier: Modifier = Modifier) {
    Card(modifier) {
        Column(Modifier.padding(8.dp)) {
            Text(
                text = stringResource(R.string.data_types),
                fontWeight = FontWeight.Bold
            )
            Text(stringResource(R.string.data_types_description))
        }
    }
}

/**
 * Displays a card with information about derived MPI data types.
 *
 * @param modifier The modifier for the layout
 */
@Composable
private fun DerivedDataTypes(modifier: Modifier = Modifier) {
    Card(modifier) {
        Column(Modifier.padding(8.dp)) {
            Text(
                text = stringResource(R.string.derived_data_types),
                fontWeight = FontWeight.Bold
            )
            Text(stringResource(R.string.derived_data_types_description))
        }
    }
}

/**
 * Displays a card with information about MPI communication patterns.
 *
 * @param modifier The modifier for the layout
 */
@Composable
private fun CommunicationPatterns(modifier: Modifier = Modifier) {
    Card(modifier) {
        Column(Modifier.padding(8.dp), Arrangement.spacedBy(8.dp)) {
            Text(
                text = stringResource(R.string.communication_patterns),
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.Bold
            )
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
 * Displays a card with information about MPI_AllReduce
 *
 *  @param modifier The modifier for the layout
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
 * Displays a card with information about MPI_AllGather
 *
 *  @param modifier The modifier for the layout
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
 * Displays a card with information about MPI_Barrier
 *
 *  @param modifier The modifier for the layout
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
        MPIScreen()
    }

}