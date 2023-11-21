package com.example.fooddelivery.presentation.orders

import android.widget.Space
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.fooddelivery.R
import com.example.fooddelivery.domain.model.Order
import com.example.fooddelivery.presentation.components.CustomProgress
import com.example.fooddelivery.presentation.main.OrderDetails
import com.example.fooddelivery.presentation.ui.theme.Satoshi
import com.google.gson.Gson

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun OrdersView(
    navController: NavController? = null,
    viewModel: OrdersViewModel = hiltViewModel()
) {

    var state = viewModel.state.value

    Scaffold(containerColor = Color.White) { _ ->
        var query by remember{ mutableStateOf("") }



        Column(modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp)) {
            Spacer(modifier = Modifier.height(20.dp))
            Row(verticalAlignment = Alignment.CenterVertically) {
                Image(painter = painterResource(id = R.drawable.food_logo), contentDescription = "",
                    modifier = Modifier
                        .width(50.dp)
                        .height(50.dp), contentScale = ContentScale.FillBounds)

                Spacer(modifier = Modifier.width(20.dp))
                Text(
                    text = "Ordder History",
                    style = TextStyle(
                        fontSize = 18.sp,
                        fontFamily = Satoshi,
                        fontWeight = FontWeight(700),
                        color = Color(0xFF181E22),

                        )
                )


            }

            Spacer(modifier = Modifier.height(20.dp))

            OutlinedTextField(value = query, onValueChange = {
                query = it
            }, modifier = Modifier
                .fillMaxWidth()
                .height(52.dp),
                shape = RoundedCornerShape(54.dp),
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    containerColor = Color(0xFFF9F9F9),
                    unfocusedBorderColor = Color(0xFFF9F9F9),
                    focusedBorderColor = Color(0xFFF9F9F9),
                ),
                leadingIcon = {
                    Icon(painter = painterResource(id = R.drawable.search), contentDescription = "" )
                },
                trailingIcon = {
                    Icon(painter = painterResource(id = R.drawable.filter), contentDescription ="" )
                },
                placeholder = {
                    Text(text = "Search...", fontSize = 16.sp,
                        fontFamily = Satoshi,
                        fontWeight = FontWeight.W400,
                        color = Color(0xFF94979F))
                }
            )

            Spacer(modifier = Modifier.height(20.dp))

            if(state.isLoading) {
                CustomProgress(modifier = Modifier.align(Alignment.CenterHorizontally))
            }
            if (state.error.isNotEmpty()) {
                Text(
                    modifier = Modifier
                        .fillMaxWidth()
                        .align(Alignment.CenterHorizontally),
                    text = state.error,
                    style = TextStyle(
                        fontSize = 12.sp,
                        fontFamily = Satoshi,
                        fontWeight = FontWeight(500),
                        color = Color(0xFF181E22),
                        textAlign = TextAlign.Center,
                    )

                )
            }

            LazyColumn(contentPadding = PaddingValues(bottom = 100.dp)) {

                items(state.data) { order ->
                    OrderItemView(order = order,onClick = {
                        val orderGson = Gson().toJson(order, Order::class.java)
                        navController?.navigate(OrderDetails.route+"?order=$orderGson")
                    })
                }


            }
        }
    }
}


@Preview
@Composable
fun PrevOrdersView() {
    OrdersView()
}