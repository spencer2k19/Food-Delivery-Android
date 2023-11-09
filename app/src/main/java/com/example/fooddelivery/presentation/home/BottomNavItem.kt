package com.example.fooddelivery.presentation.home

import com.example.fooddelivery.R

sealed class BottomNavItem(var title: String, var icon: Int, var screenRoute: String) {
    object Main : BottomNavItem(title = "Home", icon = R.drawable.home, "home")
    object Orders : BottomNavItem(title = "Orders", icon = R.drawable.commerce, "orders")

    object Profile : BottomNavItem(title = "Profile", icon = R.drawable.user, "profile")
    object Chat : BottomNavItem(title = "Chat", icon = R.drawable.chat, "chat")
}
