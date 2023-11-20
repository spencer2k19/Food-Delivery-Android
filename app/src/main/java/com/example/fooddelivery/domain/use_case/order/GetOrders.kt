package com.example.fooddelivery.domain.use_case.order

import com.example.fooddelivery.common.Resource
import com.example.fooddelivery.domain.model.Order
import com.example.fooddelivery.domain.repository.OrderRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetOrders @Inject constructor(
    private val repository: OrderRepository
) {

    operator fun invoke(fields: String): Flow<Resource<List<Order>>> {
        return flow {
            try {
                emit(Resource.Loading())
                val orders = repository.fetchOrders(fields)
                emit(Resource.Success(orders))
            }catch (e: Exception) {
                emit(Resource.Error(e.message ?: ""))
            }
        }
    }
}