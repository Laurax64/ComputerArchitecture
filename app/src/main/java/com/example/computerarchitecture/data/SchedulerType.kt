package com.example.computerarchitecture.data

import com.example.computerarchitecture.R

/**
 *  A data class that represents a scheduler type that can be selected in the multithreading screen
 *
 *  @param name The name of the scheduler
 *  @param description A description of the scheduler
 */
data class SchedulerType(
    val name: String,
    val description: String
)

/**
 *  A list of all possible [SchedulerType]s that can be selected in the multithreading screen
 */
val schedulerTypes = listOf(
    SchedulerType(
        R.string.static_scheduling_name.toString(),
        R.string.static_scheduling_description.toString()
    ),
    SchedulerType(
        R.string.dynamic_scheduling_name.toString(),
        R.string.dynamic_scheduling_description.toString()
    )
)