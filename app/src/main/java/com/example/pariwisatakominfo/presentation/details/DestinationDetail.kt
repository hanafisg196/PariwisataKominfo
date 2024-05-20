package com.example.pariwisatakominfo.presentation.details

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import android.util.Log
import android.widget.Toast
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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
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
import com.example.pariwisatakominfo.model.Destination
import com.example.pariwisatakominfo.presentation.loading.LoadDetail
import com.example.pariwisatakominfo.ui.fonts.Fonts
import kotlinx.coroutines.delay


@Composable
fun DestinationDetail(
    destination: Destination,
    navController: NavController
) {

    var isLoading by remember { mutableStateOf(true) }

    LaunchedEffect(Unit) {

        delay(1000)
        isLoading = false
    }
    if (isLoading) {
        LoadDetail()
    } else {

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
                ParagraphSection(
                    article = destination.article
                )
            }
            item {
                Text(
                    text = "Preview",
                    overflow = TextOverflow.Ellipsis,
                    fontFamily = Fonts.fontFamily,
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 20.sp,
                    modifier = Modifier.padding(start = 15.dp, bottom = 10.dp)
                )
            }
            item {
                DestinationDetailPreview(destination)
            }
            item {
                Text(
                    text = destination.location,
                    overflow = TextOverflow.Ellipsis,
                    fontFamily = Fonts.fontFamily,
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 20.sp,
                    modifier = Modifier.padding(start = 15.dp, bottom = 15.dp)
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
            color = Color.LightGray,
            modifier = Modifier
                .align(Alignment.BottomStart)
                .padding(start = 25.dp, bottom = 60.dp)
        )
        Text(
            text = daerah,
            fontFamily = Fonts.fontFamily,
            fontWeight = FontWeight.Light,
            fontSize = 16.sp,
            color = Color.LightGray,
            modifier = Modifier
                .align(Alignment.BottomStart)
                .padding(start = 30.dp, bottom = 40.dp)
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
                .padding(start = 5.dp, end = 5.dp)
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
            .height(80.dp)
            .clickable {
                val intent = Intent(Intent.ACTION_VIEW, Uri.parse("$MAP_URL$lat,$long"))
                intent.setPackage("com.google.android.apps.maps")
                if (intent.resolveActivity(context.packageManager) != null) {
                    context.startActivity(intent)
                } else {
                    Toast
                        .makeText(context, "Google Maps App not found", Toast.LENGTH_SHORT)
                        .show()
                }
                val kor = "$MAP_URL$lat,$long"
                Log.e("Coordinates Location", "data:$kor")
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
                    .size(40.dp)
            )
            Text(
                text = location,
                fontFamily = Fonts.fontFamily,
                fontWeight = FontWeight.Normal,
                fontSize = 20.sp,
                color = Color.Gray,
                modifier = Modifier.padding(start = 20.dp)
            )
        }

    }
}





