package com.example.pariwisatakominfo.presentation.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import com.example.pariwisatakominfo.R
import com.example.pariwisatakominfo.model.BottomMenus

@Composable
fun ButtonMenu(
    items: List<BottomMenus>,
    onItemClick: (BottomMenus)-> Unit

) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 60.dp)
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = Alignment.CenterVertically,

            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(30.dp))
                .background(color = colorResource(id = R.color.blue))
                .padding(2.dp)

        ) {
            items.forEach { item ->
                ButtonMenuItem(item = item, onItemClick = onItemClick)
            }
        }
    }
}
