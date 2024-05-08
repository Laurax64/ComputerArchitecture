package com.example.computerarchitecture.ui.screens.multithreading

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.computerarchitecture.data.CAThread
import com.example.computerarchitecture.data.Cache
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
        var threads = exampleThreads
        val caches = exampleCaches
        var units = exampleUnits


        var resultThread: CAThread by remember {
            mutableStateOf(
                CAThread(
                    0,
                    "",
                    0,
                    mutableListOf()
                )
            )
        }

        Text("Context Switch Overhead:", style = MaterialTheme.typography.titleMedium)
        Text("1 cycle")
        Text("Processing Units:", style = MaterialTheme.typography.titleMedium)
        units.forEach {
            Text("Unit ${it.id}, type ${it.type}, latency ${it.numberOfLatencyCycles}")
        }
        Text("Caches:", style = MaterialTheme.typography.titleMedium)
        caches.forEach {
            Text("${it.type}, hit latency ${it.hitLatency}, miss latency ${it.missLatency}")
        }



        DisplayThreads(threads = threads, units = units)

        //  Execute the Coarse Grain Multithreading algorithm if the user has added an L2 cache
        Button(
            {
                val l2Cache = caches.find { it.type == "L2 Cache" }
                if (l2Cache == null) {
                    Toast.makeText(
                        null,
                        "Please add an L2 cache to continue",
                        Toast.LENGTH_SHORT
                    ).show()
                } else {
                    resultThread =
                        coarseGrainMultiTreading(threads, units, caches, l2Cache.missLatency, 1)
                }
            },
            Modifier.fillMaxWidth()
        ) {
            Text("Execute CGMT")
        }
        DisplayThread(resultThread, units, calculateMaxEndTime(listOf(resultThread)))
    }
}

/**
 * Applies the Coarse Grain Multithreading algorithm to the given threads and units
 *
 * @param threads The threads to apply the algorithm to
 * @param units The processing units to use
 * @param caches The caches
 * @param l2CacheMiss The latency of an L2 cache miss
 * @param contextSwitchOverhead The context switch overhead
 * @return The threads after applying the algorithm
 */
fun coarseGrainMultiTreading(
    threads: List<CAThread>,  // Change parameter type to List to ensure immutability
    units: List<ProcessingUnit>,
    caches: List<Cache>,
    l2CacheMiss: Int,
    contextSwitchOverhead: Int
): CAThread {
    val resultThread = CAThread(0, "", 0, mutableListOf())
    var totalOperations = threads.sumOf { it.operations.size }
    var threadIndex = 0
    var recentEndTime = 0
    val copiedThreads = threads.map { thread ->
        thread.copy(operations = thread.operations.toMutableList())
    }

    while (totalOperations > 0) {
        val currentThread = copiedThreads[threadIndex]
        val nextOperation = currentThread.operations.firstOrNull()

        if (nextOperation != null) {
            if (nextOperation.start <= recentEndTime) {
                resultThread.operations.add(nextOperation)
                currentThread.operations.removeAt(0)
                totalOperations--
                recentEndTime = nextOperation.end
                if (nextOperation.start < l2CacheMiss) {
                    threadIndex = (threadIndex + 1) % copiedThreads.size
                }
            } else {
                threadIndex = (threadIndex + 1) % copiedThreads.size
            }
        } else {
            threadIndex = (threadIndex + 1) % copiedThreads.size
        }
    }
    return resultThread
}
