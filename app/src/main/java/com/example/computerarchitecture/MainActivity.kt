package com.example.computerarchitecture

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.computerarchitecture.ui.navigation.ComputerArchitectureNavHost
import com.example.computerarchitecture.ui.theme.ComputerArchitectureTheme

/**
 * The main activity for the application
 */
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComputerArchitectureTheme {
                val navHostController: NavHostController = rememberNavController()
                ComputerArchitectureNavHost(navHostController)
            }
        }
    }
}