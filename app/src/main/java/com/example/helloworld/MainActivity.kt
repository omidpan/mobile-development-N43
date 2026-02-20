package com.example.helloworld

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.helloworld.ui.theme.HelloWorldTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            HelloWorldTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    //01 simple button
                    SimpleButton(Modifier.padding(innerPadding))
                    //02 button with an Event
//                        ButtonWithEvent()

                    //03 Toggle State
//                    ButtonToggleState(Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun SimpleButton(modifier: Modifier= Modifier) {

    Button(
        onClick = { /* Perform action here */ },
        border = BorderStroke(3.dp, Color.Black),
        colors = ButtonDefaults.buttonColors(containerColor = Color.Red)
    ) {
        Text("Click Me")
    }

}

@Composable
fun ButtonWithEvent(modifier: Modifier= Modifier){
    val buttonText = remember { mutableStateOf("Click Me") }
    val buttonColor = remember { mutableStateOf(Color.Red) }
    Button(
        onClick = {
            buttonText.value = "Clicked!"
            buttonColor.value = Color.Green
        },
        colors = ButtonDefaults.buttonColors(buttonColor.value)
    ) {
        Text(buttonText.value)
    }
}
@Composable
fun ButtonToggleState(modifier: Modifier= Modifier) {
    var buttonStatus by remember { mutableStateOf(false) }
    var buttonText ="Click Me"
    var buttonColor = Color.Red
    Button(
        onClick = {
            if (buttonStatus) {
                buttonText = "Hello, Compose!"
                buttonColor = Color.White

            } else {
                buttonText = "Hello, World!"
                buttonColor = Color.Black

            }
            buttonStatus = !buttonStatus
        }
    ) {
        Text(buttonText, color = buttonColor)
    }
}

@Preview(showBackground = true, showSystemUi = true,
    device = "spec:width=200dp,height=200dp,dpi=200")
@Composable
fun UIComponentPreview() {
    HelloWorldTheme {
        ButtonWithEvent()
    }

}
