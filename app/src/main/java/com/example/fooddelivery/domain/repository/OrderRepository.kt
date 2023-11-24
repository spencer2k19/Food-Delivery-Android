package com.example.fooddelivery.domain.repository

import com.example.fooddelivery.data.data_source.local.entity.FoodEntity
import com.example.fooddelivery.data.data_source.remote.dto.order.OrderDto
import com.example.fooddelivery.domain.model.Order
import kotlinx.coroutines.flow.Flow

interface OrderRepository {
    suspend fun fetchOrders(fields: String): List<Order>
    fun getCachedFoods(): Flow<List<FoodEntity>>

    suspend fun getFoodById(id: Int): FoodEntity?

    suspend fun addFood(food:FoodEntity)

    suspend fun updateFood(food: FoodEntity)

    suspend fun deleteFood(food:FoodEntity)

    suspend fun addOrder(data: OrderDto)

    suspend fun deleteCachedFoods()


}