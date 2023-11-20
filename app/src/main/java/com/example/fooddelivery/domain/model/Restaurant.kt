package com.example.fooddelivery.domain.model


import com.google.gson.annotations.SerializedName

data class Restaurant(
    @SerializedName("cover_image")
    val coverImage: String?,
    @SerializedName("date_created")
    val dateCreated: String?,
    @SerializedName("date_updated")
    val dateUpdated: String?,
    @SerializedName("description")
    val description: String?,
    @SerializedName("id")
    val id: Int?,
    @SerializedName("logo")
    val logo: String?,
    @SerializedName("name")
    val name: String?,
    @SerializedName("rating")
    val rating: Int?,
    @SerializedName("status")
    val status: String?
)