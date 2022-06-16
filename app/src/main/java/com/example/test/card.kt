package com.example.test


import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.test.R

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun CardList(mub:Int){
    LazyVerticalGrid(
        modifier = Modifier
            .padding(horizontal = 3.dp)
            .fillMaxSize(),
        cells = GridCells.Fixed(2)
    ) {
        items(mub){ item->
            cardView(item)
        }
    }
}


@Composable
fun cardView(mub: Int) {
    Card(
        modifier = Modifier
            .clip(RoundedCornerShape(1.dp))
            .padding(3.dp)
            .fillMaxWidth(0.45f)
            .aspectRatio(1f)

    ) {
        Column {
            Image(
                painter = painterResource(id = R.drawable.img),
                contentDescription = null,
                modifier = Modifier
                    .background(Color.Black)
                    .fillMaxWidth()
                    .fillMaxHeight(0.6f),
                contentScale = ContentScale.Crop,
            )
            Text(
                text = "标题 $mub",
                modifier = Modifier
                    .weight(1f)
                    .padding(horizontal = 10.dp, vertical = 5.dp)
                    .fillMaxWidth(),
                fontSize = 13.sp,
            )
            Row(
                Modifier
                    .padding(10.dp, 6.dp, 10.dp, 3.dp)
                    .height(15.dp)
            ) {
                Icon(Icons.Filled.Call, contentDescription = null, tint = Color.Gray)
                Text(
                    text = "描述", modifier = Modifier.weight(1f),
                    fontSize = 10.sp,
                    color = Color.Gray

                )

            }
        }

    }
}