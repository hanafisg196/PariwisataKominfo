package com.example.pariwisatakominfo.presentation.home

import android.annotation.SuppressLint
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.pariwisatakominfo.R
import com.example.pariwisatakominfo.common.Constant.ITEM_URL
import com.example.pariwisatakominfo.model.Destination
import com.example.pariwisatakominfo.model.Trip
import com.example.pariwisatakominfo.presentation.loading.LoadRefreshItem
import com.example.pariwisatakominfo.presentation.navgraph.Screen
import com.example.pariwisatakominfo.ui.fonts.Fonts


@Composable
fun HomeScreen(
    viewModel: RecomendViewModel = hiltViewModel(),
    navController: NavHostController
) {
    val state by viewModel.state.collectAsState()
    val error by viewModel.error.collectAsState()

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = colorResource(id = R.color.white))
    ) {
        LazyColumn(
            modifier = Modifier.fillMaxSize()
        ) {
            item {
                Spacer(modifier = Modifier.height(35.dp))
            }

            item {
                TopBar(name = "Sumbar Traveling", navController = navController)
            }

            item {
                Text(
                    text = "Top 5 Trip",
                    overflow = TextOverflow.Ellipsis,
                    fontFamily = Fonts.fontFamily,
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 20.sp,
                    modifier = Modifier.padding(start = 20.dp, top = 20.dp)
                )
            }

            item {
                Trips(navController = navController)
            }

            if (error!=null) {
                item {
                    LoadRefreshItem()
                }
            } else if (state.isNotEmpty())  {
                item {
                    Text(
                        text = "Recommend Destination",
                        overflow = TextOverflow.Ellipsis,
                        fontFamily = Fonts.fontFamily,
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 20.sp,
                        modifier = Modifier.padding(start = 19.dp)
                    )
                }

                items(state.size) { index ->
                    val recomDes = state[index]
                    Destination(destination = recomDes, navController = navController)
                }

            }else {
                item {
                    LoadRefreshItem()
                }

            }

            item {
                Spacer(modifier = Modifier.height(70.dp))
            }
        }
    }
}




@Composable
fun TopBar(
    name: String,
    modifier: Modifier = Modifier,
    navController: NavController,
)
{
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 25.dp)

    )
    {
        Box(
            modifier = Modifier
                .background(
                    shape = RoundedCornerShape(10.dp),
                    color = Color.Transparent
                )
                .padding(10.dp)

        ) {
//            Icon(
//                painter = painterResource(id = R.drawable.toolbar),
//                contentDescription = "Back",
//                tint = Color.Black,
//                modifier = Modifier.size(25.dp)
//            )
        }
        Text(
            text = name,
            overflow = TextOverflow.Ellipsis,
            fontFamily = Fonts.fontFamily,
            fontWeight = FontWeight.SemiBold,
            fontSize = 20.sp,

            )

        Box(modifier = Modifier
            .background(
                shape = RoundedCornerShape(10.dp),
                color = Color.White
            )
            .padding(10.dp)
            .clickable {
                navController.navigate(Screen.SearchScreen.route)
            }

        ) {
            Icon(
                painter = painterResource(id = R.drawable.search),
                contentDescription = "Back",
                tint = Color.Black,
                modifier = Modifier.size(25.dp)
            )
        }
    }

}



@SuppressLint("SuspiciousIndentation")
@Composable
fun Trip(
    trip:Trip,
    onclickItem: (Trip) -> Unit
) {
  val total = trip.destinations_count

    Card(
        colors = CardDefaults.cardColors(
            containerColor = Color.White,
        ),
        modifier = Modifier
            .padding(start = 15.dp, top = 2.dp, bottom = 15.dp)
            .width(220.dp)
            .height(250.dp)
            .clickable {
                onclickItem(trip)
            },
        shape = RoundedCornerShape(8.dp),

    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)
                .height(150.dp),
            contentAlignment = Alignment.Center
        ) {

            val context = LocalContext.current
            val imageUrl = trip.cover
            AsyncImage(
                model = ImageRequest.Builder(context)
                    .data(ITEM_URL + imageUrl)
                    .crossfade(true)
                    .build(),
                contentDescription = null,
                contentScale = ContentScale.FillBounds,
                modifier = Modifier
                    .clip(RoundedCornerShape(10.dp))
                    .fillMaxSize()
            )


        }
        Text(
            text = trip.name,
            fontFamily = Fonts.fontFamily,
            fontWeight = FontWeight.SemiBold,
            fontSize = 15.sp,
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
        )
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding( start = 20.dp)
        ) {
            Icon(
                tint = colorResource(id = R.color.blue),
                painter = painterResource(id = R.drawable.destination),
                contentDescription = null,
                modifier =
                Modifier
                    .size(20.dp)
            )
            Text(
                text = "$total Destinasi Wisata",
                fontFamily = Fonts.fontFamily,
                fontWeight = FontWeight.Normal,
                fontSize = 13.sp,
                color = Color.Gray,
                modifier = Modifier.padding(start = 10.dp)
            )


        }


    }
}
@Composable
fun Trips(
    viewModel: TripSlideViewModel = hiltViewModel(),
    navController: NavController
)
{
    val context = LocalContext.current
    val state by viewModel.state.collectAsState()
    val error by viewModel.error.collectAsState()
    LazyRow {
        if (error !=null)
        {
            Toast.makeText(context, "Something went wrong", Toast.LENGTH_SHORT).show()
        }else{
            items(state.size) { index ->
                val tripSlide = state[index]
                Trip(trip = tripSlide){
                    navController.navigate(Screen.TripDetailScreen.route + "/${tripSlide.id}")
                }
            }
        }

    }
}

@Composable
fun Destination(
    destination: Destination,
    navController: NavController,

)
{
    Card(
        colors = CardDefaults.cardColors(
            containerColor = Color.White,
        ),
        modifier = Modifier
            .padding(10.dp)
            .fillMaxWidth()
            .height(150.dp)
            .clickable {
                navController.navigate(Screen.DestinationDetail.route + "/${destination.id}")
            },

        shape = RoundedCornerShape(8.dp),

        )
    {
        Row (
            modifier = Modifier
        ) {
            Box(
                modifier = Modifier
                    .padding(10.dp)
                    .width(200.dp)
                    .height(150.dp),
                contentAlignment = Alignment.Center
            ) {
                val context = LocalContext.current
                val imageUrl = destination.cover
                AsyncImage(
                    model = ImageRequest.Builder(context)
                        .data(ITEM_URL + imageUrl)
                        .crossfade(true)
                        .build(),
                    contentDescription = null,
                    contentScale = ContentScale.FillBounds,
                    modifier = Modifier
                        .clip(RoundedCornerShape(10.dp))
                        .fillMaxSize()
                )
            }
            Column {
                Text(
                    text = destination.title,
                    fontFamily = Fonts.fontFamily,
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 16.sp,
                    color = Color.Black,
                    modifier = Modifier.padding(top = 30.dp)
                )
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.location),
                        contentDescription = null,
                        modifier = Modifier.size(20.dp),
                        tint = colorResource(id = R.color.blue)
                    )
                    Text(
                        text = destination.daerah,
                        fontFamily = Fonts.fontFamily,
                        fontWeight = FontWeight.Normal,
                        fontSize = 13.sp,
                        color = Color.Gray,
                        modifier = Modifier.padding(start = 5.dp)
                    )
                }
                Spacer(modifier = Modifier.height(5.dp))
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.star),
                        contentDescription = null,
                        modifier = Modifier.size(20.dp),
                        tint = colorResource(id = R.color.blue)
                    )
                    Text(
                        text = " 4.5 ",
                        fontFamily = Fonts.fontFamily,
                        fontWeight = FontWeight.Normal,
                        fontSize = 13.sp,
                        color = Color.Gray,
                        modifier = Modifier.padding(start = 5.dp)
                    )
                }

            }


        }



    }
}


