package com.example.fooddelivery.domain.use_case.order

data class OrderUseCases(
    val getOrders: GetOrders,
    val addFoodToCart: AddFoodToCart,
    val getSavedFoods: GetSavedFoods,
    val removeFoodFromCart: RemoveFoodFromCart,
    val increaseFoodQuantity: IncreaseFoodQuantity
)
