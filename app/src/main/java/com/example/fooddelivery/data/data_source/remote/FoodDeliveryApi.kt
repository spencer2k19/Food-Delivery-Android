package com.example.fooddelivery.data.data_source.remote

import com.example.fooddelivery.common.Endpoints
import com.example.fooddelivery.common.Utils
import com.example.fooddelivery.data.data_source.remote.dto.LoginDto
import com.example.fooddelivery.data.data_source.remote.dto.ResponseCategories
import com.example.fooddelivery.data.data_source.remote.dto.ResponseFoods
import com.example.fooddelivery.data.data_source.remote.dto.ResponseOrders
import com.example.fooddelivery.data.data_source.remote.dto.ResponseRestaurants
import com.example.fooddelivery.data.data_source.remote.dto.ResponseToken
import com.example.fooddelivery.data.data_source.remote.dto.ResponseUser
import com.example.fooddelivery.domain.model.Category
import com.example.fooddelivery.domain.model.Food
import com.example.fooddelivery.domain.model.Restaurant
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST
import retrofit2.http.Query

interface FoodDeliveryApi {
    @POST(Endpoints.LOGIN_URL)
    suspend fun login(@Body data: LoginDto): ResponseToken


    @GET(Endpoints.USER_URL)
    suspend fun getCurrentUser(@Header("Authorization") authorization: String = Utils.bearerToken()): ResponseUser


    @GET(Endpoints.CATEGORIES_URL)
    suspend fun fetchCategories(@Header("Authorization") authorization: String = Utils.bearerToken()): ResponseCategories

    @GET(Endpoints.FOODS_URL)
    suspend fun fetchFoods(@Header("Authorization") authorization: String = Utils.bearerToken()):ResponseFoods

    @GET(Endpoints.RESTAURANTS_URL)
    suspend fun fetchRestaurants(@Header("Authorization") authorization: String = Utils.bearerToken()): ResponseRestaurants

    @GET(Endpoints.ORDERS_URL)
    suspend fun fetchOrders(
        @Query("fields")fields: String,
        @Header("Authorization") authorization: String = Utils.bearerToken()): ResponseOrders






}