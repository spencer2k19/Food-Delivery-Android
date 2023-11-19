package com.example.fooddelivery.domain.repository

import com.example.fooddelivery.domain.model.SessionToken
import com.example.fooddelivery.domain.model.User

interface AuthRepository {
    suspend fun login(email: String, password: String): SessionToken
    suspend fun register(email: String,password: String, firstname: String, lastname: String,
                         location: String)

    suspend fun getCurrentUser(authorization: String): User
}