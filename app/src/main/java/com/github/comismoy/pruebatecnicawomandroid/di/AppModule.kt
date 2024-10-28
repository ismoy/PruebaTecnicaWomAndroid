package com.github.comismoy.pruebatecnicawomandroid.di

import android.content.Context
import com.github.comismoy.pruebatecnicawomandroid.data.NetworkHelperImpl
import com.github.comismoy.pruebatecnicawomandroid.data.core.NetworkHelper
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    fun provideNetworkHelper(@ApplicationContext context: Context): NetworkHelper {
        return NetworkHelperImpl(context)
    }

}