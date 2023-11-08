package com.example.fooddelivery.presentation.register

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
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
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.fooddelivery.R
import com.example.fooddelivery.presentation.components.BackButton
import com.example.fooddelivery.presentation.components.CustomFilledButton
import com.example.fooddelivery.presentation.components.CustomOutlinedTextField
import com.example.fooddelivery.presentation.main.Payment
import com.example.fooddelivery.presentation.ui.theme.PrimaryColor
import com.example.fooddelivery.presentation.ui.theme.Satoshi

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BioView(
    navController: NavController? = null
) {
    Scaffold(topBar = {
        TopAppBar(title = {
            Row(verticalAlignment = Alignment.CenterVertically) {
               BackButton {
                   navController?.popBackStack()
               }

                Spacer(modifier = Modifier.width(20.dp))
                Text(text = "Fill in all fields", fontSize = 20.sp,
                    fontWeight = FontWeight.W700, fontFamily = Satoshi)
            }

        },
            colors = TopAppBarDefaults.mediumTopAppBarColors(
                containerColor = Color.White
            )

        )
    }, containerColor = Color.White) { _ ->
        var fullName by remember { mutableStateOf("") }
        var gender by remember {
            mutableStateOf("")
        }
        var phoneNumber by remember {
            mutableStateOf("")
        }

        var birthdate by remember {
            mutableStateOf("")
        }



        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxWidth()
                .verticalScroll(rememberScrollState())
                .padding(horizontal = 20.dp, vertical = 20.dp)

        ) {


            Spacer(modifier = Modifier.height(80.dp))

            Text(text = "Fill all fields for security", fontSize = 14.sp,
                fontWeight = FontWeight.Normal,
                fontFamily = Satoshi, modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.Start))


            Spacer(modifier = Modifier.height(50.dp))


            Text(
                text = "Full Name", fontSize = 17.sp,
                fontWeight = FontWeight.W700,

                fontFamily = Satoshi,
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.Start)
            )

            Spacer(modifier = Modifier.height(10.dp))

            CustomOutlinedTextField(text = fullName, onValueChange = {
                fullName = it
            }, placeHolder = "")

            Spacer(modifier = Modifier.height(20.dp))

            Text(
                text = "Gender", fontSize = 17.sp,
                fontWeight = FontWeight.W700,
                fontFamily = Satoshi,
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.Start)
            )

            Spacer(modifier = Modifier.height(10.dp))

            CustomOutlinedTextField(text = gender, onValueChange = {
                gender = it
            }, placeHolder = "Gender", keyboardType = KeyboardType.Text, obscureText = false)


            Spacer(modifier = Modifier.height(20.dp))

            Text(
                text = "Phone Number", fontSize = 17.sp,
                fontWeight = FontWeight.W700,
                fontFamily = Satoshi,
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.Start)
            )

            Spacer(modifier = Modifier.height(10.dp))

            CustomOutlinedTextField(text = phoneNumber, onValueChange = {
                phoneNumber = it
            }, placeHolder = "Confirm ", keyboardType = KeyboardType.Phone)


            Spacer(modifier = Modifier.height(20.dp))

            Text(
                text = "Birth Date", fontSize = 17.sp,
                fontWeight = FontWeight.W700,
                fontFamily = Satoshi,
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.Start)
            )

            Spacer(modifier = Modifier.height(10.dp))

            CustomOutlinedTextField(text = birthdate, onValueChange = {
                birthdate = it
            }, placeHolder = "Birthdate ", keyboardType = KeyboardType.Phone)


            Spacer(modifier = Modifier.height(40.dp))
            CustomFilledButton(text = "NEXT", onClick = {
                navController?.navigate(Payment.route)
            })

            Spacer(modifier = Modifier.height(25.dp))


        }
    }
}


@Preview
@Composable
fun PrevBioView() {
    BioView()
}