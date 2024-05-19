package com.example.pariwisatakominfo.presentation.search

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
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
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
import androidx.navigation.NavController
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.pariwisatakominfo.R
import com.example.pariwisatakominfo.common.Constant
import com.example.pariwisatakominfo.model.Destination
import com.example.pariwisatakominfo.presentation.navgraph.Screen
import com.example.pariwisatakominfo.ui.fonts.Fonts


@Composable
fun TopBar(
    navController: NavController
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 25.dp, top = 10.dp)

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
        Text(
            text = "Search Destination",
            overflow = TextOverflow.Ellipsis,
            fontFamily = Fonts.fontFamily,
            fontWeight = FontWeight.SemiBold,
            fontSize = 20.sp,
            modifier = Modifier.padding(start = 20.dp, top = 5.dp)
            )


    }
}


@Composable
fun SearchBar(
    searchQuery: String,
    onQueryChange: (String) -> Unit
) {
    var query by remember { mutableStateOf(searchQuery) }

    OutlinedTextField(
        value = query,
        onValueChange = { newQuery ->
            query = newQuery
            onQueryChange(newQuery)
        },
        placeholder = { Text(text = "Search") },
        leadingIcon = {
            Icon(imageVector = Icons.Default.Search, contentDescription = "search")
        },
        trailingIcon = {
            if (query.isNotEmpty()) {
                IconButton(onClick = {
                    query = ""
                    onQueryChange("")
                }) {
                    Icon(imageVector = Icons.Default.Close, contentDescription = "clear")
                }
            }
        },
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 20.dp, end = 20.dp)

        ,
        colors = OutlinedTextFieldDefaults.colors(
            focusedContainerColor = Color.White,
            unfocusedContainerColor = Color.White,
            disabledContainerColor = Color.White,
            cursorColor = Color.Gray,
            focusedBorderColor = colorResource(id = R.color.blue),
            unfocusedBorderColor = Color.Black
        )
    )
}




@Composable
fun SearchResult(
    destination: Destination,
    navController: NavController
) {

    Card(
        colors = CardDefaults.cardColors(
            containerColor = Color.White,
        ),
        modifier = Modifier
            .padding(start = 20.dp, end = 20.dp, bottom = 10.dp)
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
