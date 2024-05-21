package com.example.pariwisatakominfo.presentation.navgraph

sealed class Screen (val route : String){

    object HomeScreen : Screen(route = "home")
    object TripDetailScreen : Screen(route = "tripdetail/{id}")

    object DestinationDetail : Screen(route = "destination/{id}")

    object SearchScreen : Screen(route = "search")
    object DestinationsScreen : Screen(route = "destinations")

    object Trips : Screen(route = "trips")
    object PermissionScreen :  Screen(route = "permission")

}