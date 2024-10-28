package com.github.comismoy.pruebatecnicawomandroid.domain.repository

import com.github.comismoy.pruebatecnicawomandroid.data.core.ResultData
import com.github.comismoy.pruebatecnicawomandroid.domain.model.DogBreedsModel

interface DogBreedsRepository {
    suspend fun getDogBreeds(): ResultData<DogBreedsModel>
}