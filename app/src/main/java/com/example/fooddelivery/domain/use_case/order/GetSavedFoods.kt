package com.example.fooddelivery.domain.use_case.order

import com.example.fooddelivery.data.data_source.local.entity.FoodEntity
import com.example.fooddelivery.domain.repository.OrderRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetSavedFoods @Inject constructor(
    private val repository: OrderRepository
) {
    operator fun invoke(): Flow<List<FoodEntity>> {
        return repository.getCachedFoods()
    }
}