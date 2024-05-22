package com.example.pariwisatakominfo.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.pariwisatakominfo.R
import com.example.pariwisatakominfo.presentation.navgraph.Screen

@Composable
fun BottomBar(navController: NavHostController) {
    val selected = remember { mutableStateOf(Screen.HomeScreen.route) }

    Box(
        modifier = Modifier
            .padding(horizontal = 20.dp)
            .offset(y = (-50).dp)
    ) {
        Surface(
            modifier = Modifier.
            height(80.dp),
            color = Color.Black,
            shape = RoundedCornerShape(30.dp)
        ) {
            BottomAppBar(
                containerColor = Color.Transparent,
                contentColor = Color.White,
                modifier = Modifier.fillMaxWidth()
            ) {
                IconButton(
                    onClick = {
                        selected.value = Screen.HomeScreen.route
                        navController.navigate(Screen.HomeScreen.route) {
                            popUpTo(0)
                            launchSingleTop = true
                        }
                    },
                    modifier = Modifier
                        .weight(1f)
                        .fillMaxHeight()
                        .align(Alignment.CenterVertically)
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.home),
                        contentDescription = "Home",
                        modifier = Modifier.size(30.dp),
                        tint = if (selected.value == Screen.HomeScreen.route) Color.White else Color.Gray
                    )
                }

                IconButton(
                    onClick = {
                        selected.value = Screen.DestinationsScreen.route
                        navController.navigate(Screen.DestinationsScreen.route) {
                            popUpTo(0)
                            launchSingleTop = true
                        }
                    },
                    modifier = Modifier
                        .weight(1f)
                        .fillMaxHeight()
                        .align(Alignment.CenterVertically)
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.destination),
                        contentDescription = "Destinations",
                        modifier = Modifier.size(30.dp),
                        tint = if (selected.value == Screen.DestinationsScreen.route) Color.White else Color.Gray
                    )
                }

                IconButton(
                    onClick = {
                        selected.value = Screen.Trips.route
                        navController.navigate(Screen.Trips.route) {
                            popUpTo(0)
                            launchSingleTop = true
                        }
                    },
                    modifier = Modifier
                        .weight(1f)
                        .fillMaxHeight()
                        .align(Alignment.CenterVertically)
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.trips),
                        contentDescription = "Search",
                        modifier = Modifier.size(30.dp),
                        tint = if (selected.value == Screen.Trips.route) Color.White else Color.Gray
                    )
                }


            }
        }
    }
}
