package com.example.fooddelivery.domain.use_case.order

import com.example.fooddelivery.common.Resource
import com.example.fooddelivery.data.data_source.remote.dto.order.OrderDto
import com.example.fooddelivery.domain.model.SessionToken
import com.example.fooddelivery.domain.repository.OrderRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class AddOrder @Inject constructor(
    private val repository: OrderRepository
) {

    operator fun invoke(data: OrderDto): Flow<Resource<Unit>> {
        return flow {
            try {
                emit(Resource.Loading())
                repository.addOrder(data)
                emit(Resource.Success(Unit))
            }catch (e: Exception) {
                emit(Resource.Error(e.message ?: ""))
            }
        }
    }
}