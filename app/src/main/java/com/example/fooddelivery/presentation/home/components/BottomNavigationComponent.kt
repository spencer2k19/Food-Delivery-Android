package com.example.fooddelivery.presentation.home.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.layout.Box
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarDefaults
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.fooddelivery.presentation.home.BottomNavItem

@Composable
fun BottomNavigationComponent(navController: NavController,bottomBarState: MutableState<Boolean>) {
    val items = listOf(
        BottomNavItem.Main,
        BottomNavItem.Orders,
        BottomNavItem.Profile,
        BottomNavItem.Chat
    )


    AnimatedVisibility(visible = bottomBarState.value,
        enter = slideInVertically(initialOffsetY = {it}),
        exit = slideOutVertically(targetOffsetY = {it}),
        ) {
        NavigationBar(contentColor = Color.Unspecified, containerColor = Color.White) {
            val navBackStackEntry by navController.currentBackStackEntryAsState()
            val currentRoute = navBackStackEntry?.destination?.route
            items.forEach { item ->
                NavigationBarItem(
                    selected = currentRoute == item.screenRoute,
                    icon = {
                        Icon(
                            painter = painterResource(id = item.icon),
                            contentDescription = item.title
                        )
                    },
                    alwaysShowLabel = false, onClick = {
                        navController.navigate(item.screenRoute) {
                            navController.graph.startDestinationRoute?.let { screen_route ->
                                popUpTo(screen_route) {
                                    saveState = true
                                }
                            }
                            launchSingleTop = true
                            restoreState = true
                        }
                    }, colors = NavigationBarItemDefaults.colors(
                        selectedIconColor = Color.Black,
                        unselectedIconColor = Color(0xFF94979F),
                        indicatorColor = Color.White,

                        )
                )
            }
        }
    }


}