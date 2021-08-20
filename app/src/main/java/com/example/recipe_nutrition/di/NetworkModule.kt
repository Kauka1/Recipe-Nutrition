package com.example.recipe_nutrition.di

import com.example.recipe_nutrition.util.Constants.Companion.BASE_URL
import com.example.recipe_nutrition.data.network.FoodRecipesApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

//provides the FoodRecipesApi and makes the dependencies for it
@Module
@InstallIn(ApplicationComponent::class)
object NetworkModule {

    //provides the Httpclient to the retrofit create function
    @Singleton
    @Provides
    fun provideHttpClient(): OkHttpClient{
        return OkHttpClient.Builder().readTimeout(15, TimeUnit.SECONDS).connectTimeout(15, TimeUnit.SECONDS).build()
    }

    //provides the gsonConverter for the retrofit function
    @Singleton
    @Provides
    fun provideConverterFactor(): GsonConverterFactory {
        return GsonConverterFactory.create()
    }

    //Makes the instance of the retrofit
    @Singleton
    @Provides
    fun provideRetrofitInstance(
        okHttpClient: OkHttpClient,
        gsonConverterFactory: GsonConverterFactory
    ): Retrofit {
        return Retrofit.Builder().baseUrl(BASE_URL).client(okHttpClient).addConverterFactory(gsonConverterFactory).build()
    }

    //creates the food api service
    @Singleton
    @Provides
    fun provideApiService(retrofit: Retrofit): FoodRecipesApi {
        return retrofit.create(FoodRecipesApi::class.java)
    }
}