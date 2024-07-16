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
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.tooling.preview.PreviewScreenSizes
import androidx.compose.ui.unit.dp
import com.example.computerarchitecture.R
import com.example.computerarchitecture.ui.theme.ComputerArchitectureTheme

/**
 * Displays the software layer tab, including descriptions for POSIX threads.
 */
@Composable
fun SoftwareLayer(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier.verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.spacedBy(12.dp),
    ) {
        Text(
            text = stringResource(R.string.posix_threads),
            style = MaterialTheme.typography.titleLarge,
            fontWeight = FontWeight.Bold
        )
        ThreadManagement()
        MutexVariables()
        ConditionVariables()
    }
}

@Composable
private fun ThreadManagement(modifier: Modifier = Modifier) {
    Card(modifier) {
        Column(Modifier.padding(8.dp), verticalArrangement = Arrangement.spacedBy(8.dp)) {
            Text(
                text = stringResource(R.string.thread_management),
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.Bold
            )
            PThreadCreation(Modifier.fillMaxWidth())
            PThreadExit(Modifier.fillMaxWidth())
            PThreadJoin(Modifier.fillMaxWidth())
            PthreadCancel(Modifier.fillMaxWidth())
        }
    }
}

@Composable
private fun MutexVariables(modifier: Modifier = Modifier) {
    Card(modifier) {
        Column(Modifier.padding(8.dp), verticalArrangement = Arrangement.spacedBy(8.dp)) {
            Text(
                text = stringResource(R.string.mutex_variables),
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.Bold
            )
            PthreadMutexInit(Modifier.fillMaxWidth())
            PthreadMutexDestroy(Modifier.fillMaxWidth())
            PthreadMutexLock(Modifier.fillMaxWidth())
            PthreadMutexUnlock(Modifier.fillMaxWidth())
        }
    }
}

@Composable
private fun ConditionVariables(modifier: Modifier = Modifier) {
    Card(modifier) {
        Column(Modifier.padding(8.dp), verticalArrangement = Arrangement.spacedBy(8.dp)) {
            Text(
                text = stringResource(R.string.condition_variables),
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.Bold
            )
            PthreadConditionInit(Modifier.fillMaxWidth())
            PthreadConditionSignal(Modifier.fillMaxWidth())
            PthreadConditionWait(Modifier.fillMaxWidth())
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
    Card(modifier.clickable {}
    ) {
        Column(Modifier.padding(8.dp)) {
            Text(
                text = stringResource(R.string.thread_create),
                fontWeight = FontWeight.Bold,
            )
            Text(stringResource(R.string.pthread_create))
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
    Card(modifier.clickable {}
    ) {
        Column(Modifier.padding(8.dp)) {
            Text(
                text = stringResource(R.string.thread_exit),
                fontWeight = FontWeight.Bold,
            )
            Text(stringResource(R.string.pthread_exit))
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
    Card(modifier.clickable {}
    ) {
        Column(Modifier.padding(8.dp)) {
            Text(
                text = stringResource(R.string.thread_join),
                fontWeight = FontWeight.Bold,
            )
            Text(stringResource(R.string.pthread_join))
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
    Card(modifier.clickable {}
    ) {
        Column(Modifier.padding(8.dp)) {
            Text(
                text = stringResource(R.string.thread_cancel),
                fontWeight = FontWeight.Bold,
            )
            Text(stringResource(R.string.pthread_cancel))
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
    Card(modifier.clickable {}
    ) {
        Column(Modifier.padding(8.dp)) {
            Text(
                text = stringResource(R.string.thread_mutex_init),
                fontWeight = FontWeight.Bold,
            )
            Text(stringResource(R.string.pthread_mutex_init))
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
    Card(modifier.clickable {}
    ) {
        Column(Modifier.padding(8.dp)) {
            Text(
                text = stringResource(R.string.thread_mutex_destroy),
                fontWeight = FontWeight.Bold,
            )
            Text(stringResource(R.string.pthread_mutex_destroy))
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
    Card(modifier.clickable {}
    ) {
        Column(Modifier.padding(8.dp)) {
            Text(
                text = stringResource(R.string.thread_mutex_lock),
                fontWeight = FontWeight.Bold,
            )
            Text(stringResource(R.string.pthread_mutex_lock))
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
    Card(modifier.clickable {}
    ) {
        Column(Modifier.padding(8.dp)) {
            Text(
                text = stringResource(R.string.thread_mutex_unlock),
                fontWeight = FontWeight.Bold,
            )
            Text(stringResource(R.string.pthread_mutex_unlock))
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
    Card(modifier.clickable {}
    ) {
        Column(Modifier.padding(8.dp)) {
            Text(
                text = stringResource(R.string.thread_condition_init),
                fontWeight = FontWeight.Bold,
            )
            Text(stringResource(R.string.pthread_cond_init))
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
    Card(modifier.clickable {}
    ) {
        Column(Modifier.padding(8.dp)) {
            Text(
                text = stringResource(R.string.thread_condition_signal),
                fontWeight = FontWeight.Bold,
            )
            Text(stringResource(R.string.pthread_cond_signal))
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
    Card(modifier.clickable {}
    ) {
        Column(Modifier.padding(8.dp)) {
            Text(
                text = stringResource(R.string.thread_condition_wait),
                fontWeight = FontWeight.Bold,
            )
            Text(stringResource(R.string.pthread_cond_wait))
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
            SoftwareLayer()
        }
    }
}