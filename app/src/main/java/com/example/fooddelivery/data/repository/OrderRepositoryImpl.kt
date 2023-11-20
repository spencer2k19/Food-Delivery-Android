package com.example.fooddelivery.data.repository

import com.example.fooddelivery.data.data_source.remote.OrderDataSource
import com.example.fooddelivery.domain.model.Order
import com.example.fooddelivery.domain.repository.OrderRepository
import javax.inject.Inject

class OrderRepositoryImpl @Inject constructor(
    private val dataSource: OrderDataSource
): OrderRepository {
    override suspend fun fetchOrders(fields: String): List<Order> {
        return dataSource.fetchOrders(fields).data
    }
}