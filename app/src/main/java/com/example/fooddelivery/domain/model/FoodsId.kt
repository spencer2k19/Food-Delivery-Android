package com.example.fooddelivery.domain.model


import com.google.gson.annotations.SerializedName

data class FoodsId(
    @SerializedName("currency")
    val currency: String?,
    @SerializedName("image")
    val image: String?,
    @SerializedName("name")
    val name: String?,
    @SerializedName("price")
    val price: Double?,
    @SerializedName("restaurant")
    val restaurant: RestaurantOrder?
)