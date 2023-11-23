package com.example.fooddelivery.data.data_source.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.fooddelivery.data.data_source.local.entity.FoodEntity


@Database(
    entities = [FoodEntity::class],
    version = 1
)
abstract  class FoodDeliveryDatabase: RoomDatabase()  {
    abstract val foodsDao:FoodsDao
    companion object {
        const val DATABASE_NAME = "food_delivery_db"
    }
}