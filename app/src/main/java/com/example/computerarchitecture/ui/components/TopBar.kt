package com.example.computerarchitecture.ui.components


import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.rounded.AccountCircle
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

/**
 * Displays a [CenterAlignedTopAppBar] including a button to open a [MultithreadingLoginDialog] and a back button
 *
 * @param title The title of the top bar
 * @param onAccountButtonClick The action to perform when the account button is clicked
 * @param navigateBack The function to navigate back
 * @param modifier The modifier for the layout
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ComputerArchitectureTopBar(
    title: String,
    onAccountButtonClick: () -> Unit,
    navigateBack: () -> Unit,
    modifier: Modifier = Modifier,
) {
    CenterAlignedTopAppBar(
        title = { Text(title) },
        modifier = modifier,
        navigationIcon = {
            IconButton(onClick = { navigateBack() }) {
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                    contentDescription = "Localized description",
                    tint = MaterialTheme.colorScheme.onPrimary,
                )
            }
        },
        actions = {
            IconButton(onClick = { onAccountButtonClick() }) {
                Icon(
                    imageVector = Icons.Rounded.AccountCircle,
                    contentDescription = "Localized description",
                    tint = MaterialTheme.colorScheme.onPrimary,
                )
            }
        },
        colors = topAppBarColors(
            containerColor = MaterialTheme.colorScheme.primary,
            titleContentColor = MaterialTheme.colorScheme.onPrimary,
        ),
    )
}

/**
 * Displays a top bar including a button for the login dialog and a back button
 *
 * @param title The title of the top bar
 * @param onAccountButtonClick The action to perform when the account button is clicked
 * @param modifier The modifier for the layout
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ComputerArchitectureTopBar(
    title: String,
    onAccountButtonClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    TopAppBar(
        title = { Text(title) },
        modifier = modifier,
        actions = {
            IconButton(onClick = { onAccountButtonClick() }) {
                Icon(
                    imageVector = Icons.Rounded.AccountCircle,
                    contentDescription = "Localized description",
                    tint = MaterialTheme.colorScheme.onPrimary,
                )
            }
        },
        colors = topAppBarColors(
            containerColor = MaterialTheme.colorScheme.primary,
            titleContentColor = MaterialTheme.colorScheme.onPrimary,
        ),
    )
}
