package com.example.computerarchitecture.ui.screens.multithreading

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
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
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.computerarchitecture.R
import com.example.computerarchitecture.data.Operation
import com.example.computerarchitecture.data.ProcessingUnit
import com.example.computerarchitecture.data.Thread
import com.example.computerarchitecture.ui.components.ComputerArchitectureTopBar
import com.example.computerarchitecture.ui.navigation.NavigationDestination
import com.example.computerarchitecture.ui.theme.ComputerArchitectureTheme
import com.example.computerarchitecture.viewmodels.MultithreadingViewModel

/**
 * Represents a navigation destination for the  screen
 */
object MultithreadingDestination : NavigationDestination {
    override val route = "multithreading"
}

/**
 * Displays the multithreading screen
 *
 * @param navigateBack The function to navigate back
 * @param modifier The modifier for the layout
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MultithreadingScreen(
    navigateBack: () -> Unit,
    modifier: Modifier = Modifier,
) {
    val viewModel: MultithreadingViewModel = viewModel()
    var openDialog by rememberSaveable { mutableStateOf(false) }
    val localFocusManager = LocalFocusManager.current
    Scaffold(
        modifier = modifier.pointerInput(Unit) { detectTapGestures(onTap = { localFocusManager.clearFocus() }) },
        topBar = {
            ComputerArchitectureTopBar(
                stringResource(R.string.multithreading),
                { openDialog = true },
                navigateBack
            )
        },
    ) { paddingValues ->
        if (openDialog) {
            /*TODO: Add dialog*/
        }
        var state by rememberSaveable { mutableIntStateOf(0) }
        val titles = listOf("CGMT", "FGMT", "CGMT")
        Column {
            PrimaryTabRow(selectedTabIndex = state, modifier = Modifier.padding(paddingValues)) {
                titles.forEachIndexed { index, title ->
                    Tab(
                        selected = state == index,
                        onClick = { state = index },
                        text = { Text(text = title) })
                }
            }
            when (state) {
                0 -> CGMTTab(Modifier.padding(24.dp))
                1 -> FGMTTab(Modifier.padding(24.dp))
                2 -> CGMTTab(Modifier.padding(24.dp))
            }
        }
    }
}

/**
 * Displays the given [Thread]s in a [Column]
 *
 * @param threads The list of threads to display
 * @param units The list of processing units of the processor
 * @param modifier The modifier for the layout
 */
@Composable
fun DisplayThreads(
    threads: List<Thread>,
    units: MutableList<ProcessingUnit>,
    modifier: Modifier = Modifier
) {
    Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {
        threads.forEach {
            DisplayThread(it, units, modifier)
        }
    }
}

/**
 * Displays the given [Thread]
 *
 * @param thread The thread to display
 * @param units The list of processing units of the processor
 * @param modifier The modifier for the layout
 */
@Composable
fun DisplayThread(thread: Thread, units: MutableList<ProcessingUnit>, modifier: Modifier) {
    Row(horizontalArrangement = Arrangement.spacedBy(12.dp)) {
        Text("\nTime \nv")
        Column {
            Text("Processing Units >")
            Row(Modifier.border(BorderStroke(1.dp, MaterialTheme.colorScheme.primary))) {
                units.forEach { unit ->
                    val operationsSortedByStart: List<Operation> =
                        thread.operations.sortedBy { it.start }
                    var currentEndTime = 0
                    var currentStartTime: Int
                    Column {
                        operationsSortedByStart.forEach {
                            currentStartTime = it.start
                            while (currentEndTime < it.start) {
                                Spacer(
                                    modifier = Modifier
                                        .width(50.dp)
                                        .height(50.dp)
                                )
                                currentEndTime++
                            }
                            if (it.unitId == unit.id) {
                                var operationLength = it.end - it.start
                                while (operationLength > 0) {
                                    Card(
                                        modifier = Modifier
                                            .width(50.dp)
                                            .height(50.dp),
                                        shape = RoundedCornerShape(0.dp),
                                        border = BorderStroke(
                                            1.dp,
                                            MaterialTheme.colorScheme.primary
                                        )
                                    ) {
                                        Text(thread.name + (currentStartTime + 1).toString())
                                    }
                                    operationLength--
                                }
                                currentEndTime = it.end
                            }
                        }
                    }
                }
            }
            Text("Thread ${thread.name} (Priority: ${thread.priority})")
        }
    }
}

/**
 * Displays a preview for the multithreading screen in light mode
 */
@Preview
@Composable
private fun MultithreadingLightPreview() {
    ComputerArchitectureTheme {
        MultithreadingScreen(
            navigateBack = {},
        )
    }
}

/**
 * Displays a preview for the poi intent screen in dark mode
 */
@Preview
@Composable
private fun MultithreadingDarkPreview() {
    ComputerArchitectureTheme(true) {
        MultithreadingScreen(
            navigateBack = {},
        )
    }
}
