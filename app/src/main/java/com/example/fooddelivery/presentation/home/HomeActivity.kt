package com.example.fooddelivery.presentation.home

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.example.fooddelivery.presentation.home.components.BottomNavigationComponent
import com.example.fooddelivery.presentation.home.ui.theme.FoodDeliveryTheme

class HomeActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HomeView()
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeView() {
    FoodDeliveryTheme {
        val navController = rememberNavController()
        Scaffold(bottomBar = { BottomNavigationComponent(navController = navController)},
            containerColor = Color.White) { _ ->
            HomeNavHost(navController = navController)
        }
    }
}


@Preview
@Composable
fun PrevHomeView() {
    HomeView()
}