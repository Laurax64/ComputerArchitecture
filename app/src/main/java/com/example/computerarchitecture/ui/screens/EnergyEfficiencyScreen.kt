package com.example.computerarchitecture.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.tooling.preview.PreviewScreenSizes
import androidx.compose.ui.unit.dp
import com.example.computerarchitecture.R
import com.example.computerarchitecture.ui.components.TopicTopBar
import com.example.computerarchitecture.ui.theme.ComputerArchitectureTheme
import com.example.computerarchitecture.ui.viewmodels.EnergyEfficiencyViewModel

/**
 * Displays the energy efficiency screen.
 *
 * @param navigateBack The function to navigate back
 * @param energyEfficiencyViewModel The view model for the energy efficiency screen
 * @param modifier The modifier for the layout
 */
@Composable
fun EnergyEfficiencyScreen(
    navigateBack: () -> Unit,
    energyEfficiencyViewModel: EnergyEfficiencyViewModel,
    modifier: Modifier = Modifier,
) {
    Scaffold(
        modifier = modifier,
        topBar = {
            TopicTopBar(
                title = stringResource(R.string.energy_efficiency),
                navigateBack = navigateBack
            )
        },
    ) {
        EnergyEfficiencyScreen(
            energyEfficiencyViewModel.isStudyMode,
            Modifier
                .padding(it)
                .padding(start = 16.dp, end = 16.dp)
                .fillMaxWidth()
        )
    }
}

/**
 * Displays the energy efficiency screen.
 *
 * @param isStudyMode Whether the user is in study mode
 * @param modifier The modifier for the layout
 */
@Composable
fun EnergyEfficiencyScreen(isStudyMode: Boolean, modifier: Modifier = Modifier) {
    var expanded by rememberSaveable { mutableStateOf(!isStudyMode) }
    Card({ expanded = !expanded }, modifier) {
        Column(Modifier.padding(8.dp), Arrangement.spacedBy(8.dp)) {
            Text(
                text = stringResource(R.string.energy_formula),
                style = MaterialTheme.typography.titleLarge
            )
            if (expanded) {
                Image(
                    painter = painterResource(id = R.drawable.energy_formula),
                    contentDescription = null,
                    modifier = Modifier.fillMaxWidth()
                )
            }
        }
    }
}

/**
 * Displays previews for the energy efficiency screen.
 */
@PreviewLightDark
@PreviewScreenSizes
@Composable
fun EnergyEfficiencyScreenPreview() {
    ComputerArchitectureTheme {
        EnergyEfficiencyScreen(false)
    }
}