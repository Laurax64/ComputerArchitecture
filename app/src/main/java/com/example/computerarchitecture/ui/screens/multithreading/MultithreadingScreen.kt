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
import androidx.compose.foundation.verticalScroll
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
import androidx.compose.material3.TextField
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
import com.example.computerarchitecture.data.Cache
import com.example.computerarchitecture.data.Operation
import com.example.computerarchitecture.data.ProcessingUnit
import com.example.computerarchitecture.generateColor
import com.example.computerarchitecture.toRange
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
        val titles = listOf("CGMT", "FGMT", "SMT")

        Column(horizontalAlignment = Alignment.CenterHorizontally) {
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
    if (openDialog) {
        MultithreadingSettingsDialog(
            mutableListOf(),
            mutableListOf(),
            mutableListOf(),
            { openDialog = false })
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
 * Displays a dialog to add and delete new threads or units or caches
 *
 * @param caches The list of caches to configure
 * @param units The list of units to configure
 * @param threads The list of threads to configure
 * @param onDismissRequest The function to call when the dialog is dismissed
 * @param modifier The modifier for the layout
 */
@Composable
fun MultithreadingSettingsDialog(
    caches: MutableList<Cache>,
    units: MutableList<ProcessingUnit>,
    threads: MutableList<CAThread>,
    onDismissRequest: () -> Unit,
    modifier: Modifier = Modifier
) {
    val openDialog = remember { mutableStateOf(true) }

    if (openDialog.value) {
        Dialog(onDismissRequest = { openDialog.value = false }) {
            Card(modifier = modifier.verticalScroll(rememberScrollState())) {
                Column(modifier = Modifier.padding(16.dp)) {
                    var configureCaches by remember { mutableStateOf(false) }
                    var configureUnits by remember { mutableStateOf(false) }
                    var configureThreads by remember { mutableStateOf(false) }
                    Button(
                        onClick = { configureCaches = !configureCaches },
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Text("Cache Settings")
                    }
                    if (configureCaches) {
                        ConfigureCacheDialog(caches)
                    }
                    Button(
                        onClick = { configureUnits = !configureUnits },
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Text("Unit Settings")
                    }
                    if (configureUnits) {
                        ConfigureUnitsDialog(units)
                    }
                    Button(
                        onClick = { configureThreads = !configureThreads },
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Text("Thread Settings")
                    }
                    if (configureThreads) {
                        ConfigureThreadsDialog(threads)
                    }
                }
            }
        }
    }
}

/**
 * Displays a dialog to add or delete threads
 *
 * @param threads The list of threads to configure
 * @param modifier The modifier for the layout
 */
@Composable
fun ConfigureThreadsDialog(threads: MutableList<CAThread>, modifier: Modifier = Modifier) {
    var threadId by remember { mutableStateOf("") }
    var threadName by rememberSaveable { mutableStateOf("") }
    var threadPriority by rememberSaveable { mutableStateOf("") }
    val threadOperations: MutableList<Operation> = mutableListOf()
    var configureNewOperation by remember { mutableStateOf(false) }
    TextField(
        value = threadId,
        onValueChange = { threadId = it },
        Modifier.fillMaxWidth(),
        label = { Text("Thread Id") },
    )
    TextField(
        value = threadName,
        onValueChange = { threadName = it },
        Modifier.fillMaxWidth(),
        label = { Text("Thread Name") },
    )
    TextField(
        value = threadPriority,
        onValueChange = { threadPriority = it },
        modifier = Modifier.fillMaxWidth(),
        label = { Text("Thread Priority") },
        supportingText = { Text("Lower numbers imply higher priorities.") },
    )

    Button(
        onClick = { configureNewOperation = true },
        Modifier
            .fillMaxWidth()
    ) {
        Text("Add operation")
    }
    Button(
        onClick = { threadOperations.clear() },
        Modifier
            .fillMaxWidth()
    ) {
        Text("Clear operations")
    }
    if (configureNewOperation) {
        ConfigureOperationDialog(
            threadId = threadId.toInt(),
            onDismissRequest = { configureNewOperation = false },
            addOperation = { operation: Operation ->
                threadOperations.add(operation)
                configureNewOperation = false
            },
        )
    }
    Row(
        horizontalArrangement = Arrangement.spacedBy(12.dp),
        modifier = Modifier.fillMaxWidth()
    ) {
        Button(
            {
                threads.add(
                    CAThread(
                        threadId.toInt(),
                        threadName,
                        threadPriority.toInt(),
                        threadOperations
                    )
                )
                threadName = ""
                threadPriority = ""
                threadOperations.clear()
            },
            Modifier
                .fillMaxWidth()
                .weight(1f)
        ) {
            Text("Add Thread")
        }
        Button(
            { threads.clear() },
            Modifier
                .fillMaxWidth()
                .weight(1f)
        ) {
            Text("ClearThreads ")
        }
    }
}


/**
 * Displays a dialog to add or delete units
 *
 * @param units The list of units to configure
 * @param modifier The modifier for the layout
 */
@Composable
fun ConfigureUnitsDialog(units: MutableList<ProcessingUnit>, modifier: Modifier = Modifier) {
    var unitId by remember { mutableStateOf("") }
    var unitType by remember { mutableStateOf("") }
    var unitLatency by remember { mutableStateOf("") }

    TextField(
        value = unitId,
        onValueChange = { unitId = it },
        modifier = Modifier.fillMaxWidth(),
        label = { Text("Unit Id") },
    )
    TextField(
        value = unitType,
        onValueChange = { unitType = it },
        modifier = Modifier.fillMaxWidth(),
        label = { Text("Unit Type") },
    )
    TextField(
        value = unitLatency,
        onValueChange = { unitLatency = it },
        modifier = Modifier.fillMaxWidth(),
        label = { Text("Unit Latency") },
    )

    Row {
        Button(
            { units.add(ProcessingUnit(unitId.toInt(), unitType, unitLatency.toRange())) },
            Modifier
                .fillMaxWidth()
                .weight(1f)
        ) {
            Text("Add Unit")
        }
        Button(
            onClick = { units.clear() },
            Modifier
                .fillMaxWidth()
                .weight(1f)
        ) {
            Text("Clear Units")
        }
    }
}

/**
 * Displays a dialog to add or delete caches
 *
 * @param caches The list of caches to configure
 * @param modifier The modifier for the layout
 */
@Composable
fun ConfigureCacheDialog(caches: MutableList<Cache>, modifier: Modifier = Modifier) {
    var cacheType by rememberSaveable { mutableStateOf("") }
    var cacheHitLatency by rememberSaveable { mutableStateOf("0") }
    var cacheMissLatency by rememberSaveable { mutableStateOf("0") }
    TextField(
        value = cacheType,
        onValueChange = { cacheType = it },
        modifier = Modifier.fillMaxWidth(),
        label = { Text("Cache Type") },
    )
    TextField(
        value = cacheHitLatency,
        onValueChange = { cacheHitLatency = it },
        modifier = Modifier.fillMaxWidth(),
        label = { Text("Cache Hit Latency") },
    )
    TextField(
        value = cacheMissLatency,
        onValueChange = { cacheMissLatency = it },
        modifier = Modifier.fillMaxWidth(),
        label = { Text("Cache Miss Latency") },
    )
    Button(
        { caches.add(Cache(cacheType, cacheHitLatency.toInt(), cacheMissLatency.toInt())) },
        Modifier.fillMaxWidth()
    ) {
        Text("Add Cache")
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
