package com.example.fooddelivery.domain.model


import com.google.gson.annotations.SerializedName

data class Testimonial(
    @SerializedName("author_name")
    val authorName: String?,
    @SerializedName("avatar")
    val avatar: String?,
    @SerializedName("content")
    val content: String?,
    @SerializedName("date_created")
    val dateCreated: String?,
    @SerializedName("date_updated")
    val dateUpdated: String?,
    @SerializedName("id")
    val id: Int?,
    @SerializedName("rating")
    val rating: Double?,
    @SerializedName("restaurant")
    val restaurant: Int?,
    @SerializedName("status")
    val status: String?
)