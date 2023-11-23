package com.example.fooddelivery.data.data_source.remote

import com.example.fooddelivery.data.data_source.BaseDataSource
import com.example.fooddelivery.data.data_source.remote.dto.ResponseFoods
import com.example.fooddelivery.data.data_source.remote.dto.ResponseOrders
import com.example.fooddelivery.data.data_source.remote.dto.order.OrderDto
import javax.inject.Inject

class OrderDataSource @Inject constructor(
    private val api: FoodDeliveryApi
): BaseDataSource() {
    suspend fun fetchOrders(fields: String): ResponseOrders {
        return safeApiCall {
            api.fetchOrders(fields)
        }
    }


    suspend fun addOrder(order:OrderDto): Unit {
        return safeApiCall {
            api.addOrder(order)
        }
    }
}