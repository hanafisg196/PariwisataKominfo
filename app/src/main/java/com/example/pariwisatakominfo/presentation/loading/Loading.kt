package com.example.pariwisatakominfo.presentation.loading

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.pariwisatakominfo.R
import com.example.pariwisatakominfo.presentation.navgraph.Screen


@Composable
fun  LoadingItem()
{
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight(),
        contentAlignment = Alignment.Center
    )
    {
        CircularProgressIndicator(
            modifier = Modifier.
            width(30.dp),
            color = MaterialTheme.colorScheme.secondary,
            trackColor = MaterialTheme.colorScheme.surfaceVariant,
        )
    }
}




@Composable
fun LoadRefreshItem() {
    Box (
        modifier = Modifier
            .fillMaxSize()
    ) {
        Column(

            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 20.dp , bottom = 20.dp)
                .align(Alignment.Center)

        ) {
            CircularProgressIndicator(
                modifier = Modifier.
                width(50.dp),
                color = MaterialTheme.colorScheme.secondary,
                trackColor = MaterialTheme.colorScheme.surfaceVariant,
            )
        }
    }

}




@Composable
fun LoadDetail() {

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 20.dp , bottom = 20.dp)


        ) {
            CircularProgressIndicator(
                modifier = Modifier.
                width(50.dp),
                color = MaterialTheme.colorScheme.secondary,
                trackColor = MaterialTheme.colorScheme.surfaceVariant,
            )
        }


}











@Composable
fun BottomBar(navController: NavHostController) {
    val selected = remember { mutableStateOf(Screen.HomeScreen.route) }

    Box(modifier = Modifier
        .padding(horizontal = 50.dp)
        .offset(y = (-10).dp) // Adjust the vertical offset as needed
    ) {
        Surface(
            modifier = Modifier
                .height(70.dp),
            color = colorResource(id = R.color.blue),
            shape = RoundedCornerShape(30.dp) // Adjust the corner radius as needed
        ) {
            BottomAppBar(
                containerColor = Color.Transparent,
                contentColor = Color.White,
                modifier = Modifier.height(70.dp)
            ) {
                IconButton(onClick = {
                    selected.value = Screen.HomeScreen.route
                    navController.navigate(Screen.HomeScreen.route) {
                        popUpTo(navController.graph.startDestinationId)
                        launchSingleTop = true
                    }
                }, modifier = Modifier.weight(1f)) {
                    Icon(
                        painter = painterResource(id = R.drawable.home),
                        contentDescription = null,
                        modifier = Modifier.size(30.dp),
                        tint = if (selected.value == Screen.HomeScreen.route) Color.White else Color.Gray
                    )
                }

                IconButton(onClick = {
                    selected.value = Screen.SearchScreen.route
                    navController.navigate(Screen.SearchScreen.route) {
                        popUpTo(navController.graph.startDestinationId)
                        launchSingleTop = true
                    }
                }, modifier = Modifier.weight(1f)) {
                    Icon(
                        painter = painterResource(id = R.drawable.destination),
                        contentDescription = null,
                        modifier = Modifier.size(30.dp),
                        tint = if (selected.value == Screen.SearchScreen.route) Color.White else Color.Gray
                    )
                }

                IconButton(onClick = {
                    selected.value = Screen.SearchScreen.route
                    navController.navigate(Screen.SearchScreen.route) {
                        popUpTo(navController.graph.startDestinationId)
                        launchSingleTop = true
                    }
                }, modifier = Modifier.weight(1f)) {
                    Icon(
                        painter = painterResource(id = R.drawable.trips),
                        contentDescription = null,
                        modifier = Modifier.size(30.dp),
                        tint = if (selected.value == Screen.SearchScreen.route) Color.White else Color.Gray
                    )
                }
            }
        }
    }
}



@Composable
fun BottomBarFloating(navController: NavHostController) {
    val selected = remember { mutableStateOf(Screen.HomeScreen.route) }

    Box(modifier = Modifier
        .padding(horizontal = 50.dp)
        .offset(y = (-10).dp) // Adjust the vertical offset as needed
    ) {
        Surface(
            modifier = Modifier
                .height(70.dp),
            color = colorResource(id = R.color.blue),
            shape = RoundedCornerShape(30.dp) // Adjust the corner radius as needed
        ) {
            BottomAppBar(
                containerColor = Color.Transparent,
                contentColor = Color.White,
                modifier = Modifier.height(70.dp)
            ) {
                IconButton(onClick = {
                    selected.value = Screen.HomeScreen.route
                    navController.navigate(Screen.HomeScreen.route) {
                        popUpTo(navController.graph.startDestinationId)
                        launchSingleTop = true
                    }
                }, modifier = Modifier.weight(1f)) {
                    Icon(
                        painter = painterResource(id = R.drawable.home),
                        contentDescription = null,
                        modifier = Modifier.size(30.dp),
                        tint = if (selected.value == Screen.HomeScreen.route) Color.White else Color.Gray
                    )
                }

                IconButton(onClick = {
                    selected.value = Screen.SearchScreen.route
                    navController.navigate(Screen.SearchScreen.route) {
                        popUpTo(navController.graph.startDestinationId)
                        launchSingleTop = true
                    }
                }, modifier = Modifier.weight(1f)) {
                    Icon(
                        painter = painterResource(id = R.drawable.destination),
                        contentDescription = null,
                        modifier = Modifier.size(30.dp),
                        tint = if (selected.value == Screen.SearchScreen.route) Color.White else Color.Gray
                    )
                }

                IconButton(onClick = {
                    selected.value = Screen.SearchScreen.route
                    navController.navigate(Screen.SearchScreen.route) {
                        popUpTo(navController.graph.startDestinationId)
                        launchSingleTop = true
                    }
                }, modifier = Modifier.weight(1f)) {
                    Icon(
                        painter = painterResource(id = R.drawable.trips),
                        contentDescription = null,
                        modifier = Modifier.size(30.dp),
                        tint = if (selected.value == Screen.SearchScreen.route) Color.White else Color.Gray
                    )
                }
            }
        }
    }
}


