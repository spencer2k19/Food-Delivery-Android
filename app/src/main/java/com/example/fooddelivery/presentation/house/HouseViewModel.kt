package com.example.fooddelivery.presentation.house

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.fooddelivery.common.Resource
import com.example.fooddelivery.domain.model.Category
import com.example.fooddelivery.domain.model.Food
import com.example.fooddelivery.domain.model.Restaurant
import com.example.fooddelivery.domain.use_case.category.GetCategoriesUseCase
import com.example.fooddelivery.domain.use_case.food.FoodUseCases
import com.example.fooddelivery.domain.use_case.order.OrderUseCases
import com.example.fooddelivery.domain.use_case.restaurant.RestaurantUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HouseViewModel @Inject constructor(
    private val foodUseCases: FoodUseCases,
    private val getCategories: GetCategoriesUseCase,
    private val restaurantUseCases: RestaurantUseCases,
    private val orderUseCases: OrderUseCases
): ViewModel() {
    private val _foodState = mutableStateOf(FoodState())
    val foodState: State<FoodState> = _foodState

    private val _categoryState = mutableStateOf(CategoryState())
    val categoryState: State<CategoryState> = _categoryState

    private val _restaurantState = mutableStateOf(RestaurantState())
    val restaurantState: State<RestaurantState> = _restaurantState

    private val _foodsAddedToCart = mutableIntStateOf(0)
    val foodsAddedToCart:State<Int> = _foodsAddedToCart

    init {
        fetchCategories()
        fetchFoods()
        fetchRestaurants()
        getSavedFoods()
    }


    //fetch foods
    private fun fetchFoods() {
        foodUseCases.getFoods().onEach {result ->
            when(result) {
                is Resource.Loading -> {
                    _foodState.value = _foodState.value.copy(isLoading = true)
                }

                is Resource.Success -> {
                    _foodState.value = FoodState(foods = result.data ?: emptyList())
                }

                is Resource.Error -> {
                    _foodState.value = FoodState(error = result.message ?: "")
                }
            }
        }.launchIn(viewModelScope)
    }


    fun addFoodToCart(food: Food) {
        viewModelScope.launch {
            orderUseCases.addFoodToCart(food)
        }
    }

    private fun getSavedFoods() {
        orderUseCases.getSavedFoods().onEach {
            _foodsAddedToCart.intValue = it.size
        }.launchIn(viewModelScope)
    }

    //fetch categories
    private fun fetchCategories() {
        getCategories().onEach {result ->
            when(result) {
                is Resource.Loading -> {
                    _categoryState.value = _categoryState.value.copy(isLoading = true)
                }

                is Resource.Success -> {
                    _categoryState.value = CategoryState(categories = result.data ?: emptyList())
                }

                is Resource.Error -> {
                    _categoryState.value = CategoryState(error = result.message ?: "")
                }
            }
        }.launchIn(viewModelScope)
    }


    //fetch restaurants
    private fun fetchRestaurants() {
        restaurantUseCases.getRestaurants().onEach {result ->
            when(result) {
                is Resource.Loading -> {
                    _restaurantState.value = _restaurantState.value.copy(isLoading = true)
                }

                is Resource.Success -> {
                    _restaurantState.value = RestaurantState(restaurants = result.data ?: emptyList())
                }

                is Resource.Error -> {
                    _restaurantState.value = RestaurantState(error = result.message ?: "")
                }
            }
        }.launchIn(viewModelScope)
    }




    data class FoodState(
        var isLoading: Boolean = false,
        var foods: List<Food> = emptyList(),
        var error: String = ""
    )

    data class CategoryState(
        var isLoading: Boolean = false,
        var categories: List<Category> = emptyList(),
        var error: String = ""
    )

    data class RestaurantState(
        var isLoading: Boolean = false,
        var restaurants: List<Restaurant> = emptyList(),
        var error: String = ""
    )


}