package com.github.comismoy.pruebatecnicawomandroid.di

import com.github.comismoy.pruebatecnicawomandroid.ui.core.utils.Constants.BASE_URL
import com.github.comismoy.pruebatecnicawomandroid.data.remote.DogApiServices
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Singleton
    fun  provideRetrofit():Retrofit{
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun provideDogApiServices(retrofit: Retrofit):DogApiServices =
        retrofit.create(DogApiServices::class.java)
}