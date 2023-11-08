package com.example.fooddelivery.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.fooddelivery.R
import com.example.fooddelivery.presentation.components.CustomFilledButton
import com.example.fooddelivery.presentation.main.Login
import com.example.fooddelivery.presentation.ui.theme.Satoshi

@Composable
fun StartView(
    navController: NavController? = null
) {
    Box(modifier = Modifier.fillMaxSize()) {
        Image(painter = painterResource(id = R.drawable.intro_burger), contentDescription ="",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxSize()
                .alpha(0.7f)
            )
        Spacer(modifier = Modifier.fillMaxHeight())
        Column(verticalArrangement = Arrangement.Bottom,modifier = Modifier
            .fillMaxHeight()
            .padding(horizontal = 20.dp),

            ) {
            Text(text = "Brand", style = TextStyle(
                fontSize = 24.sp,
                fontFamily = Satoshi,
                fontWeight = FontWeight.Bold,
                color = Color.White
            ))

            Text(text = "Savor the convenience of restaurant-quality meals, delivered promptly.",
                    style = TextStyle(
                        fontSize = 14.sp,
                        fontFamily = Satoshi,
                        fontWeight = FontWeight.W400,
                        color = Color.White
                    )

                )

            Spacer(modifier = Modifier.height(20.dp))


            CustomFilledButton(text = "NEXT", onClick = {
                navController?.navigate(Login.route)
            }, color = Color.White, textColor = Color.Black)

            Spacer(modifier = Modifier.height(40.dp))
        }

    }
}


@Preview
@Composable
fun DefaultPrevStart() {
    StartView()
}