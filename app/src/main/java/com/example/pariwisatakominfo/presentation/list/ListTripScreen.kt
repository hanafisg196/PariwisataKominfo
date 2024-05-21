package com.example.pariwisatakominfo.presentation.list

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.paging.LoadState
import androidx.paging.compose.collectAsLazyPagingItems
import com.example.pariwisatakominfo.R
import com.example.pariwisatakominfo.presentation.home.Trip
import com.example.pariwisatakominfo.presentation.loading.LoadRefreshItem
import com.example.pariwisatakominfo.presentation.loading.LoadingItem
import com.example.pariwisatakominfo.presentation.navgraph.Screen
import com.example.pariwisatakominfo.ui.fonts.Fonts


@Composable
fun TripsScreen(
    navController: NavHostController
)
{
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = colorResource(id = R.color.white))
    ) {
        Spacer(modifier = Modifier.height(35.dp))
        TopBarTrips()
        Spacer(modifier = Modifier.height(10.dp))
        Trips( navController = navController )
        Spacer(modifier = Modifier.height(70.dp))

}
}


@Preview(showSystemUi = true)
@Composable
fun TopBarTrips(

)
{
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 25.dp, top = 10.dp)

    ) {

        Text(
            text = "Trips",
            overflow = TextOverflow.Ellipsis,
            fontFamily = Fonts.fontFamily,
            fontWeight = FontWeight.SemiBold,
            fontSize = 20.sp,
            modifier = Modifier.padding(start = 20.dp, top = 5.dp)
        )

    }
}

@Composable
fun Trips(
    viewModel:TripsViewModel = hiltViewModel(),
navController: NavHostController
)
{
    val tripList = viewModel.tripsPage.collectAsLazyPagingItems()
    LazyVerticalGrid(
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        columns = GridCells.Fixed(2),
        modifier = Modifier
            .scale(1.01f)
            .padding(horizontal = 16.dp)
    ) {
        items(tripList.itemCount) { index ->
            val item = tripList[index]
            item?.let {
                Trip(trip = it){
                    navController.navigate(Screen.TripDetailScreen.route + "/${item.id}")
                }
            }
        }
        when(tripList.loadState.append)
        {
            is LoadState.NotLoading -> Unit
            LoadState.Loading -> {
                item {
                    LoadingItem()
                }
            }

            is LoadState.Error ->
                item {
                    // TODO
                }
        }

        when(tripList.loadState.refresh)
        {
            is LoadState.NotLoading -> Unit
            LoadState.Loading -> {
                item {
                    LoadRefreshItem()
                }
            }

            is LoadState.Error ->
                item {
                    Text(
                        text = "Failed to refresh destinations.",
                        overflow = TextOverflow.Ellipsis,
                        fontFamily = Fonts.fontFamily,
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 20.sp,

                    )
                }
        }
    }

}