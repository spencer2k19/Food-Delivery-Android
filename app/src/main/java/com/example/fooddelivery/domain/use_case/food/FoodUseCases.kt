package com.example.fooddelivery.domain.use_case.food

data class FoodUseCases(
    val getFoods: GetFoods,
    val getFavoriteFoods: GetFavoriteFoods,
    val getFoodsPerRestaurant: GetFoodsPerRestaurant,
    val getTestimonials: GetTestimonials
)
