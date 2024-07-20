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
 * Displays the OpenMP screen.
 *
 * @param navigateBack The function to navigate back
 * @param modifier The modifier for the layout
 */
@Composable
fun OpenMPScreen(
    navigateBack: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Scaffold(
        modifier = modifier,
        topBar = {
            TopicTopBar(
                title = stringResource(R.string.open_mp),
                navigateBack = navigateBack
            )
        },
    ) {
        OpenMPScreen(
            modifier
                .padding(it)
                .padding(start = 24.dp, end = 24.dp)
        )
    }
}

/**
 * Displays the OpenMP screen.
 *
 * @param modifier The modifier for the layout
 */
@Composable
fun OpenMPScreen(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier.verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.spacedBy(8.dp),
    ) {
        ParallelDirective(Modifier.fillMaxWidth())
        ScheduleClause(Modifier.fillMaxWidth())
        SynchronizationConstructs(Modifier.fillMaxWidth())
        LibraryFunctions(Modifier.fillMaxWidth())
        DataSharingClauses(Modifier.fillMaxWidth())
        ReductionClause(Modifier.fillMaxWidth())
        NoWaitClause(Modifier.fillMaxWidth())
        WorkSharingConstructs(Modifier.fillMaxWidth())

    }
}

/**
 * Displays a card with information about the parallel directive.
 *
 * @param modifier The modifier for the layout
 */
@Composable
private fun ParallelDirective(modifier: Modifier = Modifier) {
    Card(modifier) {
        Column(Modifier.padding(8.dp), Arrangement.spacedBy(8.dp)) {
            Text(
                text = stringResource(R.string.parallel_directive),
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.Bold,
            )
            Card(Modifier.fillMaxWidth()) {
                Column(Modifier.padding(8.dp)) {
                    Text(
                        text = stringResource(R.string.parallel_syntax),
                        fontWeight = FontWeight.Bold
                    )
                    Text(stringResource(R.string.parallel_description))
                }
            }
        }
    }
}


/**
 * Displays a card with information about the schedule clause.
 *
 * @param modifier The modifier for the layout
 */
@Composable
private fun ScheduleClause(modifier: Modifier = Modifier) {
    Card(modifier) {
        Column(Modifier.padding(8.dp), Arrangement.spacedBy(8.dp)) {
            Text(
                text = stringResource(R.string.schedule_clause),
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.Bold
            )
            Card(Modifier.fillMaxWidth()) {
                Column(Modifier.padding(8.dp)) {
                    Text(
                        text = stringResource(R.string.schedule_syntax),
                        fontWeight = FontWeight.Bold
                    )
                    Text(stringResource(R.string.schedule_pragma_description))
                }
            }
        }
    }
}

/**
 * Displays a card with information about #pragma omp critical
 *
 * @param modifier The modifier for the layout
 */
@Composable
private fun Critical(modifier: Modifier = Modifier) {
    Card(modifier) {
        Column(Modifier.padding(8.dp)) {
            Text(
                text = stringResource(R.string.pragma_omp_critical),
                fontWeight = FontWeight.Bold
            )
            Text(stringResource(R.string.pragma_omp_critical_description))
        }
    }
}

/**
 * Displays a card with information about #pragma omp atomic.
 *
 * @param modifier The modifier for the layout
 */
@Composable
private fun Atomic(modifier: Modifier = Modifier) {
    Card(modifier) {
        Column(Modifier.padding(8.dp)) {
            Text(
                text = stringResource(R.string.pragma_omp_atomic),
                fontWeight = FontWeight.Bold
            )
            Text(stringResource(R.string.pragma_omp_atomic_description))
        }
    }
}

/**
 * Displays a card with information about synchronization constructs.
 *
 * @param modifier The modifier for the layout
 */
@Composable
private fun SynchronizationConstructs(modifier: Modifier = Modifier) {
    Card(modifier) {
        Column(Modifier.padding(8.dp), verticalArrangement = Arrangement.spacedBy(8.dp)) {
            Text(
                text = stringResource(R.string.synchronization_constructs),
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.Bold
            )
            Critical(Modifier.fillMaxWidth())
            Barrier(Modifier.fillMaxWidth())
            Atomic(Modifier.fillMaxWidth())
            Ordered(Modifier.fillMaxWidth())
        }
    }
}

/**
 * Displays a card with information about the barrier construct.
 *
 * @param modifier The modifier for the layout
 */
@Composable
private fun Barrier(modifier: Modifier = Modifier) {
    Card(modifier) {
        Column(Modifier.padding(8.dp)) {
            Text(
                text = stringResource(R.string.barrier_syntax),
                fontWeight = FontWeight.Bold
            )
            Text(stringResource(R.string.barrier_description))
        }
    }
}

/**
 * Displays a card with information about the OpenMP library functions.
 *
 * @param modifier The modifier for the layout
 */
@Composable
private fun LibraryFunctions(modifier: Modifier = Modifier) {
    Card(modifier) {
        Column(Modifier.padding(8.dp), verticalArrangement = Arrangement.spacedBy(8.dp)) {
            Text(
                text = stringResource(R.string.library_functions),
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.Bold
            )
            SetNumThreads(Modifier.fillMaxWidth())
            GetNumThreads(Modifier.fillMaxWidth())
            GetThreadNum(Modifier.fillMaxWidth())
        }
    }
}

/**
 * Displays a card with information about the omp_set_num_threads function.
 *
 * @param modifier The modifier for the layout
 */
@Composable
private fun SetNumThreads(modifier: Modifier = Modifier) {
    Card(modifier) {
        Column(Modifier.padding(8.dp)) {
            Text(
                text = stringResource(R.string.set_num_threads),
                fontWeight = FontWeight.Bold,
            )
            Text(stringResource(R.string.set_num_threads_description))
        }
    }
}

/**
 * Displays a card with information about the omp_get_num_threads function.
 *
 * @param modifier The modifier for the layout
 */
@Composable
private fun GetNumThreads(modifier: Modifier = Modifier) {
    Card(modifier) {
        Column(Modifier.padding(8.dp)) {
            Text(
                text = stringResource(R.string.get_num_threads),
                fontWeight = FontWeight.Bold,
            )
            Text(stringResource(R.string.get_num_threads_description))
        }
    }
}

@Composable
private fun GetThreadNum(modifier: Modifier = Modifier) {
    Card(modifier) {
        Column(Modifier.padding(8.dp)) {
            Text(
                text = stringResource(R.string.get_thread_num),
                fontWeight = FontWeight.Bold,
            )
            Text(stringResource(R.string.get_thread_num_description))
        }
    }
}

/**
 * Displays a card with information about data sharing clauses.
 *
 * @param modifier The modifier for the layout
 */
@Composable
private fun DataSharingClauses(modifier: Modifier = Modifier) {
    Card(modifier) {
        Column(Modifier.padding(8.dp), Arrangement.spacedBy(8.dp)) {
            Text(
                text = stringResource(R.string.data_sharing_clauses),
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.Bold
            )
            Default(Modifier.fillMaxWidth())
            Shared(Modifier.fillMaxWidth())
            Private(Modifier.fillMaxWidth())
        }
    }
}

/**
 * Displays a card with information about the default clause.
 *
 * @param modifier The modifier for the layout
 */
@Composable
private fun Default(modifier: Modifier = Modifier) {
    Card(modifier) {
        Column(Modifier.padding(8.dp)) {
            Text(
                text = stringResource(R.string.default_syntax),
                fontWeight = FontWeight.Bold
            )
            Text(stringResource(R.string.default_description))
        }
    }
}

/**
 * Displays a card with information about the shared clause
 *
 * @param modifier The modifier for the layout
 */
@Composable
private fun Shared(modifier: Modifier = Modifier) {
    Card(modifier) {
        Column(Modifier.padding(8.dp)) {
            Text(
                text = stringResource(R.string.shared_syntax),
                fontWeight = FontWeight.Bold
            )
            Text(stringResource(R.string.shared_description))
        }
    }
}

/**
 * Displays a card with information about the private clause.
 *
 * @param modifier The modifier for the layout
 */
@Composable
private fun Private(modifier: Modifier = Modifier) {
    Card(modifier) {
        Column(Modifier.padding(8.dp)) {
            Text(
                text = stringResource(R.string.private_syntax),
                fontWeight = FontWeight.Bold
            )
            Text(stringResource(R.string.private_description))
        }
    }
}

/**
 * Displays a card with information about the reduction clause.
 *
 * @param modifier The modifier for the layout
 */
@Composable
private fun ReductionClause(modifier: Modifier = Modifier) {
    Card(modifier) {
        Column(Modifier.padding(8.dp)) {
            Text(
                text = stringResource(R.string.reduction_clause),
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.Bold
            )
            Card(
                Modifier.fillMaxWidth()
            ) {
                Column(Modifier.padding(8.dp)) {
                    Text(
                        text = stringResource(R.string.reduction_syntax),
                        fontWeight = FontWeight.Bold
                    )
                    Text(stringResource(R.string.reduction_description))
                }
            }
        }
    }
}

/**
 * Displays a card with information about the nowait clause
 *
 * @param modifier The modifier for the layout
 */
@Composable
private fun NoWaitClause(modifier: Modifier = Modifier) {
    Card(modifier) {
        Column(Modifier.padding(8.dp)) {
            Text(
                text = stringResource(R.string.no_wait_clause),
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.Bold
            )
            Card(
                Modifier.fillMaxWidth()
            ) {
                Column(Modifier.padding(8.dp)) {
                    Text(
                        text = stringResource(R.string.no_wait_syntax),
                        fontWeight = FontWeight.Bold
                    )
                    Text(stringResource(R.string.no_wait_description))
                }
            }
        }
    }
}

/**
 * Displays a card with information about the ordered clause.
 *
 * @param modifier The modifier for the layout
 */
@Composable
private fun Ordered(modifier: Modifier = Modifier) {
    Card(modifier) {
        Column(Modifier.padding(8.dp)) {
            Text(
                text = stringResource(R.string.ordered_syntax),
                fontWeight = FontWeight.Bold
            )
            Text(stringResource(R.string.order_description))
        }
    }
}

/**
 * Displays a card with information about work sharing constructs.
 *
 * @param modifier The modifier for the layout
 */
@Composable
private fun WorkSharingConstructs(modifier: Modifier = Modifier) {
    Card(modifier) {
        Column(Modifier.padding(8.dp), Arrangement.spacedBy(8.dp)) {
            Text(
                text = stringResource(R.string.work_sharing_constructs),
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.Bold
            )
            Single(Modifier.fillMaxWidth())
            Master(Modifier.fillMaxWidth())
            For(Modifier.fillMaxWidth())
            Sections(Modifier.fillMaxWidth())
        }
    }
}

/**
 * Displays a card with information about #pragma omp single
 *
 * @param modifier The modifier for the layout
 */
@Composable
private fun Single(modifier: Modifier = Modifier) {
    Card(modifier) {
        Column(Modifier.padding(8.dp)) {
            Text(
                text = stringResource(R.string.single_syntax),
                fontWeight = FontWeight.Bold
            )
            Text(stringResource(R.string.single_description))
        }
    }
}

/**
 * Displays a card with information about #pragma omp master
 *
 * @param modifier The modifier for the layout
 */
@Composable
private fun Master(modifier: Modifier = Modifier) {
    Card(modifier) {
        Column(Modifier.padding(8.dp)) {
            Text(
                text = stringResource(R.string.master_syntax),
                fontWeight = FontWeight.Bold
            )
            Text(stringResource(R.string.master_description))
        }
    }
}


/**
 * Displays a card with information about #pragma omp parallel for.
 *
 * @param modifier The modifier for the layout
 */
@Composable
private fun For(modifier: Modifier = Modifier) {
    Card(modifier) {
        Column(Modifier.padding(8.dp)) {
            Text(
                text = stringResource(R.string.pragma_omp_parallel_for),
                fontWeight = FontWeight.Bold
            )
            Text(stringResource(R.string.parallel_for_pragma_description))
        }
    }
}

/**
 * Displays a card with information about #pragma omp sections.
 *
 * @param modifier The modifier for the layout
 */
@Composable
private fun Sections(modifier: Modifier = Modifier) {
    Card(modifier) {
        Column(Modifier.padding(8.dp)) {
            Text(
                text = stringResource(R.string.sections_syntax),
                fontWeight = FontWeight.Bold
            )
            Text(stringResource(R.string.sections_description))
        }
    }
}

/**
 * Displays previews for the OpenMP screen.
 */
@PreviewLightDark
@PreviewScreenSizes
@Composable
private fun OpenMPScreenPreview() {
    ComputerArchitectureTheme {
        OpenMPScreen(
            navigateBack = {},
        )
    }
}