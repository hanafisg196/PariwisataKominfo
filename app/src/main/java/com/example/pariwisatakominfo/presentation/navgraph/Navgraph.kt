package com.example.pariwisatakominfo.presentation.navgraph

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.pariwisatakominfo.presentation.details.DestinationDetailScreen
import com.example.pariwisatakominfo.presentation.details.DestinationViewModel
import com.example.pariwisatakominfo.presentation.details.TripDetailScreen
import com.example.pariwisatakominfo.presentation.details.TripDetailViewModel
import com.example.pariwisatakominfo.presentation.details.TripViewModel
import com.example.pariwisatakominfo.presentation.home.Destination
import com.example.pariwisatakominfo.presentation.home.HomeScreen
import com.example.pariwisatakominfo.presentation.list.DestinationsScreen
import com.example.pariwisatakominfo.presentation.list.TripsScreen
import com.example.pariwisatakominfo.presentation.search.SearchScreen

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
            route = Screen.DestinationDetail.route+ "/{id}"
        ){
            navBackStackEntry ->
            val viewModelDestination: DestinationViewModel = hiltViewModel()
            val id = navBackStackEntry.arguments?.getString("id")?.toIntOrNull()?: -1
            LaunchedEffect(id) {
                viewModelDestination.destinationId = id
                viewModelDestination.getDestination()
            }


            DestinationDetailScreen(navController = navController)
        }
        composable(
            route = Screen.TripDetailScreen.route + "/{id}"
        ){
            navBackStackEntry ->
            val id = navBackStackEntry.arguments?.getString("id")?.toIntOrNull()?: -1
            val viewModel: TripDetailViewModel = hiltViewModel()
            val viewModelTrip: TripViewModel = hiltViewModel()

            viewModel.destinationId = id

            LaunchedEffect(id) {
                viewModelTrip.tripId = id
                viewModelTrip.getTrip()
            }

            TripDetailScreen(navController = navController)
        }
        composable(
            route = Screen.SearchScreen.route
        ){
            SearchScreen(navController = navController)
        }

        composable(
            route = Screen.DestinationsScreen.route
        ){
            DestinationsScreen(navController = navController)
        }

        composable(
            route = Screen.Trips.route
        ){
            TripsScreen(navController = navController)
        }




    }

}