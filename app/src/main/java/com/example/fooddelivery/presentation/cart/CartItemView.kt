package com.example.fooddelivery.presentation.cart

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.fooddelivery.R
import com.example.fooddelivery.common.Endpoints
import com.example.fooddelivery.common.extensions.toPriceString
import com.example.fooddelivery.data.data_source.local.entity.FoodEntity
import com.example.fooddelivery.presentation.ui.theme.RedColor
import com.example.fooddelivery.presentation.ui.theme.Satoshi

@Composable
fun CartItemView(
    food:FoodEntity? = null,
    addQuantityCallback: () -> Unit,
    reduceQuantityCallback: () -> Unit
) {
    Card(colors = CardDefaults.cardColors(
        containerColor = Color.White
    ), shape = RoundedCornerShape(16.dp),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 5.dp
        ),
        modifier = Modifier.padding(bottom = 10.dp)
    ) {
        Row(modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)) {

        AsyncImage(model = ImageRequest.Builder(LocalContext.current)
            .data("${Endpoints.ASSETS_URL}/${food?.image}")
            .crossfade(true).build(),
            contentDescription =  food?.name ?: "",
            modifier = Modifier
                .width(70.dp)
                .height(70.dp), error = painterResource(id = R.drawable.cheese))




            Spacer(modifier = Modifier.width(10.dp))
            Column(horizontalAlignment = Alignment.Start) {
                Text(text = "${food?.name}",
                        fontSize = 16.sp,
                    fontWeight = FontWeight.W700,
                    fontFamily = Satoshi
                     )

                Spacer(modifier = Modifier.height(5.dp))
                Row {
                    Text(text = "Provider: ", fontSize = 12.sp, fontWeight = FontWeight.W400,
                        fontFamily = Satoshi, color = Color.Gray)

                    Text(text = "Wendy's", fontSize = 12.sp, fontWeight = FontWeight.W400,
                        fontFamily = Satoshi, color = RedColor)
                }

                Spacer(modifier = Modifier.height(5.dp))
                Row {
                    Text(text = "${food?.quantity} x ${food?.price?.toPriceString()} ${food?.currency}", fontSize = 15.sp, fontWeight = FontWeight.W400,
                        fontFamily = Satoshi)
                    Spacer(modifier = Modifier.weight(1f))
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        IconButton(onClick = {
                            reduceQuantityCallback()
                        }) {
                            Icon(painter = painterResource(id = R.drawable.baseline_remove_circle_outline_24), contentDescription ="" )
                        }
                        Spacer(modifier = Modifier.width(5.dp))
                        Text(text = "${food?.quantity}", fontSize = 15.sp, fontWeight = FontWeight.W400,
                            fontFamily = Satoshi, textAlign = TextAlign.Center)
                        Spacer(modifier = Modifier.width(5.dp))
                        IconButton(onClick = {
                            addQuantityCallback()
                        }) {
                            Icon(painter = painterResource(id = R.drawable.baseline_add_circle_outline_24), contentDescription ="" )
                        }
                    }



                }




            }
        }
    }
}


@Preview
@Composable
fun PrevCartItemView() {
    CartItemView(addQuantityCallback = {}, reduceQuantityCallback = {})
}