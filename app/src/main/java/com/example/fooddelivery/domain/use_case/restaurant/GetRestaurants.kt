package com.example.fooddelivery.domain.use_case.restaurant

import com.example.fooddelivery.common.Resource
import com.example.fooddelivery.domain.model.Restaurant
import com.example.fooddelivery.domain.repository.FoodRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetRestaurants @Inject constructor(
    private val repository: FoodRepository
) {

    operator fun invoke(): Flow<Resource<List<Restaurant>>> {
        return flow {
            try {
               emit(Resource.Loading())
               val restaurants = repository.fetchRestaurants()
               emit(Resource.Success(restaurants))
            }catch (e: Exception) {
                emit(Resource.Error(e.message ?: ""))
            }
        }
    }
}