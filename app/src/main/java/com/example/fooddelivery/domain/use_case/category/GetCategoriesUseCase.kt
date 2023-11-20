package com.example.fooddelivery.domain.use_case.category

import com.example.fooddelivery.common.Resource
import com.example.fooddelivery.domain.model.Category
import com.example.fooddelivery.domain.repository.FoodRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetCategoriesUseCase @Inject constructor(
    private val repository: FoodRepository
) {

    operator fun invoke(): Flow<Resource<List<Category>>> {
        return flow {
            try {
                emit(Resource.Loading())
                val categories = repository.fetchCategories()
                emit(Resource.Success(categories))
            }catch (e: Exception) {
                emit(Resource.Error(e.message?: ""))
            }
        }
    }
}