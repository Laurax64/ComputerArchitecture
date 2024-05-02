package com.example.computerarchitecture.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.computerarchitecture.ui.screens.TopicsDestination
import com.example.computerarchitecture.ui.screens.TopicsScreen
import com.example.computerarchitecture.ui.screens.multithreading.MultithreadingDestination
import com.example.computerarchitecture.ui.screens.multithreading.MultithreadingScreen

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
                { navController.navigate(getUnitsRoute(it)) },
            )
        }
        composable(route = MultithreadingDestination.route) {
            MultithreadingScreen(
                { navController.popBackStack() },
            )
        }
    }
}

/**
 * Gets the route for the given screen name
 *
 * @param name The name of the screen
 * @return The corresponding route for the screen
 * @throws IllegalArgumentException if the screen name is unknown
 */
private fun getUnitsRoute(name: String): String = when (name) {
    "Multithreading" -> "multithreading"
    else -> throw IllegalArgumentException("Unknown unit name: $name")
}
