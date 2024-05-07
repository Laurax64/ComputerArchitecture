package com.example.computerarchitecture.ui.screens.multithreading

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.PrimaryTabRow
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Tab
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.computerarchitecture.R
import com.example.computerarchitecture.data.CAThread
import com.example.computerarchitecture.data.Operation
import com.example.computerarchitecture.data.ProcessingUnit
import com.example.computerarchitecture.generateColor
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
                0 -> CGMTTab()
                1 -> FGMTTab()
                2 -> CGMTTab()
            }
        }
    }
}

/**
 * Displays the given [CAThread]s in a [Column]
 *
 * @param threads The list of threads to display
 * @param units The list of processing units of the processor
 * @param modifier The modifier for the layout
 */
@Composable
fun DisplayThreads(
    threads: List<CAThread>,
    units: MutableList<ProcessingUnit>,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = Modifier.horizontalScroll(rememberScrollState()),
    ) {
        Text("Threads:", style = MaterialTheme.typography.titleMedium)
        threads.forEach {
            DisplayThread(it, units, calculateMaxEndTime(threads), modifier)
        }
    }
}

/**
 * Displays the given [CAThread]
 *
 * @param thread The thread to display
 * @param units The list of processing units of the processor
 * @param cardCount The number of cards to display
 * @param modifier The modifier for the layout
 */
@Composable
fun DisplayThread(
    thread: CAThread,
    units: MutableList<ProcessingUnit>,
    cardCount: Int,
    modifier: Modifier = Modifier
) {
    Column(Modifier.fillMaxWidth()) {
        var showDetails by remember { mutableStateOf(false) }
        TextButton(
            onClick = { showDetails = !showDetails },
        ) {
            Row(horizontalArrangement = Arrangement.spacedBy(12.dp)) {
                Text("Thread ${thread.name}: id ${thread.id}, priority ${thread.priority}")
                Icon(Icons.Default.ArrowDropDown, "Show thread details")
            }
        }
        if (showDetails) {
            DisplayThreadExecutionBehavior(
                thread,
                units,
                cardCount,
                modifier
            )
            Text("Execution Behavior", style = MaterialTheme.typography.labelSmall)
        }
    }
}

/**
 * Displays the given [CAThread]'s execution behavior
 *
 * @param thread The thread to display
 * @param units The list of processing units of the processor
 * @param cardCount The number of cards to display
 * @param modifier The modifier for the layout
 */
@Composable
fun DisplayThreadExecutionBehavior(
    thread: CAThread,
    units: MutableList<ProcessingUnit>,
    cardCount: Int,
    modifier: Modifier
) {
    Row(Modifier.border(BorderStroke(2.dp, MaterialTheme.colorScheme.primary))) {
        units.forEach { unit ->
            val operationsSortedByStart: List<Operation> = thread.operations.sortedBy { it.start }
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
                                colors = CardDefaults.cardColors(generateColor(it.threadId)),
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
                while (currentEndTime < cardCount) {
                    Spacer(
                        modifier = Modifier
                            .width(50.dp)
                            .height(50.dp)
                    )
                    currentEndTime++
                }
            }
        }
    }
}

/**
 * Calculates the maximum end time of the given [CAThread]s
 *
 * @param threads The list of threads
 * @return The maximum end time
 */
fun calculateMaxEndTime(threads: List<CAThread>): Int {
    var maxEndTime = 0
    threads.forEach { thread ->
        thread.operations.forEach {
            if (it.end > maxEndTime) {
                maxEndTime = it.end
            }
        }
    }
    return maxEndTime
}

/**
 * Displays a dialog to configure and add a new operation
 *
 * @param threadId The ID of the thread to add the operation to
 * @param onDismissRequest The function to call when the dialog is dismissed
 * @param addOperation The function to add the operation
 * @param modifier The modifier for the layout
 */
@Composable
fun ConfigureOperationDialog(
    threadId: Int,
    onDismissRequest: () -> Unit,
    addOperation: (Operation) -> Unit,
    modifier: Modifier = Modifier
) {
    var unitId by remember { mutableStateOf("0") }
    var start by remember { mutableStateOf("0") }
    var end by remember { mutableStateOf("10") }

    Dialog(onDismissRequest) {
        Card {
            Column(modifier.background(MaterialTheme.colorScheme.background)) {
                OutlinedTextField(
                    value = unitId,
                    onValueChange = { unitId = it },
                    modifier = Modifier.padding(vertical = 8.dp),
                    label = { Text("Unit Id") },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
                )
                OutlinedTextField(
                    value = start,
                    onValueChange = { start = it },
                    modifier = Modifier.padding(vertical = 8.dp),
                    label = { Text("Start Time") },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
                )
                OutlinedTextField(
                    value = end,
                    onValueChange = { end = it },
                    modifier = Modifier.padding(vertical = 8.dp),
                    label = { Text("End Time") },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
                )
                Button(
                    {
                        addOperation(
                            Operation(
                                unitId.toInt(),
                                start.toInt(),
                                threadId,
                                end.toInt()
                            )
                        )
                    },
                    Modifier.align(Alignment.End)
                ) {
                    Text("Add Operation")
                }
            }
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
