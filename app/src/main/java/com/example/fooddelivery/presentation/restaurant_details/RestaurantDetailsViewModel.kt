package com.example.fooddelivery.presentation.restaurant_details

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.fooddelivery.common.Resource
import com.example.fooddelivery.domain.model.Food
import com.example.fooddelivery.domain.model.Restaurant
import com.example.fooddelivery.domain.model.Testimonial
import com.example.fooddelivery.domain.use_case.food.FoodUseCases
import com.example.fooddelivery.presentation.favorites.FavoritesViewModel
import com.google.gson.Gson
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject


@HiltViewModel
class RestaurantDetailsViewModel @Inject constructor(
    private val useCases: FoodUseCases,
    savedStateHandle: SavedStateHandle
): ViewModel() {

    private var restaurant: Restaurant? = null

    private val _foodState = mutableStateOf(FoodState())
    val foodState: State<FoodState> = _foodState

    private val _testimonialsState = mutableStateOf(TestimonialState())
    val testimonialState: State<TestimonialState> = _testimonialsState

    init {
        savedStateHandle.get<String>("restaurant")?.let {restaurantGson ->
            restaurant = Gson().fromJson(restaurantGson,Restaurant::class.java)
            fetchFoods(restaurant?.id ?: 0)
            fetchTestimonials(restaurant?.id ?: 0)
        }
    }



    private fun fetchFoods(restaurantId: Int) {
        useCases.getFoodsPerRestaurant(restaurantId).onEach {result ->
            when(result) {
                is Resource.Loading -> {
                    _foodState.value = FoodState(isLoading = true)
                }

                is Resource.Success -> {
                    _foodState.value = FoodState(data = result.data ?: emptyList())
                }

                is Resource.Error -> {
                    _foodState.value = FoodState(error = result.message ?: "")
                }
            }
        }.launchIn(viewModelScope)
    }

    private fun fetchTestimonials(restaurantId: Int) {
        useCases.getTestimonials(restaurantId).onEach {result ->
            when(result) {
                is Resource.Loading -> {
                    _testimonialsState.value = TestimonialState(isLoading = true)
                }

                is Resource.Success -> {
                    Log.e("food_delivery","Testimonials: ${result.data}")
                    _testimonialsState.value = TestimonialState(data = result.data ?: emptyList())
                }

                is Resource.Error -> {
                    _testimonialsState.value = TestimonialState(error = result.message ?: "")
                }
            }
        }.launchIn(viewModelScope)
    }


    data class FoodState(
        var isLoading: Boolean = false,
        var data: List<Food> = emptyList(),
        var error: String = ""
    )

    data class  TestimonialState(
        var isLoading: Boolean = false,
        var data: List<Testimonial> = emptyList(),
        var error: String = ""
    )


}