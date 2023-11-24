package com.example.fooddelivery.presentation.popular_menu

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.fooddelivery.common.Resource
import com.example.fooddelivery.domain.model.Food
import com.example.fooddelivery.domain.model.Restaurant
import com.example.fooddelivery.domain.use_case.food.FoodUseCases
import com.example.fooddelivery.presentation.restaurant_details.RestaurantDetailsViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject


@HiltViewModel
class PopularMenuViewModel @Inject constructor(
    private val useCases: FoodUseCases,
    savedStateHandle: SavedStateHandle
): ViewModel() {

    private var restaurantId: Int = 0
    private val _foodState = mutableStateOf(PopularMenuState())
    val foodState: State<PopularMenuState> = _foodState

    init {
        savedStateHandle.get<Int>("restaurantId")?.let { restaurantId ->
            this.restaurantId = restaurantId
            fetchFetchPopularFoods(restaurantId)
        }
    }

    private fun fetchFetchPopularFoods(restaurantId: Int) {
        useCases.getFoodsPerRestaurant(restaurantId).onEach {result ->
            when(result) {
                is Resource.Loading -> {
                    _foodState.value = PopularMenuState(isLoading = true)
                }

                is Resource.Success -> {
                    _foodState.value =
                        PopularMenuState(data = result.data ?: emptyList())
                }

                is Resource.Error -> {
                    _foodState.value =
                        PopularMenuState(error = result.message ?: "")
                }
            }
        }.launchIn(viewModelScope)
    }


    data class PopularMenuState(
        var isLoading: Boolean = false,
        var data: List<Food> = emptyList(),
        var error: String = ""
    )



}