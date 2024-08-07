package com.example.computerarchitecture.ui.screens.multithreading

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.tooling.preview.PreviewScreenSizes
import androidx.compose.ui.unit.dp
import com.example.computerarchitecture.R
import com.example.computerarchitecture.ui.theme.ComputerArchitectureTheme

/**
 * Displays the hardware layer tab, including descriptions for coarse grain
 * multithreading, fine grain multithreading, and simultaneous multithreading.
 *
 * @param modifier The modifier for the layout
 * @param isStudyMode Whether the user is in study mode
 */
@Composable
fun HardwareLayer(modifier: Modifier = Modifier, isStudyMode: Boolean) {
    Column(
        modifier = modifier.verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.spacedBy(8.dp),
    ) {
        CGMT(Modifier.fillMaxWidth(), isStudyMode)
        FGMT(Modifier.fillMaxWidth(), isStudyMode)
        SMT(Modifier.fillMaxWidth(), isStudyMode)
    }
}

/**
 * Displays a card with information about coarse-grained multithreading.
 *
 * @param modifier The modifier for the layout
 * @param isStudyMode Whether the user is in study mode
 */
@Composable
private fun CGMT(modifier: Modifier, isStudyMode: Boolean) {
    var expanded by rememberSaveable { mutableStateOf(!isStudyMode) }
    Card({ expanded = !expanded }, modifier) {
        Column(Modifier.padding(8.dp), Arrangement.spacedBy(8.dp)) {
            Text(
                text = stringResource(R.string.coarse_grained_multithreading),
                style = MaterialTheme.typography.titleLarge,
            )
            if (expanded) {
                Row(
                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                    verticalAlignment = Alignment.Top
                ) {
                    Column(Modifier.weight(1f)) {
                        Text(text = stringResource(R.string.cgmt_description))
                        Text(
                            text = stringResource(R.string.advantages),
                            style = MaterialTheme.typography.titleMedium,
                        )
                        Text(stringResource(R.string.cgmt_advantages))
                        Text(
                            text = stringResource(R.string.disadvantages),
                            style = MaterialTheme.typography.titleMedium,
                        )
                        Text(stringResource(R.string.cgmt_disadvantages))
                    }
                    Column(Modifier.border(1.dp, MaterialTheme.colorScheme.onSurface)) {
                        cgmtThreads.forEach {
                            Row {
                                it.forEach {
                                    val color = generateBlueShade(it)
                                    Box(
                                        modifier = Modifier
                                            .size(20.dp)
                                            .background(color)
                                            .border(1.dp, MaterialTheme.colorScheme.onSurface)
                                    )
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}

/**
 * Displays a card with information about fine-grained multithreading.
 *
 * @param modifier The modifier for the layout
 */
@Composable
private fun FGMT(modifier: Modifier, isStudyMode: Boolean) {
    var expanded by rememberSaveable { mutableStateOf(!isStudyMode) }
    Card({ expanded = !expanded }, modifier) {
        Column(Modifier.padding(8.dp), Arrangement.spacedBy(8.dp)) {
            Text(
                text = stringResource(R.string.fine_grained_multithreading),
                style = MaterialTheme.typography.titleLarge,
            )
            if (expanded) {
                Row(
                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                    verticalAlignment = Alignment.Top
                ) {
                    Column(Modifier.weight(1f)) {
                        Text(text = stringResource(R.string.fgmt_description))
                        Text(
                            text = stringResource(R.string.advantages),
                            style = MaterialTheme.typography.titleMedium,
                        )
                        Text(stringResource(R.string.fgmt_advantages))
                        Text(
                            text = stringResource(R.string.disadvantages),
                            style = MaterialTheme.typography.titleMedium,
                        )
                        Text(stringResource(R.string.fgmt_disadvantages))
                    }
                    Column(Modifier.border(1.dp, MaterialTheme.colorScheme.onSurface)) {
                        fgmtThreads.forEach {
                            Row {
                                it.forEach {
                                    val color = generateBlueShade(it)
                                    Box(
                                        modifier = Modifier
                                            .size(20.dp)
                                            .background(color)
                                            .border(1.dp, MaterialTheme.colorScheme.onSurface)
                                    )
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}

/**
 * Displays a card with information about simultaneous multithreading.
 *
 * @param modifier The modifier for the layout
 * @param isStudyMode Whether the user is in study mode
 */
@Composable
private fun SMT(modifier: Modifier = Modifier, isStudyMode: Boolean) {
    var expanded by rememberSaveable { mutableStateOf(!isStudyMode) }
    Card({ expanded = !expanded }, modifier) {
        Column(Modifier.padding(8.dp), Arrangement.spacedBy(8.dp)) {
        Text(
            text = stringResource(R.string.simultaneous_multithreading),
            style = MaterialTheme.typography.titleLarge,
        )
        if (expanded) {
            Row(
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                verticalAlignment = Alignment.Top
            ) {
                Column(Modifier.weight(1f)) {
                    Text(text = stringResource(R.string.smt_description))
                    Text(
                        text = stringResource(R.string.advantages),
                        style = MaterialTheme.typography.titleMedium,
                    )
                    Text(stringResource(R.string.smt_advantages))
                    Text(
                        text = stringResource(R.string.disadvantages),
                        style = MaterialTheme.typography.titleMedium,
                    )
                    Text(stringResource(R.string.smt_disadvantages))
                }
                Column(Modifier.border(1.dp, MaterialTheme.colorScheme.onSurface)) {
                    smtThreads.forEach {
                        Row {
                            it.forEach {
                                val color = generateBlueShade(it)
                                Box(
                                    modifier = Modifier
                                        .size(20.dp)
                                        .background(color)
                                        .border(1.dp, MaterialTheme.colorScheme.onSurface)
                                )
                            }
                        }
                    }
                }
            }
        }
        }
    }
}

/**
 * The threads for coarse grain multithreading.
 */
val cgmtThreads = listOf(
    listOf(0, 0, 0, 0),
    listOf(0, 0, -1, -1),
    listOf(0, 0, 0, -1),
    listOf(0, -1, -1, -1),
    listOf(-1, -1, -1, -1),
    listOf(1, 1, 1, -1),
    listOf(1, 1, 1, -1),
    listOf(1, 1, -1, -1),
    listOf(0, 0, -1, -1),
    listOf(0, 0, 0, 0),
)

/**
 * The threads for fine grain multithreading.
 */
val fgmtThreads = listOf(
    listOf(0, 0, 0, 0),
    listOf(1, 1, 1, -1),
    listOf(2, 2, 2, 2),
    listOf(3, 3, -1, -1),
    listOf(0, 0, 0, -1),
    listOf(1, 1, 1, 1),
    listOf(2, 2, 2, -1),
    listOf(3, 3, -1, -1),
    listOf(0, 0, 0, 0),
    listOf(1, 1, -1, -1),
)

/**
 * The threads for simultaneous multithreading.
 */
val smtThreads = listOf(
    listOf(0, 0, 1, 2),
    listOf(1, 1, 0, -1),
    listOf(2, 2, 3, 3),
    listOf(3, 3, 2, 1),
    listOf(0, 0, 1, 2),
    listOf(1, 1, 0, -1),
    listOf(2, 2, 3, 3),
    listOf(3, 3, 2, 1),
    listOf(0, 0, 1, 2),
    listOf(1, 1, 0, -1),
)


/**
 * Generates a shade of blue based on the id.
 *
 * @param id The id to generate the shade of blue from
 * @return The shade of blue
 */
fun generateBlueShade(id: Int): Color {
    return when (id) {
        0 -> Color(0, 0, 255)
        1 -> Color(0, 130, 255)
        2 -> Color(0, 200, 255)
        3 -> Color(0, 255, 255)
        else -> Color.Transparent
    }
}

/**
 * Displays previews for the hardware layer.
 */
@PreviewLightDark
@PreviewScreenSizes
@Composable
fun PreviewHardwareLayer() {
    ComputerArchitectureTheme {
        Surface {
            HardwareLayer(isStudyMode = false)
        }
    }
}