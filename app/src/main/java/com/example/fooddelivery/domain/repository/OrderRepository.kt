package com.example.fooddelivery.domain.repository

import com.example.fooddelivery.domain.model.Order

interface OrderRepository {
    suspend fun fetchOrders(fields: String): List<Order>

}