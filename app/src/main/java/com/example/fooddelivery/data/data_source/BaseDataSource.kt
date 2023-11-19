package com.example.fooddelivery.data.data_source

import android.util.Log
import com.example.fooddelivery.data.data_source.remote.dto.GeneralError
import com.google.gson.Gson
import okio.IOException
import retrofit2.HttpException
import retrofit2.Response

open class BaseDataSource {
    suspend fun<T: Any> safeApiCall(call: suspend () -> T) : T {
        val response: T
        val gson = Gson()
        return try {
           response = call.invoke()
           response
        }catch (e: HttpException) {

            when(e.code()) {
                400 -> {
                    val error = gson.fromJson(e.response()?.errorBody()!!.charStream(),GeneralError::class.java)
                    throw Exception(error?.errors!![0]?.message?: "")
                }
                401 -> {
                    val error = gson.fromJson(e.response()?.errorBody()!!.charStream(),GeneralError::class.java)
                    throw Exception(error?.errors!![0]?.message?: "")
                }

                403 -> {
                    val error = gson.fromJson(e.response()?.errorBody()!!.charStream(),GeneralError::class.java)
                    throw Exception(error?.errors!![0]?.message?: "")
                }
            }
            throw Exception("An unexpected error occured")
        } catch (e: IOException) {
            throw Exception("Couldn't reach server. Please check your internet connection")
        }
    }
}