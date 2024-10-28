package com.github.comismoy.pruebatecnicawomandroid.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.github.comismoy.pruebatecnicawomandroid.data.core.ResultData
import com.github.comismoy.pruebatecnicawomandroid.domain.usecase.DogBreedsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class DogBreedsViewModel @Inject constructor(private val dogBreedsUseCase: DogBreedsUseCase):
    ViewModel(){
    private val _dogBreeds = MutableStateFlow(DogBreedsState())
        val dogBreeds = _dogBreeds.asStateFlow()


    fun getDogBreeds(){
        viewModelScope.launch {
            val response = withContext(Dispatchers.IO){dogBreedsUseCase()}
            when(response){
                is ResultData.Success -> _dogBreeds.update { dogBreedsState ->
                    dogBreedsState.copy(breedsList = response.data) }
                is ResultData.Error -> _dogBreeds.update { dogBreedsState ->
                    dogBreedsState.copy(error = response.error.message) }
            }
        }
    }
}