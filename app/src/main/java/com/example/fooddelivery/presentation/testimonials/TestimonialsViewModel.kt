package com.example.fooddelivery.presentation.testimonials

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.fooddelivery.common.Resource
import com.example.fooddelivery.domain.model.Testimonial
import com.example.fooddelivery.domain.use_case.food.FoodUseCases
import com.example.fooddelivery.presentation.restaurant_details.RestaurantDetailsViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class TestimonialsViewModel @Inject constructor(
    private val useCases: FoodUseCases,
    savedStateHandle: SavedStateHandle
): ViewModel() {

    private val _testimonialsState = mutableStateOf(RestaurantDetailsViewModel.TestimonialState())
    val testimonialState: State<RestaurantDetailsViewModel.TestimonialState> = _testimonialsState

    init {
        savedStateHandle.get<Int>("restaurantId")?.let { restaurantId ->
            fetchTestimonials(restaurantId)
        }
    }

    private fun fetchTestimonials(restaurantId: Int) {
        useCases.getTestimonials(restaurantId).onEach {result ->
            when(result) {
                is Resource.Loading -> {
                    _testimonialsState.value =
                        RestaurantDetailsViewModel.TestimonialState(isLoading = true)
                }

                is Resource.Success -> {
                    Log.e("food_delivery","Testimonials: ${result.data}")
                    _testimonialsState.value = RestaurantDetailsViewModel.TestimonialState(
                        data = result.data ?: emptyList()
                    )
                }

                is Resource.Error -> {
                    _testimonialsState.value =
                        RestaurantDetailsViewModel.TestimonialState(error = result.message ?: "")
                }
            }
        }.launchIn(viewModelScope)
    }


    data class  TestimonialState(
        var isLoading: Boolean = false,
        var data: List<Testimonial> = emptyList(),
        var error: String = ""
    )
}