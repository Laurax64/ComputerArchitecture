package com.example.computerarchitecture.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.PrimaryTabRow
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Tab
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.tooling.preview.PreviewScreenSizes
import androidx.compose.ui.unit.dp
import com.example.computerarchitecture.R
import com.example.computerarchitecture.ui.components.TopicTopBar
import com.example.computerarchitecture.ui.theme.ComputerArchitectureTheme

/**
 * Displays the graphics processing units (GPUs) screen with an app scaffold.
 *
 * @param navigateBack The function to navigate back
 * @param modifier The modifier for the layout
 */
@Composable
fun GPUsScreen(
    navigateBack: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Scaffold(
        modifier = modifier,
        topBar = {
            TopicTopBar(
                title = stringResource(R.string.gpus),
                navigateBack = navigateBack
            )
        },
    ) { paddingValues ->
        GPUsScreen(modifier.padding(paddingValues))
    }
}

/**
 * Displays the GPUs screen.
 *
 * @param modifier The modifier for the layout
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GPUsScreen(modifier: Modifier = Modifier) {
    var state by rememberSaveable { mutableIntStateOf(0) }
    val titles = listOf(R.string.open_cl)

    Column(modifier.fillMaxWidth()) {
        PrimaryTabRow(selectedTabIndex = state) {
            titles.forEachIndexed { index, title ->
                Tab(
                    selected = state == index,
                    onClick = { state = index },
                    text = { Text(text = stringResource(title)) })
            }
        }
        when (state) {
            0 -> OpenCLTab(
                Modifier
                    .fillMaxWidth()
                    .padding(24.dp)
            )
        }
    }
}

/**
 * Displays the OpenCL tab.
 *
 * @param modifier The modifier for the layout
 */
@Composable
fun OpenCLTab(modifier: Modifier = Modifier) {
    Column(modifier.verticalScroll(rememberScrollState()), Arrangement.spacedBy(8.dp)) {
        OpenCLComputationModel(Modifier.fillMaxWidth())
        ExecutingKernels(Modifier.fillMaxWidth())
        WorkItemFunctions(Modifier.fillMaxWidth())
        OpenCLProgramComponents(Modifier.fillMaxWidth())
        Portability(Modifier.fillMaxWidth())
        MemoryModel(Modifier.fillMaxWidth())
    }
}

@Composable
private fun OpenCLComputationModel(modifier: Modifier = Modifier) {
    Card(modifier) {
        Column(Modifier.padding(8.dp), Arrangement.spacedBy(8.dp)) {
            Text(
                text = stringResource(R.string.computation_model),
                style = MaterialTheme.typography.titleLarge,
            )
            Row(Modifier.fillMaxWidth(), Arrangement.spacedBy(8.dp)) {
                Image(
                    painter = painterResource(
                        id = R.drawable.open_cl_computation_model
                    ),
                    modifier = Modifier.weight(1f),
                    contentDescription = null, // decorative
                )
                Text(
                    text = stringResource(R.string.open_cl_computation_model_description),
                    modifier = Modifier.weight(1f),
                )
            }
        }
    }
}

@Composable
private fun ExecutingKernels(modifier: Modifier = Modifier) {
    Card(modifier) {
        Column(Modifier.padding(8.dp)) {
            Text(
                text = stringResource(R.string.executing_kernels),
                style = MaterialTheme.typography.titleLarge,
            )
            Text(
                text = stringResource(R.string.cl_enqueue_nd_range_kernel),
                fontWeight = FontWeight.Bold,
            )
            Text(stringResource(R.string.cl_enqueue_nd_range_kernel_description))
        }
    }
}

/**
 * Displays a card with information about the work-item functions in OpenCL.
 *
 * @param modifier The modifier for the layout
 */
@Composable
private fun WorkItemFunctions(modifier: Modifier = Modifier) {
    Card(modifier) {
        Column(Modifier.padding(8.dp)) {
            Text(
                text = stringResource(R.string.work_item_functions),
                style = MaterialTheme.typography.titleLarge,
            )
            GetGlobalId(Modifier.fillMaxWidth())
        }
    }
}

/**
 * Displays a card with information about the get_global_id function in OpenCL.
 *
 * @param fillMaxWidth The modifier for the layout
 */
@Composable
fun GetGlobalId(fillMaxWidth: Modifier = Modifier) {
    Card(fillMaxWidth) {
        Column(Modifier.padding(8.dp)) {
            Text(
                text = stringResource(R.string.get_global_id),
                fontWeight = FontWeight.Bold,
            )
            Text(stringResource(R.string.get_global_id_description))
        }
    }
}

/**
 * Displays a card with information about portability of OpenCL programs.
 *
 * @param modifier The modifier for the layout
 */
@Composable
private fun Portability(modifier: Modifier = Modifier) {
    Card(modifier) {
        Column(Modifier.padding(8.dp)) {
            Text(
                text = stringResource(R.string.portability),
                style = MaterialTheme.typography.titleLarge,
            )
            Text(
                text = stringResource(R.string.open_cl_portability_description)
            )
        }
    }
}

/**
 * Displays a card with information about the program components of an OpenCL program.
 */
@Composable
private fun OpenCLProgramComponents(modifier: Modifier) {
    Card(modifier) {
        Column(Modifier.padding(8.dp)) {
            Text(
                text = stringResource(R.string.open_cl_program_components),
                style = MaterialTheme.typography.titleLarge,
            )
            Text(
                text = stringResource(R.string.open_cl_program_components_description),
            )
        }
    }
}

/**
 * Displays a card with information about the memory model of OpenCL.
 *
 * @param modifier The modifier for the layout
 */
@Composable
private fun MemoryModel(modifier: Modifier = Modifier) {
    Card(modifier) {
        Column(Modifier.padding(8.dp), Arrangement.spacedBy(8.dp)) {
            Text(
                text = stringResource(R.string.memory_model),
                style = MaterialTheme.typography.titleLarge,
            )
            Row(Modifier.fillMaxWidth(), Arrangement.spacedBy(8.dp)) {
                Image(
                    painter = painterResource(
                        id = R.drawable.open_cl_memory_model
                    ),
                    modifier = Modifier.weight(1f),
                    contentDescription = null, // TODO add description
                )
            }
        }
    }
}



/**
 * Displays a previews for the GPUs screen.
 */
@PreviewLightDark
@PreviewScreenSizes
@Composable
private fun GPUsScreenPreview() {
    ComputerArchitectureTheme {
        GPUsScreen(
            navigateBack = {},
        )
    }
}
