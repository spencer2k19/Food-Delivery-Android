package com.example.fooddelivery.presentation.cart

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
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
import androidx.compose.ui.unit.sp
import com.example.fooddelivery.R
import com.example.fooddelivery.presentation.ui.theme.RedColor
import com.example.fooddelivery.presentation.ui.theme.Satoshi

@Composable
fun CartItemView() {
    Card(colors = CardDefaults.cardColors(
        containerColor = Color.White
    ), shape = RoundedCornerShape(16.dp),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 5.dp
        ),
        modifier = Modifier.padding(bottom = 10.dp)
    ) {
        Row(modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)) {
            Image(painter = painterResource(id = R.drawable.cheese), contentDescription ="",
                modifier = Modifier
                    .width(70.dp)
                    .height(70.dp))

            Spacer(modifier = Modifier.width(10.dp))
            Column(horizontalAlignment = Alignment.Start) {
                Text(text = "Cheese Burger",
                        fontSize = 16.sp,
                    fontWeight = FontWeight.W700,
                    fontFamily = Satoshi
                     )

                Spacer(modifier = Modifier.height(5.dp))
                Row {
                    Text(text = "Provider: ", fontSize = 12.sp, fontWeight = FontWeight.W400,
                        fontFamily = Satoshi, color = Color.Gray)

                    Text(text = "Wendy's", fontSize = 12.sp, fontWeight = FontWeight.W400,
                        fontFamily = Satoshi, color = RedColor)
                }

                Spacer(modifier = Modifier.height(5.dp))
                Row {
                    Text(text = "1 x 12.45 $", fontSize = 15.sp, fontWeight = FontWeight.W400,
                        fontFamily = Satoshi)
                    Spacer(modifier = Modifier.weight(1f))
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        IconButton(onClick = {  }) {
                            Icon(painter = painterResource(id = R.drawable.baseline_remove_circle_outline_24), contentDescription ="" )
                        }
                        Spacer(modifier = Modifier.width(5.dp))
                        Text(text = "1", fontSize = 15.sp, fontWeight = FontWeight.W400,
                            fontFamily = Satoshi, textAlign = TextAlign.Center)
                        Spacer(modifier = Modifier.width(5.dp))
                        IconButton(onClick = {  }) {
                            Icon(painter = painterResource(id = R.drawable.baseline_add_circle_outline_24), contentDescription ="" )
                        }
                    }



                }




            }
        }
    }
}


@Preview
@Composable
fun PrevCartItemView() {
    CartItemView()
}