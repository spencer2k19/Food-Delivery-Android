package com.example.fooddelivery.domain.use_case.food

import com.example.fooddelivery.common.Resource
import com.example.fooddelivery.domain.model.Food
import com.example.fooddelivery.domain.model.Testimonial
import com.example.fooddelivery.domain.repository.FoodRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetTestimonials @Inject constructor(
    private val repository: FoodRepository
) {
    operator fun invoke(restaurantId: Int): Flow<Resource<List<Testimonial>>> {
        return flow {
            try {
                emit(Resource.Loading())
                val data = repository.fetchTestimonials(restaurantId)
                emit(Resource.Success(data))
            }catch (e: Exception) {
                emit(Resource.Error(e.message ?: ""))
            }
        }
    }
}