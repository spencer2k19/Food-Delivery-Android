package com.example.fooddelivery.common

object Utils  {
    fun bearerToken(): String {
        return "Bearer " + PrefSingleton.getTokenData()?.accessToken
    }
}