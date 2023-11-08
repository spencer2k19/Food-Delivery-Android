package com.example.fooddelivery.presentation.change_password

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.fooddelivery.R
import com.example.fooddelivery.presentation.components.CustomFilledButton
import com.example.fooddelivery.presentation.main.Login
import com.example.fooddelivery.presentation.ui.theme.PrimaryColor
import com.example.fooddelivery.presentation.ui.theme.Satoshi

@Composable
fun CongratsPasswordChanged(
    navController: NavController? = null
) {
    Box(modifier = Modifier
        .fillMaxSize()
        .background(Color.White)) {
        Image(painter = painterResource(id = R.drawable.splash_background),
            contentDescription = "", modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop)

        Column(horizontalAlignment = Alignment.CenterHorizontally,modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 20.dp, vertical = 20.dp)) {
            Spacer(modifier = Modifier.weight(1f))

            
            Box(modifier = Modifier
                .height(120.dp)
                .width(120.dp)
                .background(PrimaryColor, shape = CircleShape)
            ) {
                Icon(imageVector = Icons.Filled.Check, contentDescription = "", tint = Color.White,
                    modifier = Modifier.width(50.dp).height(50.dp).align(Alignment.Center))
            }

            Spacer(modifier = Modifier.height(10.dp))
            Text(text = "Congrats", fontSize = 24.sp,
                color = PrimaryColor,
                fontFamily = Satoshi,
                fontWeight = FontWeight.W700
                )
            Spacer(modifier = Modifier.height(10.dp))
            Text(text = "Password reset successful", fontSize = 16.sp,
                fontFamily = Satoshi,
             fontWeight = FontWeight.W400,
                color = Color(0xFF181E22)
            )

            Spacer(modifier = Modifier.weight(1f))
            CustomFilledButton(text = "NEXT", onClick = {
                navController?.popBackStack(Login.route,inclusive = false)
            })

        }
    }
}


@Preview
@Composable
fun PrevCongratsPasswordChanged() {
    CongratsPasswordChanged()
}