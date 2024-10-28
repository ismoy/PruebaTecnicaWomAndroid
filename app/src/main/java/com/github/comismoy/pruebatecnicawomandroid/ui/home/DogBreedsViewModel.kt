package com.github.comismoy.pruebatecnicawomandroid.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.github.comismoy.pruebatecnicawomandroid.data.core.DispatcherProvider
import com.github.comismoy.pruebatecnicawomandroid.data.core.NetworkHelper
import com.github.comismoy.pruebatecnicawomandroid.data.core.ResultData
import com.github.comismoy.pruebatecnicawomandroid.domain.usecase.DogBreedsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class DogBreedsViewModel @Inject constructor(private val dogBreedsUseCase: DogBreedsUseCase,
                                             private val dispatcherProvider: DispatcherProvider,
                                             private val networkHelper: NetworkHelper
):
    ViewModel(){
    private val _dogBreeds = MutableStateFlow(DogBreedsState())
    val dogBreeds = _dogBreeds.asStateFlow()


    fun getDogBreeds(){
        _dogBreeds.update { dogBreedsState ->
            dogBreedsState.copy(breedsList = null, error = null, isLoading = true)
        }
        viewModelScope.launch(dispatcherProvider.io) {
            if (networkHelper.isConnected()){
                val response = withContext(dispatcherProvider.io){dogBreedsUseCase()}
                when(response){
                    is ResultData.Success -> _dogBreeds.update { dogBreedsState ->
                        dogBreedsState.copy(breedsList = response.data, isLoading = false)
                    }
                    is ResultData.Error -> _dogBreeds.update { dogBreedsState ->
                        dogBreedsState.copy(error = response.error.message,isLoading = false) }
                }
            }else{
                _dogBreeds.update { dogBreedsState ->
                    dogBreedsState.copy(error = "No se pudo connectar al servidor", isLoading = false) }
            }

        }
    }
}