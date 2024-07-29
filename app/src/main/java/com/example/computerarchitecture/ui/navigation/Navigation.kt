package com.example.computerarchitecture.ui.navigation

import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.computerarchitecture.ui.screens.CachingScreen
import com.example.computerarchitecture.ui.screens.EnergyEfficiencyScreen
import com.example.computerarchitecture.ui.screens.GPUsScreen
import com.example.computerarchitecture.ui.screens.MPIScreen
import com.example.computerarchitecture.ui.screens.OpenMPScreen
import com.example.computerarchitecture.ui.screens.PipelineScreen
import com.example.computerarchitecture.ui.screens.SpectreScreen
import com.example.computerarchitecture.ui.screens.TopicsScreen
import com.example.computerarchitecture.ui.screens.branchprediction.BranchPredictionScreen
import com.example.computerarchitecture.ui.screens.instructionscheduling.InstructionSchedulingScreen
import com.example.computerarchitecture.ui.screens.memoryhierarchy.MemoryHierarchyScreen
import com.example.computerarchitecture.ui.screens.multiprocessorsystems.MultiprocessorSystemsScreen
import com.example.computerarchitecture.ui.screens.multithreading.MultithreadingScreen
import com.example.computerarchitecture.ui.screens.network.NetworksScreen
import com.example.computerarchitecture.ui.viewmodels.BranchPredictionViewModel
import com.example.computerarchitecture.ui.viewmodels.CachingViewModel
import com.example.computerarchitecture.ui.viewmodels.EnergyEfficiencyViewModel
import com.example.computerarchitecture.ui.viewmodels.GPUsViewModel
import com.example.computerarchitecture.ui.viewmodels.InstructionSchedulingViewModel
import com.example.computerarchitecture.ui.viewmodels.MPIViewModel
import com.example.computerarchitecture.ui.viewmodels.MemoryHierarchyViewModel
import com.example.computerarchitecture.ui.viewmodels.MultiprocessorSystemsViewModel
import com.example.computerarchitecture.ui.viewmodels.MultithreadingViewModel
import com.example.computerarchitecture.ui.viewmodels.NetworksViewModel
import com.example.computerarchitecture.ui.viewmodels.OpenMPViewModel
import com.example.computerarchitecture.ui.viewmodels.PipelineViewModel
import com.example.computerarchitecture.ui.viewmodels.SpectreViewModel
import com.example.computerarchitecture.ui.viewmodels.TopicsViewModel

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
            TopicsScreen(
                navController::navigate,
                windowWidthSizeClass,
                hiltViewModel<TopicsViewModel>()
            )
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
            GPUsScreen(navController::popBackStack, hiltViewModel<GPUsViewModel>())
        }
        composable(OpenMPDestination.screenRoute) {
            OpenMPScreen(navController::popBackStack, hiltViewModel<OpenMPViewModel>())
        }
        composable(MPIDestination.screenRoute) {
            MPIScreen(navController::popBackStack, hiltViewModel<MPIViewModel>())
        }
        composable(NetworksDestination.screenRoute) {
            NetworksScreen(navController::popBackStack, hiltViewModel<NetworksViewModel>())
        }
        composable(EnergyEfficiencyDestination.screenRoute) {
            EnergyEfficiencyScreen(
                navController::popBackStack,
                hiltViewModel<EnergyEfficiencyViewModel>()
            )
        }
        composable(InstructionSchedulingDestination.screenRoute) {
            InstructionSchedulingScreen(
                navController::popBackStack,
                hiltViewModel<InstructionSchedulingViewModel>()
            )
        }
        composable(BranchPredictionDestination.screenRoute) {
            BranchPredictionScreen(
                navController::popBackStack,
                hiltViewModel<BranchPredictionViewModel>()
            )
        }
        composable(MemoryHierarchyDestination.screenRoute) {
            MemoryHierarchyScreen(
                navController::popBackStack,
                hiltViewModel<MemoryHierarchyViewModel>()
            )
        }
        composable(CachingDestination.screenRoute) {
            CachingScreen(navController::popBackStack, hiltViewModel<CachingViewModel>())
        }
        composable(SpectreDestination.screenRoute) {
            SpectreScreen(navController::popBackStack, hiltViewModel<SpectreViewModel>())
        }
        composable(PipelineDestination.screenRoute) {
            PipelineScreen(navController::popBackStack, hiltViewModel<PipelineViewModel>())
        }
    }
}
