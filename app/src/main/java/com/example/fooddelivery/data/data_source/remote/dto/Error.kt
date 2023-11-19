package com.example.fooddelivery.data.data_source.remote.dto


import com.google.gson.annotations.SerializedName

data class Error(
    @SerializedName("extensions")
    val extensions: Extensions?,
    @SerializedName("message")
    val message: String?
)