package com.github.comismoy.pruebatecnicawomandroid.di

import com.github.comismoy.pruebatecnicawomandroid.data.repository.DogBreedsRepositoryImpl
import com.github.comismoy.pruebatecnicawomandroid.domain.repository.DogBreedsRepository
import com.github.comismoy.pruebatecnicawomandroid.domain.repository.DogImagesRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Binds
    @Singleton
    abstract fun bindDogBreedsRepository(impl: DogBreedsRepositoryImpl): DogBreedsRepository

    @Binds
    @Singleton
    abstract fun bindDogImagesRepository(impl: DogBreedsRepositoryImpl): DogImagesRepository

}