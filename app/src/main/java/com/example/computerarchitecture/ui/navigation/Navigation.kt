package com.example.computerarchitecture.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.computerarchitecture.ui.screens.MultithreadingDestination
import com.example.computerarchitecture.ui.screens.MultithreadingScreen
import com.example.computerarchitecture.ui.screens.TopicsDestination
import com.example.computerarchitecture.ui.screens.TopicsScreen

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
    }
}

