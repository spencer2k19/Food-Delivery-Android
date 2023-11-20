package com.example.fooddelivery.presentation.house

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
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
import com.example.fooddelivery.presentation.components.CustomProgress
import com.example.fooddelivery.presentation.house.components.CategoryItemView
import com.example.fooddelivery.presentation.house.components.FoodItemView
import com.example.fooddelivery.presentation.house.components.RestaurantItemView
import com.example.fooddelivery.presentation.main.Cart
import com.example.fooddelivery.presentation.main.NotificationsDestination
import com.example.fooddelivery.presentation.main.RestaurantPage
import com.example.fooddelivery.presentation.ui.theme.Satoshi

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HouseView(
    navController: NavController? = null,
    viewModel: HouseViewModel = hiltViewModel()
) {

       var categoryState = viewModel.categoryState.value
        var foodState = viewModel.foodState.value
        var restaurantState = viewModel.restaurantState.value


        Scaffold(containerColor = Color.White) { _ ->
            var query by remember { mutableStateOf("") }


            Column(modifier = Modifier
                .fillMaxWidth()
                .padding(top = 20.dp)

            ) {

              Row(modifier = Modifier.padding(horizontal = 20.dp)) {
                  OutlinedTextField(value = query, onValueChange = {
                      query = it
                  }, modifier = Modifier
                      .weight(1f)
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

                    Spacer(modifier = Modifier.width(10.dp))
                  Box(modifier = Modifier
                      .clickable {
                          navController?.navigate(NotificationsDestination.route)
                      }
                      .width(54.dp)
                      .height(54.dp)

                      .background(color = Color(0xFFF9F9F9), shape = CircleShape)) {
                      Icon(painter = painterResource(id = R.drawable.notification), contentDescription = "",
                          modifier = Modifier.align(Alignment.Center))
                  }

                  Spacer(modifier = Modifier.width(10.dp))
                  Box(modifier = Modifier
                      .clickable {
                          navController?.navigate(Cart.route)
                      }
                      .width(54.dp)
                      .height(54.dp)

                      .background(color = Color(0xFFF9F9F9), shape = CircleShape)) {
                      Icon(painter = painterResource(id = R.drawable.cart_apple), contentDescription = "",
                          modifier = Modifier.align(Alignment.Center))
                  }
              }
                Spacer(modifier = Modifier.height(20.dp))
                Column(modifier = Modifier
                    .verticalScroll(rememberScrollState())
                    .fillMaxWidth(),
                    horizontalAlignment = Alignment.Start) {
                    Text(text = "Categories",style = TextStyle(
                        fontSize = 18.sp,
                        fontFamily = Satoshi,
                        fontWeight = FontWeight(700),
                        color = Color(0xFF181E22),

                        ),
                        modifier = Modifier.padding(horizontal = 20.dp)
                    )

                    if(categoryState.isLoading) {
                        Spacer(modifier = Modifier.height(10.dp))
                        CustomProgress(modifier = Modifier.align(Alignment.CenterHorizontally))
                    }
                    if (categoryState.error.isNotEmpty()) {
                        Text(
                            modifier = Modifier
                                .fillMaxWidth()
                                .align(Alignment.CenterHorizontally),
                            text = categoryState.error,
                            style = TextStyle(
                                fontSize = 12.sp,
                                fontFamily = Satoshi,
                                fontWeight = FontWeight(500),
                                color = Color(0xFF181E22),
                                textAlign = TextAlign.Center,
                            )

                        )
                    }
                    LazyRow(contentPadding = PaddingValues(end = 20.dp, top = 10.dp, start = 20.dp, bottom = 20.dp)) {
                        items(categoryState.categories) {category ->
                            CategoryItemView(category = category)
                        }

                    }

                    Text(text = "Popular this week",style = TextStyle(
                        fontSize = 18.sp,
                        fontFamily = Satoshi,
                        fontWeight = FontWeight(700),
                        color = Color(0xFF181E22),

                        ),
                        modifier = Modifier.padding(horizontal = 20.dp)
                    )


                    if(foodState.isLoading) {
                        Spacer(modifier = Modifier.height(10.dp))
                        CustomProgress(modifier = Modifier.align(Alignment.CenterHorizontally))
                    }
                    if (foodState.error.isNotEmpty()) {
                        Text(
                            modifier = Modifier
                                .fillMaxWidth()
                                .align(Alignment.CenterHorizontally),
                            text = foodState.error,
                            style = TextStyle(
                                fontSize = 12.sp,
                                fontFamily = Satoshi,
                                fontWeight = FontWeight(500),
                                color = Color(0xFF181E22),
                                textAlign = TextAlign.Center,
                            )

                        )
                    }

                    LazyRow(contentPadding = PaddingValues(start = 20.dp, end = 40.dp, top = 10.dp)) {
                        items(foodState.foods) {food ->
                            FoodItemView(food = food)
                        }

                    }

                    Text(text = "Popular Restaurants",style = TextStyle(
                        fontSize = 18.sp,
                        fontFamily = Satoshi,
                        fontWeight = FontWeight(700),
                        color = Color(0xFF181E22),

                        ),
                        modifier = Modifier.padding(horizontal = 20.dp)
                    )



                    if(restaurantState.isLoading) {
                        Spacer(modifier = Modifier.height(10.dp))
                        CustomProgress(modifier = Modifier.align(Alignment.CenterHorizontally))
                    }
                    if (restaurantState.error.isNotEmpty()) {
                        Spacer(modifier = Modifier.height(10.dp))
                        Text(
                            modifier = Modifier
                                .fillMaxWidth()
                                .align(Alignment.CenterHorizontally),
                            text = restaurantState.error,
                            style = TextStyle(
                                fontSize = 12.sp,
                                fontFamily = Satoshi,
                                fontWeight = FontWeight(500),
                                color = Color(0xFF181E22),
                                textAlign = TextAlign.Center,
                            )

                        )
                    }

                    LazyRow(contentPadding = PaddingValues(horizontal = 20.dp, vertical = 15.dp)) {

                        items(restaurantState.restaurants) {restaurant ->
                            RestaurantItemView(onClick = {
                                navController?.navigate(RestaurantPage.route)
                            }, restaurant = restaurant)
                        }

                    }
                    
                    Spacer(modifier = Modifier.height(100.dp))



                }

            }
        }
}


@Preview
@Composable
fun PrevHouseView() {
    HouseView()
}