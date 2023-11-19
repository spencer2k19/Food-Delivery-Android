package com.example.fooddelivery

import android.app.Application
import com.example.fooddelivery.common.PrefSingleton
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class FoodDeliveryApp: Application() {

    override fun onCreate() {
        super.onCreate()
        PrefSingleton.init(this)
    }
}