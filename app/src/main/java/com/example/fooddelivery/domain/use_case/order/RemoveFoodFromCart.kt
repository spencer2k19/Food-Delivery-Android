package com.example.fooddelivery.domain.use_case.order

import com.example.fooddelivery.domain.repository.OrderRepository
import javax.inject.Inject

class RemoveFoodFromCart @Inject constructor(
    private val repository: OrderRepository
) {

    suspend operator fun invoke(foodId: Int) {
        try {
            val existingFood = repository.getFoodById(foodId)
            existingFood?.let { entity ->
                if(entity.quantity == 1) {
                    repository.deleteFood(existingFood)
                } else {
                    existingFood.quantity -= 1
                }
                repository.updateFood(existingFood)
            }
        } catch (e: Exception) {
            //
        }
    }
}