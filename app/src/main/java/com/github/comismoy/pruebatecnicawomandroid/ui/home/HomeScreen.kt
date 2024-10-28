package com.github.comismoy.pruebatecnicawomandroid.ui.home

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.github.comismoy.pruebatecnicawomandroid.ui.core.navigation.ScreenRoutes
import com.github.comismoy.pruebatecnicawomandroid.ui.core.utils.Constants.TiTLETOPBAR

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun  HomeScreen(navController: NavHostController) {
    val viewModel : DogBreedsViewModel = hiltViewModel()
    val dogBreedsState by  viewModel.dogBreeds.collectAsState()

    LaunchedEffect(Unit){
        viewModel.getDogBreeds()
    }

    Scaffold(
      topBar ={
          TopAppBar(
              title = {
                  Text(
                      TiTLETOPBAR.uppercase(),
                      Modifier.fillMaxWidth(),
                      textAlign = TextAlign.Center
                  )
              }
          )
      }
    ) {paddingValues ->
        Surface(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            DogBreedsList(
                dogBreedsState = dogBreedsState,
                onBreedClick = {breedName->
                    navController.navigate(
                        ScreenRoutes.Details.createRoute(
                            breedName = breedName
                        )
                    )
                }
            )
        }
    }
}

@Composable
fun DogBreedsList(dogBreedsState: DogBreedsState, onBreedClick: (String) -> Unit) {

    Box(modifier = Modifier.fillMaxSize()) {
        if (dogBreedsState.breedsList?.breedsList.isNullOrEmpty()) {
            CircularProgressIndicator(
                modifier = Modifier
                    .align(Alignment.Center)
                    .size(64.dp)
            )
        } else {
            LazyVerticalGrid(
                columns = GridCells.Fixed(2),
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp),
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 16.dp)
            ) {
                items(dogBreedsState.breedsList!!.breedsList.size) { index ->
                    val breed = dogBreedsState.breedsList.breedsList[index]
                    DogBreedCard(breed = breed, onBreedClick = onBreedClick)
                }
            }
        }
    }
}
@Composable
fun DogBreedCard(breed: String, onBreedClick: (String) -> Unit) {
    Card(
        shape = RoundedCornerShape(8.dp),
        modifier = Modifier
            .size(120.dp)
            .padding(4.dp)
            .clickable { onBreedClick(breed) }
    ) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = breed,
                color = Color.Black,
                fontSize = 24.sp,
                textAlign = TextAlign.Center
            )
        }
    }
}
