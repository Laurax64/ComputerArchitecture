package com.example.computerarchitecture.ui.screens.multithreading

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
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
import com.example.computerarchitecture.data.Operation
import com.example.computerarchitecture.data.ProcessingUnit
import com.example.computerarchitecture.data.exampleThreads
import com.example.computerarchitecture.data.exampleUnits
import java.util.Collections.max

/**
 * Displays the fine grain multithreading tab
 *
 * @param modifier The modifier for the layout
 */
@Composable
fun FGMTTab(
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
        val threads: MutableList<CAThread> = exampleThreads
        val units: MutableList<ProcessingUnit> = exampleUnits
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

        // UI elements for configuring caches, processing units, and threads...

        // Execute the Fine Grain Multithreading algorithm if the user has added an L2 cache
        Button(
            {
                resultThread = fineGrainMultithreading(threads)
            },
            Modifier.fillMaxWidth()
        ) {
            Text("Execute FGMT")
        }
        DisplayThread(resultThread, units, calculateMaxEndTime(listOf(resultThread)))
    }
}

/**
 * Applies the Fine Grain Multithreading algorithm to the given threads and units
 *
 * @param threads The threads to apply the algorithm to
 * @return The threads after applying the algorithm
 */
fun fineGrainMultithreading(threads: MutableList<CAThread>): CAThread {
    val resultThread = CAThread(0, "", 0, mutableListOf())
    val threadsCopy: MutableList<CAThread> = mutableListOf()
    threadsCopy.addAll(threads)
    // Sort the threads by the number
    var start = 0
    var end = 1
    val operations = mutableListOf<Operation>()

    var maxOperationCount = max(threadsCopy.map { it.operations.size })
    var unitIndex = 0
    while (unitIndex < 4) {
        var operationIndex = 0
        while (operationIndex < maxOperationCount) {
            var threadIndex = 0
            while (threadIndex < threadsCopy.size) {
                if (threads[threadIndex].operations.size > operationIndex) {
                    if (threads[threadIndex].operations[operationIndex].unitId == unitIndex) {
                        operations.add(
                            Operation(
                                threads[threadIndex].operations[operationIndex].unitId,
                                threads[threadIndex].operations[operationIndex].threadId,
                                start,
                                end
                            )
                        )
                    }
                    operationIndex++
                }
                threadIndex++
            }
        }
        start++
        end++
        unitIndex++
    }
    resultThread.operations.addAll(operations.sortedBy { it.start })
    return resultThread
}


