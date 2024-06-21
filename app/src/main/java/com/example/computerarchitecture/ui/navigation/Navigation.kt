package com.example.computerarchitecture.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.computerarchitecture.ui.screens.GPUsDestination
import com.example.computerarchitecture.ui.screens.GPUsScreen
import com.example.computerarchitecture.ui.screens.MultiprocessorSystemsDestination
import com.example.computerarchitecture.ui.screens.MultiprocessorSystemsScreen
import com.example.computerarchitecture.ui.screens.MultithreadingDestination
import com.example.computerarchitecture.ui.screens.MultithreadingScreen
import com.example.computerarchitecture.ui.screens.TopicsDestination
import com.example.computerarchitecture.ui.screens.TopicsScreen
import com.example.computerarchitecture.ui.screens.caching.AverageRuntimesDestination
import com.example.computerarchitecture.ui.screens.caching.AverageRuntimesScreen
import com.example.computerarchitecture.ui.screens.caching.BlockIdentificationDestination
import com.example.computerarchitecture.ui.screens.caching.BlockIdentificationScreen
import com.example.computerarchitecture.ui.screens.caching.BlockPlacementDestination
import com.example.computerarchitecture.ui.screens.caching.BlockPlacementScreen
import com.example.computerarchitecture.ui.screens.caching.BlockReplacementDestination
import com.example.computerarchitecture.ui.screens.caching.BlockReplacementScreen
import com.example.computerarchitecture.ui.screens.caching.CachingDestination
import com.example.computerarchitecture.ui.screens.caching.CachingScreen
import com.example.computerarchitecture.ui.screens.caching.WriteStrategyDestination
import com.example.computerarchitecture.ui.screens.caching.WriteStrategyScreen

/**
 * Provides a navigation graph for the application
 *
 * @param navController The navigation controller
 * @param modifier The modifier for the layout
 */
@Composable
fun ComputerArchitectureNavHost(
    navController: NavHostController,
    modifier: Modifier = Modifier,
) {
    NavHost(navController, TopicsDestination.route, modifier) {
        composable(route = TopicsDestination.route) {
            TopicsScreen(
                { navController.navigate(it) },
            )
        }
        composable(route = MultithreadingDestination.route) {
            MultithreadingScreen(
                { navController.popBackStack() },
            )
        }
        composable(route = MultiprocessorSystemsDestination.route) {
            MultiprocessorSystemsScreen(
                { navController.popBackStack() },
            )
        }
        composable(route = GPUsDestination.route) {
            GPUsScreen(
                { navController.popBackStack() },
            )
        }
        composable(route = CachingDestination.route) {
            CachingScreen(
                { navController.popBackStack() },
                { navController.navigate(it) },
            )
        }
        composable(route = AverageRuntimesDestination.route) {
            AverageRuntimesScreen {
                navController.popBackStack()
            }
        }
        composable(route = BlockIdentificationDestination.route) {
            BlockIdentificationScreen {
                navController.popBackStack()
            }
        }
        composable(route = BlockPlacementDestination.route) {
            BlockPlacementScreen {
                navController.popBackStack()
            }
        }
        composable(route = BlockReplacementDestination.route) {
            BlockReplacementScreen {
                navController.popBackStack()
            }
        }
        composable(route = WriteStrategyDestination.route) {
            WriteStrategyScreen {
                navController.popBackStack()
            }
        }
    }
}

