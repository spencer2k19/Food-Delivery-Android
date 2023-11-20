package com.example.fooddelivery.domain.model


import com.google.gson.annotations.SerializedName

data class Category(
    @SerializedName("date_created")
    val dateCreated: String?,
    @SerializedName("id")
    val id: Int?,
    @SerializedName("image")
    val image: String?,
    @SerializedName("name")
    val name: String?
)