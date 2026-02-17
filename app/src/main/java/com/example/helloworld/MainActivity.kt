package com.example.helloworld

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
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
                   CustomButton(modifier = Modifier.padding(innerPadding) )
                }
            }
        }
    }
}

@Composable
fun CustomButton(modifier: Modifier = Modifier) {
    Text(
        text = "Click Me",
        modifier = Modifier
            .padding(20.dp)
            .background(Color.Yellow)
            .clickable { println("Button Clicked!") }

    )
}



@Preview(showBackground = true, showSystemUi = true,
    device = "spec:width=1400dp,height=300dp,dpi=240")
@Composable
fun GreetingPreview() {
    HelloWorldTheme {
        CustomButton()
    }
}
