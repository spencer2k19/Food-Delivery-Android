package com.example.fooddelivery.presentation.cart

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.fooddelivery.common.Resource
import com.example.fooddelivery.data.data_source.local.entity.FoodEntity
import com.example.fooddelivery.data.data_source.remote.dto.order.FoodDto
import com.example.fooddelivery.data.data_source.remote.dto.order.OrderDto
import com.example.fooddelivery.domain.model.Food
import com.example.fooddelivery.domain.use_case.order.OrderUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CartViewModel @Inject constructor(
    private val useCase: OrderUseCases
): ViewModel() {

    private var _state = mutableStateOf(CartState())
    val state: State<CartState> = _state

    private var _orderState = mutableStateOf(OrderState())
    val orderState: State<OrderState> = _orderState

    init {
        fetchSavedFoods()
    }
    private fun fetchSavedFoods() {
        useCase.getSavedFoods().onEach {
          _state.value = CartState(data = it, total = getTotal(it))
        }.launchIn(viewModelScope)
    }

    private fun getTotal(foods: List<FoodEntity>): Double {
        var total = 0.0
        foods.forEach {food ->
            total += food.quantity.toDouble() * food.price
        }
        return total
    }

    fun increaseFoodQuantity(foodId: Int) {
        viewModelScope.launch {
            useCase.increaseFoodQuantity(foodId)
        }
    }

    fun removeFoodFromCart(foodId: Int) {
        viewModelScope.launch {
            useCase.removeFoodFromCart(foodId)
        }
    }


    fun addOrder(comments: String, data: List<FoodEntity>) {
        val foodsDto = mutableListOf<FoodDto>()
        data.forEach {
            foodsDto.add(FoodDto(it.id,it.quantity))
        }
        val orderDto = OrderDto(comments = comments, foods = foodsDto, orderStatus = "process",
            status = "published")

        useCase.addOrder(orderDto).onEach {result ->
            when(result) {
                is Resource.Loading -> {
                    _orderState.value = OrderState(isLoading = true)
                }

                is Resource.Success -> {
                    _orderState.value = OrderState(success = "Order is created successfully")
                }

                is Resource.Error -> {
                    _orderState.value = OrderState(error = result.message ?: "")
                }
            }
        }.launchIn(viewModelScope)
    }




    data class CartState(
        var data: List<FoodEntity> = emptyList(),
        var total: Double = 0.0
    )

    data class OrderState(
        var isLoading: Boolean = false,
        var success: String = "",
        var error: String = ""
    )
}