package com.example.computerarchitecture.ui.screens

import androidx.compose.foundation.Image
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
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
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
        Syntax(Modifier.fillMaxWidth())
        Constructs(Modifier.fillMaxWidth())
        Clauses(Modifier.fillMaxWidth())
        Functions(Modifier.fillMaxWidth())
    }
}

/**
 * Displays a card with information about the OpenMP syntax.
 *
 * @param modifier The modifier for the layout
 */
@Composable
private fun Syntax(modifier: Modifier = Modifier) {
    var expanded by rememberSaveable { mutableStateOf(false) }
    Card({ expanded = !expanded }, modifier) {
        Column(Modifier.padding(8.dp), Arrangement.spacedBy(8.dp)) {
            Text(
                text = stringResource(R.string.syntax),
                style = MaterialTheme.typography.titleLarge,
            )
            if (expanded) {
                Text(
                    buildAnnotatedString {
                        withStyle(SpanStyle(fontWeight = FontWeight.Bold)) {
                            append("#pragma omp ")
                        }
                        append("construct clauses")
                    }
                )
            }
        }
    }
}

/**
 * Displays a card with information about OpenMP constructs.
 */
@Composable
private fun Constructs(modifier: Modifier = Modifier) {
    var expanded by rememberSaveable { mutableStateOf(false) }
    Card({ expanded = !expanded }, modifier) {
        Column(Modifier.padding(8.dp), Arrangement.spacedBy(8.dp)) {
            Text(
                stringResource(R.string.constructs),
                style = MaterialTheme.typography.titleLarge,
            )
            if (expanded) {
                Parallel(Modifier.fillMaxWidth())
                Critical(Modifier.fillMaxWidth())
                Barrier(Modifier.fillMaxWidth())
                Atomic(Modifier.fillMaxWidth())
                Ordered(Modifier.fillMaxWidth())
                Single(Modifier.fillMaxWidth())
                Master(Modifier.fillMaxWidth())
                For(Modifier.fillMaxWidth())
                Sections(Modifier.fillMaxWidth())
            }
        }
    }
}

/**
 * Displays a card with information about the parallel construct.
 *
 * @param modifier The modifier for the layout
 */
@Composable
private fun Parallel(modifier: Modifier = Modifier) {
    Card(modifier) {
        Column(Modifier.padding(8.dp)) {
            Text("parallel", fontWeight = FontWeight.Bold)
            Text(stringResource(R.string.parallel_description))

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
                text = "critical",
                fontWeight = FontWeight.Bold
            )
            Text(stringResource(R.string.pragma_omp_critical_description))
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
                text = "barrier",
                fontWeight = FontWeight.Bold
            )
            Text(stringResource(R.string.barrier_description))
        }
    }
}

/**
 * Displays a card with information about the atomic construct.
 *
 * @param modifier The modifier for the layout
 */
@Composable
private fun Atomic(modifier: Modifier = Modifier) {
    Card(modifier) {
        Column(Modifier.padding(8.dp)) {
            Text(
                text = "atomic",
                fontWeight = FontWeight.Bold
            )
            Text(stringResource(R.string.pragma_omp_atomic_description))
        }
    }
}

/**
 * Displays a card with information about the ordered construct.
 *
 * @param modifier The modifier for the layout
 */
@Composable
private fun Ordered(modifier: Modifier = Modifier) {
    var showExample by rememberSaveable { mutableStateOf(false) }
    Card(modifier) {
        Column(Modifier.padding(8.dp)) {
            Text(
                text = "ordered",
                fontWeight = FontWeight.Bold
            )
            Text(stringResource(R.string.order_description))
            TextButton(onClick = { showExample = !showExample }) {
                Text(stringResource(R.string.example))
            }

            if (showExample) {
                Image(painter = painterResource(R.drawable.open_mp_ordered_example), null)
            }
        }
    }
}

/**
 * Displays a card with information about the single construct.
 *
 * @param modifier The modifier for the layout
 */
@Composable
private fun Single(modifier: Modifier = Modifier) {
    Card(modifier) {
        Column(Modifier.padding(8.dp)) {
            Text(
                text = "single",
                fontWeight = FontWeight.Bold
            )
            Text(stringResource(R.string.single_description))
        }
    }
}

/**
 * Displays a card with information about the master construct.
 *
 * @param modifier The modifier for the layout
 */
@Composable
private fun Master(modifier: Modifier = Modifier) {
    Card(modifier) {
        Column(Modifier.padding(8.dp)) {
            Text(
                text = "master",
                fontWeight = FontWeight.Bold
            )
            Text(stringResource(R.string.master_description))
        }
    }
}


/**
 * Displays a card with information about the for construct.
 *
 * @param modifier The modifier for the layout
 */
@Composable
private fun For(modifier: Modifier = Modifier) {
    Card(modifier) {
        Column(Modifier.padding(8.dp)) {
            Text(
                text = "for",
                fontWeight = FontWeight.Bold
            )
            Text(stringResource(R.string.for_description))
        }
    }
}

/**
 * Displays a card with information about the sections construct.
 *
 * @param modifier The modifier for the layout
 */
@Composable
private fun Sections(modifier: Modifier = Modifier) {
    var showExample by rememberSaveable { mutableStateOf(false) }
    Card(modifier) {
        Column(Modifier.padding(8.dp)) {
            Text("sections", fontWeight = FontWeight.Bold)
            Text(stringResource(R.string.sections_description))
            TextButton(onClick = { showExample = !showExample }) {
                Text(stringResource(R.string.example))
            }
            if (showExample) {
                Image(painterResource(R.drawable.open_mp_sections_example), null)
            }
        }
    }
}

/**
 * Displays a card with information about OpenMP clauses.
 *
 * @param modifier The modifier for the layout
 */
@Composable
private fun Clauses(modifier: Modifier = Modifier) {
    var expanded by rememberSaveable { mutableStateOf(false) }
    Card({ expanded = !expanded }, modifier) {
        Column(Modifier.padding(8.dp), Arrangement.spacedBy(8.dp)) {
            Text(
                stringResource(R.string.clauses),
                style = MaterialTheme.typography.titleLarge
            )
            if (expanded) {
                Default(Modifier.fillMaxWidth())
                Shared(Modifier.fillMaxWidth())
                Private(Modifier.fillMaxWidth())
                Reduction(Modifier.fillMaxWidth())
                NoWait(Modifier.fillMaxWidth())
                NumThread(Modifier.fillMaxWidth())
                Schedule(Modifier.fillMaxWidth())
            }
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
private fun Reduction(modifier: Modifier = Modifier) {
    var showExample by rememberSaveable { mutableStateOf(false) }
    Card(modifier) {
        Column(Modifier.padding(8.dp)) {
            Text(
                text = stringResource(R.string.reduction_syntax),
                fontWeight = FontWeight.Bold
            )
            Text(stringResource(R.string.reduction_description))
            TextButton(onClick = { showExample = !showExample }) {
                Text(stringResource(R.string.example))
            }
            if (showExample) {
                Image(painter = painterResource(R.drawable.open_mp_reduction_example), null)
            }
        }
    }
}

/**
 * Displays a card with information about the nowait clause.
 *
 * @param modifier The modifier for the layout
 */
@Composable
private fun NoWait(modifier: Modifier = Modifier) {
    Card(
        modifier
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

/**
 * Displays a card with information about the num_threads clause.
 *
 * @param modifier The modifier for the layout
 */
@Composable
private fun NumThread(modifier: Modifier = Modifier) {
    Card(
        modifier
    ) {
        Column(Modifier.padding(8.dp)) {
            Text(
                text = stringResource(R.string.num_threads_syntax),
                fontWeight = FontWeight.Bold
            )
            Text(stringResource(R.string.num_threads_description))
        }
    }
}

/**
 * Displays a card with information about the schedule clause.
 *
 * @param modifier The modifier for the layout
 */
@Composable
private fun Schedule(modifier: Modifier = Modifier) {
    Card(modifier) {
        Column(Modifier.padding(8.dp), Arrangement.spacedBy(8.dp)) {
            Text(
                text = "schedule(schedule_kind, chunk_size)",
                fontWeight = FontWeight.Bold
            )
            Text(stringResource(R.string.schedule_pragma_description))
        }
    }
}

/**
 * Displays a card with information about the OpenMP functions.
 *
 * @param modifier The modifier for the layout
 */
@Composable
private fun Functions(modifier: Modifier = Modifier) {
    var expanded by rememberSaveable { mutableStateOf(false) }
    Card({ expanded = !expanded }, modifier) {
        Column(Modifier.padding(8.dp), Arrangement.spacedBy(8.dp)) {
            Text(
                text = stringResource(R.string.functions),
                style = MaterialTheme.typography.titleLarge,
            )
            if (expanded) {
                SetNumThreads(Modifier.fillMaxWidth())
                GetNumThreads(Modifier.fillMaxWidth())
                GetThreadNum(Modifier.fillMaxWidth())
            }
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

/**
 * Displays a card with information about the omp_get_thread_num function.
 *
 * @param modifier The modifier for the layout
 */
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