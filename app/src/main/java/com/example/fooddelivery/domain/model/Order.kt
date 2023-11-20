package com.example.fooddelivery.domain.model


import com.google.gson.annotations.SerializedName

data class Order(
    @SerializedName("date_created")
    val dateCreated: String?,
    @SerializedName("date_updated")
    val dateUpdated: Any?,
    @SerializedName("foods")
    val foods: List<FoodOrder>?,
    @SerializedName("id")
    val id: Int?,
    @SerializedName("order_status")
    val orderStatus: String?,
    @SerializedName("status")
    val status: String?,
    @SerializedName("user_created")
    val userCreated: String?,
    @SerializedName("user_updated")
    val userUpdated: Any?
)