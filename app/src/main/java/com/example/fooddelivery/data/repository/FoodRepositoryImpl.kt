package com.example.fooddelivery.data.repository

import com.example.fooddelivery.data.data_source.remote.FoodDataSource
import com.example.fooddelivery.domain.model.Category
import com.example.fooddelivery.domain.model.Food
import com.example.fooddelivery.domain.model.Restaurant
import com.example.fooddelivery.domain.model.Testimonial
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

    override suspend fun fetchFavoriteFoods(): List<Food> {
        return dataSource.fetchFavoriteFoods().data
    }

    override suspend fun fetchPopularFoods(restaurantId: Int): List<Food> {
        return dataSource.fetchPopularFoods(restaurantId).data
    }

    override suspend fun fetchFoodsPerRestaurant(restaurantId: Int): List<Food> {
        return dataSource.fetchFoodsPerRestaurant(restaurantId).data
    }

    override suspend fun fetchTestimonials(restaurantId: Int): List<Testimonial> {
        return dataSource.fetchTestimonials(restaurantId).data
    }


}