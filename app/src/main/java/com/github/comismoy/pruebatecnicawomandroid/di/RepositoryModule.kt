package com.github.comismoy.pruebatecnicawomandroid.di

import com.github.comismoy.pruebatecnicawomandroid.data.DogBreedsRepositoryImpl
import com.github.comismoy.pruebatecnicawomandroid.domain.repository.DogBreedsRepository
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
}