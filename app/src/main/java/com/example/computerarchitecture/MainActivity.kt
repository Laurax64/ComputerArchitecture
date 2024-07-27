package com.example.computerarchitecture

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.computerarchitecture.ui.navigation.ComputerArchitectureNavHost
import com.example.computerarchitecture.ui.theme.ComputerArchitectureTheme
import dagger.hilt.android.AndroidEntryPoint

/**
 * The main activity for the application
 */
@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComputerArchitectureTheme {
                val navHostController: NavHostController = rememberNavController()
                val windowSize = calculateWindowSizeClass(this)
                ComputerArchitectureNavHost(navHostController, windowSize.widthSizeClass)
            }
        }
    }
}
