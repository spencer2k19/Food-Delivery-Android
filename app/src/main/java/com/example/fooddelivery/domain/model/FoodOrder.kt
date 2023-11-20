package com.example.fooddelivery.domain.model


import com.google.gson.annotations.SerializedName

data class FoodOrder(
    @SerializedName("foods_id")
    val foodsId: FoodsId?,
    @SerializedName("id")
    val id: Int?,
    @SerializedName("quantity")
    val quantity: Int?
)