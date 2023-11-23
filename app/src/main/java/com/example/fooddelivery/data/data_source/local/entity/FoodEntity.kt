package com.example.fooddelivery.data.data_source.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "foods")
data class FoodEntity(
    var currency: String,
    @PrimaryKey var id: Int,
    var image: String,
    var name: String,
    var price: Double,
    var quantity: Int,
    var restaurantId: Int
)
