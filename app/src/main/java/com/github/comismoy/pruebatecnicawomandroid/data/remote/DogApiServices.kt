package com.github.comismoy.pruebatecnicawomandroid.data.remote

import com.github.comismoy.pruebatecnicawomandroid.data.remote.response.DogBreedsManagerResponse
import retrofit2.http.GET

interface DogApiServices {
    @GET("api/breeds/list")
    suspend fun getDogBreeds(): DogBreedsManagerResponse
}