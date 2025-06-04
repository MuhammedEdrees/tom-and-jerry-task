package com.edrees.tomjerry

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeContent
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.edrees.tomjerry.ui.jerrystore.JerryStore
import com.edrees.tomjerry.ui.theme.TomAndJerryTheme
import com.edrees.tomjerry.ui.tomaccount.TomAccount
import com.edrees.tomjerry.ui.tomkitchen.TomKitchen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TomAndJerryTheme {
                Box(modifier = Modifier
                    .windowInsetsPadding(WindowInsets.safeContent)
                    .fillMaxSize()
                ) {
                    JerryStore()
//                    TomKitchen()
//                    TomAccount()
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    TomAndJerryTheme {
        Greeting("Android")
    }
}