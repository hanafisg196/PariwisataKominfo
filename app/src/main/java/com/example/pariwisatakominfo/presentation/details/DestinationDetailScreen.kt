package com.example.pariwisatakominfo.presentation.details

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.pariwisatakominfo.presentation.loading.LoadDetail


@Composable
fun DestinationDetailScreen(
    navController: NavController,
    destinationId: Int,
    viewModel: DestinationViewModel = hiltViewModel()
)
{
    val destinationState by viewModel.destination.collectAsState()

    LaunchedEffect(destinationId) {
        viewModel.getDestination(destinationId)

    }


    if (destinationState != null) {
        destinationState?.let { item ->
            DestinationDetail(destination = item, navController)
        }
    } else {
        LoadDetail()
    }

}