package com.example.computerarchitecture.data


/**
 *  A data class that represents a thread
 *
 * @param id The id of the thread
 *  @param name The name of the thread
 *  @param priority The priority of the thread
 *  @param operations The list of operations
 */
data class CAThread(
    val id: Int,
    val name: String,
    var priority: Int,
    val operations: MutableList<Operation>
)

/**
 * A list of [CAThread]s that can be used as an example in the multithreading screen
 */
val exampleThreads: MutableList<CAThread> = mutableListOf(
    CAThread(
        0,
        "A",
        0,
        mutableListOf(
            Operation(0, 0, 0, 1),
            Operation(2, 0, 0, 4),
            Operation(0, 0, 4, 5),
            Operation(0, 0, 5, 6),
            Operation(1, 0, 4, 5),
            Operation(1, 0, 5, 6),
            Operation(3, 0, 4, 5),
            Operation(3, 0, 5, 6)
        )
    ),
    CAThread(
        1,
        "B",
        1,
        mutableListOf(
            Operation(0, 1, 0, 1),
            Operation(1, 1, 0, 1),
            Operation(2, 1, 0, 1),
            Operation(3, 1, 0, 1),
            Operation(0, 1, 1, 2),
            Operation(2, 1, 1, 2),
            Operation(2, 1, 2, 4),
            Operation(0, 1, 4, 5),
            Operation(1, 1, 4, 5),
            Operation(0, 1, 5, 6),
            Operation(1, 1, 5, 6),
            Operation(3, 1, 5, 6)
        )
    ),
    CAThread(
        2,
        "C",
        2,
        mutableListOf(
            Operation(3, 2, 0, 1),
            Operation(3, 2, 1, 2),
            Operation(3, 2, 2, 3),
            Operation(3, 2, 3, 4)
        )
    )
)