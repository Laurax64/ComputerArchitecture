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
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.computerarchitecture.R

/**
 * Displays the hardware layer tab, including descriptions for coarse grain
 * multithreading, fine grain multithreading, and simultaneous multithreading.
 *
 * @param modifier The modifier for the layout
 */
@Composable
fun HardwareLayer(modifier: Modifier = Modifier) {
    Column(
        modifier
            .fillMaxWidth()
            .padding(24.dp)
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.spacedBy(12.dp),
    ) {
        CGMT(Modifier)
        FGMT(Modifier)
        SMT(Modifier)
    }
}

/**
 * Displays a card with information about coarse grain multithreading.
 *
 * @param modifier The modifier for the layout
 */
@Composable
private fun CGMT(modifier: Modifier) {
    Card(modifier) {
        Row(Modifier.padding(8.dp), Arrangement.spacedBy(8.dp), Alignment.CenterVertically) {
            Column(Modifier.weight(1f)) {
                Text(
                    text = stringResource(R.string.coarse_grained_multithreading),
                    fontWeight = FontWeight.Bold,
                )
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

/**
 * Displays a card with information about fine grain multithreading.
 *
 * @param modifier The modifier for the layout
 */
@Composable
private fun FGMT(modifier: Modifier) {
    Card(modifier) {
        Row(Modifier.padding(8.dp), Arrangement.spacedBy(8.dp), Alignment.CenterVertically) {
            Column(Modifier.weight(1f)) {
                Text(
                    text = stringResource(R.string.fine_grained_multithreading),
                    fontWeight = FontWeight.Bold,
                )
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

/**
 * Displays a card with information about simultaneous multithreading.
 *
 * @param modifier The modifier for the layout
 */
@Composable
private fun SMT(modifier: Modifier = Modifier) {
    Card(modifier) {
        Row(Modifier.padding(8.dp), Arrangement.spacedBy(8.dp), Alignment.CenterVertically) {
            Column(Modifier.weight(1f)) {
                Text(
                    text = stringResource(R.string.simultaneous_multithreading),
                    fontWeight = FontWeight.Bold,
                )
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