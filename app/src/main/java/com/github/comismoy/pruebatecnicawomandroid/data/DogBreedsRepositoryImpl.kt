package com.github.comismoy.pruebatecnicawomandroid.data

import com.github.comismoy.pruebatecnicawomandroid.data.core.ResultData
import com.github.comismoy.pruebatecnicawomandroid.data.mappers.DogBreedsMapper.toDogBreedsModel
import com.github.comismoy.pruebatecnicawomandroid.data.remote.DogApiServices
import com.github.comismoy.pruebatecnicawomandroid.domain.model.DogBreedsModel
import com.github.comismoy.pruebatecnicawomandroid.domain.repository.DogBreedsRepository
import javax.inject.Inject

class DogBreedsRepositoryImpl @Inject constructor(
    private val dogApiServices: DogApiServices
):DogBreedsRepository{
    override suspend fun getDogBreeds(): ResultData<DogBreedsModel> {
        return try {
            val response = dogApiServices.getDogBreeds()
            ResultData.Success(response.toDogBreedsModel())
        }catch (e:Exception){
            ResultData.Error(e)
        }
    }
}