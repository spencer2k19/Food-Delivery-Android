package com.example.fooddelivery.data.data_source.remote

import com.example.fooddelivery.data.data_source.BaseDataSource
import com.example.fooddelivery.data.data_source.remote.dto.ResponseCategories
import com.example.fooddelivery.data.data_source.remote.dto.ResponseFoods
import com.example.fooddelivery.data.data_source.remote.dto.ResponseRestaurants
import com.example.fooddelivery.data.data_source.remote.dto.ResponseTestimonials
import com.example.fooddelivery.data.data_source.remote.dto.ResponseUser
import javax.inject.Inject

class FoodDataSource @Inject constructor(
    private val apiService: FoodDeliveryApi
): BaseDataSource() {


    suspend fun fetchCategories(): ResponseCategories {
        return safeApiCall {
            apiService.fetchCategories()
        }
    }


    suspend fun fetchFoods(): ResponseFoods {
        return safeApiCall {
            apiService.fetchFoods()
        }
    }

    suspend fun fetchFavoriteFoods(): ResponseFoods {
        return safeApiCall {
            apiService.fetchFavoriteFoods()
        }
    }

    suspend fun fetchRestaurants(): ResponseRestaurants {
        return safeApiCall {
            apiService.fetchRestaurants()
        }
    }

    suspend fun fetchFoodsPerRestaurant(restaurantId: Int): ResponseFoods {
        return safeApiCall {
            apiService.fetchFoodsPerRestaurant(restaurantId)
        }
    }

    suspend fun fetchTestimonials(restaurantId: Int): ResponseTestimonials {
        return safeApiCall {
            apiService.fetchTestimonials(restaurantId)
        }
    }






}
