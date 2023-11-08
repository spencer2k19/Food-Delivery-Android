package com.example.fooddelivery.presentation.payment

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.fooddelivery.R
import com.example.fooddelivery.presentation.ui.theme.PrimaryColor
import com.example.fooddelivery.presentation.ui.theme.Satoshi


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PaymentRowView(image: Int,isClicked: Boolean,callback: () -> Unit ,content: @Composable () -> Unit) {
    Card(onClick = {
        callback()
    }, elevation = CardDefaults.cardElevation(
        defaultElevation = 10.dp,

        ),
        modifier = Modifier
            .fillMaxWidth()
            .height(100.dp).border(1.dp, color = if(isClicked) PrimaryColor else Color.Transparent, shape = RoundedCornerShape(16.dp)),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        )



    ) {
        Row(verticalAlignment = Alignment.CenterVertically, modifier =
        Modifier.fillMaxSize()

            .padding(horizontal = 20.dp)) {
            Image(painter = painterResource(id = image), contentDescription = "")
            Spacer(modifier = Modifier.width(40.dp))
            content()
        }
    }
}

@Preview
@Composable
fun PrevPaymentRowView() {
    PaymentRowView(R.drawable.paypal,isClicked = false ,callback = {

    } ,content = {
        Text(text = "Example@example.com", fontSize = 14.sp, fontWeight = FontWeight(400),
            fontFamily = Satoshi )
    } )
}

