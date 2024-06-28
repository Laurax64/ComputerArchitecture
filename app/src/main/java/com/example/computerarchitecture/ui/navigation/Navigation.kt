package com.example.computerarchitecture.ui.navigation

import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
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
import com.example.computerarchitecture.ui.screens.caching.CachingDestination
import com.example.computerarchitecture.ui.screens.caching.CachingScreen

/**
 * Provides a navigation graph for the application
 *
 * @param navController The navigation controller
 * @param modifier The modifier for the layout
 */
@Composable
fun ComputerArchitectureNavHost(
    navController: NavHostController,
    windowWidthSizeClass: WindowWidthSizeClass,
    modifier: Modifier = Modifier,
) {
    NavHost(navController, TopicsDestination.route, modifier) {
        composable(route = TopicsDestination.route) {
            TopicsScreen({ navController.navigate(it) }, windowWidthSizeClass)
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
                { navController.popBackStack() }
            )
        }

    }
}

