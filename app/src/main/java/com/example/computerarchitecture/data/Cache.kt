package com.example.computerarchitecture.data

/**
 *  A data class that represents a Cache
 *
 *  @param type The type of the cache
 *  @param hitLatency The latency of a cache hit
 *   @param missLatency The latency of a cache miss
 */
data class Cache(
    val type: String,
    val hitLatency: Int,
    val missLatency: Int,
)

/**
 *  A list of all possible cache types that can be selected in the multithreading screen
 */
val cacheTypes = listOf("L1 Cache", "L2 Cache", "L3 Cache")

/**
 * A list of [Cache]s for the [exampleThreads]
 */
val exampleCaches = mutableListOf(Cache(cacheTypes[0], 1, 2), Cache(cacheTypes[1], 2, 4))
