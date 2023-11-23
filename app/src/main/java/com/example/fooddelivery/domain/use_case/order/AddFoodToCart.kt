package com.example.fooddelivery.domain.use_case.order

import com.example.fooddelivery.data.data_source.local.entity.FoodEntity
import com.example.fooddelivery.domain.model.Food
import com.example.fooddelivery.domain.repository.OrderRepository
import javax.inject.Inject

class AddFoodToCart @Inject constructor(
    private val repository: OrderRepository
) {

    suspend operator fun invoke(food: Food) {
        try {
            val existingFood = repository.getFoodById(food.id ?: 0)
            if(existingFood != null) {
                existingFood.quantity += 1
                repository.updateFood(existingFood)
            } else {
                val newFood = FoodEntity(food.currency ?: "",food.id ?:0,food.image ?: "",food.name ?: "",
                    food.price ?: 0.0,1, food.restaurant ?: 0)
                repository.addFood(newFood)
            }

        }catch (e: Exception) {
            //
        }
    }
}