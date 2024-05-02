package com.example.computerarchitecture.ui.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.computerarchitecture.R
import com.example.computerarchitecture.data.screenNames
import com.example.computerarchitecture.ui.components.ComputerArchitectureTopBar
import com.example.computerarchitecture.ui.navigation.NavigationDestination
import com.example.computerarchitecture.ui.theme.ComputerArchitectureTheme


/**
 * Represents a navigation destination for the topics screen
 */
object TopicsDestination : NavigationDestination {
    override val route = "topics"
}

/**
 * Displays the topics screen
 *
 * @param navigateToTopic The function to navigate to other screens
 * @param modifier The modifier for the layout
 */
@Composable
fun TopicsScreen(
    navigateToTopic: (String) -> Unit,
    modifier: Modifier = Modifier,
) {
    var openDialog by remember { mutableStateOf(false) }
    Scaffold(
        modifier = modifier,
        topBar = {
            ComputerArchitectureTopBar(
                stringResource(R.string.computer_architecture),
                { openDialog = true })
        },
    ) {
        TopicsList(Modifier.padding(it), navigateToTopic)
    }
}

/**
 * Displays a scrollable list of topics
 *
 * @param modifier The modifier for the layout
 * @param onUnitClick The function to call when an intent is clicked
 */
@Composable
private fun TopicsList(modifier: Modifier = Modifier, onUnitClick: (String) -> Unit) {
    LazyColumn(modifier.fillMaxWidth()) {
        itemsIndexed(screenNames) { index, unit ->
            if (index > 0) {
                HorizontalDivider()
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp)
                    .clickable { onUnitClick(unit) },
                horizontalArrangement = Arrangement.SpaceBetween,
            ) {
                Text(text = unit)
                Icon(Icons.AutoMirrored.Filled.KeyboardArrowRight, "navigate to unit")
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

