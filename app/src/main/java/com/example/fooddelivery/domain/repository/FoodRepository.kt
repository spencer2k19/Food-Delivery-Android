package com.example.fooddelivery.domain.repository

import com.example.fooddelivery.domain.model.Category
import com.example.fooddelivery.domain.model.Food
import com.example.fooddelivery.domain.model.Restaurant

interface FoodRepository {
    suspend fun fetchCategories(): List<Category>
    suspend fun fetchFoods(): List<Food>
    suspend fun fetchRestaurants(): List<Restaurant>

    suspend fun fetchFavoriteFoods(): List<Food>
}