package com.example.fooddelivery.presentation.house.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
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
fun RestaurantItemView() {
    Card(shape = RoundedCornerShape(16.dp), colors = CardDefaults.cardColors(
        containerColor = Color.White
    ), elevation = CardDefaults.cardElevation(
        defaultElevation = 5.dp
    ), modifier = Modifier.padding(end = 10.dp)) {
       Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.padding(
           horizontal = 30.dp,
           vertical = 10.dp
       )) {
           Image(painter = painterResource(id = R.drawable.mcdonald), contentDescription = "",
               modifier = Modifier
                   .width(79.dp)
                   .height(70.dp), contentScale = ContentScale.FillBounds)
           Spacer(modifier = Modifier.height(10.dp))
           Text(
               text = "McDonald’s",
               style = TextStyle(
                   fontSize = 14.sp,
                   fontFamily = Satoshi,
                   fontWeight = FontWeight(700),
                   color = Color(0xFF181E22),
               )
           )
           Spacer(modifier = Modifier.height(10.dp))
           Text(
               text = "15mins",
               style = TextStyle(
                   fontSize = 12.sp,
                   fontFamily = Satoshi,
                   fontWeight = FontWeight(400),
                   color = Color(0xFF94979F),
                   textAlign = TextAlign.Center,
               )
           )
       }


    }
}


@Preview
@Composable
fun PrevRestaurantItemView() {
    RestaurantItemView()
}