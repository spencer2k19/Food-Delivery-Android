package com.example.fooddelivery.presentation.popular_menu


import android.widget.Space
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
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
import com.example.fooddelivery.presentation.ui.theme.PrimaryColor
import com.example.fooddelivery.presentation.ui.theme.Satoshi

@Composable
fun FoodGridItem() {
    Box(modifier = Modifier.height(320.dp)) {
        Card(modifier = Modifier
            .padding(end = 10.dp)
             .height(290.dp)
            .padding(top = 20.dp), colors = CardDefaults.cardColors(
            containerColor = Color.White
        ), shape = RoundedCornerShape(16.dp),
            elevation = CardDefaults.cardElevation(
                defaultElevation = 20.dp
            )


        ) {

            Column(modifier = Modifier
                .fillMaxWidth()
                .padding(top = 140.dp),
                horizontalAlignment = Alignment.CenterHorizontally) {
                Text(text = "Cheese Burger",
                    fontSize = 14.sp, fontFamily = Satoshi,
                    fontWeight = FontWeight.W700,
                    textAlign = TextAlign.Center,
                )
                Spacer(modifier = Modifier.height(5.dp))
                Row {
                    Text(
                        text = "Cheesy Heaven",
                        style = TextStyle(
                            fontSize = 12.sp,
                            fontFamily = Satoshi),
                        fontWeight = FontWeight(400),
                        color = Color(0xFF94979F),
                        textAlign = TextAlign.Center,
                    )
                    Spacer(modifier = Modifier.width(5.dp))

                    Image(painter = painterResource(id = R.drawable.custom_cheese),
                        contentDescription = "" )






                }

                Spacer(modifier = Modifier.height(5.dp))
                Row(verticalAlignment = Alignment.Bottom) {
                    Text(
                        text = "$",
                        style = TextStyle(
                            fontSize = 10.sp,
                            fontFamily = Satoshi),
                        fontWeight = FontWeight(700),
                        color = Color(0xFF181E22),

                        textAlign = TextAlign.Center,
                        modifier = Modifier.padding(bottom = 2.dp)
                    )
                    Spacer(modifier = Modifier.width(2.dp))

                    Text(
                        text = "5.99",
                        style = TextStyle(
                            fontSize = 16.sp,
                            fontFamily = Satoshi,
                            fontWeight = FontWeight(700),
                            color = Color(0xFF181E22),

                            textAlign = TextAlign.Center,
                        )
                    )

                }

                Spacer(modifier = Modifier.weight(1f))

                Box(modifier = Modifier
                    .fillMaxWidth()
                    .height(48.dp)
                    .background(PrimaryColor)) {
                    Row(modifier = Modifier.fillMaxSize(), horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically) {
                        Icon(painter = painterResource(id = R.drawable.shopping_basket_add), contentDescription = "",
                            tint = Color.White)
                        Spacer(modifier = Modifier.width(10.dp))
                        Text(
                            text = "ADD TO CART",
                            style = TextStyle(
                                fontSize = 12.sp,
                                fontFamily = Satoshi,
                                fontWeight = FontWeight(400),
                                color = Color(0xFFFFFFFF),

                                textAlign = TextAlign.Center,
                                letterSpacing = 0.96.sp,
                            )
                        )
                    }
                }

            }


        }

        Row(modifier = Modifier.align(Alignment.TopCenter)) {
            Image(painter = painterResource(id = R.drawable.chicken_sandwich), contentDescription = "",
                modifier = Modifier
                    .width(150.dp)
                    .height(150.dp)
                ,

                contentScale = ContentScale.FillBounds,
            )
            Box(modifier = Modifier
                .offset(x = (-25).dp, y = 10.dp)
                .width(32.dp)
                .height(32.dp)
                .background(color = Color(0xFFF9F9F9), shape = CircleShape)
                .wrapContentSize(unbounded = true)


            ) {
                Icon(painter = painterResource(id = R.drawable.heart),
                    contentDescription = "",modifier = Modifier.align(Alignment.Center))
            }


        }



    }
}


@Preview
@Composable
fun PrevFoodGridItem() {
    FoodGridItem()
}


