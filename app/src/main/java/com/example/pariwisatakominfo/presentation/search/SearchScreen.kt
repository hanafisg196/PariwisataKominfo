package com.example.pariwisatakominfo.presentation.search

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
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
fun SearchScreen(
    viewModel: SearchDestinationViewModel = hiltViewModel(),
    navController: NavController
) {
    val searchResult = viewModel.searchDestinationPage.collectAsLazyPagingItems()
    val searchQuery by viewModel.query.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = colorResource(id = R.color.white))


    ) {

        Spacer(modifier = Modifier.height(35.dp))
        TopBar(navController)
        Spacer(modifier = Modifier.height(10.dp))
        SearchBar(
            searchQuery = searchQuery,
            onQueryChange = { newQuery ->
                viewModel.updateQuery(newQuery)
            }
        )

        Spacer(modifier = Modifier.height(20.dp))
        if (searchResult.itemCount == 0)
        {
            EmptyState()
        }else{
            LazyColumn {
                items(searchResult) { item ->
                    item?.let {
                        SearchResult(destination = it, navController = navController)
                    }
                }
                when(searchResult.loadState.append){
                    is LoadState.NotLoading -> Unit
                    LoadState.Loading -> {
                        item {
                            LoadingItem()
                        }
                    }

                    is LoadState.Error -> TODO()
                }
                when(searchResult.loadState.refresh){
                    is LoadState.NotLoading -> Unit
                    LoadState.Loading -> {
                        item {
                            LoadRefreshItem()
                        }
                    }

                    is LoadState.Error -> TODO()
                }
            }
        }




    }
}


@Composable
fun EmptyState() {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = colorResource(id = R.color.white)),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "No Result Found",
            fontFamily = Fonts.fontFamily,
            fontWeight = FontWeight.Thin,
            fontSize = 12.sp,
            color = Color.Black,

        )
    }
}






