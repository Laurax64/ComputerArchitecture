package com.example.computerarchitecture.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog

/**
 * Displays a login dialog with a username and password field and a cancel and sign-in button
 *
 * @param username The username to display
 * @param password The password to display
 * @param onCancelClick The function to call when the cancel button is clicked
 * @param onSignInClick The function to call when the sign-in button is clicked
 * @param modifier The modifier for the layout
 */
@Composable
fun ComputerArchitectureLoginDialog(
    username: String,
    password: String,
    onCancelClick: () -> Unit,
    onSignInClick: (String, String) -> Unit,
    modifier: Modifier = Modifier,
) {
    var usernameText by remember { mutableStateOf(username) }
    var passwordText by remember { mutableStateOf(password) }
    val openDialog = remember { mutableStateOf(true) }

    if (openDialog.value) {
        Dialog(onDismissRequest = { openDialog.value = false }) {
            Card(modifier = modifier) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Text(
                        text = "Sign-in information",
                        modifier = Modifier.fillMaxWidth(),
                        style = TextStyle(fontSize = 25.sp, textAlign = TextAlign.Center),
                    )
                    OutlinedTextField(
                        value = usernameText,
                        onValueChange = { usernameText = it },
                        modifier = Modifier.padding(vertical = 8.dp),
                        label = { Text("Username") },
                    )
                    OutlinedTextField(
                        value = passwordText,
                        onValueChange = { passwordText = it },
                        modifier = Modifier.padding(vertical = 8.dp),
                        label = { Text("Password") },
                        visualTransformation = PasswordVisualTransformation(),
                    )
                    Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.End) {
                        Button(
                            onClick = { onCancelClick() },
                            modifier = Modifier.padding(vertical = 8.dp),
                            colors = ButtonDefaults.buttonColors(
                                containerColor = MaterialTheme.colorScheme.secondary,
                            ),
                            border = ButtonDefaults.outlinedButtonBorder,
                        ) {
                            Text("Cancel")
                        }
                        Button(
                            onClick = { onSignInClick(usernameText, passwordText) },
                            modifier = Modifier.padding(8.dp),
                            colors = ButtonDefaults.buttonColors(
                                containerColor = MaterialTheme.colorScheme.primary,
                            ),
                            border = ButtonDefaults.outlinedButtonBorder,
                        ) {
                            Text("Sign-in")
                        }
                    }
                }
            }
        }
    }
}
