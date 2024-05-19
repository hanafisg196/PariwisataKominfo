package com.example.pariwisatakominfo.presentation.details

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.paging.LoadState
import androidx.paging.compose.collectAsLazyPagingItems
import androidx.paging.compose.items
import com.example.pariwisatakominfo.R
import com.example.pariwisatakominfo.presentation.loading.LoadRefreshItem
import com.example.pariwisatakominfo.presentation.loading.LoadingItem
import com.example.pariwisatakominfo.ui.fonts.Fonts


@Composable
fun TripDetailScreen(
    navController: NavController,
    viewModel: TripDetailViewModel = hiltViewModel(),
    viewModelTrip: TripViewModel = hiltViewModel()

)
{

    val destinations = viewModel.tripDetailPage.collectAsLazyPagingItems()
    val  trip = viewModelTrip.trip.collectAsState()


    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(color = colorResource(id = R.color.white))
    ){
        item{
            Spacer(modifier = Modifier.height(35.dp))
            TopBarTrip(navController)
        }
        item{
            Spacer(modifier = Modifier.height(15.dp))
            trip.value?.let { trip ->
                TripSection(trip = trip)
            }
        }
        item{

            Text(
                text = "Trip Flows",
                overflow = TextOverflow.Ellipsis,
                fontFamily = Fonts.fontFamily,
                fontWeight = FontWeight.SemiBold,
                fontSize = 20.sp,
                modifier = Modifier
                    .padding(start = 20.dp)
            )

        }
        items(destinations){ item ->
            item?.let {
                DestinationSection(navController,it)
            }
        }
        when (destinations.loadState.append) {
            is LoadState.NotLoading -> {
                Log.d("TripDetailScreen", "NotLoading State")
            }
            LoadState.Loading -> {
                Log.d("TripDetailScreen", "Loading State")
                item {
                    LoadingItem()
                }
            }
            is LoadState.Error -> {
                Log.d("TripDetailScreen", "Error State")
                // Handle the error state appropriately
            }
        }

        when (destinations.loadState.refresh) {
            is LoadState.NotLoading -> Unit
            LoadState.Loading -> {

                item {
                    LoadRefreshItem()
                }
            }
            is LoadState.Error -> {
                Log.d("TripDetailScreen", "Error State")
                // Handle the error state appropriately
            }
        }

    }

}