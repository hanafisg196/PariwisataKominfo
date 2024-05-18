package com.example.pariwisatakominfo.presentation.details

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.pariwisatakominfo.R
import com.example.pariwisatakominfo.common.Constant
import com.example.pariwisatakominfo.model.Destination
import com.example.pariwisatakominfo.model.Trip
import com.example.pariwisatakominfo.presentation.navgraph.Screen
import com.example.pariwisatakominfo.ui.fonts.Fonts


@Composable
fun TopBarTrip(

    navController: NavController
)
{
    Row(
        verticalAlignment = Alignment.CenterVertically,

        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 25.dp),
        content = {
            Box(
                modifier = Modifier
                    .background(
                        shape = RoundedCornerShape(10.dp),
                        color = Color.White
                    )
                    .padding(10.dp)
                    .clickable {
                        navController.navigateUp()
                    }

            ) {
                Icon(
                    painter = painterResource(id = R.drawable.left),
                    contentDescription = "Back",
                    tint = Color.Black,
                    modifier = Modifier.size(25.dp)
                )

            }
            Text(
                text = "Trip Details",
                overflow = TextOverflow.Ellipsis,
                fontFamily = Fonts.fontFamily,
                fontWeight = FontWeight.SemiBold,
                fontSize = 20.sp,
                modifier = Modifier.padding(start = 40.dp),
                textAlign = TextAlign.Center
            )
        }
    )
}


@Composable
fun TripSection(
    trip: Trip,

)
{
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top,
        modifier = Modifier.fillMaxSize()
    ) {
        Card(
            colors = CardDefaults.cardColors(
                containerColor = Color.White,
            ),
            modifier = Modifier
                .padding(start = 15.dp, top = 5.dp, bottom = 15.dp, end = 15.dp)
                .fillMaxWidth()
                .height(300.dp),
            shape = RoundedCornerShape(8.dp),

            ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp)
                    .height(200.dp),
                contentAlignment = Alignment.Center
            ) {

                val context = LocalContext.current
                val imageUrl = trip.cover
                AsyncImage(
                    model = ImageRequest.Builder(context)
                        .data(Constant.ITEM_URL + imageUrl)
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
                fontSize = 20.sp,
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
            )
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(start = 20.dp)
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
                    text = "10 Destinasi Wisata",
                    fontFamily = Fonts.fontFamily,
                    fontWeight = FontWeight.Normal,
                    fontSize = 13.sp,
                    color = Color.Gray,
                    modifier = Modifier.padding(start = 10.dp)
                )

            }
        }
    }
}



@Composable
fun DestinationSection(
    navController: NavController,
    destination: Destination)
{
    Card(
        colors = CardDefaults.cardColors(
            containerColor = Color.White,
        ),
        modifier = Modifier
            .padding(start = 20.dp , end = 20.dp, bottom = 10.dp)
            .fillMaxWidth()
            .height(120.dp)
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
                    .width(150.dp)
                    .fillMaxHeight(),
                contentAlignment = Alignment.Center
            ) {
                val context = LocalContext.current
                val imageUrl = destination.cover
                AsyncImage(
                    model = ImageRequest.Builder(context)
                        .data(Constant.ITEM_URL + imageUrl)
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
                    modifier = Modifier.padding(top = 15.dp)
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


