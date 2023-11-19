package com.example.fooddelivery.domain.model


import com.google.gson.annotations.SerializedName

data class SessionToken(
    @SerializedName("access_token")
    val accessToken: String?,
    @SerializedName("expires")
    val expires: Int?,
    @SerializedName("refresh_token")
    val refreshToken: String?
)