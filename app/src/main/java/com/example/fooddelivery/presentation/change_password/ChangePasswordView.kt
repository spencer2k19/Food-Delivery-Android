package com.example.fooddelivery.presentation.change_password

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Checkbox
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
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.fooddelivery.presentation.components.BackButton
import com.example.fooddelivery.presentation.components.CustomFilledButton
import com.example.fooddelivery.presentation.components.CustomOutlinedTextField
import com.example.fooddelivery.presentation.main.CongratsChangePassword
import com.example.fooddelivery.presentation.ui.theme.Satoshi

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ChangePasswordView(
    navController: NavController? = null
) {
    Scaffold(topBar = {
        TopAppBar(title = {
            Row(verticalAlignment = Alignment.CenterVertically) {
                BackButton {
                    navController?.popBackStack()
                }

                Spacer(modifier = Modifier.width(20.dp))
                Text(text = "Reset password", fontSize = 20.sp,
                    fontWeight = FontWeight.W700, fontFamily = Satoshi
                )
            }

        },
            colors = TopAppBarDefaults.mediumTopAppBarColors(
                containerColor = Color.White
            )

        )
    }, containerColor = Color.White) {_ ->
        var password by remember{ mutableStateOf("") }
        var confirmPassword by remember{ mutableStateOf("") }
        var rememberMe by remember{ mutableStateOf(false) }



        Column(modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 20.dp, vertical = 20.dp)) {
            Spacer(modifier = Modifier.height(60.dp))
            Text(
                text = "Password",
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.Start),
                style = TextStyle(
                    fontSize = 14.sp,
                    fontFamily = Satoshi,
                    fontWeight = FontWeight(700),
                    color = Color(0xFF181E22),
                    textAlign = TextAlign.Start,
                )
            )

            Spacer(modifier = Modifier.height(10.dp))
            CustomOutlinedTextField(text = password, onValueChange = {
                password = it
            } , placeHolder = "Your password", keyboardType = KeyboardType.Password, obscureText = true )

            Spacer(modifier = Modifier.height(20.dp))

            Text(
                text = "Confirm Password",
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.Start),
                style = TextStyle(
                    fontSize = 14.sp,
                    fontFamily = Satoshi,
                    fontWeight = FontWeight(700),
                    color = Color(0xFF181E22),
                    textAlign = TextAlign.Start,
                )
            )

            Spacer(modifier = Modifier.height(10.dp))
            CustomOutlinedTextField(text = confirmPassword, onValueChange = {
                confirmPassword = it
            } , placeHolder = "Confirm password", keyboardType = KeyboardType.Password, obscureText = true )

            Spacer(modifier = Modifier.height(20.dp))

            Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.Start,
                modifier = Modifier.fillMaxWidth()) {
                Checkbox(checked = rememberMe , onCheckedChange = {
                    rememberMe = it
                } )

                Text(text = "Remember Me",
                    fontWeight = FontWeight.W400,
                    fontSize = 14.sp,
                    fontFamily = Satoshi,
                    color = Color(0xFF181E22)
                )


            }

            Spacer(modifier = Modifier.weight(1f))
            CustomFilledButton(text = "SAVE", onClick = {
                navController?.navigate(CongratsChangePassword.route)
            })


        }
    }
}


@Preview
@Composable
fun PrevChangePasswordView() {
 ChangePasswordView()
}