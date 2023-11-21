package com.example.fooddelivery.presentation.profile

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.fooddelivery.common.Resource
import com.example.fooddelivery.domain.model.Food
import com.example.fooddelivery.domain.use_case.food.FoodUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject


@HiltViewModel
class ProfileViewModel @Inject constructor(private val foodUseCases: FoodUseCases):ViewModel() {

    private val _state = mutableStateOf(ProfileState())
    val state: State<ProfileState> = _state

    init {
        fetchFavorites()
    }

    private fun fetchFavorites() {
        foodUseCases.getFavoriteFoods().onEach {result ->
            when(result) {
                is Resource.Loading -> {
                    _state.value = ProfileState(isLoading = true)
                }
                is Resource.Success -> {
                    _state.value = ProfileState(data = result.data ?: emptyList())
                }

                is Resource.Error -> {
                    _state.value = ProfileState(error = result.message ?:"")
                }
            }
        }.launchIn(viewModelScope)
    }



    data class ProfileState(
        var isLoading: Boolean = false,
        var data:List<Food> = emptyList(),
        var error: String = ""
    )
}