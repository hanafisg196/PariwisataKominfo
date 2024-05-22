package com.example.pariwisatakominfo.presentation.details

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
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
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import coil.size.Scale
import com.example.pariwisatakominfo.R
import com.example.pariwisatakominfo.common.Constant.ITEM_URL
import com.example.pariwisatakominfo.common.Constant.MAP_URL
import com.example.pariwisatakominfo.helper.openMapLocation
import com.example.pariwisatakominfo.helper.parseHtml
import com.example.pariwisatakominfo.model.Destination
import com.example.pariwisatakominfo.ui.fonts.Fonts


@Composable
fun DestinationDetail(
    destination: Destination,
    navController: NavController
) {


        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.Start
        ) {
            item {
                DestinationHeader(
                    title = destination.title,
                    daerah = destination.daerah,
                    cover = ITEM_URL + destination.cover,
                    navController = navController
                )
            }
            item {
                Spacer(modifier = Modifier.height(10.dp))
                val content = parseHtml(destination.article)
                ParagraphSection(
                    article = content
                )
            }
            item {
                Text(
                    text = "Preview",
                    overflow = TextOverflow.Ellipsis,
                    fontFamily = Fonts.fontFamily,
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 15.sp,
                    modifier = Modifier.padding(start = 15.dp, bottom = 10.dp)
                )
            }
            item {
                DestinationDetailPreview(destination)
            }
            item {
                Text(
                    text = "Detail Location",
                    overflow = TextOverflow.Ellipsis,
                    fontFamily = Fonts.fontFamily,
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 15.sp,
                    modifier = Modifier.padding(start = 15.dp, bottom = 5.dp, top = 10.dp)
                )
                Text(
                    text = "Click card untuk lihat lokasi di map",
                    overflow = TextOverflow.Ellipsis,
                    fontFamily = Fonts.fontFamily,
                    fontWeight = FontWeight.Light,
                    fontSize = 12.sp,
                    modifier = Modifier.padding(start = 15.dp, bottom = 2.dp, top = 10.dp)
                )
            }
            item {
                DetailLocation(
                    location = destination.location,
                    lat =destination.latitude,
                    long = destination.longitude,
                )
            }
        }
    }






@Composable
fun DestinationHeader(
    navController: NavController,
    cover: String,
    title: String,
    daerah: String
)

    {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(300.dp),
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = rememberAsyncImagePainter(cover),
            contentDescription = null,
            modifier = Modifier
                .fillMaxSize()
                .graphicsLayer {
                    clip = true
                    shape = RoundedCornerShape(
                        bottomStart = 40.dp,
                        bottomEnd = 40.dp
                    )
                },
            contentScale = ContentScale.FillBounds
        )
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 25.dp, top = 40.dp)
                .align(Alignment.TopStart)
        ) {
            Box(
                modifier = Modifier
                    .size(40.dp)
                    .clip(RoundedCornerShape(10.dp))
                    .background(Color.White)
                    .clickable {
                        navController.navigateUp()
                    }
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.left),
                    contentDescription = null,
                    tint = Color.Black,
                    modifier = Modifier
                        .size(30.dp)
                        .align(Alignment.Center)
                )

            }

        }

        Text(
            text = title,
            fontFamily = Fonts.fontFamily,
            fontWeight = FontWeight.SemiBold,
            fontSize = 30.sp,
            color = Color.White,

            modifier = Modifier
                .align(Alignment.BottomStart)
                .padding(start = 25.dp, bottom = 40.dp)
                .shadow(10.dp, shape = RoundedCornerShape(10.dp))
        )
        Text(
            text = daerah,
            fontFamily = Fonts.fontFamily,
            fontWeight = FontWeight.Light,
            fontSize = 16.sp,
            color = Color.White,
            modifier = Modifier
                .align(Alignment.BottomStart)
                .padding(start = 30.dp, bottom = 20.dp)
                .shadow(10.dp, shape = RoundedCornerShape(10.dp))
        )

    }


}

@Composable
fun ParagraphSection(
    article:String
) {
    Text(
        text =  article,
        fontFamily = Fonts.fontFamily,
        fontWeight = FontWeight.Light,
        fontSize = 16.sp,
        color = Color.Gray,
        lineHeight = 24.sp,
        textAlign = TextAlign.Justify,
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 20.dp, bottom = 20.dp, end = 20.dp)
    )
}




@Composable
fun DestinationDetailPreview(
    destination: Destination
) {
    val imageUrl = destination.images
    LazyRow {
        items(imageUrl) { imageUrl ->
           Images(image = ITEM_URL+imageUrl.image)
        }
    }
}

@Composable
fun Images(
    image:String
)
{
    var showImage by remember {
        mutableStateOf(false)
    }
    if (showImage){
        ImagePreview (
            onDismiss = {
               showImage = false
            }, image = image
        )

    }

        Row (
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 10.dp, end = 10.dp)
        ) {
            Box(
                modifier = Modifier
                    .height(120.dp)
                    .clip(RoundedCornerShape(8.dp))
                    .clickable {
                        showImage = true
                    }
            ) {
                val context = LocalContext.current
                AsyncImage(
                    model = ImageRequest.Builder(context)
                        .data(image)
                        .crossfade(true)
                        .scale(Scale.FILL)
                        .build(),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.fillMaxSize()
                )
            }
        }
    }


@SuppressLint("QueryPermissionsNeeded")
@Composable
fun DetailLocation(
    location: String,
    lat:Float,
    long: Float,

)
{
    val context = LocalContext.current
    Card(
        elevation = CardDefaults.cardElevation(
            defaultElevation = 6.dp
        ),
        colors = CardDefaults.cardColors(
            containerColor = Color.White,
        ),
        modifier = Modifier
            .padding(start = 15.dp, top = 2.dp, end = 15.dp, bottom = 15.dp)
            .fillMaxWidth()
            .wrapContentHeight()
            .clickable {
               openMapLocation(
                   context,
                   url = "$MAP_URL$lat,$long"
               )
            },
        shape = RoundedCornerShape(8.dp),

        ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(start = 20.dp , top = 10.dp)
        ) {
            Icon(
                tint = colorResource(id = R.color.blue),
                painter = painterResource(id = R.drawable.location),
                contentDescription = null,
                modifier =
                Modifier
                    .size(30.dp)
            )
            Text(
                text = location,
                fontFamily = Fonts.fontFamily,
                fontWeight = FontWeight.Normal,
                fontSize = 15.sp,
                color = Color.Gray,
                modifier = Modifier
                    .padding(start = 20.dp)
            )
        }

    }
}






