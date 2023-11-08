package com.example.fooddelivery.presentation.forgot_password

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.fooddelivery.presentation.components.BackButton
import com.example.fooddelivery.presentation.components.CustomFilledButton
import com.example.fooddelivery.presentation.components.PinView
import com.example.fooddelivery.presentation.main.ChangePassword
import com.example.fooddelivery.presentation.ui.theme.Satoshi

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ForgotPasswordView(
    navController: NavController? = null
) {
    Scaffold(topBar = {
        TopAppBar(title = {
            Row(verticalAlignment = Alignment.CenterVertically) {
                BackButton {
                    navController?.popBackStack()
                }

                Spacer(modifier = Modifier.width(20.dp))
                Text(text = "Forgot password", fontSize = 20.sp,
                    fontWeight = FontWeight.W700, fontFamily = Satoshi
                )
            }

        },
            colors = TopAppBarDefaults.mediumTopAppBarColors(
                containerColor = Color.White
            )

        )
    }, containerColor = Color.White) { _ ->
        var otpValue by remember { mutableStateOf("") }

           Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier
               .fillMaxSize()
               .padding(horizontal = 20.dp, vertical = 20.dp)) {
               Spacer(modifier = Modifier.weight(1f))
               Text(text = "Code has been send to +6282******39",
                   fontSize = 14.sp,
                   fontFamily = Satoshi,
                   fontWeight = FontWeight(700)
               )

               Spacer(modifier = Modifier.height(10.dp))
               Text(text = "Resend code in 56 s",
                   fontSize = 14.sp,
                   fontFamily = Satoshi,
                   fontWeight = FontWeight(400)
               )
               Spacer(modifier = Modifier.height(10.dp))
               PinView(pinText = otpValue , onPinTextChange = {
                   otpValue = it
               })
               Spacer(modifier = Modifier.weight(1f))
               CustomFilledButton(text = "SAVE", onClick = {
                    navController?.navigate(ChangePassword.route)
               })
           }
    }
}


@Preview
@Composable
fun PrevForgotPassword() {
    ForgotPasswordView()
}