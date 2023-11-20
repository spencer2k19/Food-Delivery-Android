package com.example.fooddelivery.data.data_source.remote.dto

import com.example.fooddelivery.domain.model.Order

data class ResponseOrders(
    val data: List<Order>
)
