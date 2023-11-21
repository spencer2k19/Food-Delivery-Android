package com.example.fooddelivery.presentation.order_details

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.example.fooddelivery.domain.model.Order
import com.example.fooddelivery.presentation.ui.theme.GreenColor
import com.example.fooddelivery.presentation.ui.theme.PrimaryColor
import com.example.fooddelivery.presentation.ui.theme.RedColor
import com.google.gson.Gson
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class OrderDetailsViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle
): ViewModel() {

    private val _state = mutableStateOf(OrderDetailsState())
    val state: State<OrderDetailsState> = _state

    init {
        savedStateHandle.get<String>("order")?.let {orderGson ->
            val order = Gson().fromJson(orderGson,Order::class.java)
           //status color
            val statusColor =  if(order.orderStatus?.lowercase() == "process") {
                GreenColor
            } else if(order.orderStatus?.lowercase() == "completed") {
                PrimaryColor
            } else {
                RedColor
            }

            //Price Total order
            var total = 0.0
            (order.foods ?: emptyList()).forEach {foodOrder ->  
                val quantity = foodOrder.quantity ?: 0
                total += quantity.toDouble() * (foodOrder.foodsId?.price ?: 0.0)
            }

            _state.value = OrderDetailsState(order = order, priceTotalOrder = total,statusColor = statusColor)

        }
    }


    data class OrderDetailsState(
        var order:Order? = null,
        var priceTotalOrder: Double = 0.0,
        var statusColor: Color? = null
    )
}