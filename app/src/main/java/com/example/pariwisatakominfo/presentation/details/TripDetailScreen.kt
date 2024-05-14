package com.example.pariwisatakominfo.presentation.details

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pariwisatakominfo.R
import com.example.pariwisatakominfo.ui.fonts.Fonts


@Preview(showSystemUi = true)
@Composable
fun TripDetailScreen()
{
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(color = colorResource(id = R.color.white))
    ){
        item{
            Spacer(modifier = Modifier.height(35.dp))
            TopBarTrip()
        }
        item{
            TripSection()
        }
        item{
            Text(
                text = "Top Flows",
                overflow = TextOverflow.Ellipsis,
                fontFamily = Fonts.fontFamily,
                fontWeight = FontWeight.SemiBold,
                fontSize = 20.sp,
                modifier = Modifier
                    .padding(start = 20.dp)
            )
            DestinationSection()
        }

    }
}