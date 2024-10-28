package com.github.comismoy.pruebatecnicawomandroid.data.remote.response

import kotlinx.serialization.Serializable

@Serializable
data class DogBreedsManagerResponse(
    val message: List<String>,
    val status: String
)
