package com.example.computerarchitecture.ui.screens.multiprocessorsystems

import androidx.compose.foundation.Image
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.ScrollableTabRow
import androidx.compose.material3.Tab
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.tooling.preview.PreviewScreenSizes
import androidx.compose.ui.unit.dp
import com.example.computerarchitecture.R
import com.example.computerarchitecture.ui.components.TopicTopBar
import com.example.computerarchitecture.ui.theme.ComputerArchitectureTheme
import kotlin.math.roundToInt

/**
 * Displays the multiprocessor systems screen with an app scaffold.
 *
 * @param navigateBack The function to navigate back
 * @param modifier The modifier for the layout
 */
@Composable
fun MultiprocessorSystemsScreen(
    navigateBack: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Scaffold(
        modifier = modifier,
        topBar = {
            TopicTopBar(
                title = stringResource(R.string.multiprocessor_systems),
                navigateBack = navigateBack
            )
        },
    ) { paddingValues ->
        MultiprocessorSystemsScreen(
            Modifier
                .padding(paddingValues)
                .padding(start = 16.dp, end = 16.dp)
        )
    }
}

/**
 * Displays the multiprocessor systems screen.
 *
 * @param modifier The modifier for the layout
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MultiprocessorSystemsScreen(modifier: Modifier = Modifier) {
    var state by rememberSaveable { mutableIntStateOf(0) }
    val titles = listOf(
        R.string.speedup,
        R.string.numa_title_short,
        R.string.flynns_taxonomy,
        R.string.cache_coherence
    )
    val focusManager = LocalFocusManager.current
    Column(
        modifier
            .fillMaxWidth()
            .pointerInput(Unit) {
                detectTapGestures(onTap = {
                    focusManager.clearFocus()
                })
            },
    ) {
        ScrollableTabRow(selectedTabIndex = state) {
            titles.forEachIndexed { index, title ->
                Tab(
                    selected = state == index,
                    onClick = { state = index },
                    text = { Text(text = stringResource(title)) })
            }
        }
        when (state) {
            0 -> SpeedupTab(
                Modifier
                    .fillMaxWidth()
                    .padding(16.dp))
            1 -> NumaTab(
                Modifier
                    .fillMaxWidth()
                    .padding(16.dp))
            2 -> FlynnsTaxonomy(
                Modifier
                    .fillMaxWidth()
                    .padding(16.dp))
            3 -> CacheCoherence(
                Modifier
                    .fillMaxWidth()
                    .padding(16.dp))

        }
    }
}

/**
 * Displays the speedup tab.
 *
 * @param modifier The modifier for the layout
 */
@Composable
fun SpeedupTab(modifier: Modifier = Modifier) {
    Column(modifier, Arrangement.spacedBy(8.dp)) {
        AmdahlsLaw(Modifier.fillMaxWidth())
        GustafsonsLaw(Modifier.fillMaxWidth())
        SpeedupCalculator(Modifier.fillMaxWidth())
    }
}

/**
 * Displays a card with information about Amdahl's Law.
 *
 * @param modifier The modifier for the layout
 */
@Composable
private fun AmdahlsLaw(modifier: Modifier = Modifier) {
    Card(modifier) {
        Column(Modifier.padding(8.dp)) {
            Text(
                text = stringResource(R.string.amdahls_law),
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = stringResource(R.string.amdahls_law_formula),
                fontWeight = FontWeight.Bold
            )
            Text(stringResource(R.string.amdahls_law_description))
        }
    }
}

/**
 * Displays a card with information about Gustafson's Law
 *
 * @param modifier The modifier for the layout
 */
@Composable
private fun GustafsonsLaw(modifier: Modifier = Modifier) {
    Card(modifier) {
        Column(Modifier.padding(8.dp)) {
            Text(
                text = stringResource(R.string.gustafsons_law),
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = stringResource(R.string.gustafsons_law_formula),
                fontWeight = FontWeight.Bold
            )
            Text(stringResource(R.string.gustafsons_law_description))
        }
    }
}

/**
 * Displays a card containing a speedup calculator.
 *
 * @param modifier The modifier for the layout
 */
@Composable
private fun SpeedupCalculator(modifier: Modifier = Modifier) {
    var parallelizedCode by rememberSaveable { mutableStateOf("0.96") }
    var processors by rememberSaveable { mutableStateOf("16.0") }
    var speedupAmdahl by rememberSaveable {
        mutableStateOf(amdahlsLaw(processors.toDouble(), parallelizedCode.toDouble()).toString())
    }
    var speedupGustavson by rememberSaveable {
        mutableStateOf(gustavsonsLaw(processors.toDouble(), parallelizedCode.toDouble()).toString())
    }
    Card(modifier) {
        Column(Modifier.padding(8.dp), verticalArrangement = Arrangement.spacedBy(8.dp)) {
            Text(
                text = stringResource(R.string.speedup_calculator),
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.Bold
            )

            TextField(
                value = parallelizedCode.ifBlank { "0.0" },
                onValueChange = { parallelizedCode = it.ifBlank { "0.0" } },
                label = { Text("Fraction of parallelizable code P") },
                modifier = Modifier.fillMaxWidth(),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
            )
            TextField(
                value = processors.ifBlank { "0.0" },
                onValueChange = { processors = it.ifBlank { "1.0" } },
                label = { Text("Number of processors N") },
                modifier = Modifier.fillMaxWidth(),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
            )
            TextField(
                value = amdahlsLaw(processors.toDouble(), parallelizedCode.toDouble()).toString(),
                onValueChange = { speedupAmdahl = it },
                label = { Text("Speedup Amdahl's Law") },
                modifier = Modifier.fillMaxWidth(),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),

                )
            TextField(
                value = gustavsonsLaw(
                    processors.toDouble(),
                    parallelizedCode.toDouble()
                ).toString(),
                onValueChange = { speedupGustavson = it },
                label = { Text("Speedup Gustafson's Law") },
                modifier = Modifier.fillMaxWidth(),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            )
        }

    }
}

/**
 * Calculates the speedup of a program given the number of cores and the percentage of the program
 * that can be parallelized using Amdahl's Law
 *
 * @param n The number of processors
 * @param p The percentage of the program that can be parallelized
 */
private fun amdahlsLaw(n: Double, p: Double): Int {
    return (1 / ((1 - p) + (p / n))).roundToInt()
}

/**
 * Calculates the speedup of a program given the number of cores and the percentage of the program
 * that can be parallelized using Gustavson's Law
 *
 * @param n The number of processors
 * @param p The percentage of the program that can be parallelized
 */
private fun gustavsonsLaw(n: Double, p: Double): Int {
    return (1 - p + p * n).roundToInt()
}

/**
 * Displays the numa tab.
 *
 * @param modifier The modifier for the layout
 */
@Composable
fun NumaTab(modifier: Modifier = Modifier) {
    Column(
        modifier
            .fillMaxWidth()
            .verticalScroll(rememberScrollState()),
        Arrangement.spacedBy(12.dp)
    ) {
        Text(stringResource(R.string.numa_title_long), fontWeight = FontWeight.Bold)
        Image(
            painter = painterResource(R.drawable.numa),
            contentDescription = "Numa",
            modifier = Modifier.fillMaxWidth(),
            contentScale = ContentScale.FillWidth
        )
        Text(stringResource(R.string.numa_runtime_description))
    }
}

/**
 * Displays previews for the multiprocessor systems screen.
 */
@PreviewLightDark
@PreviewScreenSizes
@Composable
fun MultiprocessorSystemsScreenPreview() {
    ComputerArchitectureTheme(true) {
        MultiprocessorSystemsScreen(
            navigateBack = {},
        )
    }
}
