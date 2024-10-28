package com.github.comismoy.pruebatecnicawomandroid.data.mappers

import com.github.comismoy.pruebatecnicawomandroid.data.remote.response.DogBreedsManagerResponse
import com.github.comismoy.pruebatecnicawomandroid.domain.model.DogBreedsModel

object DogBreedsMapper {
    fun DogBreedsManagerResponse.toDogBreedsModel(): DogBreedsModel {
        return DogBreedsModel(
            breedsList = message
        )
    }
}