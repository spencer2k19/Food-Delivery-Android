package com.example.fooddelivery.presentation.payment

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
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
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.ElevatedButton
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.fooddelivery.R
import com.example.fooddelivery.presentation.components.BackButton
import com.example.fooddelivery.presentation.components.CustomFilledButton
import com.example.fooddelivery.presentation.main.CreditCart
import com.example.fooddelivery.presentation.ui.theme.PrimaryColor
import com.example.fooddelivery.presentation.ui.theme.Satoshi

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PaymentMethodView(
    navController: NavController? = null
) {



    Scaffold(topBar = {
        TopAppBar(title = {
            Row(verticalAlignment = Alignment.CenterVertically) {
                BackButton {
                    navController?.popBackStack()
                }

                Spacer(modifier = Modifier.width(20.dp))
                Text(text = "Payment Method", fontSize = 20.sp,
                    fontWeight = FontWeight.W700, fontFamily = Satoshi
                )
            }

        },
            colors = TopAppBarDefaults.mediumTopAppBarColors(
                containerColor = Color.White
            )

        )
    }, containerColor = Color.White) { _ ->

        var paymentChoiceIndex by remember {
            mutableStateOf(0)
        }
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxWidth()
                .verticalScroll(rememberScrollState())
                .padding(horizontal = 20.dp, vertical = 20.dp)

        ) {
            Spacer(modifier = Modifier.height(60.dp))
            Text(text = "A payment method is a way to transfer money or complete a financial transaction",
                fontSize = 14.sp, fontWeight = FontWeight(400), fontFamily = Satoshi
           )


            Spacer(modifier = Modifier.height(30.dp))

            PaymentRowView(image = R.drawable.paypal, isClicked = paymentChoiceIndex == 0 , callback = {
                paymentChoiceIndex = 0
            }) {
                Text(text = "Example@example.com", fontSize = 14.sp, fontWeight = FontWeight(400),
                    fontFamily = Satoshi )
            }

            Spacer(modifier = Modifier.height(15.dp))

            PaymentRowView(image = R.drawable.mastercard, isClicked = paymentChoiceIndex == 1 , callback = {
                paymentChoiceIndex = 1
            }) {
               Column(horizontalAlignment = Alignment.Start) {
                    Text(text = "****  ****  **** 5928", fontSize = 14.sp,
                        fontWeight = FontWeight(400), fontFamily = Satoshi
                   )
                   Spacer(modifier = Modifier.height(10.dp))

                   Text(text = "Express 03/27", fontSize = 12.sp,
                       fontFamily = Satoshi, fontWeight = FontWeight(400),
                       color = Color(0xFF94979F),
                   )
               }
            }

            Spacer(modifier = Modifier.height(20.dp))

            Button(onClick = {  }, shape = RoundedCornerShape(50.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFFD8EDF9),
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp)
            ) {
                Text(text = "ADD CART +", fontSize = 16.sp,
                    fontFamily = Satoshi,
                    fontWeight = FontWeight(700),
                    color = Color(0xFF0D5EF9),

                    textAlign = TextAlign.Center,
                    letterSpacing = 1.28.sp,)
            }


            Spacer(modifier = Modifier.height(20.dp))

            Text(text = "Other Methods", fontSize = 14.sp,
                fontWeight = FontWeight.W700, fontFamily = Satoshi,
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.Start))


            Spacer(modifier = Modifier.height(15.dp))

            PaymentRowView(image = R.drawable.cashapp, isClicked = paymentChoiceIndex == 2 , callback = {
                paymentChoiceIndex = 2
            }) {
                Column(horizontalAlignment = Alignment.Start) {
                    Text(text = "Cash Payment", fontSize = 14.sp,
                        fontWeight = FontWeight(400), fontFamily = Satoshi
                    )
                    Spacer(modifier = Modifier.height(10.dp))

                    Text(text = "Default Method", fontSize = 12.sp,
                        fontFamily = Satoshi, fontWeight = FontWeight(400),
                        color = Color(0xFF94979F),
                    )
                }
            }

            Spacer(modifier = Modifier.height(40.dp))

            CustomFilledButton(text = "NEXT", onClick = {
                navController?.navigate(CreditCart.route)
            })
        }
    }
}


@Preview
@Composable
fun PaymentMethodPrev() {
    PaymentMethodView()
}