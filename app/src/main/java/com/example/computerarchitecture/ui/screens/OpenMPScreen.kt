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
import com.example.computerarchitecture.ui.viewmodels.OpenMPViewModel


/**
 * Displays the OpenMP screen.
 *
 * @param navigateBack The function to navigate back
 * @param openMPViewModel The view model for the OpenMP screen
 * @param modifier The modifier for the layout
 */
@Composable
fun OpenMPScreen(
    navigateBack: () -> Unit,
    openMPViewModel: OpenMPViewModel,
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
            openMPViewModel.isStudyMode,
            modifier
                .padding(it)
                .padding(start = 24.dp, end = 24.dp)
        )
    }
}

/**
 * Displays the OpenMP screen.
 *
 * @param isStudyMode Whether the user is in study mode
 * @param modifier The modifier for the layout
 */
@Composable
fun OpenMPScreen(isStudyMode: Boolean, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier.verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.spacedBy(8.dp),
    ) {
        Syntax(isStudyMode, Modifier.fillMaxWidth())
        Constructs(isStudyMode, Modifier.fillMaxWidth())
        Clauses(isStudyMode, Modifier.fillMaxWidth())
        Functions(isStudyMode, Modifier.fillMaxWidth())
    }
}

/**
 * Displays a card with information about the OpenMP syntax.
 *
 * @param modifier The modifier for the layout
 */
@Composable
private fun Syntax(isStudyMode: Boolean, modifier: Modifier = Modifier) {
    var expanded by rememberSaveable { mutableStateOf(!isStudyMode) }
    Card({ expanded = !expanded }, modifier) {
        Column(Modifier.padding(8.dp)) {
            Text(
                text = stringResource(R.string.syntax),
                style = MaterialTheme.typography.titleLarge,
            )
            if (expanded) {
                Pragma(Modifier.fillMaxWidth())
            }
        }
    }
}


/**
 * Displays a card with information about OpenMP pragma.
 *
 * @param modifier The modifier for the layout
 */
@Composable
private fun Pragma(modifier: Modifier = Modifier) {
    Text(
        buildAnnotatedString {
            withStyle(SpanStyle(fontWeight = FontWeight.Bold)) {
                append("#pragma omp ")
            }
            append("construct clauses")
        },
        modifier
    )
}


/**
 * Displays a card with information about OpenMP constructs.
 *
 * @param isStudyMode Whether the user is in study mode
 * @param modifier The modifier for the layout
 */
@Composable
private fun Constructs(isStudyMode: Boolean, modifier: Modifier = Modifier) {
    var expanded by rememberSaveable { mutableStateOf(!isStudyMode) }
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
    var expanded by rememberSaveable { mutableStateOf(false) }
    Card({ expanded = !expanded }, modifier) {
        Column(Modifier.padding(8.dp)) {
            Text("parallel", fontWeight = FontWeight.Bold)
            if (expanded) {
                Text(stringResource(R.string.parallel_description))
                Image(painterResource(R.drawable.open_mp_parallel_example), null)
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
    var expanded by rememberSaveable { mutableStateOf(false) }
    Card({ expanded = !expanded }, modifier) {
        Column(Modifier.padding(8.dp)) {
            Text(
                text = "critical",
                fontWeight = FontWeight.Bold
            )
            if (expanded) {
                Text(stringResource(R.string.pragma_omp_critical_description))
            }
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
    var expanded by rememberSaveable { mutableStateOf(false) }
    Card({ expanded = !expanded }, modifier) {
        Column(Modifier.padding(8.dp)) {
            Text(
                text = "barrier",
                fontWeight = FontWeight.Bold
            )
            if (expanded) {
                Text(stringResource(R.string.barrier_description))
            }
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
    var expanded by rememberSaveable { mutableStateOf(false) }
    Card({ expanded = !expanded }, modifier) {
        Column(Modifier.padding(8.dp)) {
            Text(
                text = "atomic",
                fontWeight = FontWeight.Bold
            )
            if (expanded) {
                Text(stringResource(R.string.pragma_omp_atomic_description))
            }
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
    var expanded by rememberSaveable { mutableStateOf(false) }
    Card({ expanded = !expanded }, modifier) {
        Column(Modifier.padding(8.dp)) {
            Text(
                text = "ordered",
                fontWeight = FontWeight.Bold
            )
            if (expanded) {
                Text(stringResource(R.string.order_description))
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
    var expanded by rememberSaveable { mutableStateOf(false) }
    Card({ expanded = !expanded }, modifier) {
        Column(Modifier.padding(8.dp)) {
            Text(
                text = "single",
                fontWeight = FontWeight.Bold
            )
            if (expanded) {
                Text(stringResource(R.string.single_description))
            }
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
    var expanded by rememberSaveable { mutableStateOf(false) }
    Card({ expanded = !expanded }, modifier) {
        Column(Modifier.padding(8.dp)) {
            Text(
                text = "master",
                fontWeight = FontWeight.Bold
            )
            if (expanded) {
                Text(stringResource(R.string.master_description))
            }
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
    var expanded by rememberSaveable { mutableStateOf(false) }
    Card({ expanded = !expanded }, modifier) {
        Column(Modifier.padding(8.dp)) {
            Text(
                text = "for",
                fontWeight = FontWeight.Bold
            )
            if (expanded) {
                Text(stringResource(R.string.for_description))
            }
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
    var expanded by rememberSaveable { mutableStateOf(false) }
    Card({ expanded = !expanded }, modifier) {
        Column(Modifier.padding(8.dp)) {
            Text("sections", fontWeight = FontWeight.Bold)
            if (expanded) {
                Text(stringResource(R.string.sections_description))
                Image(painterResource(R.drawable.open_mp_sections_example), null)
            }
        }
    }
}

/**
 * Displays a card with information about OpenMP clauses.
 *
 * @param isStudyMode Whether the user is in study mode
 * @param modifier The modifier for the layout
 */
@Composable
private fun Clauses(isStudyMode: Boolean, modifier: Modifier = Modifier) {
    var expanded by rememberSaveable { mutableStateOf(!isStudyMode) }
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
    var expanded by rememberSaveable { mutableStateOf(false) }
    Card({ expanded = !expanded }, modifier) {
        Column(Modifier.padding(8.dp)) {
            Text(
                text = stringResource(R.string.default_syntax),
                fontWeight = FontWeight.Bold
            )
            if (expanded) {
                Text(stringResource(R.string.default_description))
            }
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
    var expanded by rememberSaveable { mutableStateOf(false) }
    Card({ expanded = !expanded }, modifier) {
        Column(Modifier.padding(8.dp)) {
            Text(
                text = stringResource(R.string.shared_syntax),
                fontWeight = FontWeight.Bold
            )
            if (expanded) {
                Text(stringResource(R.string.shared_description))
            }
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
    var expanded by rememberSaveable { mutableStateOf(false) }
    Card({ expanded = !expanded }, modifier) {
        Column(Modifier.padding(8.dp)) {
            Text(
                text = stringResource(R.string.private_syntax),
                fontWeight = FontWeight.Bold
            )
            if (expanded) {
                Text(stringResource(R.string.private_description))
            }
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
    var expanded by rememberSaveable { mutableStateOf(false) }
    Card({ expanded = !expanded }, modifier) {
        Column(Modifier.padding(8.dp)) {
            Text(
                text = stringResource(R.string.reduction_syntax),
                fontWeight = FontWeight.Bold
            )
            if (expanded) {
                Text(stringResource(R.string.reduction_description))
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
    var expanded by rememberSaveable { mutableStateOf(false) }
    Card({ expanded = !expanded }, modifier) {
        Column(Modifier.padding(8.dp)) {
            Text(
                text = stringResource(R.string.no_wait_syntax),
                fontWeight = FontWeight.Bold
            )
            if (expanded) {
                Text(stringResource(R.string.no_wait_description))
            }
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
    var expanded by rememberSaveable { mutableStateOf(false) }
    Card({ expanded = !expanded }, modifier) {
        Column(Modifier.padding(8.dp)) {
            Text(
                text = stringResource(R.string.num_threads_syntax),
                fontWeight = FontWeight.Bold
            )
            if (expanded) {
                Text(stringResource(R.string.num_threads_description))
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
private fun Schedule(modifier: Modifier = Modifier) {
    var expanded by rememberSaveable { mutableStateOf(false) }
    Card({ expanded = !expanded }, modifier) {
        Column(Modifier.padding(8.dp), Arrangement.spacedBy(8.dp)) {
            Text(
                text = "schedule(schedule_kind, chunk_size)",
                fontWeight = FontWeight.Bold
            )
            if (expanded) {
                Text(stringResource(R.string.schedule_pragma_description))
            }
        }
    }
}

/**
 * Displays a card with information about the OpenMP functions.
 *
 * @param isStudyMode Whether the user is in study mode
 * @param modifier The modifier for the layout
 */
@Composable
private fun Functions(isStudyMode: Boolean, modifier: Modifier = Modifier) {
    var expanded by rememberSaveable { mutableStateOf(!isStudyMode) }
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
    var expanded by rememberSaveable { mutableStateOf(false) }
    Card({ expanded = !expanded }, modifier) {
        Column(Modifier.padding(8.dp)) {
            Text(
                text = stringResource(R.string.set_num_threads),
                fontWeight = FontWeight.Bold,
            )
            if (expanded) {
                Text(stringResource(R.string.set_num_threads_description))
            }
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
    var expanded by rememberSaveable { mutableStateOf(false) }
    Card({ expanded = !expanded }, modifier) {
        Column(Modifier.padding(8.dp)) {
            Text(
                text = stringResource(R.string.get_num_threads),
                fontWeight = FontWeight.Bold,
            )
            if (expanded) {
                Text(stringResource(R.string.get_num_threads_description))
                Image(painter = painterResource(R.drawable.open_mp_get_num_threads_example), null)
            }
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
    var expanded by rememberSaveable { mutableStateOf(false) }
    Card({ expanded = !expanded }, modifier) {
        Column(Modifier.padding(8.dp)) {
            Text(
                text = stringResource(R.string.get_thread_num),
                fontWeight = FontWeight.Bold,
            )
            if (expanded) {
                Text(stringResource(R.string.get_thread_num_description))
            }
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
        OpenMPScreen(false)
    }
}