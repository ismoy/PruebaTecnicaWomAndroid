package com.github.comismoy.pruebatecnicawomandroid.domain.model

import kotlinx.serialization.Serializable

@Serializable
data class DogBreedsModel(
    val breedsList:List<String>
)
