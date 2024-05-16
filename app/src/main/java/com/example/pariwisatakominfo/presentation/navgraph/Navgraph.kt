package com.example.pariwisatakominfo.presentation.navgraph

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.pariwisatakominfo.presentation.details.DestinationDetailScreen
import com.example.pariwisatakominfo.presentation.details.TripDetailScreen
import com.example.pariwisatakominfo.presentation.home.HomeScreen

@Composable
fun SetNavGraph(
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = Screen.HomeScreen.route
    ){
        composable(
            route = Screen.HomeScreen.route
        ){
            HomeScreen(navController = navController)
        }
        composable(
            route = Screen.DestinationDetail.route
        ){
            DestinationDetailScreen(navController = navController)
        }
        composable(
            route = Screen.TripDetailScreen.route
        ){
            TripDetailScreen(navController = navController)
        }


    }

}