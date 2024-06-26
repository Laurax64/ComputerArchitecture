package com.example.computerarchitecture.ui.screens

import androidx.compose.foundation.Image
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
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.computerarchitecture.R
import com.example.computerarchitecture.ui.components.TopicTopBar
import com.example.computerarchitecture.ui.navigation.NavigationDestination
import com.example.computerarchitecture.ui.theme.ComputerArchitectureTheme
import kotlin.math.roundToInt

/**
 * Represents a navigation destination for the multiprocessor systems screen
 */
object MultiprocessorSystemsDestination : NavigationDestination {
    override val route = "Multiprocessor Systems"
}

/**
 * Displays the multiprocessor systems screen.
 *
 * @param navigateBack The function to navigate back
 * @param modifier The modifier for the layout
 */
@OptIn(ExperimentalMaterial3Api::class)
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
        var state by rememberSaveable { mutableIntStateOf(0) }
        val titles = listOf(R.string.speedup, R.string.numa_title_short)

        Column(Modifier.fillMaxWidth()) {
            PrimaryTabRow(selectedTabIndex = state, modifier = Modifier.padding(paddingValues)) {
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
            value = parallelizedCode,
            onValueChange = { parallelizedCode = it },
            label = { Text("Fraction of parallelizable code P") },
            modifier = Modifier.fillMaxWidth(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )
        TextField(
            value = processors,
            onValueChange = { processors = it },
            label = { Text("Number of processors N") },
            modifier = Modifier.fillMaxWidth(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )
        TextField(
            value = speedupAmdahl,
            onValueChange = { speedupAmdahl = it },
            label = { Text("Speedup Amdahl's Law") },
            modifier = Modifier.fillMaxWidth(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),

            )
        TextField(
            value = speedupGustavson,
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

