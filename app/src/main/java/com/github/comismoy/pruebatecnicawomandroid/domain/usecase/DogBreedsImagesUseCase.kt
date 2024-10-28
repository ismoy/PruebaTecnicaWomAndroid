package com.github.comismoy.pruebatecnicawomandroid.domain.usecase

import com.github.comismoy.pruebatecnicawomandroid.data.core.ResultData
import com.github.comismoy.pruebatecnicawomandroid.domain.model.DogImageModel
import com.github.comismoy.pruebatecnicawomandroid.domain.repository.DogImagesRepository
import javax.inject.Inject

class DogBreedsImagesUseCase @Inject constructor(private val dogImagesRepository: DogImagesRepository) {

    suspend operator fun invoke(breedName:String):ResultData<DogImageModel> =
        dogImagesRepository.getDogImages(breedName)
}