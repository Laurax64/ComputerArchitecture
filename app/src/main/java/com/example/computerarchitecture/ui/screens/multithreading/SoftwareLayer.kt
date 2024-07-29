package com.example.computerarchitecture.ui.screens.multithreading

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.tooling.preview.PreviewScreenSizes
import androidx.compose.ui.unit.dp
import com.example.computerarchitecture.R
import com.example.computerarchitecture.openWebsite
import com.example.computerarchitecture.ui.theme.ComputerArchitectureTheme

/**
 * Displays the software layer tab, including descriptions for POSIX threads.
 *
 * @param modifier The modifier for the layout
 * @param isStudyMode Whether the user is in study mode
 */
@Composable
fun SoftwareLayer(modifier: Modifier = Modifier, isStudyMode: Boolean) {
    Column(
        modifier = modifier.verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.spacedBy(8.dp),
    ) {
        Text(
            text = stringResource(R.string.posix_threads),
            style = MaterialTheme.typography.titleLarge,
            fontWeight = FontWeight.Bold
        )
        ThreadManagement(isStudyMode, Modifier.fillMaxWidth())
        MutexVariables(isStudyMode, Modifier.fillMaxWidth())
        ConditionVariables(isStudyMode, Modifier.fillMaxWidth())
    }
}

/**
 * Displays a card with information about POSIX thread management.
 *
 * @param isStudyMode Whether the user is in study mode
 * @param modifier The modifier for the layout
 */
@Composable
private fun ThreadManagement(isStudyMode: Boolean, modifier: Modifier = Modifier) {
    var expanded by rememberSaveable { mutableStateOf(!isStudyMode) }
    Card({ expanded = !expanded }, modifier) {
        Column(Modifier.padding(8.dp), Arrangement.spacedBy(8.dp)) {
            Text(
                text = stringResource(R.string.thread_management),
                style = MaterialTheme.typography.titleLarge
            )
            if (expanded) {
                PThreadCreation(Modifier.fillMaxWidth())
                PThreadExit(Modifier.fillMaxWidth())
                PThreadJoin(Modifier.fillMaxWidth())
                PthreadCancel(Modifier.fillMaxWidth())
            }
        }
    }
}


/**
 * Displays a card with information about mutex variables.
 *
 * @param isStudyMode Whether the user is in study mode
 * @param modifier The modifier for the layout
 */
@Composable
private fun MutexVariables(isStudyMode: Boolean, modifier: Modifier = Modifier) {
    var expanded by rememberSaveable { mutableStateOf(!isStudyMode) }
    Card({ expanded = !expanded }, modifier) {
        Column(Modifier.padding(8.dp), Arrangement.spacedBy(8.dp)) {
            Text(
                text = stringResource(R.string.mutex_variables),
                style = MaterialTheme.typography.titleLarge
            )
            if (expanded) {
                PthreadMutexInit(Modifier.fillMaxWidth())
                PthreadMutexDestroy(Modifier.fillMaxWidth())
                PthreadMutexLock(Modifier.fillMaxWidth())
                PthreadMutexUnlock(Modifier.fillMaxWidth())
            }
        }
    }
}

/**
 * Displays a card with information about condition variables.
 *
 * @param isStudyMode Whether the user is in study mode
 * @param modifier The modifier for the layout
 */
@Composable
private fun ConditionVariables(isStudyMode: Boolean, modifier: Modifier = Modifier) {
    val context = LocalContext.current
    var expanded by rememberSaveable { mutableStateOf(!isStudyMode) }
    Card({ expanded = !expanded }, modifier) {
        Column(Modifier.padding(8.dp), Arrangement.spacedBy(8.dp)) {
            Text(
                text = stringResource(R.string.condition_variables),
                style = MaterialTheme.typography.titleLarge
            )
            if (expanded) {
                PthreadConditionInit(Modifier.fillMaxWidth())
                PthreadConditionSignal(Modifier.fillMaxWidth())
                PthreadConditionWait(Modifier.fillMaxWidth())
                TextButton({ openWebsite("https://onlinegdb.com/dQ0pXnZVv", context) }) {
                    Text(stringResource(R.string.example))
                }
            }
        }
    }
}

/**
 * Displays a card with information about pthread_create.
 *
 * @param modifier The modifier for the layout
 */
@Composable
private fun PThreadCreation(modifier: Modifier = Modifier) {
    val context = LocalContext.current
    Card(modifier) {
        Column(Modifier.padding(8.dp)) {
            Text(
                text = stringResource(R.string.pthread_create),
                fontWeight = FontWeight.Bold,
            )
            Text(stringResource(R.string.pthread_create_description))
            TextButton(
                { openWebsite("https://onlinegdb.com/lDcvdpNdK", context) },
            ) {
                Text(stringResource(R.string.example))
            }
        }
    }
}

/**
 * Displays a card with information about pthread_exit.
 *
 * @param modifier The modifier for the layout
 */
@Composable
private fun PThreadExit(modifier: Modifier = Modifier) {
    val context = LocalContext.current
    Card(modifier) {
        Column(Modifier.padding(8.dp)) {
            Text(
                text = stringResource(R.string.pthread_exit),
                fontWeight = FontWeight.Bold,
            )
            Text(stringResource(R.string.pthread_exit_description))
            TextButton({ openWebsite("https://onlinegdb.com/4gSVCnil4", context) }) {
                Text(stringResource(R.string.example))
            }
        }
    }
}

/**
 * Displays a card with information about pthread_join.
 *
 * @param modifier The modifier for the layout
 */
@Composable
private fun PThreadJoin(modifier: Modifier = Modifier) {
    val context = LocalContext.current
    Card(modifier) {
        Column(Modifier.padding(8.dp)) {
            Text(
                text = stringResource(R.string.pthread_join),
                fontWeight = FontWeight.Bold,
            )
            Text(stringResource(R.string.pthread_join_description))
            TextButton({ openWebsite("https://onlinegdb.com/VkWQD-JDr", context) }) {
                Text(stringResource(R.string.example))
            }

        }
    }
}

/**
 * Displays a card with information about pthread_cancel.
 *
 * @param modifier The modifier for the layout
 */
@Composable
private fun PthreadCancel(modifier: Modifier = Modifier) {
    val context = LocalContext.current
    Card(modifier) {
        Column(Modifier.padding(8.dp)) {
            Text(
                text = stringResource(R.string.pthread_cancel),
                fontWeight = FontWeight.Bold,
            )
            Text(stringResource(R.string.pthread_cancel_description))
            TextButton({ openWebsite("https://onlinegdb.com/IuQ4ii_oR", context) }) {
                Text(stringResource(R.string.example))
            }
        }
    }
}

/**
 * Displays a card with information about pthread_mutex_init.
 *
 * @param modifier The modifier for the layout
 */
@Composable
private fun PthreadMutexInit(modifier: Modifier = Modifier) {
    val context = LocalContext.current
    Card(modifier.clickable {}) {
        Column(Modifier.padding(8.dp)) {
            Text(
                text = stringResource(R.string.pthread_mutex_init),
                fontWeight = FontWeight.Bold,
            )
            Text(stringResource(R.string.pthread_mutex_init_description))
            TextButton({ openWebsite("https://onlinegdb.com/SisTbTJOt", context) }) {
                Text(stringResource(R.string.example))
            }
        }
    }
}

/**
 * Displays a card with information about pthread_mutex_destroy.
 *
 * @param modifier The modifier for the layout
 */
@Composable
private fun PthreadMutexDestroy(modifier: Modifier = Modifier) {
    val context = LocalContext.current
    Card(modifier) {
        Column(Modifier.padding(8.dp)) {
            Text(
                text = stringResource(R.string.pthread_mutex_destroy),
                fontWeight = FontWeight.Bold,
            )
            Text(stringResource(R.string.pthread_mutex_destroy_description))
            TextButton({ openWebsite("https://onlinegdb.com/3Ywu3uHd8", context) }) {
                Text(stringResource(R.string.example))
            }
        }
    }
}

/**
 * Displays a card with information about pthread_mutex_lock.
 *
 * @param modifier The modifier for the layout
 */
@Composable
private fun PthreadMutexLock(modifier: Modifier = Modifier) {
    val context = LocalContext.current
    Card(modifier) {
        Column(Modifier.padding(8.dp)) {
            Text(
                text = stringResource(R.string.pthread_mutex_lock),
                fontWeight = FontWeight.Bold,
            )
            Text(stringResource(R.string.pthread_mutex_lock_description))
            TextButton({ openWebsite("https://www.onlinegdb.com/edit/nHpmVI1QD", context) }) {
                Text(stringResource(R.string.example))
            }
        }
    }
}

/**
 * Displays a card with information about pthread_mutex_unlock.
 *
 * @param modifier The modifier for the layout
 */
@Composable
private fun PthreadMutexUnlock(modifier: Modifier = Modifier) {
    val context = LocalContext.current
    Card(modifier) {
        Column(Modifier.padding(8.dp)) {
            Text(
                text = stringResource(R.string.pthread_mutex_unlock),
                fontWeight = FontWeight.Bold,
            )
            Text(stringResource(R.string.pthread_mutex_unlock_description))
            TextButton({ openWebsite("https://onlinegdb.com/FAtoHJdDc", context) }) {
                Text(stringResource(R.string.example))
            }
        }
    }
}

/**
 * Displays a card with information about pthread_cond_init.
 *
 * @param modifier The modifier for the layout
 */
@Composable
private fun PthreadConditionInit(modifier: Modifier = Modifier) {
    Card(modifier) {
        Column(Modifier.padding(8.dp)) {
            Text(
                text = stringResource(R.string.pthread_cond_init),
                fontWeight = FontWeight.Bold,
            )
            Text(stringResource(R.string.pthread_cond_init_description))
        }
    }
}

/**
 * Displays a card with information about pthread_cond_signal.
 *
 * @param modifier The modifier for the layout
 */
@Composable
private fun PthreadConditionSignal(modifier: Modifier = Modifier) {
    Card(modifier) {
        Column(Modifier.padding(8.dp)) {
            Text(
                text = stringResource(R.string.pthread_cond_signal),
                fontWeight = FontWeight.Bold,
            )
            Text(stringResource(R.string.pthread_cond_signal_description))
        }
    }
}

/**
 * Displays a card with information about pthread_cond_wait.
 *
 * @param modifier The modifier for the layout
 */
@Composable
private fun PthreadConditionWait(modifier: Modifier = Modifier) {
    Card(modifier) {
        Column(Modifier.padding(8.dp)) {
            Text(
                text = stringResource(R.string.pthread_cond_wait),
                fontWeight = FontWeight.Bold,
            )
            Text(stringResource(R.string.pthread_cond_wait_description))
        }
    }
}


/**
 * Displays a preview for the software layer.
 */
@PreviewLightDark
@PreviewScreenSizes
@Composable
fun PreviewSoftwareLayer() {
    ComputerArchitectureTheme {
        Surface {
            SoftwareLayer(isStudyMode = false)
        }
    }
}