package com.example.fooddelivery.presentation.orders

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.fooddelivery.common.Resource
import com.example.fooddelivery.domain.use_case.order.OrderUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class OrdersViewModel @Inject constructor(
    private val ordersUseCases: OrderUseCases
): ViewModel() {

    private val _state = mutableStateOf(OrdersState())
    val state: State<OrdersState> = _state

    init {
        fetchOrders()
    }

    private fun fetchOrders() {
        ordersUseCases.getOrders("*,foods.foods_id.restaurant.*,foods.quantity,foods.foods_id.price,foods.foods_id.image,foods.foods_id.name,foods.foods_id.currency,foods.id").onEach {result ->
            when(result) {
                is Resource.Loading -> {
                    _state.value = _state.value.copy(isLoading = true)
                }
                is Resource.Success -> {
                    _state.value = OrdersState(data = result.data ?: emptyList())
                }

                is Resource.Error -> {
                    _state.value = OrdersState(error = result.message ?: "")
                }
            }
        }.launchIn(viewModelScope)
    }



}