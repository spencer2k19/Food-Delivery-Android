package com.example.fooddelivery.domain.repository

import com.example.fooddelivery.domain.model.Category
import com.example.fooddelivery.domain.model.Food
import com.example.fooddelivery.domain.model.Restaurant
import com.example.fooddelivery.domain.model.Testimonial

interface FoodRepository {
    suspend fun fetchCategories(): List<Category>
    suspend fun fetchFoods(): List<Food>
    suspend fun fetchRestaurants(): List<Restaurant>

    suspend fun fetchFavoriteFoods(): List<Food>

    suspend fun fetchFoodsPerRestaurant(restaurantId: Int): List<Food>

    suspend fun fetchTestimonials(restaurantId: Int): List<Testimonial>
}