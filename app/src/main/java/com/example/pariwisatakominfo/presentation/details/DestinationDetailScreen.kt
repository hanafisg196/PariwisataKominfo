package com.example.pariwisatakominfo.presentation.details

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.pariwisatakominfo.presentation.loading.LoadDetail
import com.example.pariwisatakominfo.presentation.loading.LoadRefreshItem
import com.example.pariwisatakominfo.presentation.loading.LoadingItem


@Composable
fun DestinationDetailScreen(
    navController: NavController,
    viewModel: DestinationViewModel = hiltViewModel()
)
{
    val destination = viewModel.destination.collectAsState()

    if (destination.value != null) {
        destination.value?.let { item ->
            DestinationDetail(destination = item, navController)
        }
    } else {
        LoadDetail()
    }



}