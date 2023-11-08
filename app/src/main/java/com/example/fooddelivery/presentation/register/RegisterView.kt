package com.example.fooddelivery.presentation.register

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.fooddelivery.R
import com.example.fooddelivery.presentation.components.CustomFilledButton
import com.example.fooddelivery.presentation.components.CustomOutlinedTextField
import com.example.fooddelivery.presentation.main.Bio
import com.example.fooddelivery.presentation.ui.theme.PrimaryColor
import com.example.fooddelivery.presentation.ui.theme.Satoshi

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RegisterView(
    navController: NavController? = null
) {
    Scaffold(containerColor = Color.White) { _ ->
        var email by remember { mutableStateOf("") }
        var password by remember {
            mutableStateOf("")
        }
        var confirmPassword by remember {
            mutableStateOf("")
        }



        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxWidth()
                .verticalScroll(rememberScrollState())
                .padding(horizontal = 20.dp, vertical = 20.dp)

        ) {
            Image(
                painterResource(id = R.drawable.food_logo), contentDescription = "",
                modifier = Modifier
                    .width(120.dp)
                    .height(120.dp)
                    .align(Alignment.CenterHorizontally),
            )

            Text(
                text = "Sign up your account", fontSize = 17.sp,
                fontWeight = FontWeight.W700,
                fontFamily = Satoshi
            )

            Spacer(modifier = Modifier.height(20.dp))

            Text(
                text = "Email", fontSize = 17.sp,
                fontWeight = FontWeight.W700,
                fontFamily = Satoshi,
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.Start)
            )

            Spacer(modifier = Modifier.height(10.dp))

            CustomOutlinedTextField(text = email, onValueChange = {
                email = it
            }, placeHolder = "Email")

            Spacer(modifier = Modifier.height(20.dp))

            Text(
                text = "Password", fontSize = 17.sp,
                fontWeight = FontWeight.W700,
                fontFamily = Satoshi,
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.Start)
            )

            Spacer(modifier = Modifier.height(10.dp))

            CustomOutlinedTextField(text = password, onValueChange = {
                password = it
            }, placeHolder = "Password", keyboardType = KeyboardType.Password, obscureText = true)


            Spacer(modifier = Modifier.height(20.dp))

            Text(
                text = "Repeat Password", fontSize = 17.sp,
                fontWeight = FontWeight.W700,
                fontFamily = Satoshi,
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.Start)
            )

            Spacer(modifier = Modifier.height(10.dp))

            CustomOutlinedTextField(text = confirmPassword, onValueChange = {
                confirmPassword = it
            }, placeHolder = "Confirm ", keyboardType = KeyboardType.Password, obscureText = true)


            Spacer(modifier = Modifier.height(25.dp))
            CustomFilledButton(text = "NEXT", onClick = {
                navController?.navigate(Bio.route)
            })

            Spacer(modifier = Modifier.height(25.dp))
            Row {
                OutlinedButton(onClick = {

                },border = BorderStroke(1.dp, color = Color(0x1A181E22))) {
                    Image(painter = painterResource(id = R.drawable.facebook_icon), contentDescription = "Google")
                    Spacer(modifier = Modifier.width(5.dp))
                    Text(text = "Facebook", fontFamily = Satoshi,
                        color = Color.Black,
                        fontSize = 13.sp,
                        fontWeight = FontWeight.W500
                    )
                }

                Spacer(modifier = Modifier.width(10.dp))


                OutlinedButton(onClick = {

                }, shape = RoundedCornerShape(16.dp),
                    border = BorderStroke(width = 1.dp, color = Color(0x1A181E22))

                ) {
                    Image(painter = painterResource(id = R.drawable.google_icon), contentDescription = "Google")
                    Spacer(modifier = Modifier.width(5.dp))
                    Text(text = "Google", fontFamily = Satoshi,
                        color = Color.Black,
                        fontSize = 13.sp,
                        fontWeight = FontWeight.W500
                    )
                }
            }


            Spacer(modifier = Modifier.height(10.dp))

            Row (verticalAlignment = Alignment.CenterVertically){
                Text(text = "Already have an account ?", fontSize = 14.sp,
                    fontWeight = FontWeight.Normal,
                    fontFamily = Satoshi
                )

                Spacer(modifier = Modifier.width(2.dp))

                TextButton(onClick = {
                    navController?.popBackStack()
                }) {
                    Text(text = "Sign in", fontSize = 14.sp,
                        fontWeight = FontWeight.Normal,
                        color = PrimaryColor,
                        fontFamily = Satoshi
                    )
                }



            }






        }
    }
}


@Preview
@Composable
fun PrevRegisterView() {
    RegisterView()
}