package com.example.fooddelivery.data.data_source.remote.dto


import com.google.gson.annotations.SerializedName

data class LoginDto(
    @SerializedName("email")
    val email: String?,
    @SerializedName("password")
    val password: String?
)