package com.example.computerarchitecture.data

import com.example.computerarchitecture.R

/**
 * A data class that represents a scheduling algorithm that can be selected in the multithreading screen
 *
 * @param name The name of the scheduling algorithm
 * @param description A description of the scheduling algorithm
 */
data class SchedulingAlgorithm(
    val name: String,
    val description: String
)

/**
 * A list of the [SchedulingAlgorithm]s that can be selected in the multithreading screen
 */
val schedulingAlgorithms = listOf(
    SchedulingAlgorithm(
        R.string.as_soon_as_possible_name.toString(),
        R.string.as_soon_as_possible_description.toString()
    ),
    SchedulingAlgorithm(
        R.string.as_late_as_possible_name.toString(),
        R.string.as_late_as_possible_description.toString()
    ),
)
