package com.github.comismoy.pruebatecnicawomandroid.data.remote.response

import kotlinx.serialization.Serializable

@Serializable
data class DogImageResponse(
    val message: List<String>,
    val status: String
)
