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
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.computerarchitecture.R

/**
 * Displays a card with information about Flynn's Taxonomy
 *
 *  @param modifier The modifier for the layout
 */
@Composable
fun FlynnsTaxonomy(modifier: Modifier = Modifier) {
    Column(
        modifier
            .verticalScroll(rememberScrollState()), Arrangement.spacedBy(8.dp)
    ) {
        SISD(Modifier.fillMaxWidth())
        SIMD(Modifier.fillMaxWidth())
        MISD(Modifier.fillMaxWidth())
        MIMD(Modifier.fillMaxWidth())

    }
}

/**
 * Displays a card with information about single instruction single data.
 *
 * @param modifier The modifier for the layout
 */
@Composable
private fun SISD(modifier: Modifier = Modifier) {
    Card(modifier) {
        Column(Modifier.padding(8.dp)) {
            Text(
                text = stringResource(R.string.sisd),
                style = MaterialTheme.typography.titleLarge
            )
            Text(
                text = stringResource(R.string.sisd_description),
            )
        }
    }
}

/**
 * Displays a card with information about single instruction multiple data.
 *
 * @param modifier The modifier for the layout
 */
@Composable
private fun SIMD(modifier: Modifier = Modifier) {
    Card(modifier) {
        Column(Modifier.padding(8.dp)) {
            Text(
                text = stringResource(R.string.simd),
                style = MaterialTheme.typography.titleLarge
            )
            Text(
                text = stringResource(R.string.simd_description),
            )
        }
    }
}

/**
 * Displays a card with information about multiple instruction single data.
 *
 * @param modifier The modifier for the layout
 */
@Composable
private fun MISD(modifier: Modifier = Modifier) {
    Card(modifier) {
        Column(Modifier.padding(8.dp)) {
            Text(
                text = stringResource(R.string.misd),
                style = MaterialTheme.typography.titleLarge
            )
            Text(
                text = stringResource(R.string.misd_description),
            )
        }
    }
}

/**
 * Displays a card with information about multiple instruction multiple data.
 *
 * @param modifier The modifier for the layout
 */
@Composable
private fun MIMD(modifier: Modifier = Modifier) {
    Card(modifier) {
        Column(Modifier.padding(8.dp)) {
            Text(
                text = stringResource(R.string.mimd),
                style = MaterialTheme.typography.titleLarge
            )
            Text(
                text = stringResource(R.string.mimd_description),
            )
        }
    }
}