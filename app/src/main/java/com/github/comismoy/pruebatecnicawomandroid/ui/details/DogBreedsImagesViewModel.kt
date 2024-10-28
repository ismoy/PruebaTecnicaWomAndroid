package com.github.comismoy.pruebatecnicawomandroid.ui.details

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.github.comismoy.pruebatecnicawomandroid.data.core.ResultData
import com.github.comismoy.pruebatecnicawomandroid.domain.usecase.DogBreedsImagesUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

class DogBreedsImagesViewModel @Inject constructor(private val dogBreedsImagesUseCase:
                                                   DogBreedsImagesUseCase):ViewModel() {

    private val _dogBreedsImages = MutableStateFlow(DogBreedsImagesState())
    val dogBreedsImages = _dogBreedsImages.asStateFlow()


    fun getDogBreedsImages(breedName:String){
        if (breedName.isBlank()){
            _dogBreedsImages.update{dogBreedsImagesState -> dogBreedsImagesState.copy(error = "Breed name is required")}
            return
        }
        viewModelScope.launch {
            val response = withContext(Dispatchers.IO){dogBreedsImagesUseCase(breedName)}
            when(response){
                is ResultData.Success -> _dogBreedsImages.update { dogBreedsImagesState ->
                    dogBreedsImagesState.copy(dogBreedsImagesList = response.data) }
                is ResultData.Error -> _dogBreedsImages.update { dogBreedsImagesState ->
                    dogBreedsImagesState.copy(error = response.error.message) }
                }
            }
        }

}