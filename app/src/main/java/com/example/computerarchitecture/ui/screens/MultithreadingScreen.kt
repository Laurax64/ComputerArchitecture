package com.example.computerarchitecture.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.PrimaryTabRow
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Tab
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import com.example.computerarchitecture.OpenWebView
import com.example.computerarchitecture.R
import com.example.computerarchitecture.ui.components.TopicTopBar
import com.example.computerarchitecture.ui.theme.ComputerArchitectureTheme

/**
 * Displays the multithreading screen.
 *
 * @param navigateBack The function to navigate back
 * @param modifier The modifier for the layout
 */
@Composable
fun MultithreadingScreen(
    navigateBack: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Scaffold(
        modifier = modifier,
        topBar = {
            TopicTopBar(
                title = stringResource(R.string.multithreading),
                navigateBack = navigateBack
            )
        },
    ) {
        MultithreadingScreen(modifier.padding(it))
    }
}

/**
 * Displays the content for the multithreading screen.
 *
 * @param modifier The modifier for the layout
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MultithreadingScreen(modifier: Modifier = Modifier) {
    var state by rememberSaveable { mutableIntStateOf(0) }
    val titles = listOf(R.string.hardware_layer, R.string.software_layer)

    Column(modifier) {
        PrimaryTabRow(selectedTabIndex = state) {
            titles.forEachIndexed { index, title ->
                Tab(
                    selected = state == index,
                    onClick = { state = index },
                    text = { Text(text = stringResource(title)) })
            }
        }
        when (state) {
            0 -> HardwareLayer()
            1 -> SoftwareLayer()
        }
    }
}

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
 * Displays the software layer tab, including descriptions for POSIX threads.
 */

/**
 * Displays the software layer tab, including descriptions for POSIX threads.
 */
@Composable
fun SoftwareLayer(modifier: Modifier = Modifier) {
    Column(
        modifier
            .fillMaxWidth()
            .padding(24.dp)
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.spacedBy(12.dp),
    ) {
        Text(
            text = stringResource(R.string.posix_threads),
            style = MaterialTheme.typography.titleLarge,
            fontWeight = FontWeight.Bold
        )
        PThreadIncludes()
        PThreadCreation()
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
 * Displays the section for POSIX treads in the software layer tab.
 */
@Composable
fun PThreadIncludes(modifier: Modifier = Modifier) {
    Column(modifier) {
        Text(
            text = stringResource(R.string.includes),
            style = MaterialTheme.typography.titleMedium,
            fontWeight = FontWeight.Bold
        )
        Text(stringResource(R.string.pthread_include))
    }
}

/**
 * Displays the pthread_create section for POSIX treads in the software layer tab.
 *
 * @param modifier The modifier for the layout
 */
@Composable
fun PThreadCreation(modifier: Modifier = Modifier) {
    var openWebView by rememberSaveable { mutableStateOf(false) }
    if (openWebView) {
        OpenWebView("https://hpc-tutorials.llnl.gov/posix/creating_and_terminating/#creating-threads")
    } else {
        Column(modifier) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable { openWebView = true },
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Column {
                    Text(
                        text = stringResource(R.string.thread_creation),
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.Bold
                    )
                    Text(stringResource(R.string.pthread_create))
                }
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight,
                    contentDescription = "Navigate forward"
                )
            }


        }
    }
}

/**
 * Displays previews for the multithreading screen for compact screens.
 */

/**
 * Displays previews for the multithreading screen for compact screens.
 */
@PreviewLightDark
@Composable
private fun MultithreadingScreenCompactPreview() {
    ComputerArchitectureTheme {
        MultithreadingScreen(
            navigateBack = {},
        )
    }
}

/**
 * Displays previews for the multithreading screen for medium screens.
 */

/**
 * Displays previews for the multithreading screen for medium screens.
 */
@Preview(widthDp = 800, heightDp = 800)
@Composable
private fun MultithreadingScreenMediumPreview() {
    ComputerArchitectureTheme {
        MultithreadingScreen(
            navigateBack = {},
        )
    }
}

/**
 * Displays previews for the multithreading screen for expanded screens.
 */

/**
 * Displays previews for the multithreading screen for expanded screens.
 */
@Preview(widthDp = 1100, heightDp = 1100)
@Composable
private fun MultithreadingScreenExpandedPreview() {
    ComputerArchitectureTheme {
        MultithreadingScreen(
            navigateBack = {},
        )
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