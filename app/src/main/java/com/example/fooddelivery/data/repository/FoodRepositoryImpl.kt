package com.example.fooddelivery.data.repository

import com.example.fooddelivery.data.data_source.remote.FoodDataSource
import com.example.fooddelivery.domain.model.Category
import com.example.fooddelivery.domain.model.Food
import com.example.fooddelivery.domain.model.Restaurant
import com.example.fooddelivery.domain.repository.FoodRepository
import javax.inject.Inject

class FoodRepositoryImpl @Inject constructor(
    private val dataSource: FoodDataSource
): FoodRepository {
    override suspend fun fetchCategories(): List<Category> {
        return dataSource.fetchCategories().data
    }

    override suspend fun fetchFoods(): List<Food> {
       return dataSource.fetchFoods().data
    }

    override suspend fun fetchRestaurants(): List<Restaurant> {
        return dataSource.fetchRestaurants().data
    }
}