package com.example.helloworld

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
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
                    MyUIComponentsImage(Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun MyUIComponentsImage(modifier: Modifier= Modifier) {
    Image(
        painter = painterResource(id = R.drawable.first_image),

        contentDescription = "Scaled Image",
        modifier = Modifier.size(300.dp),
        contentScale = ContentScale.Fit

    )

}



@Preview(showBackground = true, showSystemUi = true,
    device = "spec:width=200dp,height=200dp,dpi=200")
@Composable
fun CustomBoxWithModifierPreview() {
    HelloWorldTheme {
        MyUIComponentsImage()
    }
}
