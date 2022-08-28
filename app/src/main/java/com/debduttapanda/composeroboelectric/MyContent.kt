package com.debduttapanda.composeroboelectric

import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun MyContent() {
        val navController = rememberNavController()
        NavHost(navController = navController, startDestination = "first") {
            composable("first") {
                Button(
                    modifier = Modifier.testTag("First Button"),
                    onClick = {
                        navController.navigate("second")
                    }
                ) {
                    Text("Push first destination")
                }
            }
            composable("second") {
                Button(
                    modifier = Modifier.testTag("Second Button"),
                    onClick = {
                        navController.popBackStack()
                    }
                ) {
                    Text("Go back to first destination")
                }
            }
        }
    }