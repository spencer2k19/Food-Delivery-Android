package com.example.fooddelivery.data.data_source.remote

import android.content.Context
import android.content.Intent
import android.util.Log
import com.example.fooddelivery.common.DialogFactory
import com.example.fooddelivery.common.PrefSingleton
import com.example.fooddelivery.presentation.main.MainActivity
import okhttp3.Interceptor
import okhttp3.Response
import retrofit2.HttpException
import java.util.logging.Handler

class BasicInterceptor(private val context: Context): Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        val authenticateRequest = request.newBuilder()
            .header("Accept","application/json")
            .header("Content-Type","application/json")
            .build()

        val response = chain.proceed(authenticateRequest)

       /* Log.e("food_delivery","Response : $response")
        Log.e("food_delivery","Response Code : ${response.code}")
        Log.e("food_delivery","Response body : ${response.body}")

*/

            if(response.code == 401 && PrefSingleton.getTokenData() != null) {
                val intent = Intent(context, MainActivity::class.java)
                intent.flags= Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                context.startActivity(intent)
            }




        return response
    }
}