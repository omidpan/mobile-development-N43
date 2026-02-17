package com.example.helloworld

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Scaffold
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
                    CustomBoxWithModifier(modifier = Modifier.padding(innerPadding) )
                }
            }
        }
    }
}

@Composable
fun CustomBoxWithModifier(modifier: Modifier = Modifier) {
    Box(
        modifier = Modifier
            .fillMaxSize() // The component will fill the entire screen
            .background(Color.Green)
    )
    Box(
        modifier = Modifier
            .fillMaxWidth() // The component will stretch horizontally
            .height(200.dp) // Fixed height of 200 DPI
            .background(Color.Red)
    )
    Box(
        modifier = Modifier
            .width(150.dp) // Fixed width of 150 DPI
            .fillMaxHeight() // The component will stretch vertically
            .background(Color.Yellow)
    )
//    //Uncomment bellow box to see size function
//    Box(
//
//        modifier = Modifier
//            .size(300.dp, 200.dp) // Width is 300 DPI, height is 200 DPI
//            .background(Color.Magenta)
//    )

}



@Preview(showBackground = true, showSystemUi = true,
    device = "spec:width=1400dp,height=300dp,dpi=240")
@Composable
fun CustomBoxWithModifierPreview() {
    HelloWorldTheme {
        CustomBoxWithModifier()
    }
}
