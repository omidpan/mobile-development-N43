package com.example.helloworld

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
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
                   Greeting( name="Android",   Modifier.padding(innerPadding))
                }
            }
        }
    }
}

//@Composable
//fun Greeting(name: String, modifier: Modifier = Modifier) {
//    Text(
//        text = "Hello $name!",
//        modifier = modifier
//    )
//}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Column {
        Box(
            modifier
                .background(Color.Red)
                .height(200.dp)
                .width(300.dp)
        ) {
            Row {
                Box(
                    modifier
                        .size(50.dp)
                        .background(Color.Blue)
                )
                Column {
                    Text(text = "Hello!")
                    Text(text = "$name!")
                }
            }
        }
    }
}


@Preview(showBackground = true, showSystemUi = true,
    device = "spec:width=1400dp,height=300dp,dpi=240")
@Composable
fun GreetingPreview() {
    HelloWorldTheme {
        Greeting("Android")
    }
}