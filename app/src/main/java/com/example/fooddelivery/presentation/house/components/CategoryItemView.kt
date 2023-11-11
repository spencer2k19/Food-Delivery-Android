package com.example.fooddelivery.presentation.house.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.fooddelivery.R
import com.example.fooddelivery.presentation.ui.theme.Satoshi

@Composable
fun CategoryItemView() {
    Card(shape = RoundedCornerShape(69.dp), modifier = Modifier
        .width(110.dp)
        .padding(end = 20.dp)

        , colors = CardDefaults.cardColors(
            containerColor = Color.White
        ), elevation = CardDefaults.cardElevation(
            defaultElevation = 5.dp
        )) {

        Image(painter = painterResource(id = R.drawable.vegetarian), contentDescription = "",
            contentScale = ContentScale.FillBounds, modifier = Modifier
                .fillMaxWidth()
                .height(90.dp)
                .padding(5.dp))


        Spacer(modifier = Modifier.height(10.dp))
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.CenterHorizontally),
            text = "Vegetarian",
            style = TextStyle(
                fontSize = 12.sp,
                fontFamily = Satoshi,
                fontWeight = FontWeight(500),
                color = Color(0xFF181E22),
                textAlign = TextAlign.Center,
            )

        )

        Spacer(modifier = Modifier.height(20.dp))
    }
}


@Preview
@Composable
fun PrevCategoryItemView() {
    Box(modifier = Modifier
        .width(300.dp)
        .height(300.dp)
        .background(Color.White)) {

        LazyRow {
           item {
               CategoryItemView()
               CategoryItemView()
               CategoryItemView()
               CategoryItemView()
           }
        }

    }




}