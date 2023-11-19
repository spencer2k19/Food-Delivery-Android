package com.example.fooddelivery.data.data_source.remote

import okhttp3.Interceptor
import okhttp3.Response

class BasicInterceptor: Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        val authenticateRequest = request.newBuilder()
            .header("Accept","application/json")
            .header("Content-Type","application/json")
            .build()
        return chain.proceed(authenticateRequest)
    }
}