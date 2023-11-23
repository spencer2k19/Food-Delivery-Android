package com.example.fooddelivery.di

import android.app.Application
import android.content.Context
import androidx.room.Room
import com.example.fooddelivery.common.Endpoints
import com.example.fooddelivery.data.data_source.local.FoodDeliveryDatabase
import com.example.fooddelivery.data.data_source.remote.AuthDataSource
import com.example.fooddelivery.data.data_source.remote.BasicInterceptor
import com.example.fooddelivery.data.data_source.remote.FoodDataSource
import com.example.fooddelivery.data.data_source.remote.FoodDeliveryApi
import com.example.fooddelivery.data.data_source.remote.OrderDataSource
import com.example.fooddelivery.data.repository.AuthRepositoryImpl
import com.example.fooddelivery.data.repository.FoodRepositoryImpl
import com.example.fooddelivery.data.repository.OrderRepositoryImpl
import com.example.fooddelivery.domain.repository.AuthRepository
import com.example.fooddelivery.domain.repository.FoodRepository
import com.example.fooddelivery.domain.repository.OrderRepository
import com.example.fooddelivery.domain.use_case.food.FoodUseCases
import com.example.fooddelivery.domain.use_case.food.GetFavoriteFoods
import com.example.fooddelivery.domain.use_case.food.GetFoods
import com.example.fooddelivery.domain.use_case.food.GetFoodsPerRestaurant
import com.example.fooddelivery.domain.use_case.food.GetTestimonials
import com.example.fooddelivery.domain.use_case.order.AddFoodToCart
import com.example.fooddelivery.domain.use_case.order.AddOrder
import com.example.fooddelivery.domain.use_case.order.GetOrders
import com.example.fooddelivery.domain.use_case.order.GetSavedFoods
import com.example.fooddelivery.domain.use_case.order.IncreaseFoodQuantity
import com.example.fooddelivery.domain.use_case.order.OrderUseCases
import com.example.fooddelivery.domain.use_case.order.RemoveFoodFromCart
import com.example.fooddelivery.domain.use_case.restaurant.GetRestaurants
import com.example.fooddelivery.domain.use_case.restaurant.RestaurantUseCases
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
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
    fun provideFoodDeliveryDatabase(app: Application):FoodDeliveryDatabase {
        return Room.databaseBuilder(app,FoodDeliveryDatabase::class.java,
            FoodDeliveryDatabase.DATABASE_NAME).build()
    }



    @Provides
    @Singleton
    fun provideFoodDeliveryApi(@ApplicationContext appContext: Context):FoodDeliveryApi {

        return Retrofit.Builder()
            .baseUrl(Endpoints.BASE_URL)
            .client(OkHttpClient.Builder().also { client->
                client.retryOnConnectionFailure(true)
                client.followRedirects(false)
                client.addInterceptor(BasicInterceptor(context = appContext))
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
    fun provideOrderDataSource(apiService: FoodDeliveryApi): OrderDataSource {
        return OrderDataSource(apiService)
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
    fun provideOrderRepository(dataSource: OrderDataSource,db: FoodDeliveryDatabase): OrderRepository {
        return OrderRepositoryImpl(dataSource,db.foodsDao)
    }


    @Provides
    @Singleton
    fun provideFoodUseCases(repository: FoodRepository): FoodUseCases {
        return FoodUseCases(getFoods = GetFoods(repository),
            getFavoriteFoods = GetFavoriteFoods(repository),
            getFoodsPerRestaurant = GetFoodsPerRestaurant(repository),
            getTestimonials = GetTestimonials(repository)
        )
    }


    @Provides
    @Singleton
    fun provideRestaurantUseCases(repository: FoodRepository): RestaurantUseCases {
        return RestaurantUseCases(getRestaurants = GetRestaurants(repository))
    }


    @Provides
    @Singleton
    fun provideOrderUseCases(repository: OrderRepository): OrderUseCases {
        return OrderUseCases(getOrders = GetOrders(repository),
            addFoodToCart = AddFoodToCart(repository),
            getSavedFoods = GetSavedFoods(repository),
            removeFoodFromCart = RemoveFoodFromCart(repository),
            increaseFoodQuantity = IncreaseFoodQuantity(repository),
            addOrder = AddOrder(repository)
        )
    }





}