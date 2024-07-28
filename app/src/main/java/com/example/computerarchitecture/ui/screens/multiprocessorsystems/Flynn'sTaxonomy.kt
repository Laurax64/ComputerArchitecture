package com.example.computerarchitecture.ui.screens.multiprocessorsystems

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
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
import androidx.compose.ui.unit.dp
import com.example.computerarchitecture.R

/**
 * Displays a card with information about Flynn's Taxonomy
 *
 * @param isStudyMode Whether the user is in study mode
 * @param modifier The modifier for the layout
 */
@Composable
fun FlynnsTaxonomy(isStudyMode: Boolean, modifier: Modifier = Modifier) {
    Column(modifier.verticalScroll(rememberScrollState()), Arrangement.spacedBy(8.dp)) {
        SISD(isStudyMode, Modifier.fillMaxWidth())
        SIMD(isStudyMode, Modifier.fillMaxWidth())
        MISD(isStudyMode, Modifier.fillMaxWidth())
        MIMD(isStudyMode, Modifier.fillMaxWidth())
    }
}

/**
 * Displays a card with information about single instruction single data.
 *
 * @param isStudyMode Whether the user is in study mode
 * @param modifier The modifier for the layout
 */
@Composable
private fun SISD(isStudyMode: Boolean, modifier: Modifier = Modifier) {
    var expanded by rememberSaveable { mutableStateOf(!isStudyMode) }
    Card({ expanded = !expanded }, modifier) {
        Column(Modifier.padding(8.dp)) {
            Text(
                text = stringResource(R.string.sisd),
                style = MaterialTheme.typography.titleLarge
            )
            if (expanded) {
                Text(
                    text = stringResource(R.string.sisd_description),
                )
            }
        }
    }
}

/**
 * Displays a card with information about single instruction multiple data.
 *
 * @param isStudyMode Whether the user is in study mode
 * @param modifier The modifier for the layout
 */
@Composable
private fun SIMD(isStudyMode: Boolean, modifier: Modifier = Modifier) {
    var expanded by rememberSaveable { mutableStateOf(!isStudyMode) }
    Card({ expanded = !expanded }, modifier) {
        Column(Modifier.padding(8.dp)) {
            Text(
                text = stringResource(R.string.simd),
                style = MaterialTheme.typography.titleLarge
            )
            if (expanded) {
                Text(
                    text = stringResource(R.string.simd_description),
                )
            }
        }
    }
}

/**
 * Displays a card with information about multiple instruction single data.
 *
 * @param isStudyMode Whether the user is in study mode
 * @param modifier The modifier for the layout
 */
@Composable
private fun MISD(isStudyMode: Boolean, modifier: Modifier = Modifier) {
    var expanded by rememberSaveable { mutableStateOf(!isStudyMode) }
    Card({ expanded = !expanded }, modifier) {
        Column(Modifier.padding(8.dp)) {
            Text(
                text = stringResource(R.string.misd),
                style = MaterialTheme.typography.titleLarge
            )
            if (expanded) {
                Text(
                    text = stringResource(R.string.misd_description),
                )
            }
        }
    }
}

/**
 * Displays a card with information about multiple instruction multiple data.
 *
 * @param isStudyMode Whether the user is in study mode
 * @param modifier The modifier for the layout
 */
@Composable
private fun MIMD(isStudyMode: Boolean, modifier: Modifier = Modifier) {
    var expanded by rememberSaveable { mutableStateOf(!isStudyMode) }
    Card({ expanded = !expanded }, modifier) {
        Column(Modifier.padding(8.dp)) {
            Text(
                text = stringResource(R.string.mimd),
                style = MaterialTheme.typography.titleLarge
            )
            if (expanded) {
                Text(
                    text = stringResource(R.string.mimd_description),
                )
            }
        }
    }
}