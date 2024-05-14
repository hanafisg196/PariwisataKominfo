package com.example.pariwisatakominfo.presentation.home

import androidx.compose.foundation.Image
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
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pariwisatakominfo.R
import com.example.pariwisatakominfo.model.BottomMenus
import com.example.pariwisatakominfo.ui.fonts.Fonts


@Preview(showSystemUi = true)
@Composable
fun HomeScreen() {
    Column (
        modifier = Modifier
            .fillMaxSize()
            .background(
                color = colorResource(id = R.color.white)
            )
    ){
        Spacer(modifier = Modifier.height(35.dp))
        Column {
            TopBar(
                name = "Sumbar Destination"
            )
            Text(
                text = "Top 5 Trip",
                overflow = TextOverflow.Ellipsis,
                fontFamily = Fonts.fontFamily,
                fontWeight = FontWeight.SemiBold,
                fontSize = 20.sp,
                modifier = Modifier
                    .padding(start = 19.dp)
            )
            City()

            Text(
                text = "Top Destination",
                overflow = TextOverflow.Ellipsis,
                fontFamily = Fonts.fontFamily,
                fontWeight = FontWeight.SemiBold,
                fontSize = 20.sp,
                modifier = Modifier
                    .padding(start = 19.dp)
            )
            Destination()
            Spacer(modifier = Modifier.height(100.dp))
            val items = listOf(
                BottomMenus(R.drawable.category),
                BottomMenus(R.drawable.destiantion),
                BottomMenus(R.drawable.star)
            )
            ButtonMenu(items = items) { clickedItem ->
                when(clickedItem.iconId){
                    R.drawable.category -> {

                    }
                    R.drawable.destiantion -> {

                    }
                    R.drawable.heart -> {

                    }
                }
            }

        }


    }

}


@Composable
fun TopBar(
    name: String,
    modifier: Modifier = Modifier
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
                    color = Color.White
                )
                .padding(10.dp)

        ) {
            Icon(
                painter = painterResource(id = R.drawable.toolbar),
                contentDescription = "Back",
                tint = Color.Black,
                modifier = Modifier.size(25.dp)
            )
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



@Composable
fun City() {
    Card(
        colors = CardDefaults.cardColors(
            containerColor = Color.White,
        ),
        modifier = Modifier
            .padding(start = 15.dp, top = 2.dp, bottom = 15.dp)
            .width(220.dp)
            .height(250.dp),
        shape = RoundedCornerShape(8.dp),

    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)
                .height(150.dp),
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = painterResource(id = R.drawable.panorama),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxSize()
                    .clip(RoundedCornerShape(10.dp)),
                contentScale = ContentScale.FillBounds
            )

        }
        Text(
            text = "Padang",
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
                painter = painterResource(id = R.drawable.destiantion),
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

@Composable
fun Destination()
{
    Card(
        colors = CardDefaults.cardColors(
            containerColor = Color.White,
        ),
        modifier = Modifier
            .padding(10.dp)
            .fillMaxWidth()
            .height(150.dp),
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
                Image(
                    painter = painterResource(id = R.drawable.panorama),
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxSize()
                        .clip(RoundedCornerShape(10.dp)),
                    contentScale = ContentScale.FillBounds
                )
            }
            Column {
                Text(
                    text = "Wisata Mandeh..",
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
                        text = "Jl. Wisata Satu...",
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


@Composable
fun ButtonMenuItem(
    item: BottomMenus,
    onItemClick: (BottomMenus) -> Unit
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier =
        Modifier.clickable {
            onItemClick(item)
        }
    ) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .clip(RoundedCornerShape(10.dp))
                .padding(10.dp)
        )
        {
            Icon(
                painter = painterResource(id = item.iconId),
                contentDescription = null,
                modifier =
                Modifier.size(30.dp),
                Color.White

            )
        }
    }
}

