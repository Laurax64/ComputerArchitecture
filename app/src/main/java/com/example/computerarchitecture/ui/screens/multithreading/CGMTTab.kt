package com.example.computerarchitecture.ui.screens.multithreading

import android.annotation.SuppressLint
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.computerarchitecture.data.exampleThreads
import com.example.computerarchitecture.data.exampleUnits

/**
 * Displays the coarse grain multithreading tab
 *
 * @param modifier The modifier for the layout
 */
@SuppressLint("RestrictedApi")
@Composable
fun CGMTTab(
    modifier: Modifier = Modifier,
) {
    Column(
        modifier
            .verticalScroll(rememberScrollState())
            .horizontalScroll(rememberScrollState())
    ) {
        DisplayThreads(threads = exampleThreads, units = exampleUnits)
    }

}