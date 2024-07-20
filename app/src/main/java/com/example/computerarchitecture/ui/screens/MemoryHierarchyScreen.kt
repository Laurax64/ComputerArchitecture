package com.example.computerarchitecture.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.tooling.preview.PreviewScreenSizes
import androidx.compose.ui.unit.dp
import com.example.computerarchitecture.R
import com.example.computerarchitecture.ui.components.TopicTopBar
import com.example.computerarchitecture.ui.theme.ComputerArchitectureTheme

private val technologies: List<Int> = listOf(
    R.string.tertiary_storage,
    R.string.secondary_storage,
    R.string.disk_caches,
    R.string.primary_memory,
    R.string.caches_tlbs,
    R.string.registers
)
/**
 * Displays the memory hierarchy screen.
 *
 * @param navigateBack The function to navigate back
 * @param modifier The modifier for the layout
 */
@Composable
fun MemoryHierarchyScreen(
    navigateBack: () -> Unit,
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
 * @param modifier The modifier for the layout
 */
@Composable
fun MemoryHierarchyScreen(modifier: Modifier = Modifier) {
    Column(modifier.verticalScroll(rememberScrollState()), Arrangement.spacedBy(8.dp)) {
        technologies.forEach {
            Card(Modifier.fillMaxWidth()) {
                Text(
                    text = stringResource(it),
                    modifier = Modifier.padding(8.dp),
                    style = MaterialTheme.typography.titleLarge,
                )
            }
        }
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
        MemoryHierarchyScreen(navigateBack = {})
    }
}