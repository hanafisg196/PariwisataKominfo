package com.example.pariwisatakominfo.presentation.details

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
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
fun DestinationDetailScreen()
{
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(color = colorResource(id = R.color.white))
    ) {
        item {
            DestinationDetail()
        }
        item {
            Spacer(modifier = Modifier.height(10.dp))
        }
        item {
            ParagraphSection()
        }
        item {
            Text(
                text = "Top Activity",
                overflow = TextOverflow.Ellipsis,
                fontFamily = Fonts.fontFamily,
                fontWeight = FontWeight.SemiBold,
                fontSize = 20.sp,
                modifier = Modifier.padding(start = 10.dp)
            )
        }
        item {
            Box(
                modifier = Modifier
                    .padding(start = 15.dp, top = 2.dp, bottom = 15.dp)
                    .background(
                        color = Color.Transparent,
                        shape = RoundedCornerShape(8.dp)
                    )
                    .clip(RoundedCornerShape(8.dp))
                    .width(200.dp)
                    .height(100.dp)
            ) {
                Column {
                    DestinationDetailPreview()
                }
            }
        }
        item {
            Text(
                text = "Detail Lokasi",
                overflow = TextOverflow.Ellipsis,
                fontFamily = Fonts.fontFamily,
                fontWeight = FontWeight.SemiBold,
                fontSize = 20.sp,
                modifier = Modifier.padding(start = 10.dp)
            )
        }
        item {
            DetailLocation()
        }
    }

}