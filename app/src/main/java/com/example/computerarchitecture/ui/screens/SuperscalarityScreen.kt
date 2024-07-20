package com.example.computerarchitecture.ui.screens

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.tooling.preview.PreviewScreenSizes
import androidx.compose.ui.unit.dp
import com.example.computerarchitecture.R
import com.example.computerarchitecture.ui.components.TopicTopBar
import com.example.computerarchitecture.ui.theme.ComputerArchitectureTheme

/**
 * Displays the superscalarity screen.
 *
 * @param navigateBack The function to navigate back
 * @param modifier The modifier for the layout
 */
@Composable
fun SuperscalarityScreen(
    navigateBack: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Scaffold(
        modifier = modifier,
        topBar = {
            TopicTopBar(
                title = stringResource(R.string.superscalarity),
                navigateBack = navigateBack
            )
        },
    ) {
        SuperscalarityScreen(
            Modifier
                .padding(it)
                .padding(start = 16.dp, end = 16.dp)
        )
    }
}

/**
 * Displays the superscalarity screen.
 *
 * @param modifier The modifier for the layout
 */
@Composable
fun SuperscalarityScreen(modifier: Modifier = Modifier) {
}

/**
 * Displays previews for the superscalarity screen.
 */
@PreviewLightDark
@PreviewScreenSizes
@Composable
fun SuperscalarityScreenPreview() {
    ComputerArchitectureTheme {
        SuperscalarityScreen(navigateBack = {})
    }
}