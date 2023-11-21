package com.example.fooddelivery.presentation.restaurant_details

import android.util.Log
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.fooddelivery.R
import com.example.fooddelivery.common.Endpoints
import com.example.fooddelivery.domain.model.Restaurant
import com.example.fooddelivery.presentation.components.CustomProgress
import com.example.fooddelivery.presentation.components.TestimonialItemView
import com.example.fooddelivery.presentation.house.components.FoodItemView
import com.example.fooddelivery.presentation.main.PopularMenu
import com.example.fooddelivery.presentation.main.Testimonials
import com.example.fooddelivery.presentation.ui.theme.PrimaryColor
import com.example.fooddelivery.presentation.ui.theme.Satoshi

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RestaurantDetailsView(
    navController: NavController? = null,
    restaurant: Restaurant? = null,
    viewModel: RestaurantDetailsViewModel = hiltViewModel()
) {

    val foodsState = viewModel.foodState.value
    val testimonialsState = viewModel.testimonialState.value


    Scaffold(containerColor = Color.White) { _ ->

        val scrollValue = rememberScrollState()


        Box(modifier = Modifier.fillMaxSize()) {

        AsyncImage(model = ImageRequest.Builder(LocalContext.current)
            .data("${Endpoints.ASSETS_URL}/${restaurant?.coverImage}")
            .crossfade(true)
            .build(),
            contentDescription = "${restaurant?.name}",
            error = painterResource(id = R.drawable.restaurant_page),
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
            )

           Column(modifier = Modifier
               .fillMaxSize()
               .verticalScroll(scrollValue)
               ) {



                 Card(colors = CardDefaults.cardColors(
                    containerColor = Color.White
                ), shape = RoundedCornerShape(topStart = 32.dp, topEnd = 32.dp),
                    elevation = CardDefaults.cardElevation(
                        defaultElevation = 0.dp
                    ),
                    modifier = Modifier

                        .fillMaxWidth()
                        .offset(y = 300.dp)


                ) {
                   Column(modifier = Modifier.padding(horizontal = 20.dp, vertical = 20.dp)) {

                       Row {
                           Box(modifier = Modifier
                               .background(PrimaryColor, shape = RoundedCornerShape(16.dp))
                               .padding(horizontal = 10.dp, vertical = 5.dp)
                           ) {
                               Text(
                                   text = "Popular",
                                   style = TextStyle(
                                       fontSize = 12.sp,
                                       fontFamily = Satoshi,
                                       fontWeight = FontWeight(400),
                                       color = Color(0xFFFFFFFF),
                                   )
                               )

                           }
                           Spacer(modifier = Modifier.weight(1f))
                           Box(modifier = Modifier
                               .width(34.dp)
                               .height(34.dp)
                               .background(Color(0x400D5EF9), shape = CircleShape)
                           ) {
                               Icon(painter = painterResource(id = R.drawable.location), tint = PrimaryColor ,contentDescription = "",
                                   modifier = Modifier.align(Alignment.Center))
                           }
                           Spacer(modifier = Modifier.width(10.dp))

                           Box(modifier = Modifier
                               .width(34.dp)
                               .height(34.dp)
                               .background(Color(0x400D5EF9), shape = CircleShape)
                           ) {
                               Icon(painter = painterResource(id = R.drawable.heart_blue),
                                   contentDescription = "", tint = PrimaryColor,modifier = Modifier.align(Alignment.Center))
                           }
                       }


                       Spacer(modifier = Modifier.height(20.dp))
                       Text(
                           text = "${restaurant?.name}",
                           style = TextStyle(
                               fontSize = 16.sp,
                               fontFamily = Satoshi,
                               fontWeight = FontWeight(700),
                               color = Color(0xFF181E22),

                               )
                       )
                       Spacer(modifier = Modifier.height(20.dp))
                       Row(verticalAlignment = Alignment.CenterVertically) {
                           Box(modifier = Modifier
                               .width(34.dp)
                               .height(34.dp)
                               .background(Color(0x1A181E22), shape = CircleShape)
                           ) {
                               Icon(painter = painterResource(id = R.drawable.location),
                                   tint = Color.Black,
                                   contentDescription = "",modifier = Modifier.align(Alignment.Center))
                           }
                           Spacer(modifier = Modifier.width(10.dp))
                           Text(
                               text = "3 km",
                               style = TextStyle(
                                   fontSize = 14.sp,
                                   fontFamily = Satoshi,
                                   fontWeight = FontWeight(400),
                                   color = Color(0xFF181E22),
                               )
                           )
                           Spacer(modifier = Modifier.width(30.dp))
                           Box(modifier = Modifier
                               .width(34.dp)
                               .height(34.dp)
                               .background(Color(0x1A181E22), shape = CircleShape)
                           ) {
                               Icon(painter = painterResource(id = R.drawable.star),
                                   contentDescription = "",modifier = Modifier.align(Alignment.Center))
                           }
                           Spacer(modifier = Modifier.width(10.dp))
                           Text(
                               text = "${restaurant?.rating} rating",
                               style = TextStyle(
                                   fontSize = 14.sp,
                                   fontFamily = Satoshi,
                                   fontWeight = FontWeight(400),
                                   color = Color(0xFF181E22),
                               )
                           )


                       }
                       Spacer(modifier = Modifier.height(20.dp))

                       Text(
                           text = "${restaurant?.description}",
                           style = TextStyle(
                               fontSize = 14.sp,
                               fontFamily = Satoshi,
                               fontWeight = FontWeight(400),
                               color = Color(0xFF181E22),

                               )
                       )
                       Spacer(modifier = Modifier.height(20.dp))
                       Row(verticalAlignment = Alignment.CenterVertically) {
                           Text(
                               text = "Popular this week",
                               style = TextStyle(
                                   fontSize = 16.sp,
                                   fontFamily = Satoshi,
                                   fontWeight = FontWeight(700),
                                   color = Color(0xFF181E22),
                               )
                           )
                           Spacer(modifier = Modifier.weight(1f))

                           TextButton(onClick = {
                               navController?.navigate(PopularMenu.route)
                           }) {
                               Text(
                                   text = "See all",
                                   style = TextStyle(
                                       fontSize = 14.sp,
                                       fontFamily = Satoshi,
                                       fontWeight = FontWeight(400),
                                       color = Color(0xFF0D5EF9),
                                   )
                               )
                           }

                       }
                       Spacer(modifier = Modifier.height(20.dp))
                       if(foodsState.isLoading) {
                           Spacer(modifier = Modifier.height(10.dp))
                           CustomProgress(modifier = Modifier.align(Alignment.CenterHorizontally))
                       }
                       if (foodsState.error.isNotEmpty()) {
                           Text(
                               modifier = Modifier
                                   .fillMaxWidth()
                                   .align(Alignment.CenterHorizontally),
                               text = foodsState.error,
                               style = TextStyle(
                                   fontSize = 12.sp,
                                   fontFamily = Satoshi,
                                   fontWeight = FontWeight(500),
                                   color = Color(0xFF181E22),
                                   textAlign = TextAlign.Center,
                               )

                           )
                       }


                       LazyRow {
                           items(foodsState.data) {food ->
                               FoodItemView(food)
                           }

                       }
                       Spacer(modifier = Modifier.height(20.dp))

                       Row(verticalAlignment = Alignment.CenterVertically) {
                           Text(
                               text = "Testimonials",
                               style = TextStyle(
                                   fontSize = 16.sp,
                                   fontFamily = Satoshi,
                                   fontWeight = FontWeight(700),
                                   color = Color(0xFF181E22),
                               )
                           )
                           Spacer(modifier = Modifier.weight(1f))

                           TextButton(onClick = {
                               navController?.navigate(Testimonials.route+"?restaurantId=${restaurant?.id}")
                           }) {
                               Text(
                                   text = "See all",
                                   style = TextStyle(
                                       fontSize = 14.sp,
                                       fontFamily = Satoshi,
                                       fontWeight = FontWeight(400),
                                       color = Color(0xFF0D5EF9),
                                   )
                               )
                           }

                       }
                       Spacer(modifier = Modifier.height(20.dp))

                       if(testimonialsState.isLoading) {
                           Spacer(modifier = Modifier.height(10.dp))
                           CustomProgress(modifier = Modifier.align(Alignment.CenterHorizontally))
                       }
                       if (testimonialsState.error.isNotEmpty()) {
                           Text(
                               modifier = Modifier
                                   .fillMaxWidth()
                                   .align(Alignment.CenterHorizontally),
                               text = foodsState.error,
                               style = TextStyle(
                                   fontSize = 12.sp,
                                   fontFamily = Satoshi,
                                   fontWeight = FontWeight(500),
                                   color = Color(0xFF181E22),
                                   textAlign = TextAlign.Center,
                               )

                           )
                       }

                       if(testimonialsState.data.isNotEmpty()) {
                           testimonialsState.data.subList(0,1).forEach {testimonial ->
                               TestimonialItemView(testimonial)
                           }
                       }


                       Spacer(modifier = Modifier.height(400.dp))

                   }

                }
           }

            AnimatedVisibility(visible = scrollValue.value == 0) {
                TextButton(onClick = {
                    navController?.popBackStack()
                }) {
                    Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "",
                        tint = PrimaryColor)

                }
            }


        }
    }
}


@Preview
@Composable
fun PrevRestaurantDetails() {
    RestaurantDetailsView()
}



