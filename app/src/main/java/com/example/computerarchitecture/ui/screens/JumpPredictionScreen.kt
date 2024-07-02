package com.example.computerarchitecture.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.example.computerarchitecture.R
import com.example.computerarchitecture.ui.components.TopicTopBar

/**
 * Displays the jump prediction screen with an app scaffold.
 *
 * @param navigateBack The function to navigate back
 * @param modifier The modifier for the layout
 */
@Composable
fun JumpPredictionScreen(
    navigateBack: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Scaffold(
        modifier = modifier,
        topBar = {
            TopicTopBar(
                title = stringResource(R.string.jump_prediction),
                navigateBack = navigateBack
            )
        },
    ) { paddingValues ->
        JumpPredictionScreen(modifier.padding(paddingValues))
    }
}

/**
 * Displays the jump prediction screen.
 *
 * @param modifier The modifier for the layout
 */
@Composable
fun JumpPredictionScreen(modifier: Modifier = Modifier) {
    Column(modifier) {

    }
}