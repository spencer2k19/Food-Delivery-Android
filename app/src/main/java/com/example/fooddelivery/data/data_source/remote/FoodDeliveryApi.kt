package com.example.fooddelivery.data.data_source.remote

import com.example.fooddelivery.common.Endpoints
import com.example.fooddelivery.data.data_source.remote.dto.LoginDto
import com.example.fooddelivery.data.data_source.remote.dto.ResponseToken
import com.example.fooddelivery.data.data_source.remote.dto.ResponseUser
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST

interface FoodDeliveryApi {
    @POST(Endpoints.LOGIN_URL)
    suspend fun login(@Body data: LoginDto): ResponseToken


    @GET(Endpoints.USER_URL)
    suspend fun getCurrentUser(@Header("Authorization") authorization: String): ResponseUser


}