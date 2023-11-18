package com.example.fooddelivery.presentation.favorites

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
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
import com.example.fooddelivery.presentation.components.FavoriteItemView
import com.example.fooddelivery.presentation.notifications.NotificationItemView
import com.example.fooddelivery.presentation.ui.theme.Satoshi

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FavoritesView(
    navController: NavController? = null
) {
    Scaffold(topBar = {
        TopAppBar(title = {
            Row(verticalAlignment = Alignment.CenterVertically) {
                BackButton {
                    navController?.popBackStack()
                }

                Spacer(modifier = Modifier.width(20.dp))
                Text(text = "Favorites", fontSize = 20.sp,
                    fontWeight = FontWeight.W700, fontFamily = Satoshi
                )
            }

        },
            colors = TopAppBarDefaults.mediumTopAppBarColors(
                containerColor = Color.White
            )

        )
    }, containerColor = Color.White) { _ ->
        var query by remember {
            mutableStateOf("")
        }

        Column(modifier = Modifier
            .fillMaxWidth()
            .padding(top = 60.dp, start = 20.dp, end = 20.dp)) {

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

            Spacer(modifier = Modifier.height(30.dp))

            LazyColumn(contentPadding = PaddingValues(bottom = 60.dp, top = 10.dp)) {
                items(6) {
                    FavoriteItemView()
                }
            }
        }


    }
}


@Preview
@Composable
fun PrevFavoritesView() {
    FavoritesView()
}