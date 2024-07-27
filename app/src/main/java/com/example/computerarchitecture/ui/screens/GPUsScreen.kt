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
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.tooling.preview.PreviewScreenSizes
import androidx.compose.ui.unit.dp
import com.example.computerarchitecture.R
import com.example.computerarchitecture.openWebsite
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
@Composable
fun GPUsScreen(modifier: Modifier = Modifier) {
    var state by rememberSaveable { mutableIntStateOf(0) }
    val titles = listOf(R.string.open_cl, R.string.gpus_vs_cpus)

    Column(modifier.fillMaxWidth()) {
        TabRow(selectedTabIndex = state) {
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

            1 -> GPUsVsCPUs(
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
        MemoryModel(Modifier.fillMaxWidth())
        OpenCLComputationModel(Modifier.fillMaxWidth())
        OpenCLProgramComponents(Modifier.fillMaxWidth())
        FunctionQualifiers(Modifier.fillMaxWidth())
        ExecutingKernels(Modifier.fillMaxWidth())
        Functions(Modifier.fillMaxWidth())
        SynchronizationAccrossWorkGroups(Modifier.fillMaxWidth())
        Portability(Modifier.fillMaxWidth())
        Flags(Modifier.fillMaxWidth())
    }
}

/**
 * Displays a card with information about synchronization across work groups in OpenCL.
 *
 * @param modifier The modifier for the layout
 */
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

/**
 * Displays a card with information about clEnqueueNDRangeKernel.
 *
 * @param modifier The modifier for the layout
 */
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
 * Displays a card with information about function qualifiers in OpenCL.
 *
 * @param modifier The modifier for the layout
 */
@Composable
private fun FunctionQualifiers(modifier: Modifier = Modifier) {
    Card(modifier) {
        Column(Modifier.padding(8.dp)) {
            Text(
                text = stringResource(R.string.function_qualifiers),
                style = MaterialTheme.typography.titleLarge,
            )
            Text(
                text = stringResource(R.string.kernel),
                style = MaterialTheme.typography.titleMedium,
            )

            Text(
                text = stringResource(R.string.kernel_description),
            )
        }
    }
}

/**
 * Displays a card with information about the work-item functions in OpenCL.
 *
 * @param modifier The modifier for the layout
 */
@Composable
private fun Functions(modifier: Modifier = Modifier) {
    val context = LocalContext.current
    Card(modifier) {
        Column(Modifier.padding(8.dp), Arrangement.spacedBy(8.dp)) {
            Text(
                text = stringResource(R.string.functions),
                style = MaterialTheme.typography.titleLarge,
            )
            GetGlobalId(Modifier.fillMaxWidth())
            Barrier(Modifier.fillMaxWidth())
            MemFence(Modifier.fillMaxWidth())
            CreateBuffer(Modifier.fillMaxWidth())
            EnqueueMapBuffer(Modifier.fillMaxWidth())
        }
    }
}

/**
 * Displays a card with information about barriers in OpenCL.
 *
 * @param modifier The modifier for the layout
 */
@Composable
private fun Barrier(modifier: Modifier = Modifier) {
    Card(modifier) {
        Column(Modifier.padding(8.dp)) {
            Text(
                text = stringResource(R.string.open_cl_barrier_syntax),
                fontWeight = FontWeight.Bold,
            )
            Text(
                text = stringResource(R.string.open_cl_barrier_description),
            )
        }
    }
}

/**
 * Displays a card with information about memory fences in OpenCL.
 *
 * @param modifier The modifier for the layout
 */
@Composable
private fun MemFence(modifier: Modifier = Modifier) {
    Card(modifier) {
        Column(Modifier.padding(8.dp)) {
            Text(
                text = stringResource(R.string.open_cl_mem_fence_syntax),
                fontWeight = FontWeight.Bold,
            )
            Text(
                text = stringResource(R.string.open_cl_mem_fence_description),
            )
        }
    }
}

/**
 * Displays a card with information about the get_global_id function in OpenCL.
 *
 * @param modifier The modifier for the layout
 */
@Composable
fun GetGlobalId(modifier: Modifier = Modifier) {
    Card(modifier) {
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
 * Displays a card with information about creating a buffer in OpenCL.
 *
 * @param modifier The modifier for the layout
 */
@Composable
private fun CreateBuffer(modifier: Modifier = Modifier) {
    Card(modifier) {
        Column(Modifier.padding(8.dp)) {
            Text(
                text = "clCreateBuffer(context, flags, size, host_ptr, errcode_ret)",
                fontWeight = FontWeight.Bold,
            )
            Text(
                text = stringResource(R.string.open_cl_create_buffer_description),
            )
        }
    }
}

/**
 * Displays a card with information about enqueuing a map buffer in OpenCL.
 *
 * @param modifier The modifier for the layout
 */
@Composable
private fun EnqueueMapBuffer(modifier: Modifier = Modifier) {
    Card(modifier) {
        Column(Modifier.padding(8.dp)) {
            Text(
                "clEnqueueMapBuffer(queue, buffer, blocking_map, map_flags, offset, size, " +
                        "num_events_in_wait_list, event_wait_list, event)",
                fontWeight = FontWeight.Bold
            )
            Text(
                text = stringResource(R.string.open_cl_enqueue_map_buffer_description),
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
 * Displays a card with information about synchronization across work groups in OpenCL.
 *
 * @param modifier The modifier for the layout
 */
@Composable
private fun SynchronizationAccrossWorkGroups(modifier: Modifier) {
    Card(modifier) {
        Column(Modifier.padding(8.dp)) {
            Text(
                text = stringResource(R.string.synchronization_across_work_groups),
                style = MaterialTheme.typography.titleLarge,
            )
            Text(
                text = stringResource(R.string.synchronization_across_work_groups_description),
            )
        }
    }
}

/**
 * Displays a card with information about GPUs vs CPUs.
 *
 * @param modifier The modifier for the layout
 */
@Composable
private fun GPUsVsCPUs(modifier: Modifier = Modifier) {
    Card(modifier) {
        Column(Modifier.padding(8.dp)) {
            Text(
                text = stringResource(R.string.gpus_vs_cpus),
                style = MaterialTheme.typography.titleLarge,
            )
            Text(
                text = stringResource(R.string.gpu),
                fontWeight = FontWeight.Bold,
            )
            Text(
                text = stringResource(R.string.gpu_description),
            )
            Text(
                text = stringResource(R.string.cpu),
                fontWeight = FontWeight.Bold,
            )
            Text(
                text = stringResource(R.string.cpu_description),
            )
        }
    }
}

/**
 * Displays a card with information about flags.
 */
@Composable
private fun Flags(modifier: Modifier = Modifier) {
    val context = LocalContext.current
    var expanded by rememberSaveable { mutableStateOf(true) }
    Card({ expanded = !expanded }, modifier) {
        Column(Modifier.padding(8.dp), Arrangement.spacedBy(8.dp)) {
            Text(
                stringResource(R.string.flags),
                style = MaterialTheme.typography.titleLarge
            )
            if (expanded) {
                TextButton(onClick = {
                    openWebsite(
                        url = "https://registry.khronos.org/OpenCL/specs/" +
                                "3.0-unified/html/OpenCL_API.html#memory-flags-table",
                        context = context
                    )
                }) {
                    Text(stringResource(R.string.memory_flags))
                }
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
