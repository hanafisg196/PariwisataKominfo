package com.example.pariwisatakominfo.presentation.navgraph

import android.annotation.SuppressLint
import androidx.compose.material3.DrawerState
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.pariwisatakominfo.ui.BottomBar

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun BottomBarScreen(navController: NavHostController ) {
    val bottomBarScreens = listOf(
        Screen.HomeScreen.route,
        Screen.DestinationsScreen.route,
        Screen.Trips.route,

        )
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route
    Scaffold(
        bottomBar = {
            if (currentRoute in bottomBarScreens) {

                BottomBar(navController = navController)
            }
        }
    ) {
        SetNavGraph(navController = navController)
    }
}