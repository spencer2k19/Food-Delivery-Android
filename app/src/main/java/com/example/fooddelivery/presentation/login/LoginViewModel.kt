package com.example.fooddelivery.presentation.login

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.fooddelivery.common.PrefSingleton
import com.example.fooddelivery.common.Resource
import com.example.fooddelivery.domain.model.SessionToken
import com.example.fooddelivery.domain.use_case.auth.LoginUseCase
import com.example.fooddelivery.domain.use_case.auth.UserUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val loginUseCase: LoginUseCase,
    private val userUseCase: UserUseCase
): ViewModel() {
    private val _state = mutableStateOf(LoginState())
    val state: State<LoginState> = _state

    private val _eventFlow = MutableSharedFlow<UIEvent>()
    val eventFlow = _eventFlow.asSharedFlow()



    fun onEmailEntered(value: String) {
        _state.value = state.value.copy(email = value)
    }

    fun onPasswordEntered(value: String) {
        _state.value = state.value.copy(password = value)
    }

    private fun fetchUserData(sessionToken: SessionToken?) {
        //fetch user data
        userUseCase("Bearer ${sessionToken?.accessToken}").onEach {result ->
            when(result) {
                is Resource.Error -> {
                    _eventFlow.emit(UIEvent.ShowSnackbar(message = result.message?:"An unexpected error occured"))
                    _state.value = state.value.copy(isLoading = false)
                }
                is Resource.Success -> {
                    PrefSingleton.saveTokenData(sessionToken)
                    PrefSingleton.saveUser(result.data)
                    _state.value = LoginState(sessionToken = sessionToken, user = result.data)
                    _eventFlow.emit(UIEvent.ShowHomeScreen)
                }
                else -> {}
            }
        }.launchIn(viewModelScope)
    }


     fun login() {
        _state.value = state.value.copy(errorForEmail = "", errorForPassword = "")
         _state.value.apply {


             if (email.isEmpty()) {
                 _state.value = state.value.copy(errorForEmail = "Please enter your email")

             }
             if(password.isEmpty()) {
                 _state.value = state.value.copy(errorForPassword = "Please enter your password")
             }

             if(state.value.errorForEmail.isNotEmpty() || state.value.errorForPassword.isNotEmpty()) {
                 return
             }
         }

        loginUseCase(state.value.email, state.value.password).onEach {result ->
            when(result) {
                is Resource.Loading -> {
                    _state.value =  state.value.copy(isLoading = true)
                }
                is Resource.Error -> {
                    _eventFlow.emit(UIEvent.ShowSnackbar(message = result.message?:"An unexpected error occured"))
                    _state.value = state.value.copy(isLoading = false)
                }
                is Resource.Success -> {
                    val sessionToken = result.data
                    fetchUserData(sessionToken)


                }

            }

        }.launchIn(viewModelScope)
    }


    sealed class UIEvent {
        data class ShowSnackbar(val message: String): UIEvent()
        object  ShowHomeScreen: UIEvent()
    }
}