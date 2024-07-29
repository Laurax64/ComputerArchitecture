package com.example.computerarchitecture.ui.screens.memoryhierarchy

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
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
import com.example.computerarchitecture.ui.viewmodels.MemoryHierarchyViewModel


/**
 * Displays the memory hierarchy screen.
 *
 * @param navigateBack The function to navigate back
 * @param memoryHierarchyViewModel The view model for the memory hierarchy screen
 * @param modifier The modifier for the layout
 */
@Composable
fun MemoryHierarchyScreen(
    navigateBack: () -> Unit,
    memoryHierarchyViewModel: MemoryHierarchyViewModel,
    modifier: Modifier = Modifier,
) {
    Scaffold(
        modifier = modifier,
        topBar = {
            TopicTopBar(
                title = stringResource(R.string.memory_hierarchy),
                navigateBack = navigateBack
            )
        },
    ) {
        MemoryHierarchyScreen(
            memoryHierarchyViewModel.isStudyMode,
            Modifier
                .padding(it)
                .padding(start = 16.dp, end = 16.dp)
                .fillMaxWidth()
        )
    }
}

/**
 * Displays the memory hierarchy screen.
 *
 * @param isStudyMode Whether the user is in study mode
 * @param modifier The modifier for the layout
 */
@Composable
fun MemoryHierarchyScreen(isStudyMode: Boolean, modifier: Modifier = Modifier) {
    Column(modifier.verticalScroll(rememberScrollState()), Arrangement.spacedBy(8.dp)) {
        HierarchyLevels(isStudyMode, Modifier.fillMaxWidth())
        MemoryAddress(isStudyMode, Modifier.fillMaxWidth())
        BlockPlacement(isStudyMode, Modifier.fillMaxWidth())
        BlockIdentification(isStudyMode, Modifier.fillMaxWidth())
        BlockReplacement(isStudyMode, Modifier.fillMaxWidth())
        WriteStrategy(isStudyMode, Modifier.fillMaxWidth())
    }
}

/**
 * Displays previews for the memory hierarchy screen.
 */
@PreviewLightDark
@PreviewScreenSizes
@Composable
fun MemoryHierarchyScreenPreview() {
    ComputerArchitectureTheme {
        MemoryHierarchyScreen(false)
    }
}