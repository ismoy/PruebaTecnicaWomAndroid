package com.github.comismoy.pruebatecnicawomandroid.domain.repository

import com.github.comismoy.pruebatecnicawomandroid.data.core.ResultData
import com.github.comismoy.pruebatecnicawomandroid.domain.model.DogImageModel

interface DogImagesRepository {
    suspend fun getDogImages(breedName: String): ResultData<DogImageModel>
}