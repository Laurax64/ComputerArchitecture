package com.example.computerarchitecture.data

/**
 *  A data class that represents an operation in a thread under the assumption that no other threads interfere
 *
 *  @param unitId The ID of the [Unit] that the operation is performed with
 *  @param start The start time of the operation
 *  @param end The end time of the operation
 */
data class Operation(
    val unitId: Int,
    val start: Int,
    val end: Int,
)