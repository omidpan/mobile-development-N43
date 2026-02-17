package com.example.helloworld

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
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
                    BrokenCounter()
//                    WorkingCounter(Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun MyUIState(modifier: Modifier= Modifier) {



}
@Composable
fun BrokenCounter(modifier: Modifier= Modifier) {
    Column {
        // This variable is RE-INITIALIZED to 0 every single time the UI refreshes
        val count = mutableStateOf(0)
        Text(text = "Count is: ${count.value}")
        // Even if we increment it, the UI 'refreshes',
        count.value++
    }
}
@Composable
fun WorkingCounter(modifier: Modifier= Modifier) {
    Column() {
        Spacer(modifier = Modifier.size(30.dp))
        // 'remember' tells Compose: "Keep this value safe during the refresh!"
        val count = remember { mutableStateOf(0) }
        Text(text = "Count is: ${count.value}", textAlign = TextAlign.Right)

        // This change triggers a "Recomposition" (a UI refresh)
        // Run the code and make Screen horizontal , you will see the count value is refreshing fast
        count.value++


    }
}
@Preview(showBackground = true, showSystemUi = true,
    device = "spec:width=200dp,height=200dp,dpi=200")
@Composable
fun CustomBoxWithModifierPreview() {
    HelloWorldTheme {
        BrokenCounter()
//        WorkingCounter()
    }
}
