package com.example.fooddelivery.presentation.orders

import com.example.fooddelivery.domain.model.Order

data class OrdersState(
    var isLoading: Boolean = false,
    var data: List<Order> = emptyList(),
    var error: String = ""
)
