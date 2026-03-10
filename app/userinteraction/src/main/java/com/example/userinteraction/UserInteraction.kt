package com.example.userinteraction

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Warning
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.userinteraction.ui.theme.HelloWorldTheme

class UserInteraction : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            HelloWorldTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    DialogExample(modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun DialogExample(modifier: Modifier = Modifier) {
    val dialogStatus = remember { mutableStateOf(false) } // Manages Dialog visibility
    val buttonTextColor = remember { mutableStateOf(Color.White) } // Tracks button color
    val context = LocalContext.current // Gets Android Context for Toast message
    Scaffold { contentPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(contentPadding),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Button(onClick = { dialogStatus.value = true }) {
                Text("Show Dialog Message", color = buttonTextColor.value)
            }
            // Show Dialog when dialogStatus is TRUE
            if (dialogStatus.value) {
                AlertDialog(
                    onDismissRequest = {
                        dialogStatus.value = true
                    }, // Prevent closing on background click
                    icon = {
                        Icon(
                            imageVector = Icons.Outlined.Warning,
                            contentDescription = "Warning Icon",
                            tint = Color.Yellow
                        )
                    },
                    title = { Text("Dialog Message", color = Color.Yellow, fontSize = 20.sp) },
                    text = {
                        Text(
                            "Do you want to change the text color?",
                            color = Color.DarkGray,
                            fontSize = 18.sp
                        )
                    },
                    containerColor = Color.LightGray, // Background color of Dialog
                    shape = RoundedCornerShape(10.dp), // Rounded corners
                    confirmButton = {
                        Button(
                            onClick = {
                                dialogStatus.value = false // Close Dialog
                                buttonTextColor.value = Color.Red // Change button text color
                                Toast.makeText(
                                    context,
                                    "Confirm button clicked",
                                    Toast.LENGTH_SHORT
                                ).show()
                            }
                        ) {
                            Text("Yes", color = Color.Green, fontSize = 18.sp)
                        }
                    },
                    dismissButton = {
                        Button(
                            onClick = {
                                dialogStatus.value = false // Close Dialog
                                Toast.makeText(
                                    context,
                                    "Dismiss button clicked",
                                    Toast.LENGTH_SHORT
                                ).show()
                            }
                        ) {
                            Text("No", color = Color.Red, fontSize = 18.sp)
                        }
                    }
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    HelloWorldTheme {
        DialogExample()
    }
}