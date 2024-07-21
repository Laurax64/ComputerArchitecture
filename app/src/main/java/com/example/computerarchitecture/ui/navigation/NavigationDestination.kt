package com.example.computerarchitecture.ui.navigation

/**
 * Interface to describe the navigation destinations for the app
 *
 * @property screenRoute The route for the screen
 * @property contentRoute The route for the content
 */
interface NavigationDestination {
    val screenRoute: String
    val contentRoute: String
}

/**
 * Represents a navigation destination for the topics screen.
 */
object TopicsDestination : NavigationDestination {
    override val screenRoute: String = "topics"
    override val contentRoute: String = ""
}

/**
 * Represents a navigation destination for the multithreading topic.
 */
object MultithreadingDestination : NavigationDestination {
    override val screenRoute: String = "multithreading"
    override val contentRoute: String = "multithreading_content"
}

/**
 * Represents a navigation destination for the multiprocessor systems topic.
 */
object MultiprocessorSystemsDestination : NavigationDestination {
    override val screenRoute: String = "multiprocessor_systems"
    override val contentRoute: String = "multiprocessor_systems_content"
}

/**
 * Represents a navigation destination for the graphics processing units topic.
 */
object GraphicsProcessingUnitsDestination : NavigationDestination {
    override val screenRoute: String = "graphics_processing_units"
    override val contentRoute: String = "graphics_processing_units_content"
}

/**
 * Represents a navigation destination for the OpenMP topic.
 */
object OpenMPDestination : NavigationDestination {
    override val screenRoute: String = "openmp"
    override val contentRoute: String = "openmp_content"
}

/**
 * Represents a navigation destination for the MPI topic.
 */
object MPIDestination : NavigationDestination {
    override val screenRoute: String = "mpi"
    override val contentRoute: String = "mpi_content"
}

/**
 * Represents a navigation destination for the networks topic.
 */
object NetworksDestination : NavigationDestination {
    override val screenRoute: String = "networks"
    override val contentRoute: String = "networks_content"
}

/**
 * Represents a navigation destination for the energy efficiency topic.
 */
object EnergyEfficiencyDestination : NavigationDestination {
    override val screenRoute: String = "energy_efficiency"
    override val contentRoute: String = "energy_efficiency_content"
}

/**
 * Represents a navigation destination for the instruction scheduling topic.
 */
object InstructionSchedulingDestination : NavigationDestination {
    override val screenRoute: String = "instruction_scheduling"
    override val contentRoute: String = "instruction_scheduling_content"
}

/**
 * Represents a navigation destination for the reliability topic.
 */
object ReliabilityDestination : NavigationDestination {
    override val screenRoute: String = "reliability"
    override val contentRoute: String = "reliability_content"
}

/**
 * Represents a navigation destination for the jump prediction topic.
 */
object BranchPredictionDestination : NavigationDestination {
    override val screenRoute: String = "branch_prediction"
    override val contentRoute: String = "branch_prediction_content"
}

/**
 * Represents a navigation destination for the superscalarity topic.
 */
object SuperscalarityDestination : NavigationDestination {
    override val screenRoute: String = "superscalarity"
    override val contentRoute: String = "superscalarity_content"
}

/**
 * Represents a navigation destination for the memory hierarchy topic.
 */
object MemoryHierarchyDestination : NavigationDestination {
    override val screenRoute: String = "memory_hierarchy"
    override val contentRoute: String = "memory_hierarchy_content"
}

/**
 * Represents a navigation destination for the flash memory topic.
 */
object FlashMemoryDestination : NavigationDestination {
    override val screenRoute: String = "flash_memory"
    override val contentRoute: String = "flash_memory_content"
}

/**
 * Represents a navigation destination for the caching topic.
 */
object CachingDestination : NavigationDestination {
    override val screenRoute: String = "caching"
    override val contentRoute: String = "caching_content"
}

/**
 * Represents a navigation destination for the spectre topic.
 */
object SpectreDestination : NavigationDestination {
    override val screenRoute: String = "spectre"
    override val contentRoute: String = "spectre_content"
}
