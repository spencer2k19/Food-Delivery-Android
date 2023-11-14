package com.example.fooddelivery.presentation.orders

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.fooddelivery.R
import com.example.fooddelivery.presentation.ui.theme.GreenColor
import com.example.fooddelivery.presentation.ui.theme.Satoshi

@Composable
fun OrderItemView() {
    Card(colors = CardDefaults.cardColors(
        containerColor = Color.White
    ), elevation = CardDefaults.cardElevation(
        defaultElevation = 5.dp
    ), shape = RoundedCornerShape(16.dp),
        modifier = Modifier
            .padding(bottom = 10.dp)
            .fillMaxWidth()
            .height(82.dp)
    ) {
        Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 20.dp)) {
            Image(painter = painterResource(id = R.drawable.subway), contentDescription = "",
                modifier = Modifier
                    .width(60.dp)
                    .height(60.dp))
            Spacer(modifier = Modifier.width(20.dp))
            Column(horizontalAlignment = Alignment.Start) {
                Text(
                    text = "Mcdonald's",
                    style = TextStyle(
                        fontSize = 14.sp,
                        fontFamily = Satoshi,
                        fontWeight = FontWeight(700),
                        color = Color(0xFF181E22),

                        )
                )
                Spacer(modifier = Modifier.height(5.dp))

                Text(
                    text = "21:30",
                    style = TextStyle(
                        fontSize = 12.sp,
                        fontFamily = Satoshi,
                        fontWeight = FontWeight(400),
                        color = Color(0xFF181E22),

                        )
                )

                Spacer(modifier = Modifier.height(5.dp))
                Text(
                    text = "$ 45.50",
                    style = TextStyle(
                        fontSize = 12.sp,
                        fontFamily = Satoshi,
                        fontWeight = FontWeight(700),
                        color = Color(0xFF0D5EF9),

                        textAlign = TextAlign.Center,
                    )
                )

            }

            Spacer(modifier = Modifier.weight(1f))
            Box(modifier = Modifier.width(72.dp).height(24.dp).background(GreenColor, shape = RoundedCornerShape(16.dp))) {
                Text(
                    text = "Process",
                    style = TextStyle(
                        fontSize = 12.sp,
                        fontFamily = Satoshi,
                        fontWeight = FontWeight(400),
                        color = Color(0xFFFFFFFF),
                        ),
                    modifier = Modifier.align(Alignment.Center)
                )
            }
        }
    }
}


@Preview
@Composable
fun PrevOrderItemView() {
    OrderItemView()
}