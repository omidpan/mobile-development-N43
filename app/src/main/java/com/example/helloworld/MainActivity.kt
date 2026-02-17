package com.example.helloworld

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.helloworld.ui.theme.HelloWorldTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            HelloWorldTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    MyAlignments(Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun MyAlignments(modifier: Modifier= Modifier){
//    //01 Aligning Components Inside a Box
//    Box(
//        modifier = Modifier.fillMaxSize(),
//        contentAlignment = Alignment.Center
//    ) {
//        Text(text = "Hello, Kotlin!")
//    }
//// 02 Adding Space Between Components
//    Spacer(modifier = Modifier.height(20.dp))
//    Column {
//        Text("Hello ")
//        Spacer(modifier = Modifier.height(20.dp)) // Adds space
//        Text("Android")
//    }
////03 Spacer can also be used in Row for horizontal spacing:
//
//    Row {
//        Text("Hello", modifier = Modifier.padding(start = 20.dp,end=30.dp))
//        Spacer(modifier = Modifier.width(20.dp)) // Adds space
//        Text("Android")
//    }


}


//04 -summary
//@Composable
//fun MyAlignments(modifier: Modifier = Modifier){
//    Column (modifier
//        .fillMaxSize()
//        .background(Color.White),
//        verticalArrangement = Arrangement.Center,
//        horizontalAlignment = Alignment.CenterHorizontally
//    ) {
//        Text(text = "Hello",
//            color = Color.White,
//            fontSize = 24.sp,
//            fontWeight = FontWeight.Bold,
//            textAlign = TextAlign.Center,
//            modifier = Modifier.background(Color.Red).padding(30.dp)
//        )
//        Spacer(modifier = Modifier.size(20.dp))
//        Text(text = "Android",
//            color = Color.White,
//            fontSize = 24.sp,
//            fontWeight = FontWeight.Bold,
//            textAlign = TextAlign.Center,
//            modifier = Modifier.background(Color.Red).width(100.dp)
//        )
//        Spacer(modifier = Modifier.size(20.dp))
//        Text(text = "Kotlin",
//            color = Color.White,
//            fontSize = 24.sp,
//            fontWeight = FontWeight.Bold,
//            textAlign = TextAlign.Center,
//            modifier = Modifier.background(Color.Red).width(100.dp)
//        )
//    }
//}



@Preview(showBackground = true, showSystemUi = true,
    device = "spec:width=200dp,height=200dp,dpi=200")
@Composable
fun CustomBoxWithModifierPreview() {
    HelloWorldTheme {
        MyAlignments()
    }
}
