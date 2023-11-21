package com.example.fooddelivery.presentation.profile

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
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
import com.example.fooddelivery.common.PrefSingleton
import com.example.fooddelivery.presentation.components.CustomProgress
import com.example.fooddelivery.presentation.components.FavoriteItemView
import com.example.fooddelivery.presentation.main.Favorites
import com.example.fooddelivery.presentation.ui.theme.PrimaryColor
import com.example.fooddelivery.presentation.ui.theme.Satoshi

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileView(
    navController: NavController? = null,
    viewModel: ProfileViewModel = hiltViewModel()
) {
    val user = PrefSingleton.getUser()
    var state = viewModel.state.value

    Scaffold(containerColor = Color.White) {_ ->
        Box(modifier = Modifier.fillMaxSize()
        ) {
            Image(painter = painterResource(id = R.drawable.background_profile), contentDescription = "",
                modifier = Modifier.fillMaxSize(), contentScale = ContentScale.Crop)

            Column(modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())) {


                Card(colors = CardDefaults.cardColors(
                    containerColor = Color.White
                ), elevation = CardDefaults.cardElevation(
                    defaultElevation = 0.dp
                ), shape = RoundedCornerShape(topStart = 32.dp, topEnd = 32.dp),
                    modifier = Modifier
                        .fillMaxWidth()
                        .offset(y = 300.dp)
                ) {

                    Column(modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 20.dp, vertical = 20.dp)) {

                        Box(modifier = Modifier
                            .background(PrimaryColor, shape = RoundedCornerShape(16.dp))
                            .padding(horizontal = 10.dp, vertical = 5.dp)
                        ) {
                            Text(
                                text = "Member gold",
                                style = TextStyle(
                                    fontSize = 12.sp,
                                    fontFamily = Satoshi,
                                    fontWeight = FontWeight(400),
                                    color = Color(0xFFFFFFFF),
                                )
                            )

                        }
                        
                        Spacer(modifier = Modifier.height(10.dp))

                         Text(
                            text = "${user?.firstName} ${user?.lastName} ",
                            style = TextStyle(
                                fontSize = 16.sp,
                                fontFamily = Satoshi,
                                fontWeight = FontWeight(700),
                                color = Color(0xFF181E22),
                            )
                        )
                        Spacer(modifier = Modifier.height(5.dp))
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Text(
                                text = "${user?.email}",
                                style = TextStyle(
                                    fontSize = 14.sp,
                                    fontFamily = Satoshi,
                                    fontWeight = FontWeight(400),
                                    color = Color(0xFF181E22),
                                )
                            )
                            Spacer(modifier = Modifier.weight(1f))
                            Box(modifier = Modifier
                                .width(34.dp)
                                .height(34.dp)
                                .background(Color(0x400D5EF9), shape = CircleShape)
                            ) {
                                Icon(painter = painterResource(id = R.drawable.edit_pencil_line_02), tint = PrimaryColor ,contentDescription = "",
                                    modifier = Modifier.align(Alignment.Center))
                            }
                        }

                        Spacer(modifier = Modifier.height(10.dp))

                        Card(modifier = Modifier.fillMaxWidth(), colors = CardDefaults.cardColors(
                            containerColor = Color.White
                        ), elevation = CardDefaults.cardElevation(
                            defaultElevation = 5.dp
                        ), shape = RoundedCornerShape(16.dp)
                        ) {
                            Row(modifier = Modifier
                                .fillMaxWidth()
                                .padding(horizontal = 20.dp, vertical = 20.dp), verticalAlignment = Alignment.CenterVertically) {
                                Box(modifier = Modifier
                                    .padding(1.dp)
                                    .width(50.dp)
                                    .height(50.dp)
                                    .background(color = Color(0xFF181E22), shape = CircleShape)) {
                                    Image(painter = painterResource(id = R.drawable.dollar),
                                        contentDescription = "", modifier = Modifier.align(Alignment.Center))
                                }

                                Spacer(modifier = Modifier.width(20.dp))
                                Text(
                                    text = "You have 4 vouchers",
                                    style = TextStyle(
                                        fontSize = 14.sp,
                                        fontFamily = Satoshi,
                                        fontWeight = FontWeight(700),
                                        color = Color(0xFF181E22),
                                    )
                                )
                            }
                        }

                        Spacer(modifier = Modifier.height(10.dp))

                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Text(
                                text = "Favorite",
                                style = TextStyle(
                                    fontSize = 16.sp,
                                    fontFamily = Satoshi,
                                    fontWeight = FontWeight(700),
                                    color = Color(0xFF181E22),
                                )
                            )
                            Spacer(modifier = Modifier.weight(1f))

                            TextButton(onClick = {
                                navController?.navigate(Favorites.route)
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

                        Spacer(modifier = Modifier.height(10.dp))


                        if(state.isLoading) {
                            Spacer(modifier = Modifier.height(10.dp))
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

                        if(state.data.isNotEmpty()) {
                            state.data.subList(0,3).forEach {food->
                                FavoriteItemView(food)
                            }
                        }





                        Spacer(modifier = Modifier.height(400.dp))

                    }


                }
            }
        }
    }
}


@Preview
@Composable
fun PrevProfileView() {
    ProfileView()
}