package com.example.fooddelivery.data.data_source.remote

import android.util.Log
import com.example.fooddelivery.data.data_source.BaseDataSource
import com.example.fooddelivery.data.data_source.remote.dto.LoginDto
import com.example.fooddelivery.data.data_source.remote.dto.ResponseToken
import com.example.fooddelivery.data.data_source.remote.dto.ResponseUser
import java.lang.Exception
import javax.inject.Inject

class AuthDataSource @Inject constructor(private val apiService: FoodDeliveryApi): BaseDataSource() {
    suspend fun login(email: String, password: String): ResponseToken {
        Log.e("food_delivery","Email: $email, password: $password")
       return safeApiCall {
           apiService.login(LoginDto(email, password))
       }
    }

    suspend fun fetchUserData(authorization: String): ResponseUser {
        return safeApiCall {
            apiService.getCurrentUser(authorization)
        }
    }
}