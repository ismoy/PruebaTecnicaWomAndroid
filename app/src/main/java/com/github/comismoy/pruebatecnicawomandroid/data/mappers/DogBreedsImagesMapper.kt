package com.github.comismoy.pruebatecnicawomandroid.data.mappers

import com.github.comismoy.pruebatecnicawomandroid.data.remote.response.DogImageResponse
import com.github.comismoy.pruebatecnicawomandroid.domain.model.DogImageModel

object DogBreedsImagesMapper {
    fun DogImageResponse.toDogImageModel(): DogImageModel {
        return DogImageModel(breedsImages = message)
    }
}