package com.example.computerarchitecture

import androidx.compose.ui.graphics.Color

/**
 * Generates a color based on the given index
 *
 * @param index The index of the thread
 * @return The generated color
 */
fun generateColor(index: Int): Color {
    val colors = listOf(
        Color.Blue,
        Color.Red,
        Color.Green,
        Color.Yellow,
        Color.Magenta,
        Color.Cyan,
    )
    return colors[index % colors.size]
}

