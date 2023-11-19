package com.example.fooddelivery.presentation.login

import com.example.fooddelivery.domain.model.SessionToken
import com.example.fooddelivery.domain.model.User

data class LoginState(
    val isLoading: Boolean = false,
    val sessionToken: SessionToken? = null,
    val user: User? = null,
    var email: String = "",
    var password: String = "",
    var errorForEmail: String = "",
    var errorForPassword: String = ""
)