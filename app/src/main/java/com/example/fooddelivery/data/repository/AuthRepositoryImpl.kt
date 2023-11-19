package com.example.fooddelivery.data.repository

import com.example.fooddelivery.data.data_source.remote.AuthDataSource
import com.example.fooddelivery.data.data_source.remote.FoodDeliveryApi
import com.example.fooddelivery.domain.model.SessionToken
import com.example.fooddelivery.domain.model.User
import com.example.fooddelivery.domain.repository.AuthRepository
import javax.inject.Inject

class AuthRepositoryImpl @Inject constructor(
    private val dataSource: AuthDataSource
): AuthRepository {
    override suspend fun login(email: String, password: String): SessionToken {
        return dataSource.login(email, password).data
    }

    override suspend fun register(
        email: String,
        password: String,
        firstname: String,
        lastname: String,
        location: String
    ) {
        TODO("Not yet implemented")
    }

    override suspend fun getCurrentUser(authorization: String): User {
        return dataSource.fetchUserData(authorization).data
    }


}