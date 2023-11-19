package com.example.fooddelivery.di

import com.example.fooddelivery.common.Endpoints
import com.example.fooddelivery.data.data_source.remote.AuthDataSource
import com.example.fooddelivery.data.data_source.remote.BasicInterceptor
import com.example.fooddelivery.data.data_source.remote.FoodDeliveryApi
import com.example.fooddelivery.data.repository.AuthRepositoryImpl
import com.example.fooddelivery.domain.repository.AuthRepository
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
    fun provideAuthRepository(dataSource: AuthDataSource):AuthRepository {
        return AuthRepositoryImpl(dataSource)
    }
}