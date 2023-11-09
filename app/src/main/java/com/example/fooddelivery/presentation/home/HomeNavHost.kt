package com.example.fooddelivery.presentation.home

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.fooddelivery.presentation.chat.ChatView
import com.example.fooddelivery.presentation.house.HouseView
import com.example.fooddelivery.presentation.orders.OrdersView
import com.example.fooddelivery.presentation.profile.ProfileView

@Composable
fun HomeNavHost(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    NavHost(navController = navController, startDestination = BottomNavItem.Main.screenRoute) {
        composable(BottomNavItem.Main.screenRoute) {
            HouseView(navController)
        }

        composable(BottomNavItem.Orders.screenRoute) {
            OrdersView(navController)
        }

        composable(BottomNavItem.Profile.screenRoute) {
            ProfileView(navController)
        }

        composable(BottomNavItem.Chat.screenRoute) {
            ChatView(navController)
        }
    }
}