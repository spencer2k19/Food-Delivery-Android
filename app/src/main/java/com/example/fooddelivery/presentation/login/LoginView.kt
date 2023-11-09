package com.example.fooddelivery.presentation.login

import android.app.Activity
import android.content.Intent
import android.content.res.Resources.Theme
import androidx.compose.foundation.BorderStroke
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
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.fooddelivery.R
import com.example.fooddelivery.presentation.components.CustomFilledButton
import com.example.fooddelivery.presentation.components.CustomOutlinedTextField
import com.example.fooddelivery.presentation.home.HomeActivity
import com.example.fooddelivery.presentation.main.ForgotPassword
import com.example.fooddelivery.presentation.main.Register
import com.example.fooddelivery.presentation.ui.theme.PrimaryColor
import com.example.fooddelivery.presentation.ui.theme.Satoshi

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginView(
    navController: NavController? = null
) {
    val activity = (LocalContext.current as? Activity)

    Scaffold(containerColor = Color.White) { _ ->
        var email by remember {  mutableStateOf("")}
        var password by remember{ mutableStateOf("") }
        var rememberMe by remember { mutableStateOf(false) }



        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxWidth()
                .verticalScroll(rememberScrollState())
                .padding(horizontal = 20.dp, vertical = 20.dp)

        ) {
            Image(
                painter = painterResource(id = R.drawable.food_logo),
                contentDescription = "", modifier = Modifier
                    .width(150.dp)
                    .height(150.dp)
                    .align(Alignment.CenterHorizontally)
            )


            Spacer(modifier = Modifier.height(20.dp))
            Text(
                text = "Sign in your account",
                style = TextStyle(
                    fontSize = 18.sp,
                    fontFamily = Satoshi,
                    fontWeight = FontWeight(700),
                    color = Color(0xFF181E22),
                    textAlign = TextAlign.Center,
                )
            )

            Spacer(modifier = Modifier.height(10.dp))
            Text(
                text = "Email",
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.Start),
                style = TextStyle(
                    fontSize = 18.sp,
                    fontFamily = Satoshi,
                    fontWeight = FontWeight(700),
                    color = Color(0xFF181E22),
                    textAlign = TextAlign.Start,
                )
            )

            Spacer(modifier = Modifier.height(10.dp))
            CustomOutlinedTextField(text = email, onValueChange = {
                                                                  email = it
            } , placeHolder = "Your email" )


            Spacer(modifier = Modifier.height(10.dp))
            Text(
                text = "Password",
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.Start),
                style = TextStyle(
                    fontSize = 18.sp,
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

            Spacer(modifier = Modifier.height(5.dp))
                
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

            Spacer(modifier = Modifier.height(20.dp))

            CustomFilledButton(text = "SIGN IN", onClick = {
                activity?.startActivity(Intent(activity,HomeActivity::class.java))
                activity?.finish()
            })

            Spacer(modifier = Modifier.height(10.dp))


            TextButton(onClick = {
                                 navController?.navigate(ForgotPassword.route)
            },) {
                Text(text = "Forgot password ?",
                    color = PrimaryColor,
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Normal,
                    fontFamily = Satoshi

                    )
            }

            Spacer(modifier = Modifier.height(10.dp))

            Row(verticalAlignment = Alignment.CenterVertically) {
                Box(modifier = Modifier
                    .weight(1f)
                    .height(2.dp)
                    .background(color = Color(237, 237, 237), shape = RoundedCornerShape(2.dp))
                )

                Spacer(modifier = Modifier.width(5.dp))

                Text(text = "or continue with",
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Normal,
                    fontFamily = Satoshi
                 )

                Spacer(modifier = Modifier.width(5.dp))

                Box(modifier = Modifier
                    .weight(1f)
                    .height(2.dp)
                    .background(color = Color(237, 237, 237), shape = RoundedCornerShape(2.dp))
                )


            }

            Spacer(modifier = Modifier.height(10.dp))

            Row(horizontalArrangement = Arrangement.Center) {
                OutlinedButton(onClick = { }, shape = RoundedCornerShape(16.dp),
                    border = BorderStroke(width = 1.dp, color = Color(0x1A181E22))

                ) {
                    Image(painter = painterResource(id = R.drawable.facebook_icon), contentDescription = "facebook")
                    Spacer(modifier = Modifier.width(5.dp))
                    Text(text = "Facebook", fontFamily = Satoshi,
                        color = Color.Black,
                        fontSize = 13.sp,
                        fontWeight = FontWeight.W500
                    )
                }

                Spacer(modifier = Modifier.width(10.dp))


                OutlinedButton(onClick = { }, shape = RoundedCornerShape(16.dp),
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
                Text(text = "Don't have an account ?", fontSize = 14.sp,
                    fontWeight = FontWeight.Normal,
                    fontFamily = Satoshi
                    )

                Spacer(modifier = Modifier.width(2.dp))

                TextButton(onClick = {
                    navController?.navigate(Register.route)
                }) {
                    Text(text = "Sign up", fontSize = 14.sp,
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
fun PrevLoginView() {
    LoginView()
}