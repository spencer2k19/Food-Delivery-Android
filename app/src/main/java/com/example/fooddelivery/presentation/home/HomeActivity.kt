package com.example.fooddelivery.presentation.home

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.fooddelivery.presentation.home.components.BottomNavigationComponent
import com.example.fooddelivery.presentation.main.Cart
import com.example.fooddelivery.presentation.main.Favorites
import com.example.fooddelivery.presentation.main.NotificationsDestination
import com.example.fooddelivery.presentation.main.OrderDetails
import com.example.fooddelivery.presentation.main.PopularMenu
import com.example.fooddelivery.presentation.main.RestaurantPage
import com.example.fooddelivery.presentation.main.Testimonials
import com.example.fooddelivery.presentation.ui.theme.FoodDeliveryTheme

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

        // State of bottomBar, set state to false, if current page route is "order-details"
        val bottomBarState = rememberSaveable { (mutableStateOf(true)) }

        val navController = rememberNavController()
        // Subscribe to navBackStackEntry, required to get current route
        val navBackStackEntry by navController.currentBackStackEntryAsState()



        //Control bottom Bar
        when(navBackStackEntry?.destination?.route) {
            OrderDetails.route -> {
                bottomBarState.value = false
            }
            NotificationsDestination.route -> {
                bottomBarState.value = false
            }

            RestaurantPage.route -> {
                bottomBarState.value = false
            }
            Favorites.route -> {
                bottomBarState.value = false
            }

            Testimonials.route -> {
                bottomBarState.value = false
            }

            PopularMenu.route -> {
                bottomBarState.value = false
            }

            Cart.route -> {
                bottomBarState.value = false
            }

            else -> {
                bottomBarState.value = true
            }
        }


        Scaffold(bottomBar = { BottomNavigationComponent(navController = navController,
            bottomBarState = bottomBarState)},
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