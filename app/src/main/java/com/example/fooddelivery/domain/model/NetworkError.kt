package com.example.fooddelivery.domain.model

data class NetworkError(
    val message: String
)

data class NetworkError422(
    val data: Map<String,List<String>>
)