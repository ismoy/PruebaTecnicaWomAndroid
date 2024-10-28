package com.github.comismoy.pruebatecnicawomandroid.data.remote

import com.github.comismoy.pruebatecnicawomandroid.data.remote.response.DogBreedsManagerResponse
import com.github.comismoy.pruebatecnicawomandroid.data.remote.response.DogImageResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface DogApiServices {
    @GET("api/breeds/list")
    suspend fun getDogBreeds(): DogBreedsManagerResponse

    @GET("api/breed/{breedName}/images")
    suspend fun getDogImagesByBreed(@Path("breedName") breedName: String): DogImageResponse
}