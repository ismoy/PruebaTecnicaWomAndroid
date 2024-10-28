package com.github.comismoy.pruebatecnicawomandroid.domain.usecase

import com.github.comismoy.pruebatecnicawomandroid.domain.repository.DogBreedsRepository
import javax.inject.Inject

class DogBreedsUseCase @Inject constructor(private val dogBreedsRepository: DogBreedsRepository) {
    suspend operator fun invoke() = dogBreedsRepository.getDogBreeds()
}