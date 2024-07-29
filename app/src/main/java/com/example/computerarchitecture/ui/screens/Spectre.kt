package com.example.computerarchitecture.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.tooling.preview.PreviewScreenSizes
import androidx.compose.ui.unit.dp
import com.example.computerarchitecture.R
import com.example.computerarchitecture.ui.components.TopicTopBar
import com.example.computerarchitecture.ui.theme.ComputerArchitectureTheme
import com.example.computerarchitecture.ui.viewmodels.SpectreViewModel

/**
 * Displays a screen with information about spectre.
 *
 * @param navigateBack The function to navigate back
 * @param spectreViewModel The view model for the spectre screen
 * @param modifier The modifier for the layout
 */
@Composable
fun SpectreScreen(
    navigateBack: () -> Unit,
    spectreViewModel: SpectreViewModel,
    modifier: Modifier = Modifier,
) {
    Scaffold(
        modifier = modifier,
        topBar = {
            TopicTopBar(
                title = stringResource(R.string.spectre),
                navigateBack = navigateBack
            )
        },
    ) {
        SpectreScreen(
            spectreViewModel.isStudyMode,
            Modifier
                .padding(it)
                .padding(start = 16.dp, end = 16.dp)
        )
    }
}

/**
 * Displays a screen with information about spectre.
 *
 * @param isStudyMode Whether the user is in study mode
 * @param modifier The modifier for the layout
 */
@Composable
fun SpectreScreen(isStudyMode: Boolean, modifier: Modifier = Modifier) {
    Column(modifier.verticalScroll(rememberScrollState()), Arrangement.spacedBy(8.dp)) {
        SpectreAttacks(isStudyMode, Modifier.fillMaxWidth())
        AvoidSpectreAttacks(isStudyMode, Modifier.fillMaxWidth())
    }
}

/**
 * Displays a card with information about spectre attacks.
 *
 * @param isStudyMode Whether the user is in study mode
 * @param modifier The modifier for the layout
 */
@Composable
private fun SpectreAttacks(isStudyMode: Boolean, modifier: Modifier = Modifier) {
    var expanded by rememberSaveable { mutableStateOf(!isStudyMode) }
    Card({ expanded = !expanded }, modifier) {
        Column(Modifier.padding(8.dp), Arrangement.spacedBy(8.dp)) {
            Text(
                text = stringResource(R.string.spectre_attacks),
                style = MaterialTheme.typography.titleLarge,
            )
            if (expanded) {
                Text(
                    text = stringResource(R.string.spectre_attacks_description),
                    style = MaterialTheme.typography.bodyMedium,
                )
                SpectreAttacksStepOne(Modifier.fillMaxWidth())
                SpectreAttacksStepTwo(Modifier.fillMaxWidth())
                SpectreAttacksStepThree(Modifier.fillMaxWidth())
            }
        }
    }
}

/**
 * Displays a card with information about a first step of a spectre attack.
 *
 * @param modifier The modifier for the layout
 */
@Composable
private fun SpectreAttacksStepOne(modifier: Modifier = Modifier) {
    var expanded by rememberSaveable { mutableStateOf(false) }
    OutlinedCard({ expanded = !expanded }, modifier) {
        Column(Modifier.padding(8.dp), Arrangement.spacedBy(8.dp)) {
            Text(
                text = stringResource(R.string.spectre_attacks_step_one),
                fontWeight = FontWeight.Bold,
            )
            if (expanded) {
                Text(
                    text = stringResource(R.string.spectre_attacks_step_one_example),
                    style = MaterialTheme.typography.bodyMedium,
                )
            }
        }
    }
}


/**
 * Displays a card with information about a second step of a spectre attack.
 *
 * @param modifier The modifier for the layout
 */
@Composable
private fun SpectreAttacksStepTwo(modifier: Modifier = Modifier) {
    var expanded by remember { mutableStateOf(false) }
    OutlinedCard({ expanded = !expanded }, modifier) {
        Column(Modifier.padding(8.dp), Arrangement.spacedBy(8.dp)) {
            Text(
                text = stringResource(R.string.spectre_attacks_step_two),
                fontWeight = FontWeight.Bold,
            )
            if (expanded) {
                Text(
                    text = stringResource(R.string.spectre_attacks_step_two_example),
                    style = MaterialTheme.typography.bodyMedium,
                )
            }
        }
    }
}

/**
 * Displays a card with information about a third step of a spectre attack.
 *
 * @param modifier The modifier for the layout
 */
@Composable
private fun SpectreAttacksStepThree(modifier: Modifier = Modifier) {
    var expanded by rememberSaveable { mutableStateOf(false) }
    OutlinedCard({ expanded = !expanded }, modifier) {
        Column(Modifier.padding(8.dp), Arrangement.spacedBy(8.dp)) {
            Text(
                text = stringResource(R.string.spectre_attacks_step_three),
                fontWeight = FontWeight.Bold,
            )
            if (expanded) {
                Text(
                    text = stringResource(R.string.spectre_attacks_step_three_example),
                    style = MaterialTheme.typography.bodyMedium,
                )
            }
        }
    }
}

/**
 * Displays a card with information about how to avoid spectre attacks.
 *
 * @param isStudyMode Whether the user is in study mode
 * @param modifier The modifier for the layout
 */
@Composable
private fun AvoidSpectreAttacks(isStudyMode: Boolean, modifier: Modifier = Modifier) {
    var expanded by rememberSaveable { mutableStateOf(!isStudyMode) }
    OutlinedCard({ expanded = !expanded }, modifier) {
        Column(Modifier.padding(8.dp), Arrangement.spacedBy(8.dp)) {
            Text(
                text = stringResource(R.string.avoid_spectre_attacks),
                style = MaterialTheme.typography.titleLarge,
            )
            if (expanded) {
                Text(
                    text = stringResource(R.string.avoid_spectre_attacks_description),
                    style = MaterialTheme.typography.bodyMedium,
                )
            }
        }
    }
}

/**
 * Displays previews for the spectre screen.
 */
@PreviewLightDark
@PreviewScreenSizes
@Composable
fun SpectreScreenPreview() {
    ComputerArchitectureTheme {
        SpectreScreen(false)
    }
}