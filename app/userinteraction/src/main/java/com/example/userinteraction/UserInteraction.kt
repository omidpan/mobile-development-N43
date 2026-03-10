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
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Snackbar
import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.SnackbarResult
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import com.example.userinteraction.ui.theme.HelloWorldTheme
import kotlinx.coroutines.launch

class UserInteraction : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            HelloWorldTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    SnackbarExample(modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}
/*
Scaffold
 */
@Composable
fun SnackbarExample(modifier: Modifier = Modifier) {
    val snackbarHostState = remember { SnackbarHostState() }
    val coroutineScope = rememberCoroutineScope()
    val myContext = LocalContext.current
    Scaffold(
        snackbarHost = {
            SnackbarHost(hostState = snackbarHostState) { snackbarData ->
                Snackbar(
                    snackbarData = snackbarData,
                    containerColor = Color.Gray,
                    contentColor = Color.White,
                    actionColor = Color.Black,
                    dismissActionContentColor = Color.Black
                )
            }
        }
    ) { contentPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(contentPadding),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Button(onClick = {
                coroutineScope.launch {
                    val result = snackbarHostState.showSnackbar(
                        message = "This is a Snackbar message",
                        actionLabel = "Show Toast",
                        duration = SnackbarDuration.Indefinite,
                        withDismissAction = true
                    )
                    if (result == SnackbarResult.ActionPerformed) {
                        Toast.makeText(
                            myContext,
                            "Action Performed!",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                }
            }) {
                Text("Show Snackbar Message")
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    HelloWorldTheme {
        SnackbarExample()
    }
}