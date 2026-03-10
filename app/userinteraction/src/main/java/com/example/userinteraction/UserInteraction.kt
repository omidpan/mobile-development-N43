package com.example.userinteraction

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.consumeWindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.FabPosition
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
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
                    TopAppBarExample(modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}
/*
Scaffold
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopAppBarExample(modifier: Modifier = Modifier) {
    val actionText = remember { mutableStateOf("Actions will be shown here") } // Tracks Clicked Action
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Column {
                        Text(text = stringResource(id = R.string.app_name), color = Color.White, fontSize = 20.sp)
                        Text(text = "Subtitle", color = Color.White, fontSize = 16.sp)
                    }
                },
                navigationIcon = {
                    IconButton(onClick = { actionText.value = "Navigation Icon Clicked" }) {
                        Icon(imageVector = Icons.Filled.Menu, contentDescription = "Menu Icon", tint =
                            Color.White)
                    }
                },
                actions = {
                    IconButton(onClick = { actionText.value = "Share Icon Clicked" }) {
                        Icon(imageVector = Icons.Filled.Share, contentDescription = "Share Icon", tint = Color.White)
                    }
                    IconButton(onClick = { actionText.value = "Search Icon Clicked" }) {
                        Icon(imageVector = Icons.Filled.Search, contentDescription = "Search Icon", tint = Color.White)
                    }
                    IconButton(onClick = { actionText.value = "More Icon Clicked" }) {
                        Icon(imageVector = Icons.Filled.MoreVert, contentDescription = "More Icon", tint = Color.White)
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = colorResource(id = R.color.purple_500),
                    scrolledContainerColor = colorResource(id = R.color.purple_700),
                    navigationIconContentColor = Color.White,
                    titleContentColor = Color.White,
                    actionIconContentColor = Color.White
                )
            )
        }
    ) { contentPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(contentPadding),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = actionText.value, color = Color.Black, fontSize = 18.sp)
        }
    }
}
@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    HelloWorldTheme {
        TopAppBarExample()
    }
}