package com.example.pariwisatakominfo.presentation.list

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
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
import androidx.paging.compose.items
import com.example.pariwisatakominfo.R
import com.example.pariwisatakominfo.presentation.home.Destination
import com.example.pariwisatakominfo.presentation.loading.LoadRefreshItem
import com.example.pariwisatakominfo.presentation.loading.LoadingItem
import com.example.pariwisatakominfo.ui.fonts.Fonts


@Composable
fun DestinationsScreen(
    viewModel: DestinationsViewModel = hiltViewModel(),
    navController: NavHostController
)
{
    val destinations = viewModel.destinationsPage.collectAsLazyPagingItems()

    LazyColumn (
        modifier = Modifier
           .fillMaxSize()
            .background(color = colorResource(id = R.color.white))
    ){

        item {
            Spacer(modifier = Modifier.height(35.dp))

        }
        item {
            TopBarDestinations()
        }

        items(destinations) {
                item ->
            item?.let {
                Destination(destination = it, navController = navController)
            }

        }

        when (destinations.loadState.append) {
            is LoadState.NotLoading -> Unit
            LoadState.Loading -> {
                item {
                    LoadingItem()
                }
            }
            is LoadState.Error -> {
                Log.e("HomeScreen", "Append: Error")
                item {
                    Text("Failed to load more destinations.")
                }
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
                Log.e("HomeScreen", "Refresh: Error")
                item {
                    Text(
                        text = "Failed to refresh destinations.",
                        overflow = TextOverflow.Ellipsis,
                        fontFamily = Fonts.fontFamily,
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 20.sp,
                        modifier = Modifier.
                        padding(start = 20.dp, top = 5.dp)

                    )
                }
            }
        }
        item {
            Spacer(modifier = Modifier.height(70.dp))
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun TopBarDestinations(


)
{
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 25.dp, top = 10.dp)

        ) {

                Text(
                    text = "Destinations",
                    overflow = TextOverflow.Ellipsis,
                    fontFamily = Fonts.fontFamily,
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 20.sp,
                    modifier = Modifier.padding(start = 20.dp, top = 5.dp)
                )

        }
}


