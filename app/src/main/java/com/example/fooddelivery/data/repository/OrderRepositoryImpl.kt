package com.example.fooddelivery.data.repository

import com.example.fooddelivery.data.data_source.local.FoodsDao
import com.example.fooddelivery.data.data_source.local.entity.FoodEntity
import com.example.fooddelivery.data.data_source.remote.OrderDataSource
import com.example.fooddelivery.data.data_source.remote.dto.order.OrderDto
import com.example.fooddelivery.domain.model.Order
import com.example.fooddelivery.domain.repository.OrderRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class OrderRepositoryImpl @Inject constructor(
    private val dataSource: OrderDataSource,
    private val dao: FoodsDao
): OrderRepository {
    override suspend fun fetchOrders(fields: String): List<Order> {
        return dataSource.fetchOrders(fields).data
    }

    override fun getCachedFoods(): Flow<List<FoodEntity>> {
        return dao.getFoods()
    }

    override suspend fun getFoodById(id: Int): FoodEntity? {
        return dao.getFoodById(id)
    }

    override suspend fun addFood(food: FoodEntity) {
       dao.insertFood(food)
    }

    override suspend fun updateFood(food: FoodEntity) {
       dao.updateFood(food = food)
    }

    override suspend fun deleteFood(food: FoodEntity) {
       dao.deleteFood(food)
    }

    override suspend fun addOrder(data: OrderDto) {
        dataSource.addOrder(order = data)
    }

    override suspend fun deleteCachedFoods() {
        dao.deleteFoods()
    }
}