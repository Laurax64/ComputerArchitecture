package com.example.computerarchitecture.viewmodels

import androidx.lifecycle.ViewModel
import com.example.computerarchitecture.data.Cache
import com.example.computerarchitecture.data.ProcessingUnit
import com.example.computerarchitecture.data.SchedulerType
import com.example.computerarchitecture.data.SchedulingAlgorithm
import com.example.computerarchitecture.data.Thread
import com.example.computerarchitecture.data.exampleCaches
import com.example.computerarchitecture.data.exampleThreads
import com.example.computerarchitecture.data.exampleUnits
import com.example.computerarchitecture.data.schedulerTypes
import com.example.computerarchitecture.data.schedulingAlgorithms
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

/**
 * A view model for the multithreading screen
 *
 * @property _uiState The mutable state flow that can be updated in the [MultithreadingViewModel]
 * @property uiState The read-only state flow for the multithreading screen
 */
class MultithreadingViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(MultithreadingUiState())
    val uiState: StateFlow<MultithreadingUiState> = _uiState.asStateFlow()

    /**
     * Updates the _uiState with the given values
     *
     * @param uiState The new state of the multithreading screen
     */
    fun updateUiState(uiState: MultithreadingUiState) {
        _uiState.value = uiState
    }

    /**
     * Updates the _uiState with example values to show an example in the multithreading screen
     */
    fun useExample() {
        updateUiState(
            MultithreadingUiState(
                units = exampleUnits, caches = exampleCaches, threads = exampleThreads
            )
        )
    }
}

/**
 * The ui state for the multithreading screen
 *
 * @param schedulerType The type of the scheduler
 * @param schedulingAlgorithm The scheduling algorithm
 * @param numberOfProcessors The number of processors
 * @param units The list of units
 * @param caches The list of caches
 * @param hitUnderNMiss The value n for hit under n miss
 * @param cgmtContextSwitchOverhead The context switch overhead for CGMT
 * @param fgmtContextSwitchOverhead The context switch overhead for FGMT
 * @param smtContextSwitchOverhead The context switch overhead for SMT
 * @param cacheInterference False if the caches do not interfere with each other and true otherwise
 * @param threads The list of threads
 */
data class MultithreadingUiState(
    val schedulerType: SchedulerType = schedulerTypes[0],
    val schedulingAlgorithm: SchedulingAlgorithm = schedulingAlgorithms[0],
    val numberOfProcessors: Int = 1,
    val units: MutableList<ProcessingUnit> = mutableListOf(),
    val caches: MutableList<Cache> = mutableListOf(),
    val hitUnderNMiss: Int = 1,
    val cgmtContextSwitchOverhead: Int = 1,
    val fgmtContextSwitchOverhead: Int = 0,
    val smtContextSwitchOverhead: Int = 0,
    val cacheInterference: Boolean = false,
    val threads: List<Thread> = listOf()
)