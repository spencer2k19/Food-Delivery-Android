package com.example.fooddelivery.data.data_source.remote.dto


import com.google.gson.annotations.SerializedName

data class GeneralError(
    @SerializedName("errors")
    val errors: List<Error?>?
)