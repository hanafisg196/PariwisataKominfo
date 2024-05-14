package com.example.pariwisatakominfo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.SystemBarStyle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.pariwisatakominfo.presentation.details.DestinationDetailScreen
import com.example.pariwisatakominfo.ui.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge(
            statusBarStyle = SystemBarStyle.light(
                android.graphics.Color.TRANSPARENT,
                android.graphics.Color.TRANSPARENT
            ))
        setContent {
            MyApplicationTheme {
//                HomeScreen()
                DestinationDetailScreen()
            }
        }
    }
}