package com.example.fooddelivery.presentation.credit_card

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.fooddelivery.R
import com.example.fooddelivery.presentation.components.BackButton
import com.example.fooddelivery.presentation.components.CustomFilledButton
import com.example.fooddelivery.presentation.components.CustomOutlinedTextField
import com.example.fooddelivery.presentation.ui.theme.PrimaryColor
import com.example.fooddelivery.presentation.ui.theme.Satoshi

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CreditCardView(
    navController: NavController? = null
) {
    Scaffold(topBar = {
        TopAppBar(title = {
            Row(verticalAlignment = Alignment.CenterVertically) {
                BackButton {
                    navController?.popBackStack()
                }

                Spacer(modifier = Modifier.width(20.dp))
                Text(text = "Add Credit Card", fontSize = 20.sp,
                    fontWeight = FontWeight.W700, fontFamily = Satoshi
                )
            }

        },
            colors = TopAppBarDefaults.mediumTopAppBarColors(
                containerColor = Color.White
            )

        )
    }, containerColor = Color.White) { _ ->
        var fullName by remember{ mutableStateOf("") }
        var cardNumber by remember{ mutableStateOf("") }
        var expires by remember{ mutableStateOf("") }
        var cvv by remember{ mutableStateOf("") }



        
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxWidth()
                .verticalScroll(rememberScrollState())
                .padding(horizontal = 20.dp, vertical = 20.dp)

        ) {

             Spacer(modifier = Modifier.height(80.dp))

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
                text = "Card Number", fontSize = 17.sp,
                fontWeight = FontWeight.W700,

                fontFamily = Satoshi,
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.Start)
            )

            Spacer(modifier = Modifier.height(10.dp))

            CustomOutlinedTextField(text = cardNumber, onValueChange = {
                cardNumber = it
            }, placeHolder = "")

            Spacer(modifier = Modifier.height(20.dp))

            Button(onClick = {

            }, colors = ButtonDefaults.buttonColors(
                containerColor = PrimaryColor
            ), modifier = Modifier.align(Alignment.Start)) {
                Image(painter = painterResource(id = R.drawable.eye_scanner),
                    contentDescription = "")

                Spacer(modifier = Modifier.width(5.dp))
                Text(text = "SCAN CARD", fontSize = 16.sp,
                    fontWeight = FontWeight.W700, fontFamily = Satoshi)
            }

            Spacer(modifier = Modifier.height(20.dp))

            Row {
                Column(modifier = Modifier.weight(1f)) {
                    Text(
                        text = "Expires", fontSize = 17.sp,
                        fontWeight = FontWeight.W700,

                        fontFamily = Satoshi,
                        modifier = Modifier
                            .fillMaxWidth()
                            .align(Alignment.Start)
                    )

                    Spacer(modifier = Modifier.height(5.dp))
                    CustomOutlinedTextField(text = expires, onValueChange = {
                        cardNumber = it
                    }, placeHolder = "10/27/2025")


                }

                Spacer(modifier = Modifier.width(20.dp))

                Column(modifier = Modifier.weight(1f)) {
                    Text(
                        text = "CVV", fontSize = 17.sp,
                        fontWeight = FontWeight.W700,

                        fontFamily = Satoshi,
                        modifier = Modifier
                            .fillMaxWidth()
                            .align(Alignment.Start)
                    )

                    Spacer(modifier = Modifier.height(5.dp))
                    CustomOutlinedTextField(text = cvv, onValueChange = {
                        cvv = it
                    }, placeHolder = "***")


                }




            }

            Spacer(modifier = Modifier.height(20.dp))

            Row(horizontalArrangement = Arrangement.Start, verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()) {
                Image(painter = painterResource(id = R.drawable.mastercard), contentDescription = "")
                Spacer(modifier = Modifier.width(20.dp))
                Image(painter = painterResource(id = R.drawable.visa), contentDescription = "")
                Spacer(modifier = Modifier.width(20.dp))
                Image(painter = painterResource(id = R.drawable.paypal), contentDescription = "")
            }

            Spacer(modifier = Modifier.height(50.dp))

            CustomFilledButton(text = "NEXT", onClick = {

            })



        }
    }
}


@Preview
@Composable
fun PrevCreditCardView() {
    CreditCardView()
}