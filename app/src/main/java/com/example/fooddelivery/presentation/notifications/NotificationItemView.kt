package com.example.fooddelivery.presentation.notifications

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.fooddelivery.presentation.ui.theme.PrimaryColor
import com.example.fooddelivery.presentation.ui.theme.Satoshi

@Composable
fun NotificationItemView() {
    Card(shape = RoundedCornerShape(16.dp), colors = CardDefaults.cardColors(
        containerColor = Color.White
    ), elevation = CardDefaults.cardElevation(
        defaultElevation = 5.dp
    ), modifier = Modifier
        .padding(bottom = 20.dp)
        .fillMaxWidth()
        .height(82.dp)) {
        Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 20.dp)) {
            Box(modifier = Modifier
                .height(50.dp)
                .width(50.dp)
                .background(PrimaryColor, shape = CircleShape)
            ) {
                Icon(imageVector = Icons.Filled.Check, contentDescription = "", tint = Color.White,
                    modifier = Modifier
                        .width(24.dp)
                        .height(24.dp)
                        .align(Alignment.Center))



            }

            Spacer(modifier = Modifier.width(20.dp))
            Column {
                Text(
                    text = "Your order is completed! ",
                    style = TextStyle(
                        fontSize = 14.sp,
                        fontFamily = Satoshi,
                        fontWeight = FontWeight(700),
                        color = Color(0xFF181E22),

                        )
                )
                Spacer(modifier = Modifier.height(5.dp))
                Text(
                    text = "20:00",
                    style = TextStyle(
                        fontSize = 12.sp,
                        fontFamily = Satoshi,
                        fontWeight = FontWeight(400),
                        color = Color(0xFF181E22),

                        )
                )

            }
        }
    }
}


@Preview
@Composable
fun PrevNotificationItemView() {
    NotificationItemView()
}