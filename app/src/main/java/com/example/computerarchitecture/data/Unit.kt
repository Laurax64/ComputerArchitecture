package com.example.computerarchitecture.data

/**
 *  A data class that represents a unit
 *
 * @param id The ID of the unit
 * @param type The type of the unit
 * @param numberOfLatencyCycles The number of latency cycles for the unit
 */
data class ProcessingUnit(
    val id: Int,
    val type: String,
    val numberOfLatencyCycles: IntRange,
)

/**
 * A list of all possible unit types of the multithreading screen
 */
val units = listOf("Integer Unit", "Floating Point Unit", "Load/Store Unit")

/**
 * The list of [CAUnit]s for the [exampleThreads]
 */
val exampleUnits = mutableListOf(
    ProcessingUnit(0, "Integer Unit", 1..1),
    ProcessingUnit(1, "Integer Unit", 1..1),
    ProcessingUnit(2, "Floating Point Unit", 1..4),
    ProcessingUnit(3, "Load/Store Unit", 1..1)
)

