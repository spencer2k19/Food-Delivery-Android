package com.example.fooddelivery.presentation.favorites

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.fooddelivery.common.Resource
import com.example.fooddelivery.domain.model.Food
import com.example.fooddelivery.domain.use_case.food.FoodUseCases
import com.example.fooddelivery.presentation.profile.ProfileViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject


@HiltViewModel
class FavoritesViewModel @Inject constructor(
    private val useCases: FoodUseCases
): ViewModel() {

    private val _state = mutableStateOf(FavoritesState())
    val state: State<FavoritesState> = _state

    init {
        fetchFavorites()
    }

    private fun fetchFavorites() {
        useCases.getFavoriteFoods().onEach {result ->
            when(result) {
                is Resource.Loading -> {
                    _state.value = FavoritesState(isLoading = true)
                }
                is Resource.Success -> {
                    _state.value = FavoritesState(data = result.data ?: emptyList())
                }

                is Resource.Error -> {
                    _state.value = FavoritesState(error = result.message ?: "")
                }
            }
        }.launchIn(viewModelScope)
    }




    data class FavoritesState(
        var isLoading: Boolean = false,
        var data: List<Food> = emptyList(),
        var error: String = ""
    )
}