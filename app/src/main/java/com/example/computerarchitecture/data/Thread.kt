package com.example.computerarchitecture.data


/**
 *  A data class that represents a thread
 *
 *  @param name The name of the thread
 *  @param priority The priority of the thread
 *  @param operations The list of operations
 */
data class Thread(
    val name: String,
    val priority: Int,
    val operations: List<Operation>,
)

/**
 * A list of [Thread]s that can be used as an example in the multithreading screen
 */
val exampleThreads: List<Thread> = listOf(
    Thread(
        "A",
        0,
        listOf(
            Operation(0, 0, 1),
            Operation(2, 0, 4),
            Operation(0, 4, 5),
            Operation(0, 5, 6),
            Operation(1, 4, 5),
            Operation(1, 5, 6),
            Operation(3, 4, 5),
            Operation(3, 5, 6),
        )
    ),
    Thread(
        "B",
        1,
        listOf(
            Operation(0, 0, 1),
            Operation(1, 0, 1),
            Operation(2, 0, 1),
            Operation(3, 0, 1),
            Operation(0, 1, 2),
            Operation(2, 1, 2),
            Operation(2, 2, 4),
            Operation(0, 4, 5),
            Operation(1, 4, 5),
            Operation(0, 5, 6),
            Operation(1, 5, 6),
            Operation(3, 5, 6),
        )
    ),
    Thread(
        "C",
        2,
        listOf(
            Operation(3, 0, 1),
            Operation(3, 1, 2),
            Operation(3, 2, 3),
            Operation(3, 3, 4),
        )
    )
)