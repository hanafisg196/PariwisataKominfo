package com.example.pariwisatakominfo.presentation.details

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController


@Composable
fun DestinationDetailScreen(
    navController: NavController,
    viewModel: DestinationViewModel = hiltViewModel()
)
{
    val  destination = viewModel.destination.collectAsState()
    destination.value?.let { item ->
        DestinationDetail(destination = item,navController)
    }

}