package com.example.fooddelivery.presentation.cart

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.fooddelivery.data.data_source.local.entity.FoodEntity
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




    data class CartState(
        var data: List<FoodEntity> = emptyList(),
        var total: Double = 0.0
    )
}