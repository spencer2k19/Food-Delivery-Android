package com.example.fooddelivery.data.data_source.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.fooddelivery.data.data_source.local.entity.FoodEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface FoodsDao {

    @Query("SELECT * FROM foods")
    fun getFoods(): Flow<List<FoodEntity>>

    @Query("SELECT * FROM foods where id = :id")
    suspend fun getFoodById(id:Int):FoodEntity?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertFood(food:FoodEntity)

    @Update
    suspend fun updateFood(food: FoodEntity)

    @Delete
    suspend fun deleteFood(food:FoodEntity)


}