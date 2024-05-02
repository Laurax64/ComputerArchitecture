package com.example.computerarchitecture.ui.screens.multithreading

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

/**
 * Displays the fine grain multithreading tab
 *
 * @param modifier The modifier for the layout
 */
@SuppressLint("RestrictedApi")
@Composable
fun FGMTTab(
    modifier: Modifier = Modifier,
) {
    Column(modifier.verticalScroll(rememberScrollState())) {

    }

}