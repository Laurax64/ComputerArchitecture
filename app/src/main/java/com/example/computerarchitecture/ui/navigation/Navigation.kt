package com.example.computerarchitecture.ui.navigation

import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.computerarchitecture.ui.PipelineScreen
import com.example.computerarchitecture.ui.SpectreScreen
import com.example.computerarchitecture.ui.screens.EnergyEfficiencyScreen
import com.example.computerarchitecture.ui.screens.GPUsScreen
import com.example.computerarchitecture.ui.screens.MPIScreen
import com.example.computerarchitecture.ui.screens.NetworksScreen
import com.example.computerarchitecture.ui.screens.OpenMPScreen
import com.example.computerarchitecture.ui.screens.TopicsScreen
import com.example.computerarchitecture.ui.screens.branchprediction.BranchPredictionScreen
import com.example.computerarchitecture.ui.screens.caching.CachingScreen
import com.example.computerarchitecture.ui.screens.instructionscheduling.InstructionSchedulingScreen
import com.example.computerarchitecture.ui.screens.memoryhierarchy.MemoryHierarchyScreen
import com.example.computerarchitecture.ui.screens.multiprocessorsystems.MultiprocessorSystemsScreen
import com.example.computerarchitecture.ui.screens.multithreading.MultithreadingScreen
import com.example.computerarchitecture.ui.viewmodels.MultiprocessorSystemsViewModel
import com.example.computerarchitecture.ui.viewmodels.MultithreadingViewModel

/**
 * Provides a navigation graph for the screens with an app scaffold.
 *
 * @param navController The navigation controller
 * @param windowWidthSizeClass The window size class of the device
 * @param modifier The modifier for the layout
 */
@Composable
fun ComputerArchitectureNavHost(
    navController: NavHostController,
    windowWidthSizeClass: WindowWidthSizeClass,
    modifier: Modifier = Modifier,
) {
    NavHost(navController, TopicsDestination.screenRoute, modifier) {
        composable(TopicsDestination.screenRoute) {
            TopicsScreen(navController::navigate, windowWidthSizeClass)
        }
        composable(MultithreadingDestination.screenRoute) {
            MultithreadingScreen(
                navController::popBackStack,
                hiltViewModel<MultithreadingViewModel>()
            )
        }
        composable(MultiprocessorSystemsDestination.screenRoute) {
            MultiprocessorSystemsScreen(
                navController::popBackStack,
                hiltViewModel<MultiprocessorSystemsViewModel>()
            )
        }
        composable(GraphicsProcessingUnitsDestination.screenRoute) {
            GPUsScreen(navController::popBackStack)
        }
        composable(OpenMPDestination.screenRoute) {
            OpenMPScreen(navController::popBackStack)
        }
        composable(MPIDestination.screenRoute) {
            MPIScreen(navController::popBackStack)
        }
        composable(NetworksDestination.screenRoute) {
            NetworksScreen(navController::popBackStack)
        }
        composable(EnergyEfficiencyDestination.screenRoute) {
            EnergyEfficiencyScreen(navController::popBackStack)
        }
        composable(InstructionSchedulingDestination.screenRoute) {
            InstructionSchedulingScreen(navController::popBackStack)
        }
        composable(BranchPredictionDestination.screenRoute) {
            BranchPredictionScreen(navController::popBackStack)
        }
        composable(MemoryHierarchyDestination.screenRoute) {
            MemoryHierarchyScreen(navController::popBackStack)
        }
        composable(CachingDestination.screenRoute) {
            CachingScreen(navController::popBackStack)
        }
        composable(SpectreDestination.screenRoute) {
            SpectreScreen(navController::popBackStack)
        }
        composable(PipelineDestination.screenRoute) {
            PipelineScreen(navController::popBackStack)
        }
    }
}
