package com.example.pariwisatakominfo.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.SystemBarStyle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.pariwisatakominfo.presentation.details.TripDetailScreen
import com.example.pariwisatakominfo.presentation.navgraph.SetNavGraph
import com.example.pariwisatakominfo.ui.theme.MyApplicationTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private lateinit var navController : NavHostController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge(
            statusBarStyle = SystemBarStyle.light(
                android.graphics.Color.TRANSPARENT,
                android.graphics.Color.TRANSPARENT
            ))
        setContent {
            MyApplicationTheme {
                    navController = rememberNavController()
                    SetNavGraph(navController = navController)
            }
        }
    }
}