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
fun fineGrainMultithreading(threads: List<CAThread>): CAThread {
    val resultThread = CAThread(0, "", 0, mutableListOf()) // Initialize totalCycles to 0
    val currentStartTime = 0
    threads.flatMap { it.operations }.forEach { operation ->
        val operationStartTime = currentStartTime
        val operationEndTime = currentStartTime + 1
        resultThread.operations.add(
            Operation(
                operation.unitId,
                operation.threadId,
                operationStartTime,
                operationEndTime
            )
        )
    }
    return resultThread
}


