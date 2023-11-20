package com.example.fooddelivery.domain.model


import com.google.gson.annotations.SerializedName

data class Food(
    @SerializedName("category")
    val category: Any?,
    @SerializedName("currency")
    val currency: String?,
    @SerializedName("date_created")
    val dateCreated: String?,
    @SerializedName("date_updated")
    val dateUpdated: String?,
    @SerializedName("foods")
    val foods: Int?,
    @SerializedName("id")
    val id: Int?,
    @SerializedName("image")
    val image: String?,
    @SerializedName("is_liked")
    val isLiked: Boolean?,
    @SerializedName("name")
    val name: String?,
    @SerializedName("price")
    val price: Int?,
    @SerializedName("restaurant")
    val restaurant: Int?,
    @SerializedName("short_description")
    val shortDescription: String?,
    @SerializedName("sort")
    val sort: Any?,
    @SerializedName("status")
    val status: String?
)