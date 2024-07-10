package com.example.computerarchitecture.data

import com.example.computerarchitecture.ui.navigation.BranchPredictionDestination
import com.example.computerarchitecture.ui.navigation.CachingDestination
import com.example.computerarchitecture.ui.navigation.EnergyEfficiencyDestination
import com.example.computerarchitecture.ui.navigation.FlashMemoryDestination
import com.example.computerarchitecture.ui.navigation.GraphicsProcessingUnitsDestination
import com.example.computerarchitecture.ui.navigation.InstructionSchedulingDestination
import com.example.computerarchitecture.ui.navigation.MPIDestination
import com.example.computerarchitecture.ui.navigation.MemoryHierarchyDestination
import com.example.computerarchitecture.ui.navigation.MultiprocessorSystemsDestination
import com.example.computerarchitecture.ui.navigation.MultithreadingDestination
import com.example.computerarchitecture.ui.navigation.NavigationDestination
import com.example.computerarchitecture.ui.navigation.NetworksDestination
import com.example.computerarchitecture.ui.navigation.OpenMPDestination
import com.example.computerarchitecture.ui.navigation.ReliabilityDestination
import com.example.computerarchitecture.ui.navigation.SuperscalarityDestination


/**
 * An enum class that represents the computer architecture topics that can be navigated to.
 *
 * @param title The title of the topic
 * @param navigationDestination The navigation destination
 */
enum class Topic(val title: String, val navigationDestination: NavigationDestination) {
    MULTITHREADING("Multithreading", MultithreadingDestination),
    MULTIPROCESSOR_SYSTEMS("Multiprocessor Systems", MultiprocessorSystemsDestination),
    GRAPHICS_PROCESSING_UNITS("Graphics Processing Units", GraphicsProcessingUnitsDestination),
    OPENMP("OpenMP", OpenMPDestination),
    MPI("MPI", MPIDestination),
    NETWORKS("Networks", NetworksDestination),
    ENERGY_EFFICIENCY("Energy Efficiency", EnergyEfficiencyDestination),
    INSTRUCTION_SCHEDULING("Instruction Scheduling", InstructionSchedulingDestination),
    RELIABILITY("Reliability", ReliabilityDestination),
    JUMP_PREDICTION("Branch Prediction", BranchPredictionDestination),
    SUPERSCALARITY("Superscalarity", SuperscalarityDestination),
    MEMORY_HIERARCHY("Memory Hierarchy", MemoryHierarchyDestination),
    FLASH_MEMORY("Flash Memory", FlashMemoryDestination),
    CACHING("Caching", CachingDestination);
}
