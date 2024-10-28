package com.github.comismoy.pruebatecnicawomandroid.ui.details

import com.github.comismoy.pruebatecnicawomandroid.domain.model.DogImageModel

data class DogBreedsImagesState (
    val dogBreedsImagesList: DogImageModel? = null,
    val error: String? = null
)