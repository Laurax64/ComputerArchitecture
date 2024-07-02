package com.example.computerarchitecture.ui.screens

import android.content.res.Configuration
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.PrimaryTabRow
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Tab
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.computerarchitecture.R
import com.example.computerarchitecture.ui.components.TopicTopBar
import com.example.computerarchitecture.ui.theme.ComputerArchitectureTheme

/**
 * Displays the graphics processing units (GPUs) screen with an app scaffold.
 *
 * @param navigateBack The function to navigate back
 * @param modifier The modifier for the layout
 */
@Composable
fun GPUsScreen(
    navigateBack: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Scaffold(
        modifier = modifier,
        topBar = {
            TopicTopBar(
                title = stringResource(R.string.gpus),
                navigateBack = navigateBack
            )
        },
    ) { paddingValues ->
        GPUsScreen(modifier.padding(paddingValues))
    }
}

/**
 * Displays the GPUs screen.
 *
 * @param modifier The modifier for the layout
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GPUsScreen(modifier: Modifier = Modifier) {
    var state by rememberSaveable { mutableIntStateOf(0) }
    val titles = listOf(R.string.open_cl)

    Column(modifier.fillMaxWidth()) {
        PrimaryTabRow(selectedTabIndex = state) {
            titles.forEachIndexed { index, title ->
                Tab(
                    selected = state == index,
                    onClick = { state = index },
                    text = { Text(text = stringResource(title)) })
            }
        }
        when (state) {
            0 -> OpenCLTab()
        }
    }
}

/**
 * Displays the OpenCL tab.
 *
 * @param modifier The modifier for the layout
 */
@Composable
fun OpenCLTab(modifier: Modifier = Modifier) {

}


/**
 * Displays a preview for the GPUs screen in light mode
 */
@Preview(
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    name = "GPUsScreenPreviewDark",
)
@Preview(
    uiMode = Configuration.UI_MODE_NIGHT_NO,
    name = "GPUsScreenPreviewLight",
)
@Preview
@Composable
private fun GPUsScreenPreview() {
    ComputerArchitectureTheme {
        GPUsScreen(
            navigateBack = {},
        )
    }
}
