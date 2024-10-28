package com.github.comismoy.pruebatecnicawomandroid.data.core

sealed class ResultData <out T> {
    data class Success<T>(val data:T): ResultData<T>()
    data class Error(val error: Exception): ResultData<Nothing>()

}