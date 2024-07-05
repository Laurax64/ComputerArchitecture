package com.example.computerarchitecture.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.PrimaryTabRow
import androidx.compose.material3.Scaffold
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
import androidx.compose.ui.tooling.preview.Preview
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
        MultiprocessorSystemsScreen(Modifier.padding(paddingValues))
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
    val titles = listOf(R.string.speedup, R.string.numa_title_short)
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
        PrimaryTabRow(selectedTabIndex = state) {
            titles.forEachIndexed { index, title ->
                Tab(
                    selected = state == index,
                    onClick = { state = index },
                    text = { Text(text = stringResource(title)) })
            }
        }
        when (state) {
            0 -> SpeedupTab()
            1 -> NumaTab()
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
    var parallelizedCode by rememberSaveable { mutableStateOf("0.96") }
    var processors by rememberSaveable { mutableStateOf("16.0") }
    var speedupAmdahl by rememberSaveable {
        mutableStateOf(AmdahlsLaw(processors.toDouble(), parallelizedCode.toDouble()).toString())
    }
    var speedupGustavson by rememberSaveable {
        mutableStateOf(GustavsonLaw(processors.toDouble(), parallelizedCode.toDouble()).toString())
    }

    Column(
        modifier
            .fillMaxWidth()
            .padding(24.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp),
    ) {
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
            value = AmdahlsLaw(processors.toDouble(), parallelizedCode.toDouble()).toString(),
            onValueChange = { speedupAmdahl = it },
            label = { Text("Speedup Amdahl's Law") },
            modifier = Modifier.fillMaxWidth(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),

            )
        TextField(
            value = GustavsonLaw(processors.toDouble(), parallelizedCode.toDouble()).toString(),
            onValueChange = { speedupGustavson = it },
            label = { Text("Speedup Gustavson's Law") },
            modifier = Modifier.fillMaxWidth(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
        )
        SpeedupFormula()
    }
}

/**
 * Calculates the speedup of a program given the number of cores and the percentage of the program
 * that can be parallelized using Amdahl's Law
 *
 * @param n The number of processors
 * @param p The percentage of the program that can be parallelized
 */
private fun AmdahlsLaw(n: Double, p: Double): Int {
    return (1 / ((1 - p) + (p / n))).roundToInt()
}

/**
 * Calculates the speedup of a program given the number of cores and the percentage of the program
 * that can be parallelized using Gustavson's Law
 *
 * @param n The number of processors
 * @param p The percentage of the program that can be parallelized
 */
private fun GustavsonLaw(n: Double, p: Double): Int {
    return (1 - p + p * n).roundToInt()
}

/**
 * Displays the speedup formula image
 */
@Composable
private fun SpeedupFormula() {
    Image(
        painter = painterResource(R.drawable.speedup),
        contentDescription = "Speedup Formulas",
        modifier = Modifier.fillMaxWidth(),
        contentScale = ContentScale.FillWidth
    )
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
            .padding(24.dp)
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.spacedBy(12.dp)
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
 * Displays a preview for the multiprocessor systems screen in light mode
 */
@Preview
@Composable
private fun MultiprocessorSystemsLightPreview() {
    ComputerArchitectureTheme {
        MultiprocessorSystemsScreen(
            navigateBack = {},
        )
    }
}

/**
 * Displays a preview for the multiprocessor systems screen in dark mode
 */
@Preview
@Composable
private fun MultiprocessorSystemsDarkPreview() {
    ComputerArchitectureTheme(true) {
        MultiprocessorSystemsScreen(
            navigateBack = {},
        )
    }
}

