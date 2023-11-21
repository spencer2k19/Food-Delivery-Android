package com.example.fooddelivery.presentation.home

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.fooddelivery.domain.model.Restaurant
import com.example.fooddelivery.presentation.cart.CartView
import com.example.fooddelivery.presentation.chat.ChatView
import com.example.fooddelivery.presentation.favorites.FavoritesView
import com.example.fooddelivery.presentation.house.HouseView
import com.example.fooddelivery.presentation.main.Cart
import com.example.fooddelivery.presentation.main.Favorites
import com.example.fooddelivery.presentation.main.NotificationsDestination
import com.example.fooddelivery.presentation.main.OrderDetails
import com.example.fooddelivery.presentation.main.PopularMenu
import com.example.fooddelivery.presentation.main.RestaurantPage
import com.example.fooddelivery.presentation.main.Testimonials
import com.example.fooddelivery.presentation.notifications.NotificationsView
import com.example.fooddelivery.presentation.order_details.OrderDetailsView
import com.example.fooddelivery.presentation.orders.OrdersView
import com.example.fooddelivery.presentation.popular_menu.PopularMenuView
import com.example.fooddelivery.presentation.profile.ProfileView
import com.example.fooddelivery.presentation.restaurant_details.RestaurantDetailsView
import com.example.fooddelivery.presentation.testimonials.TestimonialsView
import com.google.gson.Gson

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

        composable(NotificationsDestination.route) {
            NotificationsView(navController)
        }

        composable(OrderDetails.route+"?order={order}", arguments = listOf(
            navArgument("order") {
                type = NavType.StringType
                nullable = false
            }
        )) {
            OrderDetailsView(navController)
        }

        composable(RestaurantPage.route+"?restaurant={restaurant}", arguments = listOf(
            navArgument("restaurant") {
                type = NavType.StringType
                this.nullable = false
            }
        )) {
            val restaurantGson = it.arguments?.getString("restaurant")
            val restaurant = Gson().fromJson(restaurantGson,Restaurant::class.java)
            RestaurantDetailsView(navController, restaurant = restaurant)
        }

        composable(Favorites.route) {
            FavoritesView(navController)
        }

        composable(Testimonials.route+"?restaurantId={restaurantId}", arguments = listOf(
            navArgument("restaurantId") {
                type = NavType.IntType
                nullable = false
            }
        )) {
           TestimonialsView(navController)
        }

        composable(PopularMenu.route) {
            PopularMenuView(navController)
        }

        composable(Cart.route) {
            CartView(navController)
        }
    }
}