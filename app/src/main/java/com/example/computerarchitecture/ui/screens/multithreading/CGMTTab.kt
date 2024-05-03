package com.example.computerarchitecture.ui.screens.multithreading

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.computerarchitecture.data.CAThread
import com.example.computerarchitecture.data.Cache
import com.example.computerarchitecture.data.Operation
import com.example.computerarchitecture.data.ProcessingUnit
import com.example.computerarchitecture.data.exampleCaches
import com.example.computerarchitecture.data.exampleThreads
import com.example.computerarchitecture.data.exampleUnits


/**
 * Displays the coarse grain multithreading tab
 *
 * @param modifier The modifier for the layout
 */
@Composable
fun CGMTTab(
    modifier: Modifier = Modifier,
) {
    var configureNewOperation by remember { mutableStateOf(false) }

    Column(
        modifier
            .fillMaxWidth()
            .padding(24.dp)
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.spacedBy(12.dp),
    ) {
        var threads: MutableList<CAThread> = exampleThreads
        var threadId by remember { mutableStateOf("") }
        var threadName by rememberSaveable { mutableStateOf("") }
        var threadPriority by rememberSaveable { mutableStateOf("") }
        val threadOperations: MutableList<Operation> = mutableListOf()
        var units: MutableList<ProcessingUnit> = exampleUnits
        var unitId by remember { mutableStateOf("") }
        var unitType by remember { mutableStateOf("") }
        var unitLatency by remember { mutableStateOf("") }
        var caches = exampleCaches
        var cacheType by rememberSaveable { mutableStateOf("") }
        var cacheHitLatency by rememberSaveable { mutableStateOf("0") }
        var cacheMissLatency by rememberSaveable { mutableStateOf("0") }
        var resultThread: CAThread = CAThread(0, "", 0, mutableListOf())

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
        Text("Processing Units:", style = MaterialTheme.typography.titleMedium)
        units.forEach {
            Text("Unit ${it.id}, type = ${it.type}, latency = ${it.numberOfLatencyCycles}")
        }
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
        Row(
            horizontalArrangement = Arrangement.spacedBy(12.dp),
            modifier = Modifier.fillMaxWidth()
        ) {
            Button(
                onClick = { configureNewOperation = true },
                Modifier
                    .fillMaxWidth()
                    .weight(1f)
            ) {
                Text("Add operation")
            }
            Button(
                onClick = { threadOperations.clear() },
                Modifier
                    .fillMaxWidth()
                    .weight(1f)
            ) {
                Text("Clear operations")
            }
        }
        if (configureNewOperation) {
            ConfigureOperationDialog(
                onDismissRequest = { configureNewOperation = false },
                addOperation = { operation: Operation ->
                    threadOperations.add(operation)
                    configureNewOperation = false
                },
            )
        }
        Text("Thread Operations:", style = MaterialTheme.typography.titleMedium)
        threadOperations.forEach {
            Text("Operation: Unit Id ${it.unitId}, Start ${it.start}, End ${it.end}")
        }
        var useExample = false
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
        DisplayThreads(threads = threads, units = units)
        Button(
            {
                resultThread = coarseGrainMultiTreading(threads, units, caches)
            },
            Modifier.fillMaxWidth()
        ) {
            Text("Execute CGMT")
        }
        //  DisplayThread(resultThread, units, calculateMaxEndTime(listOf(resultThread)))
    }
}

/**
 * Applies the Coarse Grain Multithreading algorithm to the given threads and units
 *
 * @param threads The threads to apply the algorithm to
 * @param units The processing units to use
 * @param caches The caches
 * @return The threads after applying the algorithm
 */
fun coarseGrainMultiTreading(
    threads: MutableList<CAThread>,
    units: MutableList<ProcessingUnit>,
    caches: MutableList<Cache>
): CAThread {
    // Initialize resultThread to an empty thread
    var resultThread = CAThread(0, "", 0, mutableListOf())

    // Iterate through each thread
    threads.forEach { thread ->
        // Iterate through each operation of the thread
        thread.operations.forEach { operation ->
            // Find the unit with the least workload
            val minWorkloadUnit = units.minByOrNull { it.numberOfLatencyCycles.last }!!

            // Calculate the latency cycles based on the cache hit or miss
            val latencyCycles = if (isCacheHit(operation, caches)) {
                caches.first { it.type == operation.unitId.toString() }.hitLatency
            } else {
                caches.first { it.type == operation.unitId.toString() }.missLatency +
                        minWorkloadUnit.numberOfLatencyCycles.first
            }

            // Assign the operation to the unit with the least workload
            resultThread.operations.add(
                Operation(
                    minWorkloadUnit.id,
                    operation.start + latencyCycles,
                    operation.end + latencyCycles
                )
            )
        }
    }
    return resultThread
}

/**
 * Checks if the operation causes a cache hit or miss
 *
 * @param operation The operation to check
 * @param caches The list of caches
 * @return True if it's a cache hit, false otherwise
 */
private fun isCacheHit(operation: Operation, caches: MutableList<Cache>): Boolean {
    return caches.any { it.type == operation.unitId.toString() }
}

