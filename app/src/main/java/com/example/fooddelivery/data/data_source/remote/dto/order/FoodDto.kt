package com.example.fooddelivery.data.data_source.remote.dto.order


import com.google.gson.annotations.SerializedName

data class FoodDto(
    @SerializedName("id")
    val id: Int?,
    @SerializedName("quantity")
    val quantity: Int?
)