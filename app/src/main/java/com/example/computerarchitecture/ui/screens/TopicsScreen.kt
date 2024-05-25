package com.example.computerarchitecture.ui.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.computerarchitecture.R
import com.example.computerarchitecture.data.topics
import com.example.computerarchitecture.ui.navigation.NavigationDestination
import com.example.computerarchitecture.ui.theme.ComputerArchitectureTheme


/**
 * Represents a navigation destination for the topics screen
 */
object TopicsDestination : NavigationDestination {
    override val route = "topics"
}

/**
 * Displays a scrollable list of rows from which the user can navigate to other screens,
 * each of which represents a computer architecture topic
 *
 * @param navigateToTopic The function to navigate to other screens
 * @param modifier The modifier for the layout
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopicsScreen(
    navigateToTopic: (String) -> Unit,
    modifier: Modifier = Modifier,
) {
    Scaffold(
        modifier = modifier,
        topBar = {
            TopAppBar(
                {
                    Text(
                        text = stringResource(R.string.computer_architecture),
                        style = MaterialTheme.typography.titleLarge
                    )
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary,
                    titleContentColor = MaterialTheme.colorScheme.onPrimary,
                ),
            )
        },
    ) {
        TopicsList(Modifier.padding(it), navigateToTopic)
    }
}

/**
 * Displays a scrollable list of topics that the user can click on to navigate to other screens
 *
 * @param modifier The modifier for the layout
 * @param onUnitClick The function to call when an intent is clicked
 */
@Composable
private fun TopicsList(modifier: Modifier = Modifier, onUnitClick: (String) -> Unit) {
    LazyColumn(modifier.fillMaxWidth()) {
        items(topics) {
            Row(
                Modifier
                    .fillMaxWidth()
                    .clickable { onUnitClick(it) }
                    .padding(24.dp),
                Arrangement.SpaceBetween
            ) {
                Text(
                    text = it,
                    style = MaterialTheme.typography.titleLarge,
                    fontWeight = FontWeight.Bold
                )
                Icon(Icons.AutoMirrored.Filled.KeyboardArrowRight, contentDescription = null) 
            }
        }
    }
}

/**
 * Displays a preview for the topics screen in light mode
 */
@Preview
@Composable
private fun TopicsScreenPreviewLight() {
    ComputerArchitectureTheme {
        TopicsScreen(
            navigateToTopic = {},
        )
    }
}

/**
 * Displays a preview for the topics screen in dark mode
 */
@Preview
@Composable
private fun TopicsScreenPreviewDark() {
    ComputerArchitectureTheme(darkTheme = true) {
        TopicsScreen(
            navigateToTopic = {},
        )
    }
}

