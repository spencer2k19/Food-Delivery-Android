package com.example.fooddelivery.presentation.house.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.fooddelivery.R
import com.example.fooddelivery.presentation.main.Cart
import com.example.fooddelivery.presentation.ui.theme.RedColor
import com.example.fooddelivery.presentation.ui.theme.Satoshi

@Composable
fun CartBadge(
    number: Int = 0,
    onClick: () -> Unit
) {

    Box(modifier = Modifier
        .clickable {
            onClick()
        }
        .width(80.dp)
        .height(80.dp)) {
        Box(modifier = Modifier

            .width(54.dp)
            .height(54.dp)
            .align(Alignment.Center)

            .background(color = Color(0xFFF9F9F9), shape = CircleShape)) {
            Icon(painter = painterResource(id = R.drawable.cart_apple), contentDescription = "",
                modifier = Modifier.align(Alignment.Center))
        }

        Box(modifier = Modifier
            .padding(end = 10.dp)
            .width(24.dp)
            .height(24.dp)
            .background(color = RedColor, shape = CircleShape)
            .align(Alignment.TopEnd)

        ) {
            Text(text = "$number", color = Color.White,
                fontWeight = FontWeight.SemiBold,
                fontFamily = Satoshi,
                textAlign = TextAlign.Center, modifier = Modifier.align(Alignment.Center))
        }
    }

}


@Preview
@Composable
fun PrevCartBadge() {
    CartBadge {

    }
}