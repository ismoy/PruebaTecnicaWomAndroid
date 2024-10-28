package com.github.comismoy.pruebatecnicawomandroid.ui.home

import com.github.comismoy.pruebatecnicawomandroid.domain.model.DogBreedsModel

data class DogBreedsState (
    val breedsList: DogBreedsModel?= null,
    val error: String? = null
)