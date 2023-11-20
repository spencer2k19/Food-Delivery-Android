package com.example.fooddelivery.di

import com.example.fooddelivery.common.Endpoints
import com.example.fooddelivery.data.data_source.remote.AuthDataSource
import com.example.fooddelivery.data.data_source.remote.BasicInterceptor
import com.example.fooddelivery.data.data_source.remote.FoodDataSource
import com.example.fooddelivery.data.data_source.remote.FoodDeliveryApi
import com.example.fooddelivery.data.repository.AuthRepositoryImpl
import com.example.fooddelivery.data.repository.FoodRepositoryImpl
import com.example.fooddelivery.domain.repository.AuthRepository
import com.example.fooddelivery.domain.repository.FoodRepository
import com.example.fooddelivery.domain.use_case.food.FoodUseCases
import com.example.fooddelivery.domain.use_case.food.GetFoods
import com.example.fooddelivery.domain.use_case.restaurant.GetRestaurants
import com.example.fooddelivery.domain.use_case.restaurant.RestaurantUseCases
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideFoodDeliveryApi():FoodDeliveryApi {
        return Retrofit.Builder()
            .baseUrl(Endpoints.BASE_URL)
            .client(OkHttpClient.Builder().also { client->
                client.retryOnConnectionFailure(true)
                client.followRedirects(false)
                client.addInterceptor(BasicInterceptor())
                client.connectTimeout(1, TimeUnit.MINUTES)
                client.writeTimeout(1, TimeUnit.MINUTES)
                client.readTimeout(1, TimeUnit.MINUTES)
                client.cache(null)
                client.callTimeout(1, TimeUnit.MINUTES)
            }.build())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(FoodDeliveryApi::class.java)
    }

    @Provides
    @Singleton
    fun provideAuthDataSource(apiService: FoodDeliveryApi): AuthDataSource {
        return AuthDataSource(apiService)
    }

    @Provides
    @Singleton
    fun provideFoodDataSource(apiService: FoodDeliveryApi): FoodDataSource {
        return FoodDataSource(apiService)
    }


    @Provides
    @Singleton
    fun provideAuthRepository(dataSource: AuthDataSource):AuthRepository {
        return AuthRepositoryImpl(dataSource)
    }

    @Provides
    @Singleton
    fun provideFoodRepository(dataSource: FoodDataSource): FoodRepository {
        return FoodRepositoryImpl(dataSource)
    }


    @Provides
    @Singleton
    fun provideFoodUseCases(repository: FoodRepository): FoodUseCases {
        return FoodUseCases(getFoods = GetFoods(repository))
    }


    @Provides
    @Singleton
    fun provideRestaurantUseCases(repository: FoodRepository): RestaurantUseCases {
        return RestaurantUseCases(getRestaurants = GetRestaurants(repository))
    }





}