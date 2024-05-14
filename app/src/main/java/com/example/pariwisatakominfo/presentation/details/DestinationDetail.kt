package com.example.pariwisatakominfo.presentation.details

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
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
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import coil.size.Scale
import com.example.pariwisatakominfo.R
import com.example.pariwisatakominfo.ui.fonts.Fonts


@Preview(showSystemUi = true)
@Composable
fun DestinationDetail() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(280.dp),
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.panorama),
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
                    .size(50.dp)
                    .clip(RoundedCornerShape(10.dp))
                    .background(Color.White)
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.left),
                    contentDescription = null,
                    tint = Color.Black,
                    modifier = Modifier
                        .size(40.dp)
                        .align(Alignment.Center)
                )

            }

        }

        Text(
            text = "Wisata Mandeh",
            fontFamily = Fonts.fontFamily,
            fontWeight = FontWeight.SemiBold,
            fontSize = 30.sp,
            color = Color.LightGray,
            modifier = Modifier
                .align(Alignment.BottomStart)
                .padding(start = 25.dp, bottom = 60.dp)
        )
        Text(
            text = "Kabupaten Pesisir Selatan",
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
fun ParagraphSection()
{
    Text(
        text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.",
        fontFamily = Fonts.fontFamily,
        fontWeight = FontWeight.Light,
        fontSize = 16.sp,
        color = Color.Gray,
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 20.dp, bottom = 20.dp)
    )
}


@Composable
fun DestinationDetailPreview()
{

    Box(modifier = Modifier)
    {
        val context = LocalContext.current
        AsyncImage(
            model = ImageRequest.Builder(context)
                .data("https://images3.alphacoders.com/133/thumbbig-1337500.webp")
                .crossfade(true)
                .scale(Scale.FILL)
                .build(),
            contentDescription = null,
            contentScale = ContentScale.FillBounds,
            modifier = Modifier.fillMaxSize()
        )


    }


}


@Composable
fun DetailLocation()
{
    Card(
        elevation = CardDefaults.cardElevation(
            defaultElevation = 6.dp
        ),
        colors = CardDefaults.cardColors(
            containerColor = Color.White,
        ),
        modifier = Modifier
            .padding(start = 15.dp, top = 2.dp, end = 15.dp, bottom = 5.dp)
            .fillMaxWidth()
            .height(120.dp),
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
                text = "Jln. Padang Painan Pesisir Selatan",
                fontFamily = Fonts.fontFamily,
                fontWeight = FontWeight.Normal,
                fontSize = 20.sp,
                color = Color.Gray,
                modifier = Modifier.padding(start = 20.dp)
            )
        }

    }
}



