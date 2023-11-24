package com.example.fooddelivery.domain.use_case.food

import com.example.fooddelivery.common.Resource
import com.example.fooddelivery.domain.model.Food
import com.example.fooddelivery.domain.repository.FoodRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetPopularFoods @Inject constructor(
    private val repository: FoodRepository
) {

    operator fun invoke(restaurantId: Int): Flow<Resource<List<Food>>> {
        return flow {
            try {
                emit(Resource.Loading())
                val foods = repository.fetchPopularFoods(restaurantId)
                emit(Resource.Success(foods))
            }catch (e: Exception) {
                emit(Resource.Error(e.message ?: ""))
            }
        }
    }
}