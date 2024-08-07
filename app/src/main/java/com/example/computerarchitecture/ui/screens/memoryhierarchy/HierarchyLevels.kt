package com.example.computerarchitecture.ui.screens.memoryhierarchy

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.computerarchitecture.R
import com.example.computerarchitecture.ui.theme.ComputerArchitectureTheme

/**
 * The hierarchy levels.
 */
private val technologies: List<Int> = listOf(
    R.string.tertiary_storage,
    R.string.secondary_storage,
    R.string.disk_caches,
    R.string.primary_memory,
    R.string.caches_tlbs,
    R.string.registers
)

/**
 * Displays a card with information about the hierarchy levels.
 *
 * @param isStudyMode Whether the user is in study mode
 * @param modifier The modifier for the layout
 */
@Composable
fun HierarchyLevels(isStudyMode: Boolean, modifier: Modifier = Modifier) {
    var expanded by rememberSaveable { mutableStateOf(!isStudyMode) }
    Card({ expanded = !expanded }, modifier) {
        Column(Modifier.padding(8.dp), Arrangement.spacedBy(8.dp)) {
            Text(
                text = stringResource(R.string.hierarchy_levels),
                style = MaterialTheme.typography.titleLarge,
            )
            if (expanded) {
                technologies.forEach {
                    Text(text = stringResource(it))
                }
            }
        }
    }
}

/**
 * Displays a preview of the hierarchy level card.
 */
@Preview
@Composable
fun HierarchyLevelsPreview() {
    ComputerArchitectureTheme {
        HierarchyLevels(false)
    }
}