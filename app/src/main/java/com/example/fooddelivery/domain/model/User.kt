package com.example.fooddelivery.domain.model


import com.google.gson.annotations.SerializedName

data class User(
    @SerializedName("email")
    val email: String?,
    @SerializedName("first_name")
    val firstName: String?,
    @SerializedName("id")
    val id: String?,
    @SerializedName("last_name")
    val lastName: String?,
    @SerializedName("status")
    val status: String?
)