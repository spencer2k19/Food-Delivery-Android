package com.example.fooddelivery.data.data_source.remote.dto.order


import com.google.gson.annotations.SerializedName

data class OrderDto(
    @SerializedName("comments")
    val comments: String?,
    @SerializedName("foods")
    val foods: List<FoodDto?>?,
    @SerializedName("order_status")
    val orderStatus: String?,
    @SerializedName("status")
    val status: String?
)