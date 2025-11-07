package org.roshan.playnite

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.roshan.playnite.theme.PlayNiteTheme

import playnite.composeapp.generated.resources.Res
import playnite.composeapp.generated.resources.compose_multiplatform

@Composable
@Preview
fun App() {
    PlayNiteTheme {
        var showContent by remember { mutableStateOf(false) }
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            // App Title
            Text(
                text = "PlayNite",
                style = MaterialTheme.typography.displayMedium,
                color = MaterialTheme.colorScheme.primary,
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.height(32.dp))

            // Main Action Button
            ElevatedButton(
                onClick = { showContent = !showContent },
                modifier = Modifier.fillMaxWidth(0.8f),
                elevation = ButtonDefaults.elevatedButtonElevation(
                    defaultElevation = 6.dp,
                    pressedElevation = 2.dp
                )
            ) {
                Text(
                    text = if (showContent) "Hide Features" else "Show Features",
                    style = MaterialTheme.typography.labelLarge
                )
            }

            AnimatedVisibility(showContent) {
                Column(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                ) {
                    Spacer(modifier = Modifier.height(24.dp))

                    // Feature Card
                    Card(
                        modifier = Modifier
                            .fillMaxWidth(0.9f)
                            .padding(vertical = 8.dp),
                        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
                    ) {
                        Column(
                            modifier = Modifier.padding(16.dp),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Image(
                                painter = painterResource(Res.drawable.compose_multiplatform),
                                contentDescription = "Compose Multiplatform Logo",
                                modifier = Modifier.size(64.dp)
                            )

                            Spacer(modifier = Modifier.height(16.dp))

                            Text(
                                text = "Welcome to PlayNite!",
                                style = MaterialTheme.typography.headlineSmall,
                                textAlign = TextAlign.Center
                            )

                            Spacer(modifier = Modifier.height(8.dp))

                            val greeting = remember { Greeting().greet() }
                            Text(
                                text = greeting,
                                style = MaterialTheme.typography.bodyLarge,
                                textAlign = TextAlign.Center,
                                color = MaterialTheme.colorScheme.onSurfaceVariant
                            )

                            Spacer(modifier = Modifier.height(16.dp))

                            // Button Showcase
                            Text(
                                text = "Material 3 Components",
                                style = MaterialTheme.typography.titleMedium,
                                color = MaterialTheme.colorScheme.primary
                            )

                            Spacer(modifier = Modifier.height(12.dp))

                            // Different button types
                            Column(
                                modifier = Modifier.fillMaxWidth(),
                                verticalArrangement = Arrangement.spacedBy(8.dp)
                            ) {
                                FilledTonalButton(
                                    onClick = { /* TODO */ },
                                    modifier = Modifier.fillMaxWidth()
                                ) {
                                    Text("Filled Tonal Button")
                                }

                                OutlinedButton(
                                    onClick = { /* TODO */ },
                                    modifier = Modifier.fillMaxWidth()
                                ) {
                                    Text("Outlined Button")
                                }

                                TextButton(
                                    onClick = { /* TODO */ },
                                    modifier = Modifier.fillMaxWidth()
                                ) {
                                    Text("Text Button")
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}